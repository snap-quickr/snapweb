package org.snap.shopoweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    

}
