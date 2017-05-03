package CodenameFrozenOmega;

public class FrozenOmega {
	public static void main(String[] args) {
	Screenmain screen = new Screenmain();
	ObjectsControl objectscontrol = new ObjectsControl();
	Tile tile1 = new Tile(1, 21);
	Tile tile2 = new Tile(2, 21);
	Tile tile3 = new Tile(3, 21);
	Tile tile4 = new Tile(4, 21);
	objectscontrol.createObjects("Herbivore", "koala", 
								50, 123, 22, 1, 25, 0, 0);
	
	System.out.println("Herbivores in tile "+tile1.location+": "+tile1.listAnimals(2,objectscontrol));
	}
}
