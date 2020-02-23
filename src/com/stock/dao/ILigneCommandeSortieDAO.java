package com.stock.dao;

import java.util.List;

import com.stock.model.LigneCommandeSortie;

public interface ILigneCommandeSortieDAO {

	void insertLigneCommandeSortie(LigneCommandeSortie ligneCommandeSortie);

	List<LigneCommandeSortie> selectAllLigneCommandeSortiesByIdCmd(int commandeSortieId);
	
}
