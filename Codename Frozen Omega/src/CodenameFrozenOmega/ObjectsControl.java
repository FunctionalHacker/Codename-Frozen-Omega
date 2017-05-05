
package CodenameFrozenOmega;

import java.util.ArrayList;

public class ObjectsControl{
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
								int preferredTemperature,int location, double lifespan,
								double age, int foodChainPosition, int habitability, boolean healthy) {
		int birthTick = 0;
		if(className == "Carnivore"){
			for(int i=1; i<=amount; i++){
				carnivore.add(new Carnivore(preferredTemperature, id, location, lifespan, age,
											species, foodChainPosition, habitability, birthTick, healthy));
			}
		}else if(className == "Herbivore"){
			for(int i=1; i<=amount; i++){
				herbivore.add(new Herbivore(preferredTemperature, id, location, lifespan, age,
											species, foodChainPosition, habitability, birthTick, healthy));
			}
		}else if(className == "Plant"){
			for(int i=1; i<=amount; i++){
				plant.add(new Plant(preferredTemperature, id, location, lifespan, habitability, age,
									healthy, birthTick, species));
				}
			}else if(className == "Disease"){
			for(int i=1; i<=amount; i++){
				disease.add(new Disease(preferredTemperature, id, location, lifespan, age,
										habitability, birthTick, healthy, species));
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
	public int listDiseasesInTile(int tile){
		int amount = 0;
		for (int i = 0; i<disease.size(); i++){
			if(disease.get(i).location == tile){
				amount = amount + 1;
			}
		}
		return amount;
	}
	public int listPlantsInTile(int tile){
		int amount = 0;
		for (int i = 0; i<plant.size(); i++){
			if(plant.get(i).location == tile){
				amount = amount + 1;
			}
		}
		return amount;
	}
	public void timeToExpire(){
		for (int i = 0; i<herbivore.size(); i++){
			if(plant.get(i).age >= plant.get(i).lifespan){
				plant.set(i,null);
			}
		}
		for (int i = 0; i<carnivore.size(); i++){
			if(carnivore.get(i).age >= carnivore.get(i).lifespan){
				carnivore.set(i,null);
			}
			
		}
		for (int i = 0; i<plant.size(); i++){
			if(herbivore.get(i).age >= herbivore.get(i).lifespan){
				herbivore.set(i,null);
			}
		}
	}
	
	public void setHabitabilities(Calc calc,ObjectsControl control, ArrayList<Tile> tiles){
//		HERBIVORES	
		for(int i = 0; i<herbivore.size(); i++){
			calc.setHabitability(tiles.get(control.getHerbivore().get(i).location).getTemperature(),control.getHerbivore().get(i));
		}
//		CARNIVORES
		for(int i = 0; i<carnivore.size(); i++){
			calc.setHabitability(tiles.get(control.getCarnivore().get(i).location).getTemperature(),control.getCarnivore().get(i));
		}
//		PLANTS
		for(int i = 0; i<plant.size(); i++){
			calc.setHabitability(tiles.get(control.getPlant().get(i).location).getTemperature(),control.getPlant().get(i));
		}
	}
//	public  double grow(){
//        
//        if (habitability >1){
//            age = age + 0.75;
//
//    } else if (habitability ==1){
//        age = age +1;
//    } else if (habitability <1){
//        age = age +2;
//    }
//       return age;
//    }
	public void age(ObjectsControl control,Calc calc){
//		HERBIVORES	
		for(int i = 0; i<herbivore.size(); i++){
		calc.setAge(control.getHerbivore().get(i).age, control.getHerbivore().get(i));
		}
//		CARNIVORES
		for(int i = 0; i<carnivore.size(); i++){
		
		}
//		PLANTS
		for(int i = 0; i<plant.size(); i++){
		
		}
	}
	public void move(ObjectsControl control, Calc calc, ArrayList<Tile> tiles) {
		int n;
		int k=2;
//		HERBIVORES	
		for(int i = 0; i<herbivore.size(); i++){
			n=control.getHerbivore().get(i).location;
			if (n%k<0){//left tile exists
				if (calc.getHabitability(n-1, control.getHerbivore().get(i), tiles)>control.getHerbivore().get(i).habitability) {
					calc.setLocation(n-1, control.getHerbivore().get(i));;
				}
			}
			if(n%k<k-1){//right tile exists
				if (calc.getHabitability(n+1, control.getHerbivore().get(i), tiles)>control.getHerbivore().get(i).habitability) {
					calc.setLocation(n+1, control.getHerbivore().get(i));;
				}
			}
			if (n>=k){//top tile exists
				if (calc.getHabitability(n-k, control.getHerbivore().get(i), tiles)>control.getHerbivore().get(i).habitability) {
					calc.setLocation(n-k, control.getHerbivore().get(i));;
				}
			}
			if (n<k*(k-1)){//bot tile exists
				if (calc.getHabitability(n+k, control.getHerbivore().get(i), tiles)>control.getHerbivore().get(i).habitability) {
					calc.setLocation(n+k, control.getHerbivore().get(i));;
				}
			}
		}
//		CARNIVORES
		for(int i = 0; i<carnivore.size(); i++){
			
		}
		/*
		 * if (n%k<0), left tile exists
		 * if (n%k<k-1), right tile -
		 * if (n>=k) top
		 * if (n<k*(k-1)) bot
		*/
		
		
	}

}
