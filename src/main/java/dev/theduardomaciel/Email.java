package dev.theduardomaciel;

public class Email {
	public String address;
	public String subject;
	public String content;
	public EmailFormat format;
	
	public Email(String address, String subject, String content, EmailFormat format) {
		this.address = address;
		this.subject = subject;
		this.content = content;
		this.format = format;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public EmailFormat getFormat() {
		return this.format;
	}
}

