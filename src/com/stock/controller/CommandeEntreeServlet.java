package com.stock.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.model.CommandeEntree;
import com.stock.model.Fournisseur;
import com.stock.model.LigneCommandeEntree;
import com.stock.service.ICommandeEntreeService;
import com.stock.service.IFournisseurService;
import com.stock.service.ILigneCommandeEntreeService;
import com.stock.service.IMaterielService;
import com.stock.service.impl.CommandeEntreeService;
import com.stock.service.impl.FournisseurService;
import com.stock.service.impl.LigneCommandeEntreeService;
import com.stock.service.impl.MaterielService;

@WebServlet("/CommandeEntreeServlet")
public class CommandeEntreeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String COMMANDE_ENTREE_PAGE = "commandeEntree/commandeEntree.jsp";
	private static final String COMMANDE_ENTREE_FORM = "commandeEntree/commandeEntreeForm.jsp";
	private static final String LIGNE_COMMANDE_ENTREE_SERVLET_ACTION_NEW = "/LigneCommandeEntreeServlet?action=new";

	private ICommandeEntreeService commandeEntreeService;
	private ILigneCommandeEntreeService ligneCommandeEntreeService;
	private IFournisseurService fournisseurService;
	private IMaterielService materielService;

	@Override
	public void init() throws ServletException {
		commandeEntreeService = new CommandeEntreeService();
		ligneCommandeEntreeService = new LigneCommandeEntreeService();
		fournisseurService = new FournisseurService();
		materielService = new MaterielService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			if(action.contains("new")) {
				displayCommandeEntreeForm(request, response);
			}else if(action.contains("add")) {
				addCommandeEntree(request, response);
			}else if(action.contains("validate")) {
				finaliserCommandeEntree(request, response);
			}
			else {
				listCommandeEntrees(request, response);
			}
		}
	}

	private void displayCommandeEntreeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(COMMANDE_ENTREE_FORM);
		request.setAttribute("fournisseurs", fournisseurService.getAllFournisseurs());
		dispatcher.forward(request, response);	
	}

	private void addCommandeEntree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIGNE_COMMANDE_ENTREE_SERVLET_ACTION_NEW);
		int idFournisseur = Integer.parseInt(request.getParameter("idFournisseur"));
		Date date;
		CommandeEntree commandeEntree = null;
		try {
  			date=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));  
  			commandeEntree = new CommandeEntree(new Fournisseur(idFournisseur), date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		commandeEntreeService.addCommandeEntree(commandeEntree);

		dispatcher.forward(request, response);
	}

	private void listCommandeEntrees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CommandeEntree> commandeEntrees = commandeEntreeService.getAllCommandeEntrees();
		request.setAttribute("commandeEntrees", commandeEntrees);
		RequestDispatcher dispatcher = request.getRequestDispatcher(COMMANDE_ENTREE_PAGE);
		dispatcher.forward(request, response);
	}
	
	private void finaliserCommandeEntree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commandeEntreeId = Integer.parseInt(request.getParameter("id"));
		List<LigneCommandeEntree> ligneCommandeEntrees = ligneCommandeEntreeService.getAllLigneCommandeEntreesByIdCmd(commandeEntreeId);
		double montant = 0;
		for (LigneCommandeEntree ligneCommandeEntree : ligneCommandeEntrees) {
			int idMateriel = ligneCommandeEntree.getMateriel().getIdMateriel();
			int newQuantite = ligneCommandeEntree.getMateriel().getQuantiteStock() + ligneCommandeEntree.getQuantite();
			montant += ligneCommandeEntree.getQuantite() * ligneCommandeEntree.getMateriel().getPrixUnitaire();
			
			materielService.editMaterielQuantiteStock(idMateriel, newQuantite);
		}
		
		commandeEntreeService.setCommandeEntreeMontant(commandeEntreeId, montant);

		listCommandeEntrees(request, response);
	}

}
