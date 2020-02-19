package com.stock.service.impl;

import java.util.List;

import com.stock.dao.IClientDAO;
import com.stock.dao.impl.ClientDAO;
import com.stock.model.Client;
import com.stock.service.IClientService;

public class ClientService implements IClientService{
	
	private IClientDAO clientDAO;

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