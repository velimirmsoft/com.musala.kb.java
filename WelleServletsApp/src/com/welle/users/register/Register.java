package com.welle.users.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("userName");
		String p = request.getParameter("userPass");
		String e = request.getParameter("userEmail");
		String c = request.getParameter("userCountry");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "WELLE", "admin");

			// System.out.println("" + con);

			PreparedStatement ps = con.prepareStatement("insert into registeruser values(?,?,?,?,?)");

			ps.setInt(1, 0);
			ps.setString(2, n);
			ps.setString(3, p);
			ps.setString(4, e);
			ps.setString(5, c);

			int i = ps.executeUpdate();
			if (i > 0)
				out.print("You are successfully registered ...");

		} catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();
	}

}