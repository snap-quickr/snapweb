package org.snap.shopoweb.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.snap.shopoweb.beans.User;
import org.snap.shopoweb.dao.ProductDao;
import org.snap.shopoweb.dao.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userId")
public class HomeController {
    
    private ApplicationContext context;
    
    @RequestMapping("/home.htm")
    public ModelAndView goHome (HttpServletRequest request, HttpServletResponse response){
        
        ModelAndView mView = new ModelAndView("home");
        context = new ClassPathXmlApplicationContext("jdbc.xml");
        
        if(request.getParameter("source")!=null) {
            if(request.getParameter("source").equals("signup")){
                User user = new User();
                user.setUserName(request.getParameter("name"));
                user.setUserEmail(request.getParameter("email"));
                user.setUserPassword(request.getParameter("pass1"));
                user.setUserContact(request.getParameter("contact"));                                
                UserDaoImpl userdao = (UserDaoImpl)context.getBean("userDao");
                user.setUserId(userdao.getMaxUserId()+1);
                userdao.saveUser(user);                
    
                mView.addObject("userId", user.getUserId());
                mView.addObject("userName", user.getUserName());
            }else{
                String email = request.getParameter("email");
                String password = request.getParameter("password");                                
                UserDaoImpl userdao = (UserDaoImpl)context.getBean("userDao");                        
                
                User user = userdao.getUser(email);           
                System.out.println(user.getUserName());
                if(!user.getUserPassword().equals(password)){
                    ModelAndView mView2 = new ModelAndView("login");
                    mView2.addObject("state", "wrong-password");
                    return mView2;
                }                                                               
                mView.addObject("userId", user.getUserId());
                mView.addObject("userName", user.getUserName());
            }
        }
        
        ProductDao productDao = (ProductDao)context.getBean("productDao");
        mView.addObject("allProducts", productDao.getAllProducts());      
        ((ConfigurableApplicationContext)context).close();
        return mView;
    }

}
