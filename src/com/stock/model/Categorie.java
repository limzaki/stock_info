package com.stock.model;

public class Categorie {
	
	private int idCategorie;
	private String designation;
	
	public Categorie(int idCategorie, String designation) {
		super();
		this.idCategorie = idCategorie;
		this.designation = designation;
	}
	public Categorie(String designation) {
		this.designation = designation;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
