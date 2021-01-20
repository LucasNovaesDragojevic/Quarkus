package br.com.blockchain.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.blockchain.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> 
{

}
