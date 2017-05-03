package CodenameFrozenOmega;

public class Tile {
	int herbivores, carnivores, diseases, plants, location;
	float temperature;
	
	public Tile(int location, float temperature) {
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
}
