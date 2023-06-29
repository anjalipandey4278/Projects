package com.nagarro.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nagarro.Dao.ProductDao;
import com.nagarro.helper.Factoryprovider;

/**
 * Servlet implementation class UpdateServlet
 */
@MultipartConfig
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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
//		try {

		String Title = request.getParameter("Title");
		String Quantity = request.getParameter("Quantity");
		String Size = request.getParameter("Size");
		Part part = request.getPart("Image");
		int productID = Integer.parseInt(request.getParameter("pid"));

		ProductDao d = new ProductDao(Factoryprovider.getFactory());
		String path = request.getRealPath("img") + File.separator + "products" + File.separator
				+ part.getSubmittedFileName();
		System.out.println(path);
		d.updateProduct(Title, Quantity, Size, part, productID, path);
		response.sendRedirect("Admin.jsp");

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
