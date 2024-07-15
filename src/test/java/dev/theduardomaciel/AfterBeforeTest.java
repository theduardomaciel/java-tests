package dev.theduardomaciel;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

public class AfterBeforeTest {
	static Database database = new Database();
	
	@BeforeAll
	static void setupConnection() {
		database.connect();
	}
	
	@AfterAll
	static void closeConnection() {
		database.disconnect();
	}
	
	@Test
	void checkPersonData() {
		Person person = new Person("Eduardo Maciel", LocalDate.now().minusYears(24));
		
		Assertions.assertTrue(person.isNameValid());
		Assertions.assertEquals(24, person.getAge());
		Assertions.assertTrue(person.isAdult());
	}
	
	@BeforeEach
	void checkConnection() {
		Assertions.assertTrue(database.isOnline());
	}
	
	@AfterEach
	void afterTest() {
		System.out.println("Test finished!");
	}
}
