package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.repository.filter.PedidoParaPesquisa;

public class PedidoDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Inject
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Pedido> filtrados(PedidoParaPesquisa pedido){
		Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(Pedido.class)
				.createAlias("cliente","c") // associação join com cliente e nomeamos como "c"
				.createAlias("vendedor", "v"); // associação join com usuario e nomeamos como "v"
		
		
		if(pedido.getNumeroDe() != null){
			//id deve ser maior ou igual (ge = greater or equals) a pedido.numeroDe
			criteria.add(Restrictions.ge("id",pedido.getNumeroDe()));
		}
		
		if(pedido.getNumeroAte() != null){
			//id deve ser menor ou igual (le = lower or equals) a pedido.numeroDe
			criteria.add(Restrictions.le("id",pedido.getNumeroAte()));
		}		
		
		
		if(pedido.getDataCriacaoDe() != null){
			//id deve ser maior ou igual (ge = greater or equals) a pedido.numeroDe
			criteria.add(Restrictions.ge("dataCriacao",pedido.getDataCriacaoDe()));
		}
		
		if(pedido.getDataCriacaoAte() != null){
			//id deve ser menor ou igual (le = lower or equals) a pedido.numeroDe
			criteria.add(Restrictions.le("dataCriacao",pedido.getDataCriacaoAte()));
		}
		
		if(StringUtils.isNotBlank(pedido.getNomeCliente())){
			//acessamos o nome do cliente associado ao pedido pelo alias "c"
			criteria.add(Restrictions.ilike("c.nome", pedido.getNomeCliente(),MatchMode.ANYWHERE));
		}
		
		if(StringUtils.isNotBlank(pedido.getNomeVendedor())){
			//acessamos o nome do vendedor associado ao pedido pelo alias "v"
			criteria.add(Restrictions.ilike("v.nome", pedido.getNomeVendedor(),MatchMode.ANYWHERE));
		}
		
		if(pedido.getStatuses() != null && pedido.getStatuses().length > 0){
			//adicionamos uma restrição "in", passando um array de constantes da ENUM StatusPedido
			criteria.add(Restrictions.in("status", pedido.getStatuses()));
		}
		
		
		return criteria.addOrder(Order.asc("id")).list();
	}
	
	public Pedido porId(Long id){
		return this.manager.find(Pedido.class,id);
	}
	
	//crud
	public Pedido salvar(Pedido pedido){
		return manager.merge(pedido);
	}
	
	
}
