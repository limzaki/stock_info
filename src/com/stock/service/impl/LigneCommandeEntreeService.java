package com.stock.service.impl;

import com.stock.dao.ILigneCommandeEntreeDAO;
import com.stock.dao.impl.LigneCommandeEntreeDAO;
import com.stock.model.LigneCommandeEntree;
import com.stock.service.ILigneCommandeEntreeService;

public class LigneCommandeEntreeService implements ILigneCommandeEntreeService{
	
	private ILigneCommandeEntreeDAO ligneCommandeEntreeDAO;

	
	public LigneCommandeEntreeService() {
		this.ligneCommandeEntreeDAO = new LigneCommandeEntreeDAO();
	}

	@Override
	public void addLigneCommandeEntree(LigneCommandeEntree ligneCommandeEntree) {
		ligneCommandeEntreeDAO.insertLigneCommandeEntree(ligneCommandeEntree);
		
	}
	
}
