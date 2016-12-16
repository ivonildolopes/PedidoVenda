package com.algaworks.pedidovenda.util.mail;

import java.io.IOException;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.outjected.email.api.SessionConfig;
import com.outjected.email.impl.SimpleMailConfig;


public class MailConfigProducer {

	@Produces
	@ApplicationScoped
	public SessionConfig getMailConfig() throws IOException{
//		Properties propriedade = new Properties();
//		propriedade.load(getClass().getResourceAsStream("/mail.prorperties"));
		
//		SimpleMailConfig config = new SimpleMailConfig();
//		config.setServerHost(propriedade.getProperty("mail.server.host"));
//		config.setServerPort(Integer.parseInt(propriedade.getProperty("mail.server.port")));
//		config.setEnableSsl(Boolean.parseBoolean(propriedade.getProperty("mail.enable.ssl")));
//		config.setAuth(Boolean.parseBoolean(propriedade.getProperty("mail.auth")));
//		config.setUsername(propriedade.getProperty("mail.user"));
//		config.setPassword(propriedade.getProperty("mail.password"));
//		return config;
		
		
		SimpleMailConfig config = new SimpleMailConfig();
		configuração . setServerHost ( "
		config.setServerPort(25);
		config.setAuth(true);
		configuracao . setUsername ( "Ivonildo.)
		configuracao . setPassword ( "Henry
		return config;
		
		
		
		
	}
}
