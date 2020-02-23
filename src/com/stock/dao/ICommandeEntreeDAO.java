package com.stock.dao;

import java.util.List;

import com.stock.model.CommandeEntree;

public interface ICommandeEntreeDAO {

	List<CommandeEntree> selectAllCommandeEntrees();

	void insertCommandeEntree(CommandeEntree commandeEntree);

	CommandeEntree selectCommandeEntreeById(int idCommandeEntree);

	CommandeEntree selectLastCommandeEntree();

	void updateCommandeEntreeMontant(int idCommandeEntree, double montant);

}
