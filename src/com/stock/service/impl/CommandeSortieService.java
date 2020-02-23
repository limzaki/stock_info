package com.stock.service.impl;

import java.util.List;

import com.stock.dao.ICommandeSortieDAO;
import com.stock.dao.impl.CommandeSortieDAO;
import com.stock.model.CommandeSortie;
import com.stock.service.ICommandeSortieService;

public class CommandeSortieService implements ICommandeSortieService{
	
	private ICommandeSortieDAO commandeSortieDAO;
	
	public CommandeSortieService() {
		this.commandeSortieDAO = new CommandeSortieDAO();
	}

	@Override
	public List<CommandeSortie> getAllCommandeSorties() {
		return commandeSortieDAO.selectAllCommandeSorties();
	}
	
	@Override
	public void addCommandeSortie(CommandeSortie commandeSortie) {
		commandeSortieDAO.insertCommandeSortie(commandeSortie);
		
	}

	public CommandeSortie geCommandeSortieById(int idCommandeSortie) {
		return commandeSortieDAO.selectCommandeSortieById(idCommandeSortie);
	}

	public CommandeSortie getLastCommandeSortie() {
		return commandeSortieDAO.selectLastCommandeSortie();
	}


	public void setCommandeSortieMontant(int idCommandeSortie, double montant) {
		commandeSortieDAO.updateCommandeSortieMontant(idCommandeSortie, montant);
	}
}
