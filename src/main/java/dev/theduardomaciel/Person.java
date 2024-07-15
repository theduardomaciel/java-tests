package dev.theduardomaciel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Person {
	private final String name;
	private LocalDate birthDate;
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(String name, LocalDate birthDate) throws IllegalArgumentException {
		this.name = name;
		
		if (birthDate.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Data de nascimento inválida");
		}
		
		this.birthDate = birthDate;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isNameValid() {
		return name.split(" ").length > 1 && name.charAt(0) == name.toUpperCase().charAt(0);
	}
	
	public int getAge() {
		return (int) ChronoUnit.YEARS.between(birthDate, LocalDateTime.now());
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public boolean isAdult() {
		return getAge() >= 18;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Person person)) return false;
		return Objects.equals(getName(), person.getName()) && Objects.equals(birthDate, person.birthDate);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), birthDate);
	}
}
