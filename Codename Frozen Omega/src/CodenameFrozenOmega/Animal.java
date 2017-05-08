package CodenameFrozenOmega;

public class Animal extends Organism {
	
	protected Animal(int preferredTemperature, int id, int location, double lifespan, int habitability,
						double age, String species, int foodChainPosition, int birthTick, boolean healthy) {
		super(preferredTemperature, id, location, habitability, species, age, birthTick, lifespan, healthy);

	}
}