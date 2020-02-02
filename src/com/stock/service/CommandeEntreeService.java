package com.stock.service;

import java.util.Date;

public class CommandeEntreeService {
	
	private int idCommandeEntree;
	private int idFournisseur;
	private Date dateCommandeEntree;
	
	public int getIdCommandeEntree() {
		return idCommandeEntree;
	}
	public void setIdCommandeEntree(int idCommandeEntree) {
		this.idCommandeEntree = idCommandeEntree;
	}
	public int getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public Date getDateCommandeEntree() {
		return dateCommandeEntree;
	}
	public void setDateCommandeEntree(Date dateCommandeEntree) {
		this.dateCommandeEntree = dateCommandeEntree;
	}
	
}
