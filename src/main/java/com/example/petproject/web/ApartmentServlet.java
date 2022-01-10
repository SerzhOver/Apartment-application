package com.example.petproject.web;

import com.example.petproject.DAO.ApartmentDAO;
import com.example.petproject.entity.Apartment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class ApartmentServlet extends HttpServlet {

	private ApartmentDAO apartmentDAO;

	public ApartmentServlet() {
		this.apartmentDAO = new ApartmentDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();
		switch (action) {
			case "/new":
				showNewForm(req, resp);
			case "/add":
				addApartment(req, resp);
				break;
			case "/delete":
				deleteApartment(req, resp);
				break;
			case "/edit":
				showEditForm(req, resp);
				break;
			case "/update":
				updateApartment(req, resp);
				break;
			default:
				listApartment(req, resp);
				break;
		}

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("form.jsp");
		requestDispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Apartment existingApartment = apartmentDAO.getByID(id);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("form.jsp");
		request.setAttribute("apartment", existingApartment);
		requestDispatcher.forward(request, response);
	}

	private void addApartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String city = request.getParameter("city");
		int price = Integer.parseInt(request.getParameter("price"));
		int room = Integer.parseInt(request.getParameter("room"));
		Apartment apartment = new Apartment(city, price, room);
		apartmentDAO.add(apartment);
		response.sendRedirect("list");

	}

	private void listApartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Apartment> listApartment = apartmentDAO.getAllApartment();
		request.setAttribute("listApartment", listApartment);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("apartmentList.jsp");
		requestDispatcher.forward(request, response);
	}

	private void updateApartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String city = request.getParameter("city");
		int price = Integer.parseInt(request.getParameter("price"));
		int room = Integer.parseInt(request.getParameter("room"));
		Apartment apartment = new Apartment(id, city, price, room);
		apartmentDAO.update(apartment);
		response.sendRedirect("list");
	}

	private void deleteApartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		apartmentDAO.delete(id);
		response.sendRedirect("list");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
