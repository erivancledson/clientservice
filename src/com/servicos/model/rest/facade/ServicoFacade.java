package com.servicos.model.rest.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.servicos.model.ServicoModel;

import com.servicos.model.service.ServicoServiceInterface;

@Path("/servicos")
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ServicoFacade{

	
	@Inject
	private ServicoServiceInterface servicoServiceInterface;
	
	@GET
	public List<ServicoModel> getServicos(){
      return servicoServiceInterface.getServicos();
	}
	
	@POST
	public ServicoModel salvarServico(ServicoModel servicoModel){
		return servicoServiceInterface.salvarServico(servicoModel);
	}
	
	@PUT
	public void atualizar(ServicoModel servicoModel){
		servicoServiceInterface.alterar(servicoModel);
	}
	
	@DELETE
	//parametro 
	@Path("/{codigoServico}")
	public void excluir(@PathParam("codigoServico") Integer codigoServico){
		ServicoModel servicoModel = new ServicoModel();
		servicoModel.setCodigo(codigoServico);
		servicoServiceInterface.excluir(servicoModel);
	}
}