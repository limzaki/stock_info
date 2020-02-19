package com.stock.service;

import java.util.List;
import com.stock.model.Materiel;

public interface IMaterielService {
	
	public List<Materiel> getAllMateriels();
	
	public void removeMateriel(int idMateriel);
	
	public void addMateriel(Materiel materiel);
	
	public void editMateriel(Materiel materiel);
	
	public Materiel getMaterielById(int idMateriel);
}
