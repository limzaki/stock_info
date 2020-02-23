package com.stock.service;

import java.util.List;

import com.stock.model.LigneCommandeEntree;

public interface ILigneCommandeEntreeService {

	void addLigneCommandeEntree(LigneCommandeEntree ligneCommandeEntree);

	List<LigneCommandeEntree> getAllLigneCommandeEntreesByIdCmd(int commandeEntreeId);
	
}