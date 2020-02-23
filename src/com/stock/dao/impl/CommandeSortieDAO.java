package com.stock.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.IClientDAO;
import com.stock.dao.ICommandeSortieDAO;
import com.stock.database.DBConnection;
import com.stock.model.CommandeSortie;

public class CommandeSortieDAO implements ICommandeSortieDAO{

	private static final String SELECT_ALL_COMMANDE_SORTIES = "SELECT * FROM commande_sortie";
	private static final String SELECT_COMMANDE_SORTIE_BY_ID = "SELECT * FROM commande_sortie WHERE id_cmd_sortie = ?";
	private static final String INSERT_COMMANDE_SORTIE = "INSERT INTO commande_sortie(id_cmd_sortie, date_cmd_sortie, montant_cmd_sortie, id_client) VALUES(?, ?, ?, ?)";
	private static final String UPDATE_COMMANDE_SORTIE_MONTANT = "UPDATE commande_sortie SET montant_cmd_sortie = ? WHERE id_cmd_sortie = ?";
	private static final String SELECT_LAST_COMMANDE_SORTIE = "SELECT * FROM commande_sortie WHERE id_cmd_sortie = ("
			+ "SELECT max(id_cmd_sortie) FROM commande_sortie" + ")";


	private final Connection connection = DBConnection.getConnection();

	private IClientDAO clientDAO;

	public CommandeSortieDAO() {
		this.clientDAO = new ClientDAO();
	}

	public List<CommandeSortie> selectAllCommandeSorties() {
		List<CommandeSortie> commandeSorties = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMMANDE_SORTIES);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				int idCommandeSortie = resultSet.getInt(1);
				Date dateCommandeSortie = resultSet.getDate(2);
				double montantCommandeSortie = resultSet.getDouble(3);
				int idClient = resultSet.getInt(4);
				commandeSorties.add(new CommandeSortie(idCommandeSortie, clientDAO.selectClientById(idClient), dateCommandeSortie, montantCommandeSortie));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return commandeSorties;
	}

	public void insertCommandeSortie(CommandeSortie commandeSortie) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMANDE_SORTIE);
			preparedStatement.setInt(1, commandeSortie.getIdCommandeSortie());
			preparedStatement.setDate(2, new Date(commandeSortie.getDateCommandeSortie().getTime()));
			preparedStatement.setDouble(3, commandeSortie.getMontant());
			preparedStatement.setInt(4, commandeSortie.getClient().getIdClient());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCommandeSortieMontant(int idCommandeSortie, double montant) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COMMANDE_SORTIE_MONTANT);
			preparedStatement.setDouble(1, montant);
			preparedStatement.setInt(2, idCommandeSortie);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public CommandeSortie selectCommandeSortieById(int idCommandeSortie) {
		CommandeSortie commandeSortie = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMMANDE_SORTIE_BY_ID);
			preparedStatement.setInt(1, idCommandeSortie);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Date dateCommandeSortie = resultSet.getDate(2);
				double montant = resultSet.getDouble(3);
				int idClient = resultSet.getInt(4);
				commandeSortie = new CommandeSortie(idCommandeSortie, clientDAO.selectClientById(idClient), new java.util.Date(dateCommandeSortie.getTime()), montant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return commandeSortie;
	}

	@Override
	public CommandeSortie selectLastCommandeSortie() {
		CommandeSortie commandeSortie = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_COMMANDE_SORTIE);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				int idCommandeSortie = resultSet.getInt(1);
				Date dateCommandeSortie = resultSet.getDate(2);
				double montant = resultSet.getDouble(3);
				int idClient = resultSet.getInt(4);
				commandeSortie = new CommandeSortie(idCommandeSortie, clientDAO.selectClientById(idClient), new java.util.Date(dateCommandeSortie.getTime()), montant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return commandeSortie;
	}
}
