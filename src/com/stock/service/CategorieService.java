package com.stock.service;

import java.util.List;

import com.stock.dao.CategorieDAO;
import com.stock.model.Categorie;

public class CategorieService {
	
	private CategorieDAO categorieDAO;

	public CategorieService() {
		this.categorieDAO = new CategorieDAO();
	}

	public List<Categorie> getAllCategories() {
		return categorieDAO.selectAllCategories();
	}

	public void removeCategorie(int idCategorie) {
		categorieDAO.deleteCategorie(idCategorie);
	}

	public void addCategorie(Categorie categorie) {
		categorieDAO.insertCategorie(categorie);
	}

	public void editCategorie(Categorie categorie) {
		categorieDAO.updateCategorie(categorie);
	}

	public Categorie getCategorieById(int idCategorie) {
		return categorieDAO.selectCategorieById(idCategorie);
	}
	
}
