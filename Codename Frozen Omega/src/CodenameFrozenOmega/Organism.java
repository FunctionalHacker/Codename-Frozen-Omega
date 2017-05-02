package CodenameFrozenOmega;

public class Organism {
	int preferredClimate, id, location;
	String species;
	
	public Organism(int preferredClimate, int id, int location, String species) {
		super();
		this.preferredClimate = preferredClimate;
		this.id = id;
		this.location = location;
		this.species = species;
	}
}