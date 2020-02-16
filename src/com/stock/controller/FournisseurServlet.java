package com.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.model.Fournisseur;
import com.stock.service.FournisseurService;

@WebServlet("/FournisseurServlet")
public class FournisseurServlet extends HttpServlet {

	private static final String FOURNISSEUR_SERVLET_ACTION_GET = "/FournisseurServlet?action=get";
	private static final String FOURNISSEUR_PAGE = "fournisseur/fournisseur.jsp";
	private static final String FOURNISSEUR_FORM = "fournisseur/fournisseurForm.jsp";

	private FournisseurService fournisseurService;

	@Override
	public void init() throws ServletException {
		fournisseurService = new FournisseurService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			if(action.contains("new")) {
				displayFournisseurForm(request, response);
			}else if(action.contains("add")) {
				addFournisseur(request, response);
			}else if(action.contains("delete")) {
				deleteFournisseur(request, response);
			}else if(action.contains("modify")) {
				displayEditFournisseurForm(request, response);
			}else if(action.contains("edit")) {
				editFournisseur(request, response);
			}else {
				listFournisseurs(request, response);
			}
		}
	}

	private void displayFournisseurForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(FOURNISSEUR_FORM);
		dispatcher.forward(request, response);	
	}
	
	private void displayEditFournisseurForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idFournisseur = Integer.parseInt(request.getParameter("id"));
		Fournisseur existingFournisseur = fournisseurService.getFournisseurById(idFournisseur);
		request.setAttribute("fournisseur", existingFournisseur);
		RequestDispatcher dispatcher = request.getRequestDispatcher(FOURNISSEUR_FORM);
		dispatcher.forward(request, response);	
	}

	private void addFournisseur(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nom = request.getParameter("nom");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		fournisseurService.addFournisseur(new Fournisseur(nom, telephone, email));
		response.sendRedirect(request.getContextPath() + FOURNISSEUR_SERVLET_ACTION_GET);
	}
	
	private void editFournisseur(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idFournisseur = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		fournisseurService.editFournisseur(new Fournisseur(idFournisseur, nom, telephone, email));
		response.sendRedirect(request.getContextPath() + FOURNISSEUR_SERVLET_ACTION_GET);
	}

	private void deleteFournisseur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idFournisseur = Integer.parseInt(request.getParameter("id"));
		fournisseurService.removeFournisseur(idFournisseur);
		response.sendRedirect(request.getContextPath() + FOURNISSEUR_SERVLET_ACTION_GET);
	}

	private void listFournisseurs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseurs();
		request.setAttribute("fournisseurs", fournisseurs);
		RequestDispatcher dispatcher = request.getRequestDispatcher(FOURNISSEUR_PAGE);
		dispatcher.forward(request, response);
	}

}
