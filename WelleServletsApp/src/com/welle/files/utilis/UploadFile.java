package com.welle.files.utilis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.welle.constant.fields.Fields;

@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadFile() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// init our singleton class for constant parameters
		Fields fields = Fields.getFieldsInstance();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		MultipartRequest m = new MultipartRequest(request, fields.getUpDownFolder());
		out.print("successfully uploaded");

	}

}
