package com.stock.service.impl;

import java.util.List;

import com.stock.dao.ILigneCommandeSortieDAO;
import com.stock.dao.impl.LigneCommandeSortieDAO;
import com.stock.model.LigneCommandeSortie;
import com.stock.service.ILigneCommandeSortieService;

public class LigneCommandeSortieService implements ILigneCommandeSortieService{
	
	private ILigneCommandeSortieDAO ligneCommandeSortieDAO;

	
	public LigneCommandeSortieService() {
		this.ligneCommandeSortieDAO = new LigneCommandeSortieDAO();
	}

	@Override
	public void addLigneCommandeSortie(LigneCommandeSortie ligneCommandeSortie) {
		ligneCommandeSortieDAO.insertLigneCommandeSortie(ligneCommandeSortie);
		
	}
	
	@Override
	public List<LigneCommandeSortie> getAllLigneCommandeSortiesByIdCmd(int commandeSortieId) {
		return ligneCommandeSortieDAO.selectAllLigneCommandeSortiesByIdCmd(commandeSortieId);
	}
	
}
