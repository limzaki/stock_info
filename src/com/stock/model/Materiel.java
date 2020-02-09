package com.stock.model;

public class Materiel {

	private int idMateriel;
	private Categorie categorie;
	private String nomMateriel;
	private int quantiteStock;
	private double prixUnitaire;
	
	public Materiel(Categorie categorie, String nomMateriel, int quantiteStock, double prixUnitaire) {
		super();
		this.categorie = categorie;
		this.nomMateriel = nomMateriel;
		this.quantiteStock = quantiteStock;
		this.prixUnitaire = prixUnitaire;
	}
	
	public Materiel(int idMateriel, Categorie categorie, String nomMateriel, int quantiteStock, double prixUnitaire) {
		super();
		this.idMateriel = idMateriel;
		this.categorie = categorie;
		this.nomMateriel = nomMateriel;
		this.quantiteStock = quantiteStock;
		this.prixUnitaire = prixUnitaire;
	}

	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public int getIdMateriel() {
		return idMateriel;
	}
	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
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
