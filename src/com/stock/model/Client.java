package com.stock.model;

public class Client {
	
	private int idClient;
	private String nomComplet;
	private String telephone;
	private String email;
	
	public Client(String nomComplet, String telephone, String email) {
		super();
		this.nomComplet = nomComplet;
		this.telephone = telephone;
		this.email = email;
	}
	public Client(int idClient, String nomComplet, String telephone, String email) {
		super();
		this.idClient = idClient;
		this.nomComplet = nomComplet;
		this.telephone = telephone;
		this.email = email;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
