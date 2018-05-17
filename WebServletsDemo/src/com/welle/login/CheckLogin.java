package com.welle.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletContext context;

	public CheckLogin() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

		System.out.println("--------------------------------------------");
		System.out.println("servlet on init! - CheckLogin");

		context = config.getServletContext();

		// getting the value of the initialization parameter and printing it
		String driverName = context.getInitParameter("parName");
		System.out.println("We read this from our web.xml as parapetar -> parName = " + driverName);

	}

	public void destroy() {
		System.out.println("servlet on destroy! - CheckLogin");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// check if we actually have a previous cookie
		Cookie cks[] = request.getCookies();
		for (int i = 0; i < cks.length; i++) {
			System.out.println("cookie = " + cks[i].getName() + " " + cks[i].getValue());
			// if we got the cookie redirect to MyAppContent
			if (cks[i].getValue().equals("123")) {
				RequestDispatcher rd = request.getRequestDispatcher("MyAppContent");
				rd.forward(request, response);
			}
		}

		String n = request.getParameter("userName");
		String p = request.getParameter("userPass");

		if (n != null && p != null) {
			if (n.equals("welle") && p.equals("123")) {

				// set cookie ?
				Cookie ck = new Cookie("pass", "" + p); // creating cookie object
				// 60 secs our cookie will live
				ck.setMaxAge(60);
				response.addCookie(ck); // adding cookie in the response

				RequestDispatcher rd = request.getRequestDispatcher("MyAppContent");
				rd.forward(request, response);

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.html");
				rd.include(request, response);
			}
		}

		// send data though Attributes to another Servlet
		context.setAttribute("whoToKill", "noOne!");

		System.out.println("--------------------------------------------");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// call doGet - common practice nothing special
		doGet(request, response);
	}

}
