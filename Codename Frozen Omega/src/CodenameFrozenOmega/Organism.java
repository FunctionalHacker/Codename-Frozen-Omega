package CodenameFrozenOmega;

public class Organism {
	
	int population, preferredClimate, id, location;
	String species;
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getPreferredClimate() {
		return preferredClimate;
	}
	public void setPreferredClimate(int preferredClimate) {
		this.preferredClimate = preferredClimate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
}