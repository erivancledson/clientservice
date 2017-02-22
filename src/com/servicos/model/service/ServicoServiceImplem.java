package com.servicos.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.servicos.model.ServicoModel;
import com.servicos.model.dao.ServicoDaoInterface;



public class ServicoServiceImplem implements ServicoServiceInterface{
    
	@Inject
	private  ServicoDaoInterface servicoDaoInterface;
	
	
	@Override
	public List<ServicoModel> getServicos() {
		// TODO Auto-generated method stub
		return servicoDaoInterface.getServicos();
	}
	
	@Override
	@Transactional
	public ServicoModel salvarServico(ServicoModel servicoModel) {
		// TODO Auto-generated method stub
		return  servicoDaoInterface.salvarServico(servicoModel);
	}

	@Override
	@Transactional
	public void alterar(ServicoModel servicoModel) {
		servicoDaoInterface.alterar(servicoModel);
		
	}

	@Override
	@Transactional
	public void excluir(ServicoModel servicoModel) {
		servicoDaoInterface.excluir(servicoModel);
		
	}
	
}