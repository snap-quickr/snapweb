/*
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 13-Aug-2015
 *  @author tanuj
 */
package org.snap.shopoweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.snap.shopoweb.beans.*;
import org.snap.shopoweb.dao.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginSignUpController {
    
    private ApplicationContext context;

    @RequestMapping("/signup.htm")
    public ModelAndView signUpPage(){
        ModelAndView mView = new ModelAndView("signup");
        return mView;
    }
    
    @RequestMapping("/home.htm")
    public ModelAndView goHome (HttpServletRequest request, HttpServletResponse response){
        
        ModelAndView mView = new ModelAndView("home");
        if(request.getParameter("source")!=null && request.getParameter("source").equals("signup")){
            User user = new User();
            user.setUserName(request.getParameter("name"));
            user.setUserEmail(request.getParameter("email"));
            user.setUserPassword(request.getParameter("pass1"));
            user.setUserContact(request.getParameter("contact"));
            
            context = new ClassPathXmlApplicationContext("jdbc.xml");
            UserDaoImpl userdao = (UserDaoImpl)context.getBean("userDao");
            user.setUserId(userdao.getMaxUserId()+1);
            userdao.saveUser(user);
            
            ((ConfigurableApplicationContext)context).close();

            mView.addObject("userId", user.getUserId());
        }else{
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            context = new ClassPathXmlApplicationContext("jdbc.xml");
            UserDaoImpl userdao = (UserDaoImpl)context.getBean("userDao");
            
            User user = userdao.getUser(email);
            if(user.getUserPassword()!=password){
                ModelAndView mView2 = new ModelAndView("login");
                mView2.addObject("state", "wrong-password");
                return mView2;
            }                
            mView.addObject("userId", user.getUserId());      
        }
        return mView;
    }
    
    @RequestMapping("/login.htm")
    public ModelAndView loginPage(ModelMap model){
        ModelAndView mView = new ModelAndView("login");        
        return mView;
    }
    
}
