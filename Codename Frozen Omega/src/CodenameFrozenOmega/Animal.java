package CodenameFrozenOmega;

public class Animal extends Organism {
	
	protected Animal(int preferredTemperature, int id, int location, int lifespan, int habitability,
						double age, String species, int foodChainPosition, boolean healthy) {
		super(preferredTemperature, id, location, foodChainPosition, species, age, habitability, true);

	}
}