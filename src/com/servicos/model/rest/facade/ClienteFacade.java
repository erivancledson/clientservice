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


import com.servicos.model.ClientesModel;
import com.servicos.model.service.ClienteServiceInterface;

@Path("/clientes")
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteFacade {
	
	@Inject
	private ClienteServiceInterface clienteServiceInterface;
	
	@GET
	public List<ClientesModel> getClientes(){
		return clienteServiceInterface.getClientes();
	}
	
	@POST
	public ClientesModel salvarCliente(ClientesModel clientesModel) {
		return clienteServiceInterface.salvarCliente(clientesModel);
	}
	
	@PUT
	public void atualizar(ClientesModel clientesModel) {
		clienteServiceInterface.alterar(clientesModel);
	}
	
	@DELETE
	@Path("/{codigoCliente}")
	public void excluir(@PathParam("codigoCliente") Integer codigoCliente) {
		ClientesModel clientesModel = new ClientesModel();
		clientesModel.setCodigo(codigoCliente);
		clienteServiceInterface.excluir(clientesModel);
		
	}

}
