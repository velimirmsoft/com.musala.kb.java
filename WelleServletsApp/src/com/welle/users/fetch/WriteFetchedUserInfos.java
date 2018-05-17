package com.welle.users.fetch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.welle.users.user.User;

@WebServlet("/WriteFetchedUserInfos")
public class WriteFetchedUserInfos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WriteFetchedUserInfos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		long before = System.currentTimeMillis();

		ServletContext context = getServletContext();
		List<User> list = (List<User>) context.getAttribute("data");

		Iterator<User> itr = list.iterator();
		while (itr.hasNext()) {
			User u = (User) itr.next();
			out.print("<br>" + u.getId() + " " + u.getName() + " " + u.getPassword());
		}

		long after = System.currentTimeMillis();
		out.print("<br>total time :" + (after - before));

		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
