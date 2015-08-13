package org.snap.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Handler {
	
	public static void main(String args[])
	{
		 ApplicationContext context = 
	             new ClassPathXmlApplicationContext("jdbc.xml");
		 
		 UserDaoImpl userdao=(UserDaoImpl)context.getBean("userDao");
		 ProductDaoImpl productDao=(ProductDaoImpl)context.getBean("productDao");
		 
		/* User u=new User();
		 u.setUserId(2);
		 u.setUserContact("94839388");
		 u.setUserEmail("vgoyal200@gmail.com");
		 u.setUserName("vipul");
		 u.setUserPassword("vipul");
		 
		 userdao.saveUser(u);*/
		 
//		 Product p=new Product();
//		 p.setCategoryId(1);
//		 p.setLocationId(1);
//		 p.setProductDetail("productDetail");
//		 p.setProductId(1);
//		 p.setUrl("dfa");
//		 
//		 userdao.addUserProduct(2, p);
		 
		 
		/* User u=userdao.getUser(2);
		 System.out.println(u.userName);*/
		 
		 List<Product> p = productDao.selectProductByLocation(1);
		 
		 for(Product x:p)
		 {
			 System.out.println(x.getUrl());
		 }
		 

		 
	}

}
