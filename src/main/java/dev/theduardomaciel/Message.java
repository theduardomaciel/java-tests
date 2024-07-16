package dev.theduardomaciel;

import java.util.UUID;

public class Message {
	private final String id;
	private final String content;
	
	public Message(final String content) {
		this.id = UUID.randomUUID().toString();
		this.content = content;
	}
}
