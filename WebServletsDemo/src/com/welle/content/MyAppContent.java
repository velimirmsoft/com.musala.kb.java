package com.welle.content;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyAppContent")
public class MyAppContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServletContext context;

	public MyAppContent() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("--------------------------------------------");
		System.out.println("servlet on init! - MyAppContent");

		context = config.getServletContext();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("You are in our APP. Served at: ").append(request.getContextPath());
		
		String n = (String) context.getAttribute("whoToKill");
		// System.out.println("We got this from another SERVLET! -> whoToKill = " + n);

		// check if we actually have a previous cookie
		Cookie cks[] = request.getCookies();
		for (int i = 0; i < cks.length; i++) {
			System.out.println("cookie = " + cks[i].getName() + " " + cks[i].getValue()); // printing name and value of																			// cookie
		}
		
		System.out.println("--------------------------------------------");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// call doGet - common practice nothing special
		doGet(request, response);
	}

}
