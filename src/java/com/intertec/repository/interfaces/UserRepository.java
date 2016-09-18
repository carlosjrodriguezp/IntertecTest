package com.intertec.repository.interfaces;

import com.intertec.entity.RestrictedWord;
import com.intertec.entity.User;
import java.util.List;

public interface UserRepository {
    
    List<User> findAllUsers();
    
    User getUserByName(String userName);
    
    List<RestrictedWord> findAllRestrictedWords();
    
    void saveRestrictedWord(RestrictedWord restrictedWord);        
}
