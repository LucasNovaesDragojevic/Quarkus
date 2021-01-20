package br.com.blockchain.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import br.com.blockchain.model.Ordem;
import br.com.blockchain.model.Usuario;
import br.com.blockchain.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService 
{

	@Inject
	private OrdemRepository ordemRepository;

	public void inserir(SecurityContext securityContext, Ordem ordem) 
	{
		Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());
		Usuario usuario = usuarioOptional.orElseThrow();
		if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName()))
			throw new RuntimeException("O usuário logado é diferente da ordem de serviço.");
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");
		ordemRepository.persist(ordem);
	}

}
