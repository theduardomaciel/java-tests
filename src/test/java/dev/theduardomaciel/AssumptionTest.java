package dev.theduardomaciel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssumptionTest {
	@Test
	void validateOnlyOnLinux() {
		Assumptions.assumeTrue(System.getProperty("os.name").contains("Linux"));
		Assertions.assertTrue(true);
	}
}
