package com.welle.users.fetch;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.welle.constant.fields.Fields;

@WebServlet("/FetchUsersInfo")
public class FetchUsersInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FetchUsersInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// init our singleton class for constant parameters
		Fields fields = Fields.getFieldsInstance();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(fields.getJdbcToOracleDb(), fields.getDbUser(),
					fields.getDbPass());

			PreparedStatement ps = con.prepareStatement("select * from " + fields.getDbName());

			out.print("<table width=50% border=1>");
			out.print("<caption>Result:</caption>");

			ResultSet rs = ps.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();

			// printing columns
			int total = rsmd.getColumnCount();
			out.print("<tr>");
			for (int i = 1; i <= total; i++) {
				out.print("<th>" + rsmd.getColumnName(i) + "</th>");
			}
			out.print("</tr>");

			// the result per row -> coloum
			while (rs.next()) {
				out.print("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
						+ "</td><td>" + rs.getString(4) + "</td>" + "<td>" + rs.getString(5) + "</td></tr>");
			}

			out.print("</table>");

		} catch (Exception e2) {
			e2.printStackTrace();
		}

		finally {
			out.close();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
