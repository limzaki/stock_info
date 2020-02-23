package com.stock.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.ICommandeSortieDAO;
import com.stock.dao.ILigneCommandeSortieDAO;
import com.stock.dao.IMaterielDAO;
import com.stock.database.DBConnection;
import com.stock.model.LigneCommandeSortie;

public class LigneCommandeSortieDAO implements ILigneCommandeSortieDAO{
	
	private static final String SELECT_ALL_LIGNE_COMMANDE_SORTIES_BY_ID_CMD = "SELECT * FROM ligne_commande_sortie WHERE id_cmd_sortie = ?";
	private static final String INSERT_LIGNE_COMMANDE_SORTIE = "INSERT INTO ligne_commande_sortie(quantite, id_cmd_sortie, id_materiel) VALUES(?, ?, ?)";
	
	
	private final Connection connection = DBConnection.getConnection();
	
	private ICommandeSortieDAO commandeSortieDAO;
	private IMaterielDAO materielDAO;
	
	public LigneCommandeSortieDAO() {
		this.commandeSortieDAO = new CommandeSortieDAO();
		this.materielDAO = new MaterielDAO();
	}

	public List<LigneCommandeSortie> selectAllLigneCommandeSortiesByIdCmd(int commandeSortieId) {
		List<LigneCommandeSortie> ligneCommandeSorties = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LIGNE_COMMANDE_SORTIES_BY_ID_CMD);
			preparedStatement.setInt(1, commandeSortieId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int idLigneCommandeSortie = resultSet.getInt(1);
				int quantite = resultSet.getInt(2);
				int idCommandeSortie = resultSet.getInt(3);
				int idMateriel = resultSet.getInt(4);
				ligneCommandeSorties.add(new LigneCommandeSortie(idLigneCommandeSortie, 
						commandeSortieDAO.selectCommandeSortieById(idCommandeSortie), materielDAO.selectMaterielById(idMateriel), quantite));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ligneCommandeSorties;
	}

	public void insertLigneCommandeSortie(LigneCommandeSortie ligneCommandeSortie) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LIGNE_COMMANDE_SORTIE);
			preparedStatement.setInt(1, ligneCommandeSortie.getQuantite());
			preparedStatement.setInt(2, ligneCommandeSortie.getCommandeSortie().getIdCommandeSortie());
			preparedStatement.setInt(3, ligneCommandeSortie.getMateriel().getIdMateriel());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
