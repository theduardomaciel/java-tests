package dev.theduardomaciel.integration;

import dev.theduardomaciel.service.CorreiosApi;
import dev.theduardomaciel.LocationData;
import dev.theduardomaciel.Person;
import dev.theduardomaciel.controller.PersonController;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class PersonRegisterTest {
	@Mock
	private CorreiosApi correiosApi;
	
	@InjectMocks // Estamos injetando o mock correiosApi no construtor de PersonController
	private PersonController personController;
	
	@Test
	void testPersonRegistration() {
		LocationData fadeLocationData = new LocationData(
				"SP",
				"São Paulo",
				"Rua Teste",
				"Complemento Teste",
				"Bairro Teste"
		);
		
		// Usamos o "anyString()" para indicar que qualquer String passada como argumento para o método "getLocationDataFromCep"
		// retornará o objeto "fadeLocationData", como no caso abaixo em que temos "12345678"
		Mockito.when(correiosApi.getLocationDataFromCep(Mockito.anyString())).thenReturn(fadeLocationData);
		
		Person person = new Person("Eduardo", LocalDate.of(2005, 9, 3));
		personController.register(person, "12345678");
		
		LocationData personLocationData = person.getAddress();
		assertEquals(fadeLocationData.getNeighborhood(), personLocationData.getNeighborhood());
		assertEquals(fadeLocationData.getCity(), personLocationData.getCity());
		assertEquals(fadeLocationData.getState(), personLocationData.getState());
	}
}
