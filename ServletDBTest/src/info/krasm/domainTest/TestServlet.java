package info.krasm.domainTest;

import java.io.*;
//import java.sql.*;
//import java.util.List;

//import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.krasm.htmlParts.DivSource;
import info.krasm.htmlParts.FrontEndDependencies;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// starting html
		//masakra ten naglowek
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DivSource ds = new DivSource();
		String title = "Car rentals";
		String docType = "<!DOCTYPE html>\n";
		String pathVar = request.getContextPath()+"/css/styles.css";
		String tablePathVar = request.getContextPath()+"/css/carTable.css";
		String styleCss = "<link rel=\"stylesheet\" type=\"text/css\" href=\""+ pathVar +"\">";
		String carTableCss = "<link rel=\"stylesheet\" type=\"text/css\" href=\""+ tablePathVar +"\">";
		String popupScriptPath = request.getContextPath() + "/popups.js";
		String popupScript = "<script src =\""+ popupScriptPath +"\"></script>";
		out.println(docType + "<html>\n" + "<head><meta charset=\"utf-8\"><title>" + title + "</title>"
				+ styleCss + "\n" + carTableCss + FrontEndDependencies.JS_COLORBOX 
				+ FrontEndDependencies.JQUERY_SETUP + popupScript +
				"</head>\n<body>\n");
		// homepage starts
		
			out.println("<div id=\"page\">\n" + "<div id=\"banner\">\n" + "<div id=\"title\">\n" + "</div>\n"
					+ "<div id=\"loginForm\">\n" + "<form method=\"POST\" action=\"LoginServlet\">\n"
					+ "Username: <input type=\"text\" name=\"username\">\n"
					+ "<br><br>Password: <input type=\"password\" name=\"password\">\n" + "<br><input type=\"submit\">\n" + "</form>\n"
					+ "</div>" + "</div>\n" + "<div id=\"menuNav\">\n" + "<ul>\n"
					+ "<li><a href=\"TestServlet\">Home</a></li>\n" + "<li><a href=\"Gallery\">Gallery</a></li>\n"
					+ "<li><a href=\"Register\">Register form</a></li>\n" + "<li><a href=\"Base\">Base</a></li>\n"
					+ "</ul>\n" + "</div>" + "<div id=\"content\">");
					// potrzebna lista samochodów z bazy
					//
					ds.createCarTable(response);
			out.println("<div id=\"invisible_window\">\n");
			//formularz pobierania danych do wypozyczenia
					ds.createRentalForm(response);
			out.println("</div>\n");
					
			out.println("</div>\n" + "<div id=\"footer\">\n" + "Copyright MK 2016, życzę miłego pobytu na stronce"
					+ "</div>\n" + "</div>");
			out.println("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
