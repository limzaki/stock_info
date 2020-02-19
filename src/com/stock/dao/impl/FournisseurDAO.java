package com.stock.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.IFournisseurDAO;
import com.stock.database.DBConnection;
import com.stock.model.Fournisseur;

public class FournisseurDAO implements IFournisseurDAO{
	
	private static final String SELECT_ALL_FOURNISSEURS = "SELECT * FROM fournisseur";
	private static final String SELECT_FOURNISSEUR_BY_ID = "SELECT * FROM fournisseur WHERE id_fournisseur = ?";
	private static final String DELETE_FOURNISSEUR = "DELETE FROM fournisseur WHERE id_fournisseur = ? ";
	private static final String INSERT_FOURNISSEUR = "INSERT INTO fournisseur(nom, telephone, email) VALUES(?, ?, ?)";
	private static final String UPDATE_FOURNISSEUR = "UPDATE fournisseur SET nom = ?, telephone = ?, email = ? WHERE id_fournisseur = ?";
	
	private final Connection connection = DBConnection.getConnection();
	
	public List<Fournisseur> selectAllFournisseurs() {
		List<Fournisseur> fournisseurs = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FOURNISSEURS);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int idFournisseur = resultSet.getInt(1);
				String nom = resultSet.getString(2);
				String telephone = resultSet.getString(3);
				String email = resultSet.getString(4);
				fournisseurs.add(new Fournisseur(idFournisseur, nom, telephone, email));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fournisseurs;
	}

	public void deleteFournisseur(int idFournisseur) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FOURNISSEUR);
			preparedStatement.setInt(1, idFournisseur);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertFournisseur(Fournisseur fournisseur) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FOURNISSEUR);
			preparedStatement.setString(1, fournisseur.getNom());
			preparedStatement.setString(2, fournisseur.getTelephone());
			preparedStatement.setString(3, fournisseur.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFournisseur(Fournisseur fournisseur) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FOURNISSEUR);
			preparedStatement.setString(1, fournisseur.getNom());
			preparedStatement.setString(2, fournisseur.getTelephone());
			preparedStatement.setString(3, fournisseur.getEmail());
			preparedStatement.setInt(4, fournisseur.getIdFournisseur());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Fournisseur selectFournisseurById(int idFournisseur) {
		Fournisseur fournisseur = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FOURNISSEUR_BY_ID);
			preparedStatement.setInt(1, idFournisseur);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String nom = resultSet.getString(2);
				String telephone = resultSet.getString(3);
				String email = resultSet.getString(4);
				fournisseur = new Fournisseur(id, nom, telephone, email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fournisseur;
	}
	
}
