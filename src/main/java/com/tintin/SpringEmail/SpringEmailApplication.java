package com.tintin.SpringEmail;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailApplication {
	
	@Autowired
	private EmailService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		service.sendEmailWithAttachment("nitin.vankadari2018@vitstudent.ac.in",
				"This is Email Body with Attachment...",
				"This email has attachment",
				"C:\\Users\\Nitin\\Downloads\\18BIT0227_VL2020210105304_PE003.pdf");
	}
}
