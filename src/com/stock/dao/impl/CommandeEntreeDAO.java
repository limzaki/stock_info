package com.stock.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.ICommandeEntreeDAO;
import com.stock.dao.IFournisseurDAO;
import com.stock.database.DBConnection;
import com.stock.model.CommandeEntree;

public class CommandeEntreeDAO implements ICommandeEntreeDAO{

	private static final String SELECT_ALL_COMMANDE_ENTREES = "SELECT * FROM commande_entree";
	private static final String SELECT_COMMANDE_ENTREE_BY_ID = "SELECT * FROM commande_entree WHERE id_cmd_entree = ?";
	private static final String INSERT_COMMANDE_ENTREE = "INSERT INTO commande_entree(id_cmd_entree, date_cmd_entree, montant_cmd_entree, id_fournisseur) VALUES(?, ?, ?, ?)";
	private static final String UPDATE_COMMANDE_ENTREE_MONTANT = "UPDATE commande_entree SET montant_cmd_entree = ? WHERE id_cmd_entree = ?";
	private static final String SELECT_LAST_COMMANDE_ENTREE = "SELECT * FROM commande_entree WHERE id_cmd_entree = ("
			+ "SELECT max(id_cmd_entree) FROM commande_entree" + ")";


	private final Connection connection = DBConnection.getConnection();

	private IFournisseurDAO fournisseurDAO;

	public CommandeEntreeDAO() {
		this.fournisseurDAO = new FournisseurDAO();
	}

	public List<CommandeEntree> selectAllCommandeEntrees() {
		List<CommandeEntree> commandeEntrees = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMMANDE_ENTREES);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				int idCommandeEntree = resultSet.getInt(1);
				Date dateCommandeEntree = resultSet.getDate(2);
				double montantCommandeEntree = resultSet.getDouble(3);
				int idFournisseur = resultSet.getInt(4);
				commandeEntrees.add(new CommandeEntree(idCommandeEntree, fournisseurDAO.selectFournisseurById(idFournisseur), dateCommandeEntree, montantCommandeEntree));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return commandeEntrees;
	}

	public void insertCommandeEntree(CommandeEntree commandeEntree) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMANDE_ENTREE);
			preparedStatement.setInt(1, commandeEntree.getIdCommandeEntree());
			preparedStatement.setDate(2, new Date(commandeEntree.getDateCommandeEntree().getTime()));
			preparedStatement.setDouble(3, commandeEntree.getMontant());
			preparedStatement.setInt(4, commandeEntree.getFournisseur().getIdFournisseur());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCommandeEntreeMontant(int idCommandeEntree, double montant) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COMMANDE_ENTREE_MONTANT);
			preparedStatement.setDouble(1, montant);
			preparedStatement.setInt(2, idCommandeEntree);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public CommandeEntree selectCommandeEntreeById(int idCommandeEntree) {
		CommandeEntree commandeEntree = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMMANDE_ENTREE_BY_ID);
			preparedStatement.setInt(1, idCommandeEntree);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Date dateCommandeEntree = resultSet.getDate(2);
				double montant = resultSet.getDouble(3);
				int idFournisseur = resultSet.getInt(4);
				commandeEntree = new CommandeEntree(idCommandeEntree, fournisseurDAO.selectFournisseurById(idFournisseur), new java.util.Date(dateCommandeEntree.getTime()), montant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return commandeEntree;
	}

	@Override
	public CommandeEntree selectLastCommandeEntree() {
		CommandeEntree commandeEntree = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_COMMANDE_ENTREE);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				int idCommandeEntree = resultSet.getInt(1);
				Date dateCommandeEntree = resultSet.getDate(2);
				double montant = resultSet.getDouble(3);
				int idFournisseur = resultSet.getInt(4);
				commandeEntree = new CommandeEntree(idCommandeEntree, fournisseurDAO.selectFournisseurById(idFournisseur), new java.util.Date(dateCommandeEntree.getTime()), montant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return commandeEntree;
	}
}
