package com.intertec.controller;

import com.intertec.entity.RestrictedWord;
import com.intertec.entity.Result;
import com.intertec.exceptions.UserNameExistingException;
import com.intertec.exceptions.UserNameLengthException;
import com.intertec.exceptions.UserNameNotValidWord;
import com.intertec.service.interfaces.UserService;
import com.intertec.util.interfaces.JsonService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    
    @Autowired
    UserService userSer;
    
    @Autowired
    JsonService jsonSer;
    
    @RequestMapping(value="/checkName/{userName}", method = RequestMethod.GET, produces = "application/json")
    public void checkUserName(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("userName") String userName){            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);    
            httpServletResponse.setContentType("application/json; charset=UTF-8");
        try {
            Result result = userSer.checkUserName(userName);
            String response = jsonSer.toJson(result);
            httpServletResponse.getWriter().println(response);
        } catch (UserNameNotValidWord | UserNameLengthException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_ACCEPTED);
            try {
                httpServletResponse.getWriter().println(ex.getMessage());
            } catch (IOException ex1) {
                System.out.println("checkUserName ERROR: " + ex.getMessage());
            }
        } catch(IOException ex){
            System.out.println("checkUserName ERROR: " + ex.getMessage());
        }
    }    
    
    @RequestMapping(value="/restrictedWord/{restrictedWord}",method = RequestMethod.POST, produces = "application/json")
    public void saveRestrictedWord(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("restrictedWord") String restrictedWord){
        try{
            RestrictedWord result = new RestrictedWord(restrictedWord);
            
            userSer.saveRestrictedWord(result);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);            
            httpServletResponse.setContentType("application/json; charset=UTF-8"); 
            httpServletResponse.getWriter().println(restrictedWord);
        }catch(Exception ex){
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try{
                httpServletResponse.getWriter().println(ex.getMessage());
            }catch(IOException ex1){
                System.out.println("saveRestrictedWord ERROR: " + ex1.getMessage());
            }
        }
    }    
}
