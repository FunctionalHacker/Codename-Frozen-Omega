package CodenameFrozenOmega;

public class Ticktick {
	static int tickcount=0;
	public void Start(int rate){
		TickerEng ticker = new TickerEng(rate); //ticks per second

		ticker.addTickListener(new TickListener() {
	
		    @Override
		    public void onTick(float deltaTime) {
		    	if (tickcount==5){
		    	Listening listen=new Listening();
		    	ticker.addTickListener(listen);
		    	}
		    	System.out.println("Simtick:"+tickcount);
		    	tickcount++;

		    	
		    }
		});
		while (true) {
		    ticker.update();
		    
		}
	}
	public int getTicks(){
		return tickcount;
	}
}
