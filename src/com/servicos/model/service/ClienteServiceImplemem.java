package com.servicos.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.servicos.model.ClientesModel;
import com.servicos.model.dao.ClienteDaoInterface;

public class ClienteServiceImplemem implements ClienteServiceInterface{
	
	@Inject
	private ClienteDaoInterface clienteDaoInterface;

	@Override
	@Transactional
	public ClientesModel salvarCliente(ClientesModel clientesModel) {
		
		return clienteDaoInterface.salvarCliente(clientesModel);
	}

	@Override
	@Transactional
	public void alterar(ClientesModel clientesModel) {
		clienteDaoInterface.alterar(clientesModel);
		
	}

	@Override
	@Transactional
	public void excluir(ClientesModel clientesModel) {
		clienteDaoInterface.excluir(clientesModel);
		
	}

	@Override
	public List<ClientesModel> getClientes() {
		// TODO Auto-generated method stub
		return clienteDaoInterface.getClientes();
	}

}
