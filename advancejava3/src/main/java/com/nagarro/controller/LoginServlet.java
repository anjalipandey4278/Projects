package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.Dao.AdminDao;
import com.nagarro.entities.Admin;
import com.nagarro.helper.Factoryprovider;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(email + password);
		// authentication
		AdminDao userdao = new AdminDao(Factoryprovider.getFactory());

		Admin u1 = userdao.getUser(email, password);
		System.out.println("login:" + u1);
		HttpSession httpsession = req.getSession();

		if (u1 == null) {
			httpsession.setAttribute("message", "Invalid credentials");
			resp.sendRedirect("index.jsp");
			return;
		} else {
			httpsession.setAttribute("currentAdmin", u1);

			// redirect to admin.jsp
			resp.sendRedirect("Admin.jsp");

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
