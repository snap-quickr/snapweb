package org.snap.shopoweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.snap.shopoweb.beans.Category;
import org.snap.shopoweb.beans.Location;
import org.snap.shopoweb.beans.Product;
import org.snap.shopoweb.dao.CategoryDao;
import org.snap.shopoweb.dao.LocationDao;
import org.snap.shopoweb.dao.ProductDao;
import org.snap.shopoweb.dao.ProductDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {    

    @RequestMapping("/add.htm")
    public ModelAndView addPage(HttpServletRequest request, HttpServletResponse response){

        if(request.getParameter("userId")==null){
            ModelAndView mView = new ModelAndView("errorPage");
            mView.addObject("message", "You need to be logged in to add a product!");
            return mView;
        }

        ModelAndView mView = new ModelAndView("add");

        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        LocationDao locationDao = (LocationDao) context.getBean("locationDao");
        List<Location> locations = locationDao.getAllLocations();

        CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
        List<Category> categories = categoryDao.getAllCategories();

        mView.addObject("locations", locations);
        mView.addObject("categories", categories);        
        mView.addObject("userId", request.getParameter("userId"));

        ((ConfigurableApplicationContext)context).close();

        /*ProductDaoImpl pdi = (ProductDaoImpl) context.getBean("productDao");
        UserDaoImpl  udi = (UserDaoImpl) context.getBean("userDao");
        System.out.println(product.getProductName());
        System.out.println(product.getCategoryId());
        System.out.println(product.getLocationId());
        udi.addUserProduct(1, product);*/            
        return mView;
    }

    @RequestMapping("/saveProduct.htm")
    public ModelAndView saveProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        ModelAndView mView = new ModelAndView("home");        
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");

        Product product = new Product();
        product.setLocationId(Integer.parseInt(request.getParameter("locationId")));
        product.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
        product.setProductName(request.getParameter("productName"));
        product.setPrice(Integer.parseInt(request.getParameter("price")));
        product.setProductDetail((request.getParameter("productDetail")));
        product.setUserId(Integer.parseInt(request.getParameter("userId")));

        ProductDao productDao = (ProductDao) context.getBean("productDao");
        productDao.addProduct(product);        

        ((ConfigurableApplicationContext)context).close();
        return mView;
    }

    @RequestMapping("/showProduct.htm")
    public ModelAndView getProductsByLocationAndProductId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModelAndView mView = new ModelAndView("product");        
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");

        int pid=Integer.parseInt(request.getParameter("productId"));
        int lid=Integer.parseInt(request.getParameter("locationId"));

        ProductDao productDao = (ProductDao) context.getBean("productDao");
        Product product = productDao.getProductsByLocationAndProductId(lid,pid);       
        request.setAttribute("product",product );

        return mView;
    }
}


/*public ModelAndView userDetails(int id)
{
    //ProductDaoImpl pdao=
    ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
    ProductDaoImpl pdetail = (ProductDaoImpl) context.getBean("productDao");
    UserDaoImpl udetail = (UserDaoImpl) context.getBean("userDao");
    User user = udetail.getUser(id);
    ArrayList<Product> plist =  pdetail.getProduct(id);
    ModelAndView mav = new ModelAndView();
    mav.setViewName("userdetail");
    mav.addObject("user", user);
    mav.addObject("plist", plist);
    return mav; 
    return null;
 }*/
