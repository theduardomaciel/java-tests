package dev.theduardomaciel.service;

import dev.theduardomaciel.LocationData;

/**
 * Classe fictícia que simula uma integração com a API dos Correios
 * */
public class CorreiosApi {
	public LocationData getLocationDataFromCep(String cep) {
		return new LocationData(
			"SP",
			"São Paulo",
			"Rua Teste",
			"Complemento Teste",
			"Bairro Teste"
		);
	}
}
