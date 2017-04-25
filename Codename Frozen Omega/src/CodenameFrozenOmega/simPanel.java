package CodenameFrozenOmega;
import java.awt.*;

import java.awt.event.*;
import javax.swing.JPanel;




//// it is borken, please help
//////am desperat
///////// :C
//////Don'te worie, we fixe it *italian hand gesture*




public class simPanel extends JPanel implements Runnable{
	//Double buffering
	private Image dbImage;
	private Graphics dbg;
	//JPanel variables
	static final int GWIDTH = 500, GHEIGHT = 400;
	static final Dimension simDim = new Dimension(GWIDTH, GHEIGHT);
	//Simulator variables
	private Thread sim;
	private volatile boolean running = false;
	
	//Constructor
	public simPanel(){
		setPreferredSize(simDim);
		setBackground(Color.white);
		setFocusable(true);
		requestFocus();
		//input handling
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e){
				
			}@Override
			public void keyReleased(KeyEvent e){
				
			}@Override
			public void keyTyped(KeyEvent e){
			
			}
			
		});
		
	}
	
	public void run(){
		while (running) {
			
			simUpdate();
			simRender();
			paintScreen();
			
		}
	}
	
	private void simUpdate(){
		if (running && sim != null) {
			//update simulation state
			
		}
	}
	
	private void simRender(){
		if (dbImage==null) {
			//create buffer
			dbImage = createImage(GWIDTH, GHEIGHT);
			if (dbImage==null) {
				System.err.println("dbImage still null!!!?!?!?");
				return;
			}else {
				dbg = dbImage.getGraphics();
			}
		}
		//clearing the screen
		dbg.setColor(Color.white);
		dbg.fillRect(0, 0, GWIDTH,GHEIGHT);
		//drawing the elements
		Draw(dbg);
		
	}
	
	public void Draw(Graphics g){
	g.setColor(Color.cyan);
	g.drawString("Miau~", 100, 100);
		
	}
	
	private void paintScreen(){
		Graphics g;
		try{
			g=this.getGraphics();
			if(dbImage!=null&& g != null){
				g.drawImage(dbImage, 0, 0, null);
			}
			Toolkit.getDefaultToolkit().sync(); //Flushing linux graphics
			g.dispose();
		}catch (Exception e) {
		System.err.println(e);
		}
	}
	
	//Start and stop control
	public void addNotify(){
		super.addNotify();
		startSim();
	}
	private void startSim(){
	 if(sim == null || !running){
		 sim = new Thread(this);
		 sim.start();
		 running=true;
		 }
	}
	
	public void stopSim(){
		if (running) {
			running=false;
			
		}
		
	}
	
	private void log(String s){
	}
}
