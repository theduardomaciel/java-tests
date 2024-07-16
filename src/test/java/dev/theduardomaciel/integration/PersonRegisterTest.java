package dev.theduardomaciel.integration;

import dev.theduardomaciel.service.CorreiosApi;
import dev.theduardomaciel.LocationData;
import dev.theduardomaciel.Person;
import dev.theduardomaciel.controller.PersonController;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
	
	@Test
	void returningNullFromMock() {
		// Iremos manipular o retorno do mock, para que ele retorne null ao invés de um objeto
		Mockito.when(correiosApi.getLocationDataFromCep(Mockito.anyString())).thenReturn(null);
		
		Person person = new Person("Eduardo", LocalDate.of(2005, 9, 3));
		personController.register(person, "12345678");
		
		LocationData personLocationData = person.getAddress();
		assertNull(personLocationData);
	}
	
	@Test
	void throwExceptionWhenCallApi() {
		LocationData fadeLocationData = new LocationData(
				"SP",
				"São Paulo",
				"Rua Teste",
				"Complemento Teste",
				"Bairro Teste"
		);
		
		// Iremos manipular o retorno do mock, para que ele lance uma exceção ao invés de retornar um objeto
		// Mockito.when(correiosApi.getLocationDataFromCep(Mockito.anyString())).thenThrow(IllegalArgumentException.class);
		// ou: no lugar de "IllegalArgumentException.class" é possível utilizar: new RuntimeException("Erro ao chamar API")
		
		Mockito.doThrow(IllegalArgumentException.class).when(correiosApi).getLocationDataFromCep(Mockito.anyString());
		
		Person person = new Person("Eduardo", LocalDate.of(2005, 9, 3));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			personController.register(person, "12345678");
		});
	}
}
