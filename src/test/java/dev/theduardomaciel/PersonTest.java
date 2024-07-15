package dev.theduardomaciel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class PersonTest {
	@Test
	void isNameValid() {
		Person person = new Person("Eduardo Maciel");
		Assertions.assertTrue(person.isNameValid());
		
		person = new Person("Eduardo");
		Assertions.assertFalse(person.isNameValid());
		
		person = new Person("eduardo maciel");
		Assertions.assertFalse(person.isNameValid());
	}
	
	@Test
	void shouldReturnCorrectAge() {
		Person person = new Person("Eduardo Maciel", LocalDate.now().minusYears(5));
		Assertions.assertEquals(5, person.getAge());
	}
	
	@Test
	void isAgeValid() {
		Person person = new Person("Eduardo Maciel", LocalDate.of(2003, 1, 1));
		Assertions.assertTrue(person.isAdult());
		
		person = new Person("Eduardo Maciel", LocalDate.now().minusYears(8));
		Assertions.assertFalse(person.isAdult());
	}
	
	@Test
	void verifyPersonNull() {
		Person person = new Person("Eduardo Maciel", LocalDate.now());
		Assertions.assertNotNull(person);
		
		person = null;
		
		Assertions.assertNull(person);
	}
}
