package com.stock.service;

import java.util.List;
import com.stock.model.Client;

public interface IClientService {

	List<Client> getAllClients();

	void removeClient(int idClient);

	void addClient(Client client);

	void editClient(Client client);

	Client getClientById(int idClient);

}