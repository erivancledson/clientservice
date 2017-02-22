package com.servicos.model.service;

import java.util.List;

import com.servicos.model.ClientesModel;



public interface ClienteServiceInterface {

	
	ClientesModel salvarCliente(ClientesModel clientesModel);
	void alterar(ClientesModel clientesModel);
	void excluir(ClientesModel clientesModel);

	List<ClientesModel> getClientes();
}
