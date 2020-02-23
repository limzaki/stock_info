package com.stock.service;

import java.util.List;

import com.stock.model.CommandeSortie;

public interface ICommandeSortieService {

	List<CommandeSortie> getAllCommandeSorties();

	void addCommandeSortie(CommandeSortie commandeSortie);

	void setCommandeSortieMontant(int commandeSortieId, double montant);

	CommandeSortie getLastCommandeSortie();

}
