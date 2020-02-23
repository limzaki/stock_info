package com.stock.model;

public class LigneCommandeSortie {
	
	private int idLigneCommandeSortie;
	private CommandeSortie commandeSortie;
	private Materiel materiel;
	private int quantite;

	public LigneCommandeSortie(int idLigneCommandeSortie, CommandeSortie commandeSortie, Materiel materiel,
			int quantite) {
		super();
		this.idLigneCommandeSortie = idLigneCommandeSortie;
		this.commandeSortie = commandeSortie;
		this.materiel = materiel;
		this.quantite = quantite;
	}
	
	public LigneCommandeSortie(CommandeSortie commandeSortie, Materiel materiel,
			int quantite) {
		super();
		this.commandeSortie = commandeSortie;
		this.materiel = materiel;
		this.quantite = quantite;
	}

	public int getIdLigneCommandeSortie() {
		return idLigneCommandeSortie;
	}

	public void setIdLigneCommandeSortie(int idLigneCommandeSortie) {
		this.idLigneCommandeSortie = idLigneCommandeSortie;
	}

	public CommandeSortie getCommandeSortie() {
		return commandeSortie;
	}

	public void setCommandeSortie(CommandeSortie commandeSortie) {
		this.commandeSortie = commandeSortie;
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
