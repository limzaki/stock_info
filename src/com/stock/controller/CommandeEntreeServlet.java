package com.stock.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.model.CommandeEntree;
import com.stock.model.Fournisseur;
import com.stock.service.ICommandeEntreeService;
import com.stock.service.IFournisseurService;
import com.stock.service.impl.CommandeEntreeService;
import com.stock.service.impl.FournisseurService;

@WebServlet("/CommandeEntreeServlet")
public class CommandeEntreeServlet extends HttpServlet {

	private static final String COMMANDE_ENTREE_SERVLET_ACTION_GET = "/CommandeEntreeServlet?action=get";
	private static final String COMMANDE_ENTREE_PAGE = "commandeEntree/commandeEntree.jsp";
	private static final String COMMANDE_ENTREE_FORM = "commandeEntree/commandeEntreeForm.jsp";
	private static final String LIGNE_COMMANDE_ENTREE_SERVLET_ACTION_NEW = "/LigneCommandeEntreeServlet?action=new";

	private ICommandeEntreeService commandeEntreeService;
	private IFournisseurService fournisseurService;

	@Override
	public void init() throws ServletException {
		commandeEntreeService = new CommandeEntreeService();
		fournisseurService = new FournisseurService();
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
			}else if(action.contains("delete")) {
				//deleteCommandeEntree(request, response);
			}else if(action.contains("modify")) {
				//displayEditCommandeEntreeForm(request, response);
			}else if(action.contains("edit")) {
				//editCommandeEntree(request, response);
			}else {
				listCommandeEntrees(request, response);
			}
		}
	}

	private void displayCommandeEntreeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(COMMANDE_ENTREE_FORM);
		request.setAttribute("fournisseurs", fournisseurService.getAllFournisseurs());
		dispatcher.forward(request, response);	
	}
	
//	private void displayEditCommandeEntreeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int idCommandeEntree = Integer.parseInt(request.getParameter("id"));
//		CommandeEntree existingCommandeEntree = commandeEntreeService.getCommandeEntreeById(idCommandeEntree);
//		request.setAttribute("commandeEntree", existingCommandeEntree);
//		RequestDispatcher dispatcher = request.getRequestDispatcher(COMMANDE_ENTREE_FORM);
//		dispatcher.forward(request, response);	
//	}

	private void addCommandeEntree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIGNE_COMMANDE_ENTREE_SERVLET_ACTION_NEW);
		int idFournisseur = Integer.parseInt(request.getParameter("idFournisseur"));
		Date date;
		CommandeEntree commandeEntree = null;
		try {
  			date=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));  
  			//new Random().nextInt() positive
  			commandeEntree = new CommandeEntree(new Random().nextInt(), new Fournisseur(idFournisseur), date, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		commandeEntreeService.addCommandeEntree(commandeEntree);
		
		//dispatch to a LigneCommandeEntreeServlet with commandeEntreee object
		request.setAttribute("commandeEntree", commandeEntree);
		dispatcher.forward(request, response);
	}
	
//	private void editCommandeEntree(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		int idCommandeEntree = Integer.parseInt(request.getParameter("idCommandeEntree"));
//		String designation = request.getParameter("designation");
//		commandeEntreeService.editCommandeEntree(new CommandeEntree(idCommandeEntree, designation));
//		response.sendRedirect(request.getContextPath() + COMMANDE_ENTREE_SERVLET_ACTION_GET);
//	}
//
//	private void deleteCommandeEntree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int idCommandeEntree = Integer.parseInt(request.getParameter("id"));
//		commandeEntreeService.removeCommandeEntree(idCommandeEntree);
//		response.sendRedirect(request.getContextPath() + COMMANDE_ENTREE_SERVLET_ACTION_GET);
//	}

	private void listCommandeEntrees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CommandeEntree> commandeEntrees = commandeEntreeService.getAllCommandeEntrees();
		request.setAttribute("commandeEntrees", commandeEntrees);
		RequestDispatcher dispatcher = request.getRequestDispatcher(COMMANDE_ENTREE_PAGE);
		dispatcher.forward(request, response);
	}

}
