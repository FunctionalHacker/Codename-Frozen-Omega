package CodenameFrozenOmega;

public class Ticktick {
	static int tickcount=0;
	public void Start(int rate){
		TickerEng ticker = new TickerEng(rate); //ticks per second

		ticker.addTickListener(new TickListener() {

		    @Override
		    public void onTick(float deltaTime) {
		    	tickcount++;
		    	System.out.println(tickcount);
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
