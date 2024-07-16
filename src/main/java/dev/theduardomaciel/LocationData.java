package dev.theduardomaciel;

public class LocationData {
	private final String state;
	private final String city;
	private final String street;
	private final String complement;
	private final String neighborhood;
	
	public LocationData(final String state, final String city, final String street, final String complement, final String neighborhood) {
		this.state = state;
		this.city = city;
		this.street = street;
		this.complement = complement;
		this.neighborhood = neighborhood;
	}
	
	public String getState() {
		return state;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getComplement() {
		return complement;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
}
