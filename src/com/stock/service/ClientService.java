package com.stock.service;

import java.util.List;

import com.stock.dao.ClientDAO;
import com.stock.model.Client;

public class ClientService {
	
	private ClientDAO clientDAO;

	public ClientService() {
		this.clientDAO = new ClientDAO();
	}

	public List<Client> getAllClients() {
		return clientDAO.selectAllClients();
	}

	public void removeClient(int idClient) {
		clientDAO.deleteClient(idClient);
	}

	public void addClient(Client client) {
		clientDAO.insertClient(client);
	}

	public void editClient(Client client) {
		clientDAO.updateClient(client);
	}

	public Client getClientById(int idClient) {
		return clientDAO.selectClientById(idClient);
	}
	
}