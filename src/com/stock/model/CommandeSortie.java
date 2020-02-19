package com.stock.model;

import java.util.Date;

public class CommandeSortie {
	
	private int idCommandeSortie;
	private int idClient;
	private Date dateCommandeSortie;
	private double montant;
	
	public int getIdCommandeSortie() {
		return idCommandeSortie;
	}
	public void setIdCommandeSortie(int idCommandeSortie) {
		this.idCommandeSortie = idCommandeSortie;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public Date getDateCommandeSortie() {
		return dateCommandeSortie;
	}
	public void setDateCommandeSortie(Date dateCommandeSortie) {
		this.dateCommandeSortie = dateCommandeSortie;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
}
