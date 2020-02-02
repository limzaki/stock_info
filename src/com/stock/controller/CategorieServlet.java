package com.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.model.Categorie;
import com.stock.service.CategorieService;

@WebServlet("/CategorieServlet")
public class CategorieServlet extends HttpServlet {

	private static final String CATEGORIE_SERVLET_ACTION_GET = "/CategorieServlet?action=get";
	private static final String CATEGORIE_PAGE = "categorie/categorie.jsp";
	private static final String CATEGORIE_FORM = "categorie/categorieForm.jsp";

	private CategorieService categorieService;

	@Override
	public void init() throws ServletException {
		categorieService = new CategorieService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			if(action.contains("new")) {
				displayCategorieForm(request, response);
			}else if(action.contains("add")) {
				addCategorie(request, response);
			}else if(action.contains("delete")) {
				deleteCategorie(request, response);
			}else if(action.contains("modify")) {
				displayEditCategorieForm(request, response);
			}else if(action.contains("edit")) {
				editCategorie(request, response);
			}else {
				listCategories(request, response);
			}
		}
	}

	private void displayCategorieForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(CATEGORIE_FORM);
		dispatcher.forward(request, response);	
	}
	
	private void displayEditCategorieForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCategorie = Integer.parseInt(request.getParameter("id"));
		Categorie existingCategorie = categorieService.getCategorieById(idCategorie);
		request.setAttribute("categorie", existingCategorie);
		RequestDispatcher dispatcher = request.getRequestDispatcher(CATEGORIE_FORM);
		dispatcher.forward(request, response);	
	}

	private void addCategorie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String designation = request.getParameter("designation");
		categorieService.addCategorie(new Categorie(designation));
		response.sendRedirect(request.getContextPath() + CATEGORIE_SERVLET_ACTION_GET);
	}
	
	private void editCategorie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
		String designation = request.getParameter("designation");
		categorieService.editCategorie(new Categorie(idCategorie, designation));
		response.sendRedirect(request.getContextPath() + CATEGORIE_SERVLET_ACTION_GET);
	}

	private void deleteCategorie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCategorie = Integer.parseInt(request.getParameter("id"));
		categorieService.removeCategorie(idCategorie);
		response.sendRedirect(request.getContextPath() + CATEGORIE_SERVLET_ACTION_GET);
	}

	private void listCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> categories = categorieService.getAllCategories();
		request.setAttribute("categories", categories);
		RequestDispatcher dispatcher = request.getRequestDispatcher(CATEGORIE_PAGE);
		dispatcher.forward(request, response);
	}

}
