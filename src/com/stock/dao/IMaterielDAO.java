package com.stock.dao;

import java.util.List;

import com.stock.model.Materiel;

public interface IMaterielDAO {

	public List<Materiel> selectAllMateriels();

	public void deleteMateriel(int idMateriel);
	
	public void insertMateriel(Materiel materiel);

	public void updateMateriel(Materiel materiel);

	public Materiel selectMaterielById(int idMateriel);

}
