package br.com.blockchain.resource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import br.com.blockchain.model.Ordem;
import br.com.blockchain.service.OrdemService;

@Path("/ordens")
@Transactional
public class OrdermResource 
{
	@Inject
	OrdemService ordemService;
	
	@POST
	@RolesAllowed("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(@Context SecurityContext securityContext, Ordem ordem)
	{
		ordemService.inserir(securityContext, ordem);
	}
	
}
