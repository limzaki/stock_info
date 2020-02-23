package com.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.model.Materiel;
import com.stock.service.ICategorieService;
import com.stock.service.IMaterielService;
import com.stock.service.impl.CategorieService;
import com.stock.service.impl.MaterielService;

@WebServlet("/MaterielServlet")
public class MaterielServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String MATERIEL_SERVLET_ACTION_GET = "/MaterielServlet?action=get";
	private static final String MATERIEL_PAGE = "materiel/materiel.jsp";
	private static final String MATERIEL_FORM = "materiel/materielForm.jsp";

	private IMaterielService materielService;

	private ICategorieService categorieService;

	@Override
	public void init() throws ServletException {
		materielService = new MaterielService();
		categorieService = new CategorieService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			if(action.contains("new")) {
				displayMaterielForm(request, response);
			}else if(action.contains("add")) {
				addMateriel(request, response);
			}else if(action.contains("delete")) {
				deleteMateriel(request, response);
			}else if(action.contains("modify")) {
				displayEditMaterielForm(request, response);
			}else if(action.contains("edit")) {
				editMateriel(request, response);
			}else {
				listMateriels(request, response);
			}
		}
	}

	private void displayMaterielForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(MATERIEL_FORM);
		request.setAttribute("categories", categorieService.getAllCategories());
		dispatcher.forward(request, response);	
	}

	private void displayEditMaterielForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idMateriel = Integer.parseInt(request.getParameter("id"));
		Materiel existingMateriel = materielService.getMaterielById(idMateriel);
		request.setAttribute("materiel", existingMateriel);
		RequestDispatcher dispatcher = request.getRequestDispatcher(MATERIEL_FORM);
		dispatcher.forward(request, response);	
	}

	private void addMateriel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nomMateriel = request.getParameter("nomMateriel");
		int quantiteStock = Integer.parseInt(request.getParameter("quantiteStock"));
		double prixUnitaire = Double.parseDouble(request.getParameter("prixUnitaire"));
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));

		materielService.addMateriel(new Materiel(categorieService.getCategorieById(idCategorie), nomMateriel, quantiteStock, prixUnitaire));
		response.sendRedirect(request.getContextPath() + MATERIEL_SERVLET_ACTION_GET);
	}

	private void editMateriel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idMateriel = Integer.parseInt(request.getParameter("idMateriel"));
		String nomMateriel = request.getParameter("nomMateriel");
		int quantiteStock = Integer.parseInt(request.getParameter("quantiteStock"));
		double prixUnitaire = Double.parseDouble(request.getParameter("prixUnitaire"));
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));

		materielService.editMateriel(new Materiel(idMateriel, categorieService.getCategorieById(idCategorie), nomMateriel, quantiteStock, prixUnitaire));
		response.sendRedirect(request.getContextPath() + MATERIEL_SERVLET_ACTION_GET);
	}

	private void deleteMateriel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idMateriel = Integer.parseInt(request.getParameter("id"));
		materielService.removeMateriel(idMateriel);
		response.sendRedirect(request.getContextPath() + MATERIEL_SERVLET_ACTION_GET);
	}

	private void listMateriels(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Materiel> materiels = materielService.getAllMateriels();
		request.setAttribute("materiels", materiels);
		RequestDispatcher dispatcher = request.getRequestDispatcher(MATERIEL_PAGE);
		dispatcher.forward(request, response);
	}

}
