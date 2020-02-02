package com.stock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stock.database.DBConnection;
import com.stock.model.Categorie;

public class CategorieDAO {
	
	private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM categorie";
	private static final String SELECT_CATEGORIE_BY_ID = "SELECT * FROM categorie WHERE id_categorie = ?";
	private static final String DELETE_CATEGORIE = "DELETE FROM categorie WHERE id_categorie = ? ";
	private static final String INSERT_CATEGORIE = "INSERT INTO categorie(designation) VALUES(?)";
	private static final String UPDATE_CATEGORIE = "UPDATE categorie SET designation = ? WHERE id_categorie = ?";
	
	private final Connection connection = DBConnection.getConnection();
	
	public List<Categorie> selectAllCategories() {
		List<Categorie> categories = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int idCategorie = resultSet.getInt(1);
				String designation = resultSet.getString(2);
				categories.add(new Categorie(idCategorie, designation));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categories;
	}

	public void deleteCategorie(int idCategorie) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORIE);
			preparedStatement.setInt(1, idCategorie);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertCategorie(Categorie categorie) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORIE);
			preparedStatement.setString(1, categorie.getDesignation());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCategorie(Categorie categorie) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORIE);
			preparedStatement.setString(1, categorie.getDesignation());
			preparedStatement.setInt(2, categorie.getIdCategorie());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Categorie selectCategorieById(int idCategorie) {
		Categorie categorie = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORIE_BY_ID);
			preparedStatement.setInt(1, idCategorie);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String designation = resultSet.getString(2);
				categorie = new Categorie(id, designation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categorie;
	}
	
}
