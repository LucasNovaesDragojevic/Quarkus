package br.com.blockchain.resource;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.blockchain.model.Ordem;
import br.com.blockchain.repository.OrdemRepository;

@Path("/ordens")
@Transactional
public class OrdermResource 
{
	@Inject
	OrdemRepository ordemRepository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Ordem ordem)
	{
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");
		ordemRepository.persist(ordem);
	}
	
}
