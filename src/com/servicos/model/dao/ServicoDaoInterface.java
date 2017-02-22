package com.servicos.model.dao;

import java.util.List;

import com.servicos.model.ServicoModel;

;

public interface ServicoDaoInterface {

	
	ServicoModel salvarServico(ServicoModel servicoModel);
	void alterar(ServicoModel servicoModel);
	void excluir(ServicoModel servicoModel);

	List<ServicoModel> getServicos();
}
