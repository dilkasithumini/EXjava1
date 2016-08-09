package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CrudDao;
import com.model.Garage;

/**
 * Servlet implementation class GarageController
 */
@WebServlet("/GarageController")
public class GarageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/garage.jsp";
	private static String LIST_GARAGE = "/listGarage.jsp";
	private CrudDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GarageController() {
		super();
		dao = new CrudDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			int Id = Integer.parseInt(request.getParameter("id"));
			dao.deleteGarage(Id);
			forward = LIST_GARAGE;
			request.setAttribute("garage", dao.getAllGarages());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int Id = Integer.parseInt(request.getParameter("id"));
			Garage garage = dao.getGarageById(Id);
			request.setAttribute("garage", garage);
		} else if (action.equalsIgnoreCase("listGarage")) {
			forward = LIST_GARAGE;
			request.setAttribute("users", dao.getAllGarages());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Garage garage = new Garage();
		garage.setName(request.getParameter("name"));
		garage.setCategory(request.getParameter("category"));

		garage.setAddress(request.getParameter("address"));
		String id = request.getParameter("id");
		if (id == null || id.isEmpty()) {
			dao.addGarage(garage);
		} else {
			garage.setId(Integer.parseInt(id));
			dao.updateGarage(garage);
		}
		RequestDispatcher view = request.getRequestDispatcher(LIST_GARAGE);
		request.setAttribute("garage", dao.getAllGarages());
		view.forward(request, response);
	}

}
