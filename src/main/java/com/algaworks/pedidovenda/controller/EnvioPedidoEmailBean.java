package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.velocity.tools.generic.NumberTool;

import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;
import com.algaworks.pedidovenda.util.mail.Email;
import com.algaworks.pedidovenda.util.mail.Mailer;
import com.algaworks.pedidovenda.validation.PedidoEdicao;
import com.outjected.email.api.MailMessage;
import com.outjected.email.impl.templating.velocity.VelocityTemplate;

@Named
@RequestScoped
public class EnvioPedidoEmailBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	@PedidoEdicao
	private Pedido pedido;
	
	@Inject
	private Mailer mailer;
	
	private Email email;
	
	public EnvioPedidoEmailBean() {
		email = new Email();
	}
	
	public void enviar(){
		MailMessage msg = mailer.novaMensagem();
	
		try {
			
			
			msg.to(pedido.getCliente().getEmail())
			.from(pedido.getVendedor().getEmail())
			.bcc(pedido.getVendedor().getEmail())
			.subject("Seu pedido de venda foi " + pedido.getId())
			.bodyHtml(new VelocityTemplate(getClass().getResourceAsStream("/emails/pedidoEmail.template")))
			.put("pedido", pedido)
			.put("numberTool", new NumberTool())
			.put("locale", new Locale("pt","BR"))
			.send();
			
			FacesUtil.InfoMessage("Pedido enviado por email com sucesso!");
		} catch (Exception e) {
			System.out.println("EROOOOOOOOOOOO");
			e.printStackTrace();
			FacesUtil.ErrorMessage("Erro ao tentar enviar email");
		}
	}
	
	
	public void enviarEmail(){
	
		try {
			email.setRemetente(pedido.getVendedor().getEmail());
			email.setDestinatario(pedido.getCliente().getEmail());
			email.setCorpo("<html>"
							+ "<strong>valor total: </strong> " + this.pedido.getValorTotal()
							+ "</html>");
			email.setTitulo("Seu pedido de venda foi " + pedido.getId());
			email.email();
			
			FacesUtil.InfoMessage("Pedido enviado por email com sucesso!");
		} catch (Exception e) {
			FacesUtil.ErrorMessage("Erro ao tentar enviar email");
		}
	}
}
