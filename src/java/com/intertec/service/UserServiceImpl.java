package com.intertec.service;

import com.intertec.entity.RestrictedWord;
import com.intertec.entity.Result;
import com.intertec.entity.User;
import com.intertec.exceptions.UserNameLengthException;
import com.intertec.exceptions.UserNameNotValidWord;
import com.intertec.repository.interfaces.UserRepository;
import com.intertec.service.interfaces.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepo;
    
    @Override
    public Result checkUserName(String userName) throws UserNameLengthException, UserNameNotValidWord{
        Result result = new Result();
                        
        List<String> suggestedNames = new ArrayList<>();
        User existingUser;
        int counter = 0;
        
        if(userName.length() < 6){
            result.setIsValid(Boolean.FALSE);
            throw new UserNameLengthException();
        }else{            
            List<RestrictedWord> restrictedWords = userRepo.findAllRestrictedWords();
            for(RestrictedWord restrictedWord : restrictedWords){
                if(userName.contains(restrictedWord.getRestrictedWordWord())){
                    throw new UserNameNotValidWord();
                }
            }
            
            existingUser = userRepo.getUserByName(userName);
            
            if(existingUser != null){
                String currentName;
                Random random = new Random();
                int currentNumber;
                Boolean validFlag;
                while((suggestedNames.size() < 14) && (counter < 3)){
                    suggestedNames.clear();
                    for(int i = 0; i < 14; i++){
                        validFlag = true;
                        currentNumber = random.nextInt(100)+1;
                        currentName = userName + "_" + Integer.toString(currentNumber);
                        if(!suggestedNames.contains(currentName)){
                            if(userRepo.getUserByName(currentName) == null){
                                for(RestrictedWord restrictedWord : restrictedWords){
                                    if(currentName.contains(restrictedWord.getRestrictedWordWord())){
                                        validFlag = false;
                                    }
                                }                            
                            }
                            if(validFlag){
                                suggestedNames.add(currentName);
                            }
                        }
                    }
                    counter++;
                }

                result.setIsValid(Boolean.FALSE);
                result.setValidNames(suggestedNames);
            }else{
                result.setIsValid(Boolean.TRUE);
                suggestedNames.add(userName);
                result.setValidNames(suggestedNames);
            }
        }
        
        return result;
    }
    
    @Override
    public void saveRestrictedWord(RestrictedWord restrictedWord){
        userRepo.saveRestrictedWord(restrictedWord);
    }
}
