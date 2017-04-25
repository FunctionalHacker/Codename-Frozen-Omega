package CodenameFrozenOmega;

import javax.swing.JFrame;
public class Screenmain extends JFrame{
	simPanel draw;
	
	public Screenmain(){
		setTitle("CFO");
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(draw);
	}
}

