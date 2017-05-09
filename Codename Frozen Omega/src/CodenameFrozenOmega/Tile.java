package CodenameFrozenOmega;

import java.util.ArrayList;
import java.util.Random;

public class Tile {
	int herbivores, carnivores, diseases, plants, location;
	double temperature;
	
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double d) {
		this.temperature = d;
	}

	public Tile(int location, double temperature) {
		super();
		this.location = location;
		this.temperature = temperature;
	}

	public int listAnimals(int id, ObjectsControl objectscontrol){
		if(id == 1){
			carnivores = objectscontrol.listCarnivoresInTile(location);
			return carnivores;
		}
		else if(id == 2){
			herbivores = objectscontrol.listHerbivoresInTile(location);
			return herbivores;
		}
		else if(id == 3){
			plants = objectscontrol.listPlantsInTile(location);
			return plants;
		}
		else if(id == 4){
			diseases = objectscontrol.listDiseasesInTile(location);		
			return carnivores;
		}
		return 0;
	}
	public void randTemperature(ArrayList<Tile> tiles) {
		int min=1;
		int max=2;
		for (int i = 0; i <= 3; i++) {
			
			double temp=tiles.get(i).getTemperature();
			Random rn= new Random();
			int randomValue = min + (max - min) * rn.nextInt();
			System.out.println("RAND: "+randomValue);
			if (randomValue>0) {
				tiles.get(i).setTemperature(temp-2);
				
			}else {
				tiles.get(i).setTemperature(temp+2);
			}
		}
	    }
	/*
		public float settemperature(){
			float temperature =randtemperature(10,30);
			temperature=  (float) (temperature+Math.random());
			return Math.round(temperature);
			}
			*/
}
