package com.nagarro.tshirtsearch.controller;


	import java.io.IOException;
	import java.text.ParseException;
	import java.util.List;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

	import com.nagarro.tshirtsearch.model.*;

import com.nagarro.tshirtsearch.dao.*;
	import com.nagarro.tshirtsearch.service.ProductService;

	@Controller
	public class ProductController {

		@Autowired
		private ProductService productService;
		@Autowired
		private UserDao userDao;
		private static boolean flag = false;
		
		@RequestMapping("/")
		public String home()
		{
			
			System.out.println("this is home page");
			return "home";
		}
		// this is first login index.jsp page.
		@RequestMapping("/login")
		public String loginPage() 
		
		{
			
			
			if (!flag) 
		{
				this.productService.addProductEntries();
					flag = true;	
					}
			
			System.out.println("this is loginpage handler!!..");
			return "index";
		}
		
		@RequestMapping("/register")
		public String registerPage()
		{
			System.out.println("This is registration page handler");
			return "register";
		}
		
		@RequestMapping(path = "/checkuser")
		public String checkUser(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
			String uname = request.getParameter("name");
			String upass = request.getParameter("password");
			boolean isValidUser=userDao.findUser(uname);
			User user=new User(uname,upass);
			System.out.println(user);
			if(isValidUser)
			{	
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("current-user",user.getUserName());
				return "product";
			}
			else
			{
				System.out.println("Invalid Details");
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("message", "Invalid Details !!!");
				return "redirect:/login";
			}
			
		}
		@RequestMapping(path="/userregister", method=RequestMethod.POST)
		public String userregistration(HttpServletRequest request, Model model)throws IOException
		{
			String userName=request.getParameter("user_name");
			String userEmail=request.getParameter("user_email");
			String userPassword=request.getParameter("user_password");;
			User user=new User(userName, userPassword);
			if(!flag)
			{
				this.productService.addUserEntries(user);
				System.out.println("Successfull");
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("message", "User Registration Successfull !!");
				flag=true;
			}
			else
			{
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("message", "User Registration Unsuccessfull !!");
			}
			return "redirect:/register";
			
		}
		@RequestMapping(path = "/searchproducts", method = RequestMethod.POST)
		public String search(HttpServletRequest request, Model model) throws ParseException {
			String clr = request.getParameter("colour");
			String gndr = request.getParameter("gender");
			String sze = request.getParameter("size");
			String outpref = request.getParameter("outpref");
			List<Product> products=this.productService.getAllAvailableProducts(clr, gndr, sze, outpref);
			System.out.println(products.size());
			if (products.size() == 0) 
			{
				model.addAttribute("noproducts", "No Available Products !!..");
			} 
			else 
			{
				model.addAttribute("noproducts", "All Available Products Are Listed Below!!..");
			}
			model.addAttribute("products", products);
			return "availableproducts";
		}
		
		@RequestMapping("/logout")
		public String logout(HttpServletRequest request)
		{
			HttpSession httpSession=request.getSession();
			httpSession.removeAttribute("current-user");
			System.out.println("Logout page handler");
			return "index";
			
		}

		@RequestMapping("/product")
		public String productback()
		{
			
			return "product";
		}
	}




