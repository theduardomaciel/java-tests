package dev.theduardomaciel;

import java.util.logging.Logger;

public class Database {
	private boolean isOnline;
	private static final Logger LOGGER = Logger.getLogger(Database.class.getName());
	
	public Database() {
		this.isOnline = false;
	}
	
	public boolean isOnline() {
		return isOnline;
	}
	
	public void connect() {
		// Simula a conexão com o banco de dados
		isOnline = true;
		LOGGER.info("Banco de dados conectado!");
	}
	
	public void disconnect() {
		// Simula a desconexão com o banco de dados
		isOnline = false;
		LOGGER.info("Banco de dados desconectado!");
	}
}
