package dev.theduardomaciel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalTest {
	@Test
	@EnabledIfEnvironmentVariable(named = "USERDOMAIN", matches = "MENINOCOISO")
	void validateOnlyOnDev() {
		System.out.println("Rodando na conta pessoal");
		Assertions.assertTrue(true);
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	void validateOnlyOnLinux() {
		System.out.println("Rodando no Linux");
		Assertions.assertTrue(true);
	}
	
	@Test
	@DisabledIfSystemProperties({
		@DisabledIfSystemProperty(named = "os.arch", matches = ".*86.*"),
		@DisabledIfSystemProperty(named = "os.name", matches = "Linux.*")
	})
	// Somente roda em sistemas 64-bit Windows
	void validateOnlyOnProperties() {
		System.out.println("Rodando em propriedades específicas");
		Assertions.assertTrue(true);
	}
	
	@Test
	@EnabledForJreRange(min = JRE.JAVA_20, max = JRE.JAVA_22)
	void validateOnlyOnJre() {
		System.out.println("Rodando em versões específicas do Java");
		Assertions.assertTrue(true);
	}
}
