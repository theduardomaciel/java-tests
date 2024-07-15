package dev.theduardomaciel;

import org.junit.jupiter.api.*;

// @TestMethodOrder(MethodOrderer.MethodName.class) // -> ordena com base na ordem alfabética dos nomes dos métodos
// @TestMethodOrder(MethodOrderer.Random.class) // -> ordena aleatoriamente
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class) // -> ordena com base nos @Order()
// @TestMethodOrder(MethodOrderer.DisplayName.class) // -> ordena com base no DisplayName dos métodos

@TestMethodOrder(MethodOrderer.DisplayName.class) // precisa dos @Order() para saber a ordem
public class OrderedTest {
	@DisplayName("Teste A")
	@Test
	void validateFluxA() {
		Assertions.assertTrue(true);
	}
	
	@DisplayName("Teste C")
	@Test
	@Disabled // -> desabilita o teste
	void validateFluxB() {
		Assertions.assertTrue(true);
	}
	
	@DisplayName("Teste D")
	@Test
	void validateFluxC() {
		Assertions.assertTrue(true);
	}
	
	@DisplayName("Teste B")
	@Test
	void validateFluxD() {
		Assertions.assertTrue(true);
	}
}
