package com.intertec.repository;

import com.intertec.entity.RestrictedWord;
import com.intertec.entity.User;
import com.intertec.repository.interfaces.UserRepository;
import java.util.List;
import junit.framework.Assert;
import org.hibernate.SessionFactory;
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
public class UserReposirotyImplTest {
    
    @Autowired
    private UserRepository userRepo;
    
//    public UserReposirotyImplTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testFindAllUsers() {
        List<User> users = userRepo.findAllUsers();
        try{
            if(users != null){
                for(User user : users){
                    System.out.println("NAME: "+user.getUserName());
                }    
                Assert.assertTrue(true);
            }        
        }catch(Exception ex){
            fail("testFindAllUsers ERROR: " + ex.getMessage());
        }
    }
    
    @Test
    public void testGetUserByName(){
        String userName = "user1";
        try{
            User user = userRepo.getUserByName(userName);
            if(user != null){
                System.out.println("NAME: "+user.getUserName());
            }else{
                System.out.println("userName doesn't exist");
            }
            
            Assert.assertTrue(true);
        }catch(Exception ex){
            fail("testGetUserByName ERROR: " + ex.getMessage());
        }
    }
    
    @Test
    public void testFindAllRestrictedWords() {
        List<RestrictedWord> restrictedWords = userRepo.findAllRestrictedWords();
        try{
            if(restrictedWords != null){
                for(RestrictedWord restrictedWord : restrictedWords){
                    System.out.println("WORD: "+restrictedWord.getRestrictedWordWord());
                }    
                Assert.assertTrue(true);
            }        
        }catch(Exception ex){
            fail("testFindAllRestrictedWords ERROR: " + ex.getMessage());
        }
    }
    
    @Test
    public void testSaveRestrictedWord(){
        String newRestrictedWord = "murder";
        RestrictedWord restrictedWord = new RestrictedWord(newRestrictedWord);
        try{
            userRepo.saveRestrictedWord(restrictedWord);        
            Assert.assertTrue(true);
        }catch(Exception ex){
            fail("testSaveRestrictedWord ERROR: " + ex.getMessage());
        }

    }
           
}
