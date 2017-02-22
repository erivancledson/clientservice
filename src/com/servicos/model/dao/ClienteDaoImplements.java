package com.servicos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.servicos.model.ClientesModel;

public class ClienteDaoImplements implements ClienteDaoInterface{
	
	@PersistenceContext(unitName="meusservicos")
	
	private EntityManager entityManager;

	@Override
	public ClientesModel salvarCliente(ClientesModel clientesModel) {
		entityManager.persist(clientesModel);
		return clientesModel;
	}

	@Override
	public void alterar(ClientesModel clientesModel) {
		
		ClientesModel clientesModelMerge = entityManager.merge(clientesModel);
		entityManager.persist(clientesModelMerge);
	}

	@Override
	public void excluir(ClientesModel clientesModel) {
		ClientesModel clientesModelMerge = entityManager.merge(clientesModel);
		entityManager.remove(clientesModelMerge);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ClientesModel> getClientes() {
		Query query = entityManager.createQuery("from ClientesModel");
		return query.getResultList();
	}

}
