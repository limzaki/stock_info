package com.stock.model;

public class LigneCommandeEntree {
	
	private int idLigneCommandeEntree;
	private CommandeEntree commandeEntree;
	private Materiel materiel;
	private int quantite;

	public LigneCommandeEntree(int idLigneCommandeEntree, CommandeEntree commandeEntree, Materiel materiel,
			int quantite) {
		super();
		this.idLigneCommandeEntree = idLigneCommandeEntree;
		this.commandeEntree = commandeEntree;
		this.materiel = materiel;
		this.quantite = quantite;
	}
	
	public LigneCommandeEntree(CommandeEntree commandeEntree, Materiel materiel,
			int quantite) {
		super();
		this.commandeEntree = commandeEntree;
		this.materiel = materiel;
		this.quantite = quantite;
	}

	public int getIdLigneCommandeEntree() {
		return idLigneCommandeEntree;
	}

	public void setIdLigneCommandeEntree(int idLigneCommandeEntree) {
		this.idLigneCommandeEntree = idLigneCommandeEntree;
	}

	public CommandeEntree getCommandeEntree() {
		return commandeEntree;
	}

	public void setCommandeEntree(CommandeEntree commandeEntree) {
		this.commandeEntree = commandeEntree;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}
