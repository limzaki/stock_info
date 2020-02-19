package com.stock.model;

import java.util.Date;
import java.util.List;

public class CommandeEntree {
	
	private int idCommandeEntree;
	private int Fournisseur;
	private Date dateCommandeEntree;
	private double montant;
	private List<LigneCommandeEntree> lignesCommandeEntree;
	
	public int getIdCommandeEntree() {
		return idCommandeEntree;
	}
	public void setIdCommandeEntree(int idCommandeEntree) {
		this.idCommandeEntree = idCommandeEntree;
	}
	public int getFournisseur() {
		return Fournisseur;
	}
	public void setFournisseur(int fournisseur) {
		Fournisseur = fournisseur;
	}
	public Date getDateCommandeEntree() {
		return dateCommandeEntree;
	}
	public void setDateCommandeEntree(Date dateCommandeEntree) {
		this.dateCommandeEntree = dateCommandeEntree;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public List<LigneCommandeEntree> getLignesCommandeEntree() {
		return lignesCommandeEntree;
	}
	public void setLignesCommandeEntree(List<LigneCommandeEntree> lignesCommandeEntree) {
		this.lignesCommandeEntree = lignesCommandeEntree;
	}
	
}
