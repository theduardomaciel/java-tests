package dev.theduardomaciel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

public class GeneralTest {
	@Test
	void validateSameArrays() {
		String[] address = new String[]{"Rua São Francisco", "Itapuã", "Vila Velha"};
		String[] address2 = new String[]{"Rua Fernando de Noronha", "Itapuã", "Vila Velha"};
		
		assertNotEquals(address, address2);
		
		address2 = new String[]{"Rua São Francisco", "Itapuã", "Vila Velha"};
		
		assertArrayEquals(address, address2);
	}
	
	@Test
	void validateHobbies() {
		List<String> hobbies = List.of("Música", "Jogos", "Programação");
		List<String> hobbies2 = List.of("Jogos", "Futebol", "Crochê");
		
		// Verifica se algum dos passatempos são comuns entre si
		assertTrue(hobbies.stream().anyMatch(hobbies2::contains));
		
		hobbies2 = List.of("Futebol", "Crochê", "Dança");
		
		// Verifica se os passatempos não são todos comuns entre si
		assertFalse(hobbies.containsAll(hobbies2));
	}
	
	@Test
	void validateDifferentNumberTypes() {
		double value1 = 10.5;
		double value2 = 10.5;
		
		assertEquals(value1, value2);
		
		int value3 = 10;
		
		assertNotEquals(value1, value3);
	}
}
