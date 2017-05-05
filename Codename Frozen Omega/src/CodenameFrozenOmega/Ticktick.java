package CodenameFrozenOmega;

import java.util.ArrayList;

public class Ticktick {
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
		    		Calc calc = new Calc();
		    		ObjectsControl control = new ObjectsControl();
		    		
		    		control.createObjects("Herbivore", "Koala", 50, 2, 21, 1, 20, 0, 0, 0,true);
		    		control.createObjects("Carnivore", "puUma", 120, 1, 12, 0, 0, 0, 1, 0, true);
		    		for(int i=0; i<=4; i++){
		    			tiles.add(new Tile(i, 21));
		    		}
		    		control.setHabitabilities(calc, control, tiles);
		    		System.out.println("Puuman habiliteetti: "+control.getCarnivore().get(0).habitability);
		    		System.out.println("Koalan habiliteetti: "+control.getHerbivore().get(0).habitability);
		    	}
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
