package org.snap.shopoweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.snap.shopoweb.beans.Category;
import org.snap.shopoweb.beans.Location;
import org.snap.shopoweb.beans.Product;
import org.snap.shopoweb.beans.User;
import org.snap.shopoweb.dao.CategoryDao;
import org.snap.shopoweb.dao.LocationDao;
import org.snap.shopoweb.dao.ProductDao;
import org.snap.shopoweb.dao.ProductDaoImpl;
import org.snap.shopoweb.dao.UserDao;
import org.snap.shopoweb.dao.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {    
    
    @RequestMapping("/user.htm")
    public ModelAndView showUser(HttpServletRequest request, HttpServletResponse response){
        
        if(request.getParameter("userId")==null){
            ModelAndView mView = new ModelAndView("errorPage");
            mView.addObject("message", "You need to be logged in to add a product!");
            
            return mView;
        }
        
        ModelAndView mView = new ModelAndView("user");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        
        UserDaoImpl userDao = (UserDaoImpl) context.getBean("userDao");
        User user = userDao.getUserById(Integer.parseInt(request.getParameter("userId"))); 
        mView.addObject("user", user);
     
        ((ConfigurableApplicationContext)context).close();
        
        /*ProductDaoImpl pdi = (ProductDaoImpl) context.getBean("productDao");
        UserDaoImpl  udi = (UserDaoImpl) context.getBean("userDao");
        System.out.println(product.getProductName());
        System.out.println(product.getCategoryId());
        System.out.println(product.getLocationId());
        udi.addUserProduct(1, product);*/
        
        return mView;
    }    
}
