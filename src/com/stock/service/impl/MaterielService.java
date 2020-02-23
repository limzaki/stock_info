package com.stock.service.impl;

import java.util.List;

import com.stock.dao.IMaterielDAO;
import com.stock.dao.impl.MaterielDAO;
import com.stock.model.Materiel;
import com.stock.service.IMaterielService;

public class MaterielService implements IMaterielService{
	
	private IMaterielDAO materielDAO;

	public MaterielService() {
		this.materielDAO = new MaterielDAO();
	}

	public List<Materiel> getAllMateriels() {
		return materielDAO.selectAllMateriels();
	}

	public void removeMateriel(int idMateriel) {
		materielDAO.deleteMateriel(idMateriel);
	}

	public void addMateriel(Materiel materiel) {
		materielDAO.insertMateriel(materiel);
	}

	public void editMateriel(Materiel materiel) {
		materielDAO.updateMateriel(materiel);
	}

	public void editMaterielQuantiteStock(int idMateriel, int newQuantite) {
		materielDAO.updateMaterielQuantiteStock(idMateriel, newQuantite);
	}
	
	public Materiel getMaterielById(int idMateriel) {
		return materielDAO.selectMaterielById(idMateriel);
	}
	
}
