package dev.theduardomaciel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ExceptionTest {
	@Test
	void validateException() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Person("Eduardo", LocalDate.now().plusYears(5))
		);
		
		Person person = new Person("Eduardo", LocalDate.of(1996, 1, 1));
		
		Assertions.assertDoesNotThrow(() -> person.setBirthDate(LocalDate.of(2022, 1, 1)));
	}
}
