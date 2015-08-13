package org.snap.shopoweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    
    @RequestMapping("/home")
    public String homePage(ModelMap model){
        model.addAttribute("message","Hello vivek");
        return "Hello";
    }
    
    @RequestMapping("/login")
    public String loginPage(ModelMap model){
        model.addAttribute("message","Hello Spring");
        return "Hello";
    }
    
    @RequestMapping("/product")
    public String productPage(ModelMap model){
        model.addAttribute("message","Hello Spring");
        return "Hello";
    }
    
    @RequestMapping("/user")
    public String userPage(ModelMap model){
        model.addAttribute("message","Hello Spring");
        return "Hello";
    }
    
    @RequestMapping("/add")
    public String addPage(ModelMap model){
        model.addAttribute("message","Hello Spring");
        return "Hello";
    }

}
