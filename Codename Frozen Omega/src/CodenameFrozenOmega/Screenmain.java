package CodenameFrozenOmega;

import javax.swing.JFrame;
public class Screenmain extends JFrame{
	simPanel simpan;
	
	public Screenmain(){
		simpan=new simPanel();
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(simpan);
	}
}

