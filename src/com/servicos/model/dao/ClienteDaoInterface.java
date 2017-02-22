package com.servicos.model.dao;

import java.util.List;

import com.servicos.model.ClientesModel;


public interface ClienteDaoInterface {

	
	ClientesModel salvarCliente(ClientesModel clientesModel);
	void alterar(ClientesModel clientesModel);
	void excluir(ClientesModel clientesModel);

	List<ClientesModel> getClientes();
}
