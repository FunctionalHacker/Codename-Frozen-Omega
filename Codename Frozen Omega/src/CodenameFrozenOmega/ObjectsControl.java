package CodenameFrozenOmega;

public class ObjectsControl {
	static Carnivore lion;
	static Herbivore koala;
	static Disease flue;
	
	public void createObjects(String className,String species,int amount,int id,int population,
								int preferredClimate,int location, int foodChainPosition ) {
		
		if(className == "Carnivore" && species == "lion"){
			for(int i=1; i<=amount; i++){
				lion = new Carnivore(population, preferredClimate, id, location, species, foodChainPosition);
			}
		}if(className == "Herbivore" && species == "koala"){
			for(int i=1; i<=amount; i++){
				koala = new Herbivore(population, preferredClimate, id, location, species, foodChainPosition);
			}
		}
	}
}
