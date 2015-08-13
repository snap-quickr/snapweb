package org.snap.shopoweb;


/*import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.omg.CORBA.Request;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
    @RequestMapping("/asearch")
    public String homePage(ModelMap model){
    	
        model.addAttribute("product","Hello vivek");
        return "details";
    }
    
    @RequestMapping("/login")
    public String loginPage(ModelMap model){
        //model.addAttribute("toDo",DataContainer.getHm().get("login"));
    	
        return "login";
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
    
    //@RequestMapping("/add.htm")
   //public ModelAndView addPage(@ModelAttribute("user") User user) throws ServletException, IOException{
    	/*ModelAndView model = new ModelAndView("add");
    	ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
    	//UserDapImpl u= UserDapImpl(ac.getBean("userDao"));
    	user.setUserName(user.getUserName());
    	user.setUserPassword(user.getUserPassword());
    	user.setUserEmail(user.getUserEmail());
    	user.setUserContact(user.getUserContact());
    	
    	
    	u.insertUser(user);
    	
        return model;*/
    //}

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
