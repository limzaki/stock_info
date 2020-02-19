package com.stock.dao;

import java.util.List;

import com.stock.model.Client;

public interface IClientDAO {

	public List<Client> selectAllClients();

	public void deleteClient(int idClient);

	public void insertClient(Client client);

	public void updateClient(Client client);

	public Client selectClientById(int idClient);
	
}
