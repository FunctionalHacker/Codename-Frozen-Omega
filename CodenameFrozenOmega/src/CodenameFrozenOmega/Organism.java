package CodenameFrozenOmega;

public class Organism {
	

	
	int preferredTemperature, id, location;
	String species;
	
	public Organism(int preferredTemperature, int id, int location, String species) {
		super();
		this.preferredTemperature = preferredTemperature;
		this.id = id;
		this.location = location;
		this.species = species;
	}
}