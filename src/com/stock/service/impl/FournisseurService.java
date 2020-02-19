package com.stock.service.impl;

import java.util.List;

import com.stock.dao.IFournisseurDAO;
import com.stock.dao.impl.FournisseurDAO;
import com.stock.model.Fournisseur;
import com.stock.service.IFournisseurService;

public class FournisseurService implements IFournisseurService{
	
	private IFournisseurDAO fournisseurDAO;

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
