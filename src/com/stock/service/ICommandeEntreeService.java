package com.stock.service;

import java.util.List;

import com.stock.model.CommandeEntree;

public interface ICommandeEntreeService {

	List<CommandeEntree> getAllCommandeEntrees();

	void addCommandeEntree(CommandeEntree commandeEntree);

	void setCommandeEntreeMontant(int commandeEntreeId, double montant);

	CommandeEntree getLastCommandeEntree();

}
