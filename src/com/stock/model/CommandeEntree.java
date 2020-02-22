package com.stock.model;

import java.util.Date;
import java.util.List;

public class CommandeEntree {
	
	private int idCommandeEntree;
	private Fournisseur fournisseur;
	private Date dateCommandeEntree;
	private double montant;
	
	public CommandeEntree(int idCommandeEntree, Fournisseur fournisseur, Date dateCommandeEntree, double montant) {
		super();
		this.idCommandeEntree = idCommandeEntree;
		this.fournisseur = fournisseur;
		this.dateCommandeEntree = dateCommandeEntree;
		this.montant = montant;
	}
	public int getIdCommandeEntree() {
		return idCommandeEntree;
	}
	public void setIdCommandeEntree(int idCommandeEntree) {
		this.idCommandeEntree = idCommandeEntree;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
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

}
