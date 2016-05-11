package info.krasm.htmlParts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import info.krasm.dao.CarDao;
import info.krasm.dao.ClientDao;
import info.krasm.query.TableRow;

public class DivSource {
	
	public void formatClientResults(HttpServletResponse response) throws ServletException, IOException {
		ClientDao client = new ClientDao();
		PrintWriter out = response.getWriter();
		try {
			List<TableRow> trs = client.selectAllClients();
			for (int i = 0; i < trs.size(); i++) {
				TableRow tr = trs.get(i);
				String name = tr.getValueString("Imie");
				String surname = tr.getValueString("Nazwisko");
				String phone = tr.getValueString("Phone");
				String email = tr.getValueString("Email");
				// jest w tym jakis sens? :F

				out.println(name + " " + surname + " " + phone + " " + email + "<br>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createCarTable(HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		CarDao cars = new CarDao();
		String manufacturer;
		String model;
		
		out.println("<div id=\"table_cars\">\n");
		out.println("<table id =\"cars\">\n");
		out.println("<tr>\n" + "<th>Manufacturer</th>\n" + "<th>Model</th>\n" + "<th>GasType</th>\n" + "<th>Details</th>\n" + "<th>Rent</th>\n"
				+ "</tr>\n");
		try {
			List<TableRow> trs = cars.selectAllCars();
			for (int i = 0; i < trs.size(); i++) {
				TableRow tr = trs.get(i);
				manufacturer = tr.getValueString("Marka");
				model = tr.getValueString("Model");

				out.println(
						"<tr>\n" + "<td>" + manufacturer + "</td>\n" + "<td>" + model + "</td>\n" + "<td>            </td>\n"
								+ "<td><button onclick=\"details()\">Details</button></td>"
								+ "<td><button onclick=\"rentForm()\">Rent</button></td>" + "</tr>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			out.println("If you cannot see the car table content, please contact with the administrator or the firm.");
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("If you cannot see the car table content, please contact with the administrator or the firm.");
		}
		
		out.println("</table>");
		out.println("</div>");
	}
	
	public void createRentalForm(HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		//tworzenie formularza (html)
		out.println("<form method=\"POST\" action=\"ClientRental\">\n"
				+ "Name: <br>"
				+ "<input type=\"text\" name=\"name\">\n<br>"
				+ "Surname: <br>"
				+ "<input type=\"text\" name=\"surname\">\n<br>"
				+ "Phone: <br>"
				+ "<input type=\"text\" name=\"phone\">\n<br>"
				+ "Email: <br>"
				+ "<input type=\"text\" name=\"email\">\n<br>"
				+ "<input id=\"formSubmit\" type=\"submit\" value=\"Rent\">"
				+ "</form>"
				+ "<button onclick=\"cancel()\">Cancel</button>");
	}
	
	public void createCarDetailWindow(HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		//tworzenie okienka z zawartoscia szczegolow o aucie
		out.println("<>");
		
	}
}

	
