package com.stock.dao;

public class MaterielDAO {

	private int idMateriel;
	private int idCategorie;
	private String nomMateriel;
	private int quantiteStock;
	private double prixUnitaire;
	
	public int getIdMateriel() {
		return idMateriel;
	}
	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomMateriel() {
		return nomMateriel;
	}
	public void setNomMateriel(String nomMateriel) {
		this.nomMateriel = nomMateriel;
	}
	public int getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantiteStock(int quantiteStock) {
		this.quantiteStock = quantiteStock;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
}
