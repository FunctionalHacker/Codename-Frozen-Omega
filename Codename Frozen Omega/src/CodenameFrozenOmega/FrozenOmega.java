package CodenameFrozenOmega;

public class FrozenOmega {
	public static void main(String[] args) {
	Screenmain screen = new Screenmain();
	ObjectsControl objectscontrol = new ObjectsControl();
	objectscontrol.createObjects("Herbivore", "koala", 
								50, 123, 22, 32, 25, 0, 0);
	
	System.out.println("Herbivores in tile 32: "+objectscontrol.listHerbivoresInTile(32));
	}
}
