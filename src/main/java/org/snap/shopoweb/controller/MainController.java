package org.snap.shopoweb.controller;

/*import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.omg.CORBA.Request;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;*/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.snap.shopoweb.beans.Product;
import org.snap.shopoweb.dao.ProductDaoImpl;
import org.snap.shopoweb.dao.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
    @RequestMapping("/asearch")
    public String homePage(ModelMap model){
    	
        model.addAttribute("product","Hello vivek");
        return "details";
    }
    
    @RequestMapping("/product")
    public ModelAndView productPage(ModelMap model){
       return new ModelAndView("details");
    }
    
    @RequestMapping("/user")
    public String userPage(ModelMap model){
        //model.addAttribute("toDo",DataContainer.getHm().get("register"));
        return "Hello";
    }
    
    @RequestMapping("/add.htm")
    public ModelAndView addPage(@ModelAttribute("product") Product product) throws ServletException, IOException{
    	ModelAndView model = new ModelAndView("add");
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
    	
    	ProductDaoImpl pdi = (ProductDaoImpl) context.getBean("productDao");
    	UserDaoImpl  udi = (UserDaoImpl) context.getBean("userDao");
    	System.out.println(product.getProductName());
    	System.out.println(product.getCategoryId());
    	System.out.println(product.getLocationId());
    	udi.addUserProduct(1, product);
    	
    	
        return model;
    }

    @RequestMapping("/add")
    public String addPage(ModelMap model){
        //model.addAttribute("toDo",DataContainer.getHm().get("addpro"));
        return "Hello";
    }
    
    @RequestMapping("/validate")
    public String validateLogin(ModelMap model)
    {	
    	return "home";
    }
    
    @RequestMapping("/product")
    public ModelAndView showProduct(HttpServletRequest req, HttpServletResponse res){
    	return new ModelAndView("product");
    }

}
