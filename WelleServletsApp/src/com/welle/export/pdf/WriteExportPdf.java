package com.welle.export.pdf;

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

import com.darwinsys.spdf.MoveTo;
import com.darwinsys.spdf.PDF;
import com.darwinsys.spdf.Page;
import com.darwinsys.spdf.Text;
import com.welle.users.user.User;

@WebServlet("/WriteExportPdf")
public class WriteExportPdf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WriteExportPdf() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename='users.pdf'");

		PDF mainPdfObject = new PDF(out);

		// get users data from context that we privously store via Listener on our
		// application start
		
		ServletContext context = getServletContext();
		List<User> list = (List<User>) context.getAttribute("data");

		int users = list.size();
		int userCounter = 0;
		int perPage = 0;
		int usersPerPage = 10;
		
		// check variables for one or more pages
		if((users / 10) == 0) {
			perPage = 1;
			usersPerPage = users;
		}
		
		// so we want to have max 10 users per page
		for (int i = 1; i <= perPage; i++) {
			// create a page
			Page page = new Page(mainPdfObject);
			page.add(new MoveTo(mainPdfObject, 20, 720)); 
			for(int j = 1; j <= usersPerPage; j++) {
				// get user
				User u = list.get(userCounter);
				// System.out.println(u.getName());
				page.add(new Text(mainPdfObject, "" + u.getId() + " | " + u.getName() + " | " 
						+ u.getPassword() + " | " + u.getEmail() + " | " + u.getCountry()));
				userCounter++;
			}
			mainPdfObject.add(page);
		}
		
		mainPdfObject.setAuthor("Welle's web app!");
		mainPdfObject.writePDF();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
