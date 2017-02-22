package com.servicos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.servicos.model.ServicoModel;


public class ServicoDaoImplements  implements ServicoDaoInterface{

	@PersistenceContext(unitName="meusservicos")
	
	//manipular o banco de dados
	private EntityManager entityManager;
	
	@Override
	public ServicoModel salvarServico(ServicoModel servicoModel) {
	
		entityManager.persist(servicoModel);
		
		return servicoModel;
	}

	@Override
	public void alterar(ServicoModel servicoModel) {
		
		ServicoModel servicoModelMerge = entityManager.merge(servicoModel);
		entityManager.persist(servicoModelMerge);
	}

	@Override
	public void excluir(ServicoModel servicoModel) {
		ServicoModel servicoModelMerge = entityManager.merge(servicoModel);
		entityManager.remove(servicoModelMerge); 
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ServicoModel> getServicos() {
		//select 
		Query query = entityManager.createQuery("from ServicoModel");
		return query.getResultList();
	}
	

}
