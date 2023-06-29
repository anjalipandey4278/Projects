package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.Dao.ProductDao;
import com.nagarro.helper.Factoryprovider;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int productID = Integer.parseInt(request.getParameter("product_id").trim());
			ProductDao d = new ProductDao(Factoryprovider.getFactory());
			boolean f = d.deleteProduct(productID);
			System.out.println("product deleted=" + f);
			response.sendRedirect("Admin.jsp");
		} catch (Exception e) {

		}

	}

}
