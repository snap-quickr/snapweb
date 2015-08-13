package org.snap.shopoweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    
    @RequestMapping("/home")
    public String homePage(ModelMap model){
       // model.addAttribute("toDo",DataContainer.getHm().get("home"));
        return "Hello";
    }
    
    @RequestMapping("/login")
    public String loginPage(ModelMap model){
        //model.addAttribute("toDo",DataContainer.getHm().get("login"));
        return "Hello";
    }
    
    @RequestMapping("/product")
    public String productPage(ModelMap model){
       // model.addAttribute("toDo",DataContainer.getHm().get("search"));
        return "Hello";
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

}
