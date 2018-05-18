package com.welle.users.fetch;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.welle.constant.fields.Fields;
import com.welle.users.user.User;

// this listener fires at the begining of starting our APP
// so we get our DB and keep it in list while storing it in our context

@WebListener
public class FetchUsersInfoListener implements ServletContextListener {

	public FetchUsersInfoListener() {

	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void contextInitialized(ServletContextEvent sce) {

		// init our singleton class for constant parameters
		Fields fields = Fields.getFieldsInstance();

		System.out.println("Servlet listener is fired!");

		ArrayList<User> list = new ArrayList<User>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(fields.getJdbcToOracleDb(), fields.getDbUser(),
					fields.getDbPass());

			PreparedStatement ps = con.prepareStatement("select * from " + fields.getDbName());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setCountry(rs.getString(5));
				list.add(u);
			}
			con.close();

		} catch (Exception ex) {
			System.out.print(ex);
		}

		// storing the ArrayList object in ServletContext
		ServletContext context = sce.getServletContext();
		context.setAttribute("data", list);

	}

}
