/*
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 13-Aug-2015
 *  @author tanuj
 */
package org.snap.shopoweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.snap.dao.User;
import org.snap.dao.UserDao;
import org.snap.dao.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginSignUpController {
    
    @RequestMapping("/signup.htm")
    public ModelAndView signUpPage(){
        ModelAndView mView = new ModelAndView("signup");
        return mView;
    }
    
    @RequestMapping("/addUser.htm")
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response){
        
        User user = new User();
        user.setUserName(request.getParameter("name"));
        user.setUserEmail(request.getParameter("email"));
        user.setUserPassword(request.getParameter("pass1"));
        user.setUserContact(request.getParameter("contact"));
        
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        UserDaoImpl userdao=(UserDaoImpl)context.getBean("userDao");
        user.setUserId(userdao.getMaxUserId()+1);
        userdao.saveUser(user);
        
        ModelAndView mView = new ModelAndView("home");
        return mView;
    }

}
