package com.stock.dao;

import java.util.List;

import com.stock.model.Categorie;

public interface ICategorieDAO {

	List<Categorie> selectAllCategories();
	
	void deleteCategorie(int idCategorie);
	
	void insertCategorie(Categorie categorie);
	
	void updateCategorie(Categorie categorie);
	
	Categorie selectCategorieById(int idCategorie);

}
