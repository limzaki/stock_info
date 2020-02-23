package com.stock.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.ICommandeEntreeDAO;
import com.stock.dao.ILigneCommandeEntreeDAO;
import com.stock.dao.IMaterielDAO;
import com.stock.database.DBConnection;
import com.stock.model.LigneCommandeEntree;

public class LigneCommandeEntreeDAO implements ILigneCommandeEntreeDAO{

	private static final String SELECT_ALL_LIGNE_COMMANDE_ENTREES_BY_ID_CMD = "SELECT * FROM ligne_commande_entree WHERE id_cmd_entree = ?";
	private static final String INSERT_LIGNE_COMMANDE_ENTREE = "INSERT INTO ligne_commande_entree(quantite, id_cmd_entree, id_materiel) VALUES(?, ?, ?)";


	private final Connection connection = DBConnection.getConnection();

	private ICommandeEntreeDAO commandeEntreeDAO;
	private IMaterielDAO materielDAO;

	public LigneCommandeEntreeDAO() {
		this.commandeEntreeDAO = new CommandeEntreeDAO();
		this.materielDAO = new MaterielDAO();
	}

	public List<LigneCommandeEntree> selectAllLigneCommandeEntreesByIdCmd(int commandeEntreeId) {
		List<LigneCommandeEntree> ligneCommandeEntrees = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LIGNE_COMMANDE_ENTREES_BY_ID_CMD);
			preparedStatement.setInt(1, commandeEntreeId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				int idLigneCommandeEntree = resultSet.getInt(1);
				int quantite = resultSet.getInt(2);
				int idCommandeEntree = resultSet.getInt(3);
				int idMateriel = resultSet.getInt(4);
				ligneCommandeEntrees.add(new LigneCommandeEntree(idLigneCommandeEntree, 
						commandeEntreeDAO.selectCommandeEntreeById(idCommandeEntree), materielDAO.selectMaterielById(idMateriel), quantite));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ligneCommandeEntrees;
	}

	public void insertLigneCommandeEntree(LigneCommandeEntree ligneCommandeEntree) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LIGNE_COMMANDE_ENTREE);
			preparedStatement.setInt(1, ligneCommandeEntree.getQuantite());
			preparedStatement.setInt(2, ligneCommandeEntree.getCommandeEntree().getIdCommandeEntree());
			preparedStatement.setInt(3, ligneCommandeEntree.getMateriel().getIdMateriel());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
