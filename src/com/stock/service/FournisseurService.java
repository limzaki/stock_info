package com.stock.service;

import java.util.List;

import com.stock.dao.FournisseurDAO;
import com.stock.model.Fournisseur;

public class FournisseurService {
	
	private FournisseurDAO fournisseurDAO;

	public FournisseurService() {
		this.fournisseurDAO = new FournisseurDAO();
	}

	public List<Fournisseur> getAllFournisseurs() {
		return fournisseurDAO.selectAllFournisseurs();
	}

	public void removeFournisseur(int idFournisseur) {
		fournisseurDAO.deleteFournisseur(idFournisseur);
	}

	public void addFournisseur(Fournisseur fournisseur) {
		fournisseurDAO.insertFournisseur(fournisseur);
	}

	public void editFournisseur(Fournisseur fournisseur) {
		fournisseurDAO.updateFournisseur(fournisseur);
	}

	public Fournisseur getFournisseurById(int idFournisseur) {
		return fournisseurDAO.selectFournisseurById(idFournisseur);
	}
	
}
