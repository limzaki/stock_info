package com.stock.service.impl;

import java.util.List;

import com.stock.dao.ICommandeEntreeDAO;
import com.stock.dao.impl.CommandeEntreeDAO;
import com.stock.model.CommandeEntree;
import com.stock.service.ICommandeEntreeService;

public class CommandeEntreeService implements ICommandeEntreeService{

	private ICommandeEntreeDAO commandeEntreeDAO;

	public CommandeEntreeService() {
		this.commandeEntreeDAO = new CommandeEntreeDAO();
	}

	@Override
	public List<CommandeEntree> getAllCommandeEntrees() {
		return commandeEntreeDAO.selectAllCommandeEntrees();
	}

	@Override
	public void addCommandeEntree(CommandeEntree commandeEntree) {
		commandeEntreeDAO.insertCommandeEntree(commandeEntree);

	}

	public CommandeEntree geCommandeEntreeById(int idCommandeEntree) {
		return commandeEntreeDAO.selectCommandeEntreeById(idCommandeEntree);
	}

	public CommandeEntree getLastCommandeEntree() {
		return commandeEntreeDAO.selectLastCommandeEntree();
	}


	public void setCommandeEntreeMontant(int idCommandeEntree, double montant) {
		commandeEntreeDAO.updateCommandeEntreeMontant(idCommandeEntree, montant);
	}
}
