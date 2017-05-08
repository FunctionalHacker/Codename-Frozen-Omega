package CodenameFrozenOmega;

import java.util.ArrayList;

public class Ticktick {
	Calc calc = new Calc();
	ObjectsControl control = new ObjectsControl();
	static int tickcount=0;
	public void Start(int rate){
		TickerEng ticker = new TickerEng(rate); //ticks per second


		ticker.addTickListener(new TickListener() {
			
			ArrayList<Tile> tiles = new ArrayList<Tile>();
			public ArrayList<Tile> getTile() {
				return tiles;
			}

			public void setTile(ArrayList<Tile> tiles) {
				this.tiles = tiles;
			}

		    @Override
		    public void onTick(float deltaTime) {
		    	
		    	if(tickcount == 0){
		    		
		    		control.createObjects("Herbivore", "Koala", 50, 2, 21, 1, 20, 0, 0, 0,true);
		    		control.createObjects("Carnivore", "Joku", 5, 1, 20, 0, 7300, 0, 0, 0, true);
		    		for(int i=0; i<=4; i++){
		    			tiles.add(new Tile(i, 21));
		    		}
		    	}
		    
		    	tiles.get(0).setTemperature(10);
		    	control.setHabitabilities(calc, control, tiles);
		    	control.move(control, calc, tiles);
		    	control.age(control, calc);
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
