package com.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.model.CommandeEntree;
import com.stock.model.LigneCommandeEntree;
import com.stock.service.ICommandeEntreeService;
import com.stock.service.ILigneCommandeEntreeService;
import com.stock.service.IMaterielService;
import com.stock.service.impl.CommandeEntreeService;
import com.stock.service.impl.LigneCommandeEntreeService;
import com.stock.service.impl.MaterielService;

@WebServlet("/LigneCommandeEntreeServlet")
public class LigneCommandeEntreeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String LIGNE_COMMANDE_ENTREE_PAGE = "ligneCommandeEntree/ligneCommandeEntree.jsp";
	private static final String LIGNE_COMMANDE_ENTREE_FORM = "ligneCommandeEntree/ligneCommandeEntreeForm.jsp";


	private ILigneCommandeEntreeService ligneCommandeEntreeService;
	private ICommandeEntreeService commandeEntreeService;
	private IMaterielService materielService;

	@Override
	public void init() throws ServletException {
		ligneCommandeEntreeService = new LigneCommandeEntreeService();
		materielService = new MaterielService();
		commandeEntreeService = new CommandeEntreeService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			if(action.contains("new")) {
				displayLigneCommandeEntreeForm(request, response);
			}else if(action.contains("add")) {
				addLigneCommandeEntree(request, response);
			}else {
				listLigneCommandeEntrees(request, response);
			}
		}
	}

	private void displayLigneCommandeEntreeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIGNE_COMMANDE_ENTREE_FORM);
		CommandeEntree commandeEntree = (CommandeEntree)(request.getAttribute("commandeEntree"));
		request.setAttribute("materiels", materielService.getAllMateriels());
		if(commandeEntree != null) {
			request.setAttribute("ligneCommandeEntrees", ligneCommandeEntreeService.getAllLigneCommandeEntreesByIdCmd(commandeEntree.getIdCommandeEntree()));
		}

		dispatcher.forward(request, response);	
	}

	private void addLigneCommandeEntree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommandeEntree commandeEntree = commandeEntreeService.getLastCommandeEntree();
		int idMateriel = Integer.parseInt(request.getParameter("idMateriel"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));		
		LigneCommandeEntree ligneCommandeEntree = new LigneCommandeEntree(commandeEntree, materielService.getMaterielById(idMateriel), quantite);

		ligneCommandeEntreeService.addLigneCommandeEntree(ligneCommandeEntree);
		request.setAttribute("commandeEntree", commandeEntree);
		displayLigneCommandeEntreeForm(request, response);
	}

	private void listLigneCommandeEntrees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commandeEntreeId = Integer.parseInt(request.getParameter("id"));
		List<LigneCommandeEntree> ligneCommandeEntrees = ligneCommandeEntreeService.getAllLigneCommandeEntreesByIdCmd(commandeEntreeId);
		request.setAttribute("ligneCommandeEntrees", ligneCommandeEntrees);
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIGNE_COMMANDE_ENTREE_PAGE);
		dispatcher.forward(request, response);
	}

}
