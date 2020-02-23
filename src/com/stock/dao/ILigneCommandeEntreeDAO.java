package com.stock.dao;

import java.util.List;

import com.stock.model.LigneCommandeEntree;

public interface ILigneCommandeEntreeDAO {

	void insertLigneCommandeEntree(LigneCommandeEntree ligneCommandeEntree);

	List<LigneCommandeEntree> selectAllLigneCommandeEntreesByIdCmd(int commandeEntreeId);
	
}
