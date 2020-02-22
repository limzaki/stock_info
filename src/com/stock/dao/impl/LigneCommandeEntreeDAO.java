package com.stock.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.stock.dao.ILigneCommandeEntreeDAO;
import com.stock.dao.IFournisseurDAO;
import com.stock.database.DBConnection;
import com.stock.model.LigneCommandeEntree;

public class LigneCommandeEntreeDAO implements ILigneCommandeEntreeDAO{
	
	private static final String SELECT_ALL_LIGNE_COMMANDE_ENTREES = "SELECT * FROM ligne_commande_entree";
	private static final String SELECT_LIGNE_COMMANDE_ENTREE_BY_ID = "SELECT * FROM ligne_commande_entree WHERE id_cmd_entree = ?";
	private static final String DELETE_LIGNE_COMMANDE_ENTREE = "DELETE FROM ligne_commande_entree WHERE id_cmd_entree = ? ";
	private static final String INSERT_LIGNE_COMMANDE_ENTREE = "INSERT INTO ligne_commande_entree(quantite, id_cmd_entree, id_materiel) VALUES(?, ?, ?)";
	private static final String UPDATE_LIGNE_COMMANDE_ENTREE = "UPDATE ligne_commande_entree SET nom_complet = ?, telephone = ?, email = ? WHERE id_ligne_cmd_entree = ?";
	
	private final Connection connection = DBConnection.getConnection();
	
	private IFournisseurDAO fournisseurDAO;
	
	public LigneCommandeEntreeDAO() {
		this.fournisseurDAO = new FournisseurDAO();
	}

//	public List<LigneCommandeEntree> selectAllLigneCommandeEntrees() {
//		List<LigneCommandeEntree> commandeEntrees = new ArrayList<>();
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LIGNE_COMMANDE_ENTREES);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			
//			while(resultSet.next()) {
//				int idLigneCommandeEntree = resultSet.getInt(1);
//				Date dateLigneCommandeEntree = resultSet.getDate(2);
//				double montantLigneCommandeEntree = resultSet.getDouble(3);
//				int idFournisseur = resultSet.getInt(4);
//				commandeEntrees.add(new LigneCommandeEntree(idLigneCommandeEntree, fournisseurDAO.selectFournisseurById(idFournisseur), dateLigneCommandeEntree, montantLigneCommandeEntree));
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return commandeEntrees;
//	}

//	public void deleteLigneCommandeEntree(int idLigneCommandeEntree) {
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LIGNE_COMMANDE_ENTREE);
//			preparedStatement.setInt(1, idLigneCommandeEntree);
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
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
//
//	public void updateLigneCommandeEntree(LigneCommandeEntree commandeEntree) {
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LIGNE_COMMANDE_ENTREE);
//			preparedStatement.setString(1, commandeEntree.getNomComplet());
//			preparedStatement.setString(2, commandeEntree.getTelephone());
//			preparedStatement.setString(3, commandeEntree.getEmail());
//			preparedStatement.setInt(4, commandeEntree.getIdLigneCommandeEntree());
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public LigneCommandeEntree selectLigneCommandeEntreeById(int idLigneCommandeEntree) {
//		LigneCommandeEntree commandeEntree = null;
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LIGNE_COMMANDE_ENTREE_BY_ID);
//			preparedStatement.setInt(1, idLigneCommandeEntree);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			
//			while(resultSet.next()) {
//				int id = resultSet.getInt(1);
//				String nomComplet = resultSet.getString(2);
//				String telephone = resultSet.getString(3);
//				String email = resultSet.getString(4);
//				commandeEntree = new LigneCommandeEntree(id, nomComplet, telephone, email);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return commandeEntree;
//	}
	
}
