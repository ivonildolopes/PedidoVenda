package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.algaworks.pedidovenda.model.Usuario;

public class UsuarioDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Usuario porId(Long id){
		return this.manager.find(Usuario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarVendedores(){
		String jpql = "from Usuario";
		Query query = manager.createQuery(jpql,Usuario.class);
		return query.getResultList();
	}

	public Usuario porEmail(String email) {
		String jpql = "from Usuario u where lower(u.email) = :email";
		Usuario usuario = null;
		try {
			Query query = manager.createQuery(jpql,Usuario.class);
			usuario = (Usuario) query.setParameter("email", email.toLowerCase()).getSingleResult();
			
		} catch (NoResultException e) {
			//e.printStackTrace();
		}
		return usuario;
	}
}
