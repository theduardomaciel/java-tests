package dev.theduardomaciel.service;

import dev.theduardomaciel.Email;
import dev.theduardomaciel.EmailFormat;

public class MailApi {
	private EmailSendingPlatform emailSendingPlatform;
	
	public void sendEmail(String address, String subject, String body, boolean isHtml) {
		Email email;
		
		if (isHtml) {
			email = new Email(address, subject, "<html>" + body + "</html>", EmailFormat.HTML);
		} else {
			email = new Email(address, subject, body, EmailFormat.TEXT);
		}
		
		this.emailSendingPlatform.sendEmail(email);
	}
}

