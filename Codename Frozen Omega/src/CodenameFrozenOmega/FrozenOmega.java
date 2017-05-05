package CodenameFrozenOmega;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.jar.Attributes.Name;

import javax.swing.SwingUtilities;
=======
>>>>>>> refs/remotes/origin/master

public class FrozenOmega {
	public static void main(String[] args) {
<<<<<<< HEAD
	//Screenmain screen = new Screenmain();
	jellona = new Carnivore(0, 0, 0, 0, null, 0);
    ButtonGrid.showGui();
   
=======
	Calc calc = new Calc();
	//Screenmain screen = new Screenmain();
	ObjectsControl objectscontrol = new ObjectsControl();
	objectscontrol.createObjects("Herbivore", "Koala", 50, 2, 21, 1, 20, 0, 0, 0, true);
	
	ArrayList<Tile> tiles = new ArrayList<>();
	for(int i=1; i<=4; i++){
		tiles.add(new Tile(i, 21));
>>>>>>> refs/remotes/origin/master
	}
  }
}
