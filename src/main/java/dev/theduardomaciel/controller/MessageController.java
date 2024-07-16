package dev.theduardomaciel.controller;

import dev.theduardomaciel.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageController {
	private final List<Message> messages = new ArrayList<>();
	
	public void sendMessage(String content) {
		this.messages.add(new Message(content));
	}
	
	public List<Message> getMessages() {
		return Collections.unmodifiableList(this.messages);
	}
}
