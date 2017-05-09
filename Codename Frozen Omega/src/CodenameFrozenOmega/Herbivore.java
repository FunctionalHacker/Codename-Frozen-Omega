package CodenameFrozenOmega;

public class Herbivore extends Animal {

	protected Herbivore(int preferredTemperature, int id, int location, double lifespan, double age, String species,
			int foodChainPosition, double habitability, int birthTick, boolean healthy) {
		super(preferredTemperature, id, location, lifespan, habitability, age, species, foodChainPosition, birthTick, healthy);
	}
}
