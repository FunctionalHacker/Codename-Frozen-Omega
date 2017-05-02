package CodenameFrozenOmega;

public class Organism {
	int preferredTemperature, id, location, lifespan;
	double age;
	boolean healthy = true;
	String species;

	public Organism(int preferredTemperature, int id, int location, String species) {
		super();
		this.preferredTemperature = preferredTemperature;
		this.id = id;
		this.location = location;
		this.lifespan = lifespan;
		this.age = age;
		this.species = species;
	}
}