package com.stock.service.impl;

import java.util.List;

import com.stock.dao.ICategorieDAO;
import com.stock.dao.impl.CategorieDAO;
import com.stock.model.Categorie;
import com.stock.service.ICategorieService;

public class CategorieService implements ICategorieService {
	
	private ICategorieDAO categorieDAO;

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
