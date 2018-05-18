package com.welle.users.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.welle.constant.fields.Fields;

public class LoginValidate {

	public static boolean validate(String name, String pass) {

		// init our singleton class for constant parameters
		Fields fields = Fields.getFieldsInstance();

		boolean status = false;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(fields.getJdbcToOracleDb(), fields.getDbUser(),
					fields.getDbPass());

			PreparedStatement ps = con
					.prepareStatement("select * from " + fields.getDbName() + " where name=? and pass=?");
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
