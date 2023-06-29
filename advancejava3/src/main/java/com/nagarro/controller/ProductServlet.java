package com.nagarro.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.nagarro.Dao.ProductDao;
import com.nagarro.entities.Admin;
import com.nagarro.entities.ProductDetails;
import com.nagarro.helper.Factoryprovider;

/**
 * Servlet implementation class ProductServlet
 */
@MultipartConfig(maxRequestSize = 1024 * 1024 * 10) // 10 MB

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		try {
			String Title = request.getParameter("Title");
			String Quantity = request.getParameter("Quantity");
			String Size = request.getParameter("Size");
			Part part = request.getPart("Image");
			System.out.println(part);

			ProductDetails product = new ProductDetails();
			product.setItemTitle(Title);
			product.setItemQuantity(Quantity);
			product.setSize(Size);
			product.setImage(part.getSubmittedFileName());

			HttpSession session = request.getSession();
			Admin admin = (Admin) session.getAttribute("currentAdmin");
			ProductDao d = new ProductDao(Factoryprovider.getFactory());

			boolean f = d.saveProduct(product, admin);
			System.out.println(f);
			System.out.println("\nadmin:" + admin);

			// pic upload on folder

			// path to upload photo
			
			String path = request.getRealPath("img") + File.separator + "products" + File.separator
					+ part.getSubmittedFileName();
			System.out.println(path);

			// uploading code

			try {
				FileOutputStream fos = new FileOutputStream(path);
				InputStream is = part.getInputStream();

				// reading data

				byte[] data = new byte[is.available()];

				is.read(data);

				// writing the data

				fos.write(data);
				fos.close();
				session.setAttribute("message", "Product is added successfully");
				response.sendRedirect("Admin.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			System.out.println("file size is more");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('total size should be less than 10 MB')");
			out.println("location='Admin.jsp';");
			out.println("</script>");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
