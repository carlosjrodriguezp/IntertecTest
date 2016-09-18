package com.intertec.service.interfaces;

import com.intertec.entity.RestrictedWord;
import com.intertec.entity.Result;
import com.intertec.exceptions.UserNameLengthException;
import com.intertec.exceptions.UserNameNotValidWord;

public interface UserService {
    
    Result checkUserName(String userName) throws UserNameLengthException, UserNameNotValidWord;
    
    void saveRestrictedWord(RestrictedWord restrictedWord);
}
