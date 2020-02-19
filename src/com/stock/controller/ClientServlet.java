package com.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.model.Client;
import com.stock.service.IClientService;
import com.stock.service.impl.ClientService;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {

	private static final String CLIENT_SERVLET_ACTION_GET = "/ClientServlet?action=get";
	private static final String CLIENT_PAGE = "client/client.jsp";
	private static final String CLIENT_FORM = "client/clientForm.jsp";

	private IClientService clientService;

	@Override
	public void init() throws ServletException {
		clientService = new ClientService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			if(action.contains("new")) {
				displayClientForm(request, response);
			}else if(action.contains("add")) {
				addClient(request, response);
			}else if(action.contains("delete")) {
				deleteClient(request, response);
			}else if(action.contains("modify")) {
				displayEditClientForm(request, response);
			}else if(action.contains("edit")) {
				editClient(request, response);
			}else {
				listClients(request, response);
			}
		}
	}

	private void displayClientForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(CLIENT_FORM);
		dispatcher.forward(request, response);	
	}
	
	private void displayEditClientForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idClient = Integer.parseInt(request.getParameter("id"));
		Client existingClient = clientService.getClientById(idClient);
		request.setAttribute("client", existingClient);
		RequestDispatcher dispatcher = request.getRequestDispatcher(CLIENT_FORM);
		dispatcher.forward(request, response);	
	}

	private void addClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nomComplet = request.getParameter("nom");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		clientService.addClient(new Client(nomComplet, telephone, email));
		response.sendRedirect(request.getContextPath() + CLIENT_SERVLET_ACTION_GET);
	}
	
	private void editClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idClient = Integer.parseInt(request.getParameter("id"));
		String nomComplet = request.getParameter("nom");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		clientService.editClient(new Client(idClient, nomComplet, telephone, email));
		response.sendRedirect(request.getContextPath() + CLIENT_SERVLET_ACTION_GET);
	}

	private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idClient = Integer.parseInt(request.getParameter("id"));
		clientService.removeClient(idClient);
		response.sendRedirect(request.getContextPath() + CLIENT_SERVLET_ACTION_GET);
	}

	private void listClients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clients = clientService.getAllClients();
		request.setAttribute("clients", clients);
		RequestDispatcher dispatcher = request.getRequestDispatcher(CLIENT_PAGE);
		dispatcher.forward(request, response);
	}

}
