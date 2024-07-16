package dev.theduardomaciel.controller;

import dev.theduardomaciel.LocationData;
import dev.theduardomaciel.Person;
import dev.theduardomaciel.service.CorreiosApi;

public class PersonController {
	private final CorreiosApi correiosApi;
	
	public PersonController(final CorreiosApi correiosApi) {
		this.correiosApi = correiosApi;
	}
	
	public void register(Person person, String cep) {
		LocationData locationData = correiosApi.getLocationDataFromCep(cep);
		person.setAddress(locationData);
	}
}
