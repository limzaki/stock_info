package com.stock.service;

import java.util.List;

import com.stock.model.LigneCommandeSortie;

public interface ILigneCommandeSortieService {

	void addLigneCommandeSortie(LigneCommandeSortie ligneCommandeSortie);

	List<LigneCommandeSortie> getAllLigneCommandeSortiesByIdCmd(int commandeSortieId);
	
}