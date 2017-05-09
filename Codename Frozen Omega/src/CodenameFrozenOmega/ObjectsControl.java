
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
			calc.setHabitability(control,tiles.get(control.getHerbivore().get(i).location).getTemperature(),control.getHerbivore().get(i), "Herbivore");
		}
//		CARNIVORES
		for(int i = 0; i<carnivore.size(); i++){
			calc.setHabitability(control,tiles.get(control.getCarnivore().get(i).location).getTemperature(),control.getCarnivore().get(i), "Carnivore");
		}
//		PLANTS
		for(int i = 0; i<plant.size(); i++){
			calc.setHabitability(control,tiles.get(control.getPlant().get(i).location).getTemperature(),control.getPlant().get(i), "Plant");
		}
	}
	public void predsEat(ObjectsControl control){
		int tile0c, tile1c, tile2c, tile3c, tile0h, tile1h, tile2h, tile3h, happymeal;
		tile0h=control.listHerbivoresInTile(0);
		tile1h=control.listHerbivoresInTile(1);
		tile2h=control.listHerbivoresInTile(2);
		tile3h=control.listHerbivoresInTile(3);
		tile0c=control.listCarnivoresInTile(0);
		tile1c=control.listCarnivoresInTile(1);
		tile2c=control.listCarnivoresInTile(2);
		tile3c=control.listCarnivoresInTile(3);
		
		if (tile0c>0 && tile0h>0) {
			if (tile0c<tile0h) {
				happymeal=(int) (tile0h*0.1);
				for (int i = 0; i <= happymeal-1; i++) {
					if(herbivore.get(i).location==0){
						herbivore.remove(i);
					}else {
						i--;
					}
					}
				}
			}
			if (tile0c>tile0h) {
				happymeal=(int) (tile0h*0.5);
				for (int i = 0; i <= happymeal-1; i++) {
					if(herbivore.get(i).location==0){
						herbivore.remove(i);
					}else {
						i--;
					}
				}
			}
		
		
		if (tile1c>0 && tile1h>0) {
			if (tile1c<tile1h) {
				happymeal=(int) (tile1h*0.1);
				for (int i = 0; i <= happymeal-1; i++) {
					if(herbivore.get(i).location==1){
						herbivore.remove(i);
					}else {
						i--;
					}
				}
			}
			if (tile1c>tile1h) {
				happymeal=(int) (tile1h*0.5);
				for (int i = 0; i <= happymeal-1; i++) {
					if(herbivore.get(i).location==1){
						herbivore.remove(i);
					}else {
						i--;
					}
				}
			}
		
		}
		if (tile2c>0 && tile2h>0) {
			if (tile2c<tile2h) {
				happymeal=(int) (tile2h*0.1);
				for (int i = 0; i <= happymeal-1; i++) {
					if(herbivore.get(i).location==2){
						herbivore.remove(i);
					}else {
						i--;
					}
				}
			}
			if (tile2c>tile2h) {
				happymeal=(int) (tile2h*0.5);
				for (int i = 0; i <= happymeal-1; i++) {
					if(herbivore.get(i).location==2){
						herbivore.remove(i);
					}else {
						i--;
					}
				}
			}
		
		}
		if (tile3c>0 && tile3h>0) {
			if (tile3c<tile3h) {
				happymeal=(int) (tile3h*0.1);
				for (int i = 0; i <= happymeal-1; i++) {
					if(herbivore.get(i).location==3){
						herbivore.remove(i);
					}else {
						i--;
					}
				}
			}
			if (tile3c>tile3h) {
				happymeal=(int) (tile3h*0.5);
				for (int i = 0; i <= happymeal-1; i++) {
					if(herbivore.get(i).location==3){
						herbivore.remove(i);
					}else {
						i--;
					}
				}
			}
		
		}
	}
	
	public void removeDeadObjects(ObjectsControl control){
		for (int i = 0; i<carnivore.size(); i++){
			if(carnivore.get(i).age >= carnivore.get(i).lifespan){
				carnivore.remove(i);
			}
		}
		
		for (int i = 0; i<herbivore.size(); i++){
			if(herbivore.get(i).age >= herbivore.get(i).lifespan){
				herbivore.remove(i);
			}
		}
		
		for (int i = 0; i<plant.size(); i++){
			if(plant.get(i).age >= plant.get(i).lifespan){
				plant.remove(i);
			}
		}
		
	}
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
				if (calc.getHabitability(n-1, control, control.getHerbivore().get(i), tiles, "Herbivore")>control.getHerbivore().get(i).habitability) {
					calc.setLocation(n-1, control.getHerbivore().get(i));
				}
			}
			if(n%k<k-1){//right tile exists
				if (calc.getHabitability(n+1, control, control.getHerbivore().get(i), tiles, "Herbivore")>control.getHerbivore().get(i).habitability) {
					calc.setLocation(n+1, control.getHerbivore().get(i));
				}
			}
			if (n>=k){//top tile exists
				if (calc.getHabitability(n-k, control, control.getHerbivore().get(i), tiles, "Herbivore")>control.getHerbivore().get(i).habitability) {
					calc.setLocation(n-k, control.getHerbivore().get(i));
				}
			}
			if (n<k*(k-1)){//bot tile exists
				if (calc.getHabitability(n+k, control, control.getHerbivore().get(i), tiles, "Herbivore")>control.getHerbivore().get(i).habitability) {
					calc.setLocation(n+k, control.getHerbivore().get(i));
				}
			}
		}
//		CARNIVORES
		for(int i = 0; i<carnivore.size(); i++){
			n=control.getCarnivore().get(i).location;
			if (n%k<0){//left tile exists
				if (calc.getHabitability(n-1, control, control.getCarnivore().get(i), tiles, "Carnivore")>control.getCarnivore().get(i).habitability) {
					calc.setLocation(n-1, control.getCarnivore().get(i));
				}
			}
			if(n%k<k-1){//right tile exists
				if (calc.getHabitability(n+1, control, control.getCarnivore().get(i), tiles, "Carnivore")>control.getCarnivore().get(i).habitability) {
					calc.setLocation(n+1, control.getCarnivore().get(i));
				}
			}
			if (n>=k){//top tile exists
				if (calc.getHabitability(n-k, control, control.getCarnivore().get(i), tiles, "Carnivore")>control.getCarnivore().get(i).habitability) {
					calc.setLocation(n-k, control.getCarnivore().get(i));
				}
			}
			if (n<k*(k-1)){//bot tile exists
				if (calc.getHabitability(n+k, control, control.getCarnivore().get(i), tiles, "Carnivore")>control.getCarnivore().get(i).habitability) {
					calc.setLocation(n+k, control.getCarnivore().get(i));
				}
			}
		}
		/*
		 * if (n%k<0), left tile exists
		 * if (n%k<k-1), right tile -
		 * if (n>=k) top
		 * if (n<k*(k-1)) bot
		*/
		
		
	}
}