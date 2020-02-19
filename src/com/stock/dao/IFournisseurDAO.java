package com.stock.dao;

import java.util.List;

import com.stock.model.Fournisseur;

public interface IFournisseurDAO {
	
	public List<Fournisseur> selectAllFournisseurs();
	
	public void deleteFournisseur(int idFournisseur);
	
	public void insertFournisseur(Fournisseur fournisseur);

	public void updateFournisseur(Fournisseur fournisseur);

	public Fournisseur selectFournisseurById(int idFournisseur);
	
}
