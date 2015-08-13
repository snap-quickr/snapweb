package org.snap.dao;
//package org.snap.shopoweb;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	
	public ModelAndView userDetails(int id)
	{
	//ProductDaoImpl pdao=
	ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
	
	ProductDaoImpl pdetail = (ProductDaoImpl) context.getBean("productDao");
	UserDaoImpl  udetail = (UserDaoImpl) context.getBean("userDao");
	User user = udetail.getUser(id);
	ArrayList<Product> plist =  pdetail.getProduct(id);
	
	
	ModelAndView mav = new ModelAndView();
	mav.setViewName("userdetail");
	mav.addObject("user", user);
	mav.addObject("plist", plist);
	return mav;
	}
	

}
