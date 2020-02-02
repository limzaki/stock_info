package com.stock.dao;

import java.util.Date;

public class CommandeSortieDAO {
	
	private int idCommandeSortie;
	private int idClient;
	private Date dateCommandeSortie;
	
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
	
}
