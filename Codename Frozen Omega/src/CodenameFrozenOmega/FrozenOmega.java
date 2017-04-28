package CodenameFrozenOmega;

public class FrozenOmega {
	public static void main(String[] args) {
	Screenmain screen = new Screenmain();
	ObjectsControl asd = new ObjectsControl();
	asd.createObjects("Carnivore", "lion", 5000, 1234, 1, 12, 5);;
	System.out.println(asd.getCarnivore().get(1));
	}
}
