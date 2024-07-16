package dev.theduardomaciel.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ListTest {
	@Mock
	private List<String> list;
	
	@Test
	void addItem() {
		Mockito.when(list.getLast()).thenReturn("Teste");
		
		Assertions.assertEquals("Teste", list.getLast());
	}
}
