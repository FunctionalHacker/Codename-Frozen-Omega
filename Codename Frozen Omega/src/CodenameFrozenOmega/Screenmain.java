package CodenameFrozenOmega;

import javax.swing.JFrame;
public class Screenmain extends JFrame{
	simPanel simpanel;
	
	public Screenmain(){
		simpanel=new simPanel();
		setSize(1000, 1000);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(simpanel);
	}
}

