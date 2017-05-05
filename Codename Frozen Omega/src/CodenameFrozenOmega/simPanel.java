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
	static final int GWIDTH = 1000, GHEIGHT = 1000;
	static final Dimension simDim = new Dimension(GWIDTH, GHEIGHT);
	//Simulator variables
	private Thread sim;
	private volatile boolean running = false;
	
	//Simulation objects
	TileWorld world;
	
	//Constructor
	public simPanel(){
		world = new TileWorld();
		setPreferredSize(simDim);
		setBackground(Color.white);
		setFocusable(true);
		requestFocus();
		//input handling
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e){
			if(e.getKeyCode()== KeyEvent.VK_LEFT){
				world.navigateMap(world.PAN_LEFT);
			}
			if(e.getKeyCode()== KeyEvent.VK_RIGHT){
				world.navigateMap(world.PAN_RIGHT);
			}
			if(e.getKeyCode()== KeyEvent.VK_UP){
				world.navigateMap(world.PAN_UP);
			}
			if(e.getKeyCode()== KeyEvent.VK_DOWN){
				world.navigateMap(world.PAN_DOWN);
			}
			}@Override
			public void keyReleased(KeyEvent e){
				world.stopMoveMap();
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
			world.moveMap();
			
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
	world.draw(g);
		
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
