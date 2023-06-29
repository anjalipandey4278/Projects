package com.nagarro.springassignment.controller;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.nagarro.springassignment.constants.Constants;
import com.nagarro.springassignment.dao.UserDao;
import com.nagarro.springassignment.model.Author;
import com.nagarro.springassignment.model.Product;
import com.nagarro.springassignment.model.User;
import com.nagarro.springassignment.service.UserService;



@Controller
public class MainController {



	@Autowired
	private UserService userService;
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
		
		System.out.println("this is loginpage handler!!..");
		return "index";
	}
	
	@RequestMapping("/register")
	public String registerPage()
	{
		System.out.println("This is registration page handler");
		return "register";
	}
	@RequestMapping("/book")
	public  ModelAndView bookpage() 
	
	{
		
		RestTemplate r =new RestTemplate();

		
		Object[] bookList = r.getForObject(Constants.getBook_url, Object[].class);
		System.out.println("this is Bookig handler!!..");
		System.out.print(Arrays.asList(bookList));
		ModelAndView mv = new ModelAndView("book");
		
		mv.addObject("bookList",bookList);
	
		return mv;
		
	}
	@RequestMapping("/delete")
	    public String delete(@RequestParam int id) {
			RestTemplate r =new RestTemplate();
			 r.delete(Constants.getBook_url_id,id);
			 
	        
	       bookpage(); 
	       return "redirect:/book";

	    }
	@RequestMapping("/addBook")
	public ModelAndView addbookpage( ) {
		System.out.print("insert page");
		RestTemplate r =new RestTemplate();
		Object[] authorList = r.getForObject(Constants.getAurthor_url, Object[].class);
		ModelAndView mv = new ModelAndView("addBook");
		mv.addObject("authorList",authorList);
		return mv;
	}
	
	@RequestMapping("/editview")
	public ModelAndView editview(@RequestParam int id ) {
		RestTemplate r =new RestTemplate();
		Product bookList = r.getForObject(Constants.getBook_url+ id, Product.class);
		Object[] auth=r.getForObject(Constants.getAurthor_url,Object[].class);
		ModelAndView mv = new ModelAndView("editBook");
		mv.addObject("bookList",bookList);
		mv.addObject("authorList",auth);
		return mv;
		
		
	}
	
		
		@RequestMapping("/update")
	    public String update(@RequestParam Long bookCode,@RequestParam String bookName, @RequestParam String bookAuthor,@RequestParam String dateTime) {
			RestTemplate r =new RestTemplate();
			Product p = new Product(bookCode,bookName,bookAuthor,dateTime);
			Product res = r.postForObject(Constants.getBook_url, p, Product.class);
			if(res == null) {
				System.out.println("added done");
			}
			return "redirect:/book";
		}
	    
		
	
	
	
	@RequestMapping("/insert")
	public String insert( @RequestParam Long bookCode, @RequestParam String bookName, @RequestParam String bookAuthor,@RequestParam String dateTime) {
		RestTemplate r =new RestTemplate();
		Product p = new Product(bookCode,bookName,bookAuthor,dateTime);
		Product res = r.postForObject(Constants.getBook_url, p, Product.class);
		if(res == null) {
			System.out.println("added done");
		}
		return "redirect:/book";
	}
  
	
	@RequestMapping(path = "/checkuser")
	public String checkUser( HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
		
		
		String uname = request.getParameter("name");
		String upass = request.getParameter("password");
		User isValidUser = userDao.getUserByNameAndPassword(uname,upass);
		User user=new User(uname,upass);
		
		if(isValidUser!= null )
		{	
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("current-user",user.getUserName());
			System.out.println(user.getUserName());
			ModelAndView mv = new ModelAndView("navbar");
			mv.addObject("user",user.getUserName());
			return "redirect:/book";
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
		User user=new User(userName,userEmail, userPassword);
		if(flag==false)
		{
			this.userService.addUserEntries(user);
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
		return "redirect:/book";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		HttpSession httpSession=request.getSession();
		httpSession.removeAttribute("current-user");
		System.out.println("Logout page handler");
		return "redirect:/login";
		
	
}
}


