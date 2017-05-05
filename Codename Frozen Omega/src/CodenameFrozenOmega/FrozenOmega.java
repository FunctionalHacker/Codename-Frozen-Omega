package CodenameFrozenOmega;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import javax.swing.SwingUtilities;

public class FrozenOmega {
static Carnivore jellona;
	public static void main(String[] args) {
	//Screenmain screen = new Screenmain();
	jellona = new Carnivore(0, 0, 0, 0, null, 0);
    ButtonGrid.showGui();
   
	}
}
