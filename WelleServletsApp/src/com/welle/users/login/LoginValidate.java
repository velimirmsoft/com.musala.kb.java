package com.welle.users.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.welle.constant.fields.Fields;

public class LoginValidate {

	public static boolean validate(String name, String pass) {

		boolean status = false;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(Fields.jdbcToOracleDb, Fields.DbUser, Fields.DbPass);

			PreparedStatement ps = con.prepareStatement("select * from " + Fields.DbName + " where name=? and pass=?");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			// returns tru if we got the record we want
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

}
