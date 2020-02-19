package com.stock.service;

import java.util.List;

import com.stock.model.Categorie;

public interface ICategorieService {

	List<Categorie> getAllCategories();

	void removeCategorie(int idCategorie);

	void addCategorie(Categorie categorie);

	void editCategorie(Categorie categorie);

	Categorie getCategorieById(int idCategorie);
}
