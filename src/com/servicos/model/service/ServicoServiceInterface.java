package com.servicos.model.service;

import java.util.List;

import com.servicos.model.ServicoModel;



public interface ServicoServiceInterface {
	
	ServicoModel salvarServico(ServicoModel servicoModel);
	void alterar(ServicoModel servicoModel);
	void excluir(ServicoModel servicoModel);

	List<ServicoModel> getServicos();

}
