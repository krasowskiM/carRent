package info.krasm.domainTest;

import java.io.*;
import java.sql.*;
//import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.krasm.dao.ClientDao;
import info.krasm.htmlParts.DivSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// starting html
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Car rentals";
		String docType = "<!DOCTYPE html>\n";
		String pathVar = request.getContextPath()+"/css/styles.css";
		String styleCss = "<link rel=\"stylesheet\" type=\"text/css\" href=\""+ pathVar +"\">";
		out.println(docType + "<html>\n" + "<head><meta charset=\"utf-8\"><title>" + title + "</title>"
				+ styleCss +"</head>\n"
				+ "<body>\n");
		// homepage starts
		
			out.println("<div id=\"page\">\n" + "<div id=\"banner\">\n" + "<div id=\"title\">\n" + "</div>\n"
					+ "<div id=\"loginForm\">\n" + "<form method=\"POST\" action=\"LoginServlet\">\n"
					+ "Username: <input type=\"text\" name=\"username\">\n"
					+ "<br>Password: <input type=\"password\" name=\"password\">\n" + "<br><input type=\"submit\">\n" + "</form>\n"
					+ "</div>" + "</div>\n" + "<div id=\"menuNav\">\n" + "<ul>\n"
					+ "<li><a href=\"TestServlet\">Home</a></li>\n" + "<li><a href=\"Gallery\">Gallery</a></li>\n"
					+ "<li><a href=\"Register\">Register form</a></li>\n" + "<li><a href=\"Base\">Base</a></li>\n"
					+ "</ul>\n" + "</div>" + "<div id=\"content\">");
					// formularz rejestracji
					//
					out.println("<div id=\"regForm\">\n"
							+ "<form method=\"POST\" action=\"Registered\">\n"
							+ "Please fill in the form to register.<br><br>\n"
							+ "Username: <br><input type=\"text\" name=\"username\"><br>"
							+ "Password: <br><input type=\"password\" name=\"password\"><br>"
							+ "E-mail: <br><input type\"email\" name=\"email\"><br>"
							+ "<input type=\"submit\">"
							+ "</form>"
							+ "</div>");
			
			out.println("</div>\n" + "<div id=\"footer\">\n" + "Copyright MK 2016, życzę miłego pobytu na stronce"
					+ "</div>\n" + "</div>");
			out.println("</body></html>");
	}

}
