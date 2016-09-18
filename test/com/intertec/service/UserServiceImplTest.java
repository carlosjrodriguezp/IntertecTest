package com.intertec.service;

import com.intertec.entity.RestrictedWord;
import com.intertec.entity.Result;
import com.intertec.exceptions.UserNameExistingException;
import com.intertec.exceptions.UserNameLengthException;
import com.intertec.exceptions.UserNameNotValidWord;
import com.intertec.service.interfaces.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class UserServiceImplTest {

    @Autowired
    private UserService userSer;    

     @Test
     public void testCheckUser() {
         String userName = "grasslo_a";
        try {
            Result result = userSer.checkUserName(userName);
            System.out.println("***RESULT: "+result.getIsValid());
            int counter = 0;
            for(String name : result.getValidNames()){
                 System.out.println("***"+ counter++ +": "+name);
            }
            Assert.assertTrue(true);
        } catch (UserNameLengthException | UserNameNotValidWord ex) {
            fail("testCheckUser ERROR: " + ex.getMessage());
        }
         
     }
     
     @Test
     public void testSaveRestrictedWord(){
         try{
            String newRestrictedWord = "weed";
            RestrictedWord restrictedWord = new RestrictedWord(newRestrictedWord);

            userSer.saveRestrictedWord(restrictedWord);
            Assert.assertTrue(true);
         }catch(Exception ex){
             fail("testSaveRestrictedWord ERROR: " + ex.getMessage());
         }
     }
}
