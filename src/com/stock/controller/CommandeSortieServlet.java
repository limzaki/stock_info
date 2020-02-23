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

import com.stock.model.CommandeSortie;
import com.stock.model.Client;
import com.stock.model.LigneCommandeSortie;
import com.stock.service.ICommandeSortieService;
import com.stock.service.IClientService;
import com.stock.service.ILigneCommandeSortieService;
import com.stock.service.IMaterielService;
import com.stock.service.impl.CommandeSortieService;
import com.stock.service.impl.ClientService;
import com.stock.service.impl.LigneCommandeSortieService;
import com.stock.service.impl.MaterielService;

@WebServlet("/CommandeSortieServlet")
public class CommandeSortieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String COMMANDE_SORTIE_PAGE = "commandeSortie/commandeSortie.jsp";
	private static final String COMMANDE_SORTIE_FORM = "commandeSortie/commandeSortieForm.jsp";
	private static final String LIGNE_COMMANDE_SORTIE_SERVLET_ACTION_NEW = "/LigneCommandeSortieServlet?action=new";

	private ICommandeSortieService commandeSortieService;
	private ILigneCommandeSortieService ligneCommandeSortieService;
	private IClientService clientService;
	private IMaterielService materielService;

	@Override
	public void init() throws ServletException {
		commandeSortieService = new CommandeSortieService();
		ligneCommandeSortieService = new LigneCommandeSortieService();
		clientService = new ClientService();
		materielService = new MaterielService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			if(action.contains("new")) {
				displayCommandeSortieForm(request, response);
			}else if(action.contains("add")) {
				addCommandeSortie(request, response);
			}else if(action.contains("validate")) {
				finaliserCommandeSortie(request, response);
			}
			else {
				listCommandeSorties(request, response);
			}
		}
	}

	private void displayCommandeSortieForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(COMMANDE_SORTIE_FORM);
		request.setAttribute("clients", clientService.getAllClients());
		dispatcher.forward(request, response);	
	}

	private void addCommandeSortie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIGNE_COMMANDE_SORTIE_SERVLET_ACTION_NEW);
		int idClient = Integer.parseInt(request.getParameter("idClient"));
		Date date;
		CommandeSortie commandeSortie = null;
		try {
			date=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));  
			commandeSortie = new CommandeSortie(new Client(idClient), date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		commandeSortieService.addCommandeSortie(commandeSortie);

		dispatcher.forward(request, response);
	}

	private void listCommandeSorties(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CommandeSortie> commandeSorties = commandeSortieService.getAllCommandeSorties();
		request.setAttribute("commandeSorties", commandeSorties);
		RequestDispatcher dispatcher = request.getRequestDispatcher(COMMANDE_SORTIE_PAGE);
		dispatcher.forward(request, response);
	}

	private void finaliserCommandeSortie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commandeSortieId = Integer.parseInt(request.getParameter("id"));
		List<LigneCommandeSortie> ligneCommandeSorties = ligneCommandeSortieService.getAllLigneCommandeSortiesByIdCmd(commandeSortieId);
		double montant = 0;
		for (LigneCommandeSortie ligneCommandeSortie : ligneCommandeSorties) {
			int idMateriel = ligneCommandeSortie.getMateriel().getIdMateriel();
			int newQuantite = ligneCommandeSortie.getMateriel().getQuantiteStock() - ligneCommandeSortie.getQuantite();
			montant += ligneCommandeSortie.getQuantite() * ligneCommandeSortie.getMateriel().getPrixUnitaire();

			materielService.editMaterielQuantiteStock(idMateriel, newQuantite);
		}

		commandeSortieService.setCommandeSortieMontant(commandeSortieId, montant);

		listCommandeSorties(request, response);
	}

}
