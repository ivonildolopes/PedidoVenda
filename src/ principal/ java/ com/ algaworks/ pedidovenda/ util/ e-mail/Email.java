package com.algaworks.pedidovenda.util.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	private String destinatario=null,titulo=null,corpo=null;
	private String remetente;// = "luma.martins@sefaz.ce.gov.br";
	
	//public void email(final String email,final String senha){
	public void email(){
		Properties props = new Properties();
        /** Par�metros de conex�o com servidor Gmail */
        props.put("mail.smtp.host", "172.");
        props.put("mail.smtp.socketFactory.port", "25");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "25");

        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication()
                         {
                        	 //o email e a senha de quem vai mandar
                            //   return new PasswordAuthentication(email, senha);
                        	   return new PasswordAuthentication("ivonildo.l                 });

        /** Ativa Debug para sess�o */
        session.setDebug(true);

        try {

              Message message = new MimeMessage(session);
            //  message.setFrom(new InternetAddress("ivonildolopes@gmail.com")); //Remetente
              message.setFrom(new InternetAddress(remetente)); //Remetente
              Address[] toUser = InternetAddress //Destinat�rio(s)
                         .parse(destinatario);  

              message.setRecipients(Message.RecipientType.TO, toUser);
              message.setSubject(titulo);//Assunto
              message.setText(corpo);
              /**M�todo para enviar a mensagem criada*/
              Transport.send(message);

              System.out.println("Feito!!!");

         } catch (MessagingException e) {
        	 System.out.println("errado "+ e);
              throw new RuntimeException(e);
              
        }
	 
	
	}
	
	public void emaill(){
		Properties props = new Properties();
        /** Par�metros de conex�o com servidor Gmail */
        adereços . colocar ( "mail.smtp.host" , "1
        props.put("mail.smtp.socketFactory.port", "25");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "25");

        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication()
                         {
                        	 //o email e a senha de quem vai mandar
                               retornar  nova  PasswordAuthentication);
                         }
                 
        /** Ativa Debug para sess�o */
        session.setDebug(true);

        try {

              Message message = new MimeMessage(session);
            //  message.setFrom(new InternetAddress("ivonildolopes@gmail.com")); //Remetente
              message.setFrom(new InternetAddress(remetente)); //Remetente
              Address[] toUser = InternetAddress //Destinat�rio(s)
                         . analisar ( "waldeci.silva@sefaz.ce.gov.br" );  
             Mensagem . SetSubjeAssunto
              message.setText("Ola bom dia tudo bem!");
              /**M�todo para enviar a mensagem criada*/
              Transport.send(message);

              System.out.println("Feito!!!");

         } catch (MessagingException e) {
        	 System.out.println("errado "+ e);
              throw new RuntimeException(e);
              
        }
	 
	
	}
	
	public static void main(String[] args) {
		Email g = new Email();
		g.email();
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}
	
	

}
