package CodenameFrozenOmega;

import java.util.ArrayList;

public class ObjectsControl {
	ArrayList<Carnivore> carnivore = new ArrayList<Carnivore>();
	ArrayList<Herbivore> herbivore = new ArrayList<Herbivore>();
	ArrayList<Plant> plant = new ArrayList<Plant>();
	ArrayList<Disease> disease = new ArrayList<Disease>();
	
	public ArrayList<Carnivore> getCarnivore() {
		return carnivore;
	}

	public void setCarnivore(ArrayList<Carnivore> carnivore) {
		this.carnivore = carnivore;
	}

	public ArrayList<Herbivore> getHerbivore() {
		return herbivore;
	}

	public void setHerbivore(ArrayList<Herbivore> herbivore) {
		this.herbivore = herbivore;
	}

	public ArrayList<Plant> getPlant() {
		return plant;
	}

	public void setPlant(ArrayList<Plant> plant) {
		this.plant = plant;
	}

	public ArrayList<Disease> getDisease() {
		return disease;
	}

	public void setDisease(ArrayList<Disease> disease) {
		this.disease = disease;
	}

	public void createObjects(String className,String species,int amount,int id,
								int preferredClimate,int location, int foodChainPosition ) {
		
		if(className == "Carnivore"){
			for(int i=1; i<=amount; i++){
				carnivore.add(new Carnivore(preferredClimate, id, location, species, foodChainPosition));
			}
		}else if(className == "Herbivore"){
			for(int i=1; i<=amount; i++){
				herbivore.add(new Herbivore(preferredClimate, id, location, species, foodChainPosition));
			}
		}else if(className == "Plant"){
			for(int i=1; i<=amount; i++){
				plant.add(new Plant(preferredClimate, id, location, species));
			}
		}else if(className == "Disease"){
			for(int i=1; i<=amount; i++){
				disease.add(new Disease(preferredClimate, id, location, species));
			}
		}
	}
	public int listHerbivoresInTile(int tile){
		int amount = 0;
		for (int i = 0; i<herbivore.size(); i++){
			if(herbivore.get(i).location == tile){
				amount = amount + 1;
			}
		}
		return amount;
	}
	public int listCarnivoresInTile(int tile){
		int amount = 0;
		for (int i = 0; i<carnivore.size(); i++){
			if(carnivore.get(i).location == tile){
				amount = amount + 1;
			}
		}
		return amount;
	}
}