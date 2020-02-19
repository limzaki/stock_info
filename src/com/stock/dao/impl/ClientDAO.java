package com.stock.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.IClientDAO;
import com.stock.database.DBConnection;
import com.stock.model.Client;

public class ClientDAO implements IClientDAO{
	
	private static final String SELECT_ALL_CLIENTS = "SELECT * FROM client";
	private static final String SELECT_CLIENT_BY_ID = "SELECT * FROM client WHERE id_client = ?";
	private static final String DELETE_CLIENT = "DELETE FROM client WHERE id_client = ? ";
	private static final String INSERT_CLIENT = "INSERT INTO client(nom_complet, telephone, email) VALUES(?, ?, ?)";
	private static final String UPDATE_CLIENT = "UPDATE client SET nom_complet = ?, telephone = ?, email = ? WHERE id_client = ?";
	
	private final Connection connection = DBConnection.getConnection();
	
	public List<Client> selectAllClients() {
		List<Client> clients = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENTS);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int idClient = resultSet.getInt(1);
				String nomComplet = resultSet.getString(2);
				String telephone = resultSet.getString(3);
				String email = resultSet.getString(4);
				clients.add(new Client(idClient, nomComplet, telephone, email));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clients;
	}

	public void deleteClient(int idClient) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT);
			preparedStatement.setInt(1, idClient);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertClient(Client client) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT);
			preparedStatement.setString(1, client.getNomComplet());
			preparedStatement.setString(2, client.getTelephone());
			preparedStatement.setString(3, client.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateClient(Client client) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT);
			preparedStatement.setString(1, client.getNomComplet());
			preparedStatement.setString(2, client.getTelephone());
			preparedStatement.setString(3, client.getEmail());
			preparedStatement.setInt(4, client.getIdClient());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Client selectClientById(int idClient) {
		Client client = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_ID);
			preparedStatement.setInt(1, idClient);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String nomComplet = resultSet.getString(2);
				String telephone = resultSet.getString(3);
				String email = resultSet.getString(4);
				client = new Client(id, nomComplet, telephone, email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return client;
	}
	
}
