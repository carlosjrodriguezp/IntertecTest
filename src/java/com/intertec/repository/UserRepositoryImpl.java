package com.intertec.repository;

import com.intertec.entity.RestrictedWord;
import com.intertec.entity.User;
import com.intertec.repository.interfaces.UserRepository;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryImpl implements UserRepository{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<User> findAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = null;
        
        try{
            session.beginTransaction();
            Query q = session.getNamedQuery("User.findAll");
            users = (List<User>)q.list();
            session.getTransaction().commit();            
        }catch(Exception ex){
            System.out.println("findAllUsers ERROR " + ex.getMessage());
        }

        return users;
    }

    @Override
    public User getUserByName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        User ret = null;
        List<User> users = null;
        session.beginTransaction();
        Query q = session.getNamedQuery("User.getByName");
        q.setParameter("userName", userName);
        users = (List<User>)q.list();
        if(!users.isEmpty()){
            ret = users.get(0);
        }
        
        session.getTransaction().commit();                 
        return ret;                                 
    }
    
    @Override
    public List<RestrictedWord> findAllRestrictedWords() {
        Session session = sessionFactory.getCurrentSession();
        List<RestrictedWord> restrictedWords = null;
        
        try{
            session.beginTransaction();
            Query q =  session.getNamedQuery("RestrictedWord.findAll");
            restrictedWords = (List<RestrictedWord>)q.list();
            session.getTransaction().commit();            
        }catch(Exception ex){
            System.out.println("findAllRestrictedWords ERROR " + ex.getMessage());
        }

        return restrictedWords;
    }

    @Override
    public void saveRestrictedWord(RestrictedWord restrictedWord){
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(restrictedWord);
            session.getTransaction().commit();        
        }catch(Exception ex){
            System.out.println("saveResrictedWord ERROR " + ex.getMessage());
        }
    }
}
