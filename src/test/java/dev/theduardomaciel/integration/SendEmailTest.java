package dev.theduardomaciel.integration;

import dev.theduardomaciel.Email;
import dev.theduardomaciel.EmailFormat;
import dev.theduardomaciel.service.EmailSendingPlatform;
import dev.theduardomaciel.service.MailApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SendEmailTest {
	
	@Mock
	private EmailSendingPlatform emailSendingPlatform;
	
	@InjectMocks
	private MailApi mailApi;
	
	@Captor
	private ArgumentCaptor<Email> emailCaptor;
	
	@Test
	void validateDataSentToEmailSendingPlatform() {
		String emailAddress = "teste@gmail.com";
		String subject = "Teste";
		String body = "Lorem ipsum amet dolor sit";
		boolean isHtml = true;
		
		mailApi.sendEmail(emailAddress, subject, body, isHtml);
		
		Mockito.verify(emailSendingPlatform).sendEmail(emailCaptor.capture());
		
		Email emailCaptured = emailCaptor.getValue();
		
		Assertions.assertEquals(emailAddress, emailCaptured.getAddress());
		Assertions.assertEquals(subject, emailCaptured.getSubject());
		Assertions.assertEquals("<html>" + body + "</html>", emailCaptured.getContent());
		Assertions.assertEquals(EmailFormat.HTML, emailCaptured.getFormat());
	}
}
