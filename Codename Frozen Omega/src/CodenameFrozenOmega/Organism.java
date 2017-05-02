package CodenameFrozenOmega;

public class Organism {
	int preferredTemperature, id, location, lifespan;
	boolean healthy = true;
	String species;
	
	public Organism(int preferredTemperature, int id, int location, int lifespan, String species) {
		super();
		this.preferredTemperature = preferredTemperature;
		this.id = id;
		this.location = location;
		this.lifespan = lifespan;
		this.species = species;
	}
}