package CodenameFrozenOmega;

public class FrozenOmega {
	public static void main(String[] args) {
	Screenmain screen = new Screenmain();
	ObjectsControl objectscontrol = new ObjectsControl();
	objectscontrol.createObjects("Carnivore", "lion", 5000, 1234, 1, 12, 5);
	objectscontrol.createObjects("Herbivore", "asd", 123, 3, 1, 32, 0);
	System.out.println(objectscontrol.getCarnivore().get(300).species);
	objectscontrol.createObjects("Carnivore", "gepardi", 2, 2, 4, 14, 5);
	objectscontrol.createObjects("Carnivore", "puma", 2, 14, 2, 32, 1);
	
	System.out.println("Carnivores in tile 32: "+objectscontrol.listHerbivoresInTile(32));
	System.out.println("Herbivores in tile 32: "+objectscontrol.listCarnivoresInTile(32));
	}
}
