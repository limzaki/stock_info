package com.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.model.CommandeSortie;
import com.stock.model.LigneCommandeSortie;
import com.stock.model.Materiel;
import com.stock.service.ICommandeSortieService;
import com.stock.service.ILigneCommandeSortieService;
import com.stock.service.IMaterielService;
import com.stock.service.impl.CommandeSortieService;
import com.stock.service.impl.LigneCommandeSortieService;
import com.stock.service.impl.MaterielService;

@WebServlet("/LigneCommandeSortieServlet")
public class LigneCommandeSortieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String LIGNE_COMMANDE_SORTIE_PAGE = "ligneCommandeSortie/ligneCommandeSortie.jsp";
	private static final String LIGNE_COMMANDE_SORTIE_FORM = "ligneCommandeSortie/ligneCommandeSortieForm.jsp";


	private ILigneCommandeSortieService ligneCommandeSortieService;
	private ICommandeSortieService commandeSortieService;
	private IMaterielService materielService;

	@Override
	public void init() throws ServletException {
		ligneCommandeSortieService = new LigneCommandeSortieService();
		materielService = new MaterielService();
		commandeSortieService = new CommandeSortieService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			if(action.contains("new")) {
				displayLigneCommandeSortieForm(request, response);
			}else if(action.contains("add")) {
				addLigneCommandeSortie(request, response);
			}else {
				listLigneCommandeSorties(request, response);
			}
		}
	}

	private void displayLigneCommandeSortieForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIGNE_COMMANDE_SORTIE_FORM);
		CommandeSortie commandeSortie = (CommandeSortie)(request.getAttribute("commandeSortie"));
		request.setAttribute("materiels", materielService.getAllMateriels());
		if(commandeSortie != null) {
			request.setAttribute("ligneCommandeSorties", ligneCommandeSortieService.getAllLigneCommandeSortiesByIdCmd(commandeSortie.getIdCommandeSortie()));
		}

		dispatcher.forward(request, response);	
	}

	private void addLigneCommandeSortie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommandeSortie commandeSortie = commandeSortieService.getLastCommandeSortie();
		int idMateriel = Integer.parseInt(request.getParameter("idMateriel"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));		
		Materiel materiel = materielService.getMaterielById(idMateriel);
		if(quantite >= materiel.getQuantiteStock()) {
			request.setAttribute("error", "Veuillez Taper une quantite moins que " + materiel.getQuantiteStock());
			displayLigneCommandeSortieForm(request, response);
		}else {
			LigneCommandeSortie ligneCommandeSortie = new LigneCommandeSortie(commandeSortie,  materiel , quantite);
			ligneCommandeSortieService.addLigneCommandeSortie(ligneCommandeSortie);
			request.setAttribute("commandeSortie", commandeSortie);
			displayLigneCommandeSortieForm(request, response);
		}
	}

	private void listLigneCommandeSorties(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commandeSortieId = Integer.parseInt(request.getParameter("id"));
		List<LigneCommandeSortie> ligneCommandeSorties = ligneCommandeSortieService.getAllLigneCommandeSortiesByIdCmd(commandeSortieId);
		request.setAttribute("ligneCommandeSorties", ligneCommandeSorties);
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIGNE_COMMANDE_SORTIE_PAGE);
		dispatcher.forward(request, response);
	}

}
