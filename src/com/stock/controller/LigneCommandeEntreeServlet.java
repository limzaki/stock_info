package com.stock.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.model.CommandeEntree;
import com.stock.model.LigneCommandeEntree;
import com.stock.service.ILigneCommandeEntreeService;
import com.stock.service.IMaterielService;
import com.stock.service.impl.CommandeEntreeService;
import com.stock.service.impl.LigneCommandeEntreeService;
import com.stock.service.impl.MaterielService;

@WebServlet("/LigneCommandeEntreeServlet")
public class LigneCommandeEntreeServlet extends HttpServlet {

	private static final String LIGNE_COMMANDE_ENTREE_SERVLET_ACTION_GET = "/LigneCommandeEntreeServlet?action=get";
	private static final String LIGNE_COMMANDE_ENTREE_PAGE = "commandeEntree/commandeEntree.jsp";
	private static final String LIGNE_COMMANDE_ENTREE_FORM = "ligneCommandeEntree/ligneCommandeEntreeForm.jsp";
	private static CommandeEntree commandeEntree;

	private ILigneCommandeEntreeService ligneCommandeEntreeService;
	private CommandeEntreeService CommandeEntreeService;
	private IMaterielService materielService;

	@Override
	public void init() throws ServletException {
		ligneCommandeEntreeService = new LigneCommandeEntreeService();
		materielService = new MaterielService();
		CommandeEntreeService = new CommandeEntreeService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			if(action.contains("new")) {
				commandeEntree = (CommandeEntree)request.getAttribute("commandeEntree");
				displayLigneCommandeEntreeForm(request, response);
			}else if(action.contains("add")) {
				addLigneCommandeEntree(request, response);
			}else if(action.contains("delete")) {
				//deleteLigneCommandeEntree(request, response);
			}else if(action.contains("modify")) {
				//displayEditLigneCommandeEntreeForm(request, response);
			}else if(action.contains("edit")) {
				//editLigneCommandeEntree(request, response);
			}else {
				System.out.println("/LigneCommandeEntreeServlet");
				//listLigneCommandeEntrees(request, response);
			}
		}
	}

	private void displayLigneCommandeEntreeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIGNE_COMMANDE_ENTREE_FORM);
		request.setAttribute("commandeEntree", commandeEntree);
		request.setAttribute("materiels", materielService.getAllMateriels());
		dispatcher.forward(request, response);	
	}
	
//	private void displayEditLigneCommandeEntreeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int idLigneCommandeEntree = Integer.parseInt(request.getParameter("id"));
//		LigneCommandeEntree existingLigneCommandeEntree = commandeEntreeService.getLigneCommandeEntreeById(idLigneCommandeEntree);
//		request.setAttribute("commandeEntree", existingLigneCommandeEntree);
//		RequestDispatcher dispatcher = request.getRequestDispatcher(LIGNE_COMMANDE_ENTREE_FORM);
//		dispatcher.forward(request, response);	
//	}

	private void addLigneCommandeEntree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCommandeEntree = commandeEntree.getIdCommandeEntree();
		int idMateriel = Integer.parseInt(request.getParameter("idMateriel"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));		
		LigneCommandeEntree ligneCommandeEntree = new LigneCommandeEntree(CommandeEntreeService.geCommandeEntreeById(idCommandeEntree),
				materielService.getMaterielById(idMateriel), quantite);
		
		ligneCommandeEntreeService.addLigneCommandeEntree(ligneCommandeEntree);
		displayLigneCommandeEntreeForm(request, response);
	}
	
//	private void editLigneCommandeEntree(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		int idLigneCommandeEntree = Integer.parseInt(request.getParameter("idLigneCommandeEntree"));
//		String designation = request.getParameter("designation");
//		commandeEntreeService.editLigneCommandeEntree(new LigneCommandeEntree(idLigneCommandeEntree, designation));
//		response.sendRedirect(request.getContextPath() + LIGNE_COMMANDE_ENTREE_SERVLET_ACTION_GET);
//	}
//
//	private void deleteLigneCommandeEntree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int idLigneCommandeEntree = Integer.parseInt(request.getParameter("id"));
//		commandeEntreeService.removeLigneCommandeEntree(idLigneCommandeEntree);
//		response.sendRedirect(request.getContextPath() + LIGNE_COMMANDE_ENTREE_SERVLET_ACTION_GET);
//	}

//	private void listLigneCommandeEntrees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<LigneCommandeEntree> commandeEntrees = commandeEntreeService.getAllLigneCommandeEntrees();
//		request.setAttribute("commandeEntrees", commandeEntrees);
//		RequestDispatcher dispatcher = request.getRequestDispatcher(LIGNE_COMMANDE_ENTREE_PAGE);
//		dispatcher.forward(request, response);
//	}

}
