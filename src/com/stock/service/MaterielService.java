package com.stock.service;

import java.util.List;

import com.stock.dao.MaterielDAO;
import com.stock.model.Materiel;

public class MaterielService {
	
	private MaterielDAO materielDAO;

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

	public Materiel getMaterielById(int idMateriel) {
		return materielDAO.selectMaterielById(idMateriel);
	}
	
}
