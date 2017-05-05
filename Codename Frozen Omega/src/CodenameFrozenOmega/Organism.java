package CodenameFrozenOmega;

public class Organism {
	int preferredTemperature, id, location, lifespan, habitability;
	double age;
	boolean healthy = true;
	String species;

	public Organism(int preferredTemperature, int id, int location, int habitability,
					String species, double age, int lifespan, boolean healthy) {
		super();
		this.preferredTemperature = preferredTemperature;
		this.id = id;
		this.location = location;
		this.lifespan = lifespan;
		this.age = age;
		this.species = species;
		this.habitability = habitability;
	}
}