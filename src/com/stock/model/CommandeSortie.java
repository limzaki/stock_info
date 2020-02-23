package com.stock.model;

import java.util.Date;

public class CommandeSortie {
	
	private int idCommandeSortie;
	private Client client;
	private Date dateCommandeSortie;
	private double montant;
	
	public CommandeSortie(int idCommandeSortie, Client client, Date dateCommandeSortie, double montant) {
		super();
		this.idCommandeSortie = idCommandeSortie;
		this.client = client;
		this.dateCommandeSortie = dateCommandeSortie;
		this.montant = montant;
	}
	public CommandeSortie(Client client, Date dateCommandeSortie) {
		this.client = client;
		this.dateCommandeSortie = dateCommandeSortie;
	}
	public int getIdCommandeSortie() {
		return idCommandeSortie;
	}
	public void setIdCommandeSortie(int idCommandeSortie) {
		this.idCommandeSortie = idCommandeSortie;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
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
