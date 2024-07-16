package dev.theduardomaciel.integration;

import dev.theduardomaciel.BankAccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BankAccountTest {
	@Spy
	private BankAccount bankAccount = new BankAccount(1_000);
	
	@Test
	void validateCallOrder() {
		bankAccount.payBill(300);
		
		InOrder inOrder = Mockito.inOrder(this.bankAccount);
		inOrder.verify(this.bankAccount).isBalancePositive();
		inOrder.verify(this.bankAccount).debit(ArgumentMatchers.anyInt());
		inOrder.verify(this.bankAccount).sendCreditToEmissor(ArgumentMatchers.anyInt());
	}
	
	@Test
	void validateCallAmount() {
		bankAccount.payBill(300);
		bankAccount.payBill(100);
		bankAccount.payBill(200);
		
		Mockito.verify(this.bankAccount, Mockito.times(3)).isBalancePositive();
	}
}
