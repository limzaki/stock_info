package com.stock.model;

import java.util.List;

public class LigneCommandeSortie {
	
	private int idLigneCommandeSortie;
	private int idCommandeSortie;
	private int quantite;
	private List<LigneCommandeSortie> lignesCommandeSortie;
	
	public int getIdLigneCommandeSortie() {
		return idLigneCommandeSortie;
	}
	public void setIdLigneCommandeSortie(int idLigneCommandeSortie) {
		this.idLigneCommandeSortie = idLigneCommandeSortie;
	}
	public int getIdCommandeSortie() {
		return idCommandeSortie;
	}
	public void setIdCommandeSortie(int idCommandeSortie) {
		this.idCommandeSortie = idCommandeSortie;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public List<LigneCommandeSortie> getLignesCommandeSortie() {
		return lignesCommandeSortie;
	}
	public void setLignesCommandeSortie(List<LigneCommandeSortie> lignesCommandeSortie) {
		this.lignesCommandeSortie = lignesCommandeSortie;
	}
	
}
