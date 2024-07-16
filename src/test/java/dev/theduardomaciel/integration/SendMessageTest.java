package dev.theduardomaciel.integration;

import dev.theduardomaciel.controller.MessageController;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SendMessageTest {
	@Spy
	private MessageController messageController;
	
	@Test
	public void observeClassBehavior() {
		Mockito.verifyNoInteractions(this.messageController);
		
		messageController.sendMessage("Hello, World!");
		Mockito.verify(this.messageController).sendMessage("Hello, World!");
		
		/*
		* Em resumo, o @Spy observa o comportamento da classe real, permitindo verificar o que está acontecendo por baixo dos panos.
		* */
		
		Assertions.assertFalse(messageController.getMessages().isEmpty());
	}
}
