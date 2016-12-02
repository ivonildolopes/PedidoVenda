package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.algaworks.pedidovenda.model.Cliente;

public class ClienteDAO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Cliente porId(Long id){
		return this.manager.find(Cliente.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> porNome(String nome){
		String jpql = "from Cliente c where c.nome like :nome";
		Query query = manager.createQuery(jpql,Cliente.class);
		query.setParameter("nome","%"+nome+"%");
		return query.getResultList();
	}

}
