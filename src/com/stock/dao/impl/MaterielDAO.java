package com.stock.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.IMaterielDAO;
import com.stock.database.DBConnection;
import com.stock.model.Materiel;

public class MaterielDAO implements IMaterielDAO{

	private static final String SELECT_ALL_MATERIELS = "SELECT * FROM materiel";
	private static final String SELECT_MATERIEL_BY_ID = "SELECT * FROM materiel WHERE id_materiel = ?";
	private static final String DELETE_MATERIEL = "DELETE FROM materiel WHERE id_materiel = ? ";
	private static final String INSERT_MATERIEL = "INSERT INTO materiel(nom_materiel, quantite_stock, prix_unitaire, id_categorie) VALUES(?, ?, ?, ?)";
	private static final String UPDATE_MATERIEL = "UPDATE materiel SET nom_materiel = ? , quantite_stock = ? , prix_unitaire = ? , id_categorie = ? WHERE id_materiel = ?";
	private static final String UPDATE_MATERIEL_QUANTITE = "UPDATE materiel SET quantite_stock = ? WHERE id_materiel = ?";
	
	private final Connection connection = DBConnection.getConnection();
	
	private CategorieDAO categorieDAO;
	

	public MaterielDAO() {
		super();
		this.categorieDAO = new CategorieDAO();
	}

	public List<Materiel> selectAllMateriels() {
		List<Materiel> materiels = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MATERIELS);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				int idMateriel = resultSet.getInt(1);
				String nomMateriel = resultSet.getString(2);
				int quantiteStock = resultSet.getInt(3);
				double prixUnitaire = resultSet.getDouble(4);
				int idCategorie = resultSet.getInt(5);

				materiels.add(new Materiel(idMateriel, categorieDAO.selectCategorieById(idCategorie), nomMateriel, quantiteStock, prixUnitaire));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return materiels;
	}

	public void deleteMateriel(int idMateriel) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MATERIEL);
			preparedStatement.setInt(1, idMateriel);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertMateriel(Materiel materiel) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MATERIEL);
			preparedStatement.setString(1, materiel.getNomMateriel());
			preparedStatement.setInt(2, materiel.getQuantiteStock());
			preparedStatement.setDouble(3, materiel.getPrixUnitaire());
			preparedStatement.setInt(4, materiel.getCategorie().getIdCategorie());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateMateriel(Materiel materiel) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MATERIEL);
			preparedStatement.setString(1, materiel.getNomMateriel());
			preparedStatement.setInt(2, materiel.getQuantiteStock());
			preparedStatement.setDouble(3, materiel.getPrixUnitaire());
			preparedStatement.setInt(4, materiel.getCategorie().getIdCategorie());
			preparedStatement.setInt(5, materiel.getIdMateriel());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMaterielQuantiteStock(int idMateriel, int newQuantite) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MATERIEL_QUANTITE);
			preparedStatement.setInt(1, newQuantite);
			preparedStatement.setInt(2, idMateriel);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Materiel selectMaterielById(int idMateriel) {
		Materiel materiel = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MATERIEL_BY_ID);
			preparedStatement.setInt(1, idMateriel);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String nomMateriel = resultSet.getString(2);
				int quantiteStock = resultSet.getInt(3);
				double prixUnitaire = resultSet.getDouble(4);
				int idCategorie = resultSet.getInt(5);

				materiel = new Materiel(idMateriel, categorieDAO.selectCategorieById(idCategorie), nomMateriel, quantiteStock, prixUnitaire);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return materiel;
	}

}
