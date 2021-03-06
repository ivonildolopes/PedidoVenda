package com.algaworks.pedidovenda.security;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Named
@RequestScoped
public class Seguranca implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public String getNomeUsuario(){
		String nome = null;
		
		UsuarioSistema usuarioLogado = getUsuarioLogado();
		
		if(usuarioLogado != null)
			nome = usuarioLogado.getUsuario().getNome();
		
		return nome;
	}
 
	private UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuarioSistema = null;
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken)
		FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal(); //pega o usuario logado da instacia
		
		if(auth != null && auth.getPrincipal() != null){
			usuarioSistema = (UsuarioSistema) auth.getPrincipal();
		}
		
		return usuarioSistema;
	}
}
