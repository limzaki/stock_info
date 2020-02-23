package com.stock.dao;

import java.util.List;

import com.stock.model.CommandeSortie;

public interface ICommandeSortieDAO {

	List<CommandeSortie> selectAllCommandeSorties();

	void insertCommandeSortie(CommandeSortie commandeSortie);

	CommandeSortie selectCommandeSortieById(int idCommandeSortie);

	CommandeSortie selectLastCommandeSortie();

	void updateCommandeSortieMontant(int idCommandeSortie, double montant);

}
