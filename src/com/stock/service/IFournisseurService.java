package com.stock.service;

import java.util.List;
import com.stock.model.Fournisseur;

public interface IFournisseurService {

	public List<Fournisseur> getAllFournisseurs();
	
	public void removeFournisseur(int idFournisseur);
	
	public void addFournisseur(Fournisseur fournisseur);
	
	public void editFournisseur(Fournisseur fournisseur);
	
	public Fournisseur getFournisseurById(int idFournisseur);
	
}
