package dev.theduardomaciel;

public class BankAccount {
	private int balance;
	
	public BankAccount(int balance) {
		this.balance = balance;
	}
	
	public boolean isBalancePositive() {
		return this.balance > 0;
	}
	
	public void debit(int value) {
		this.balance -= value;
	}
	
	public void sendCreditToEmissor(int value) {
		// Enviar crédito para o emissor
	}
	
	public void payBill(int value) {
		if (!isBalancePositive()) {
			throw new IllegalStateException("Insufficient funds");
		}
		
		debit(value);
		sendCreditToEmissor(value);
	}
}
