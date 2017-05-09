package CodenameFrozenOmega;

import java.util.ArrayList;

public class Ticktick {
	Calc calc = new Calc();
	Tile tile = new Tile(600, 1000);
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
		    		//control.createObjects(className, species, amount, id, preferredTemperature,
		    		//						location, lifespan, age, foodChainPosition, habitability, healthy);
		    		control.createObjects("Herbivore", "Koala", 15, 2, 20, 0, 5, 20, 0, 0,true);
		    		control.createObjects("Carnivore", "Joku", 55, 1, 15, 0, 5, 0, 0, 0, true);
		    		control.createObjects("Herbivore", "Koala", 12, 2, 25, 1, 5, 20, 0, 0,true);
		    		control.createObjects("Carnivore", "Joku", 63, 1, 22, 1, 5, 0, 0, 0, true);
		    		control.createObjects("Herbivore", "Koala", 33, 2, 30, 2, 2000, 20, 0, 0,true);
		    		control.createObjects("Carnivore", "Joku", 122, 1, 10, 2, 7300, 0, 0, 0, true);
		    		control.createObjects("Herbivore", "Koala", 3, 2, 13, 3, 2000, 20, 0, 0,true);
		    		control.createObjects("Carnivore", "Joku", 23, 1, 17, 3, 7300, 0, 0, 0, true);
		    		for(int i=0; i<=4; i++){
		    			tiles.add(new Tile(i, 21));
		    		}
		    	}
		    	if (tickcount>=1) {
					
				
		    	//MANDATORY FOR EACH RUN
		    	control.setHabitabilities(calc, control, tiles);
		    	System.out.println("setted");
		    	control.predsEat(control, calc);
		    	System.out.println("Eatsted'st");
		    	control.move(control, calc, tiles);
		    	System.out.println("Moved");
		    	control.age(control, calc);
		    	System.out.println("Aged");
		    	control.removeDeadObjects(control);
		    	System.out.println("Död");
		    	///////////////////
		    	
		    	//tiles.get(0).setTemperature(10);
		    	
		    	System.out.println("Tile0: Herbivores: "+control.listHerbivoresInTile(0)+" Carnivores: "+control.listCarnivoresInTile(0));
		    	System.out.println("Tile1: Herbivores: "+control.listHerbivoresInTile(1)+" Carnivores: "+control.listCarnivoresInTile(1));
		    	System.out.println("Tile2: Herbivores: "+control.listHerbivoresInTile(2)+" Carnivores: "+control.listCarnivoresInTile(2));
		    	System.out.println("Tile3: Herbivores: "+control.listHerbivoresInTile(3)+" Carnivores: "+control.listCarnivoresInTile(3));
		    	System.out.println("Temperature: "+tiles.get(0).temperature);
		    	
		    	//COUNTERS
		    	if (tickcount%2==0 && tickcount!=0) {
		    		tile.randTemperature(tiles);
		    	}
		    	if(tickcount%50==0 && tickcount!=0){
		    
		    	}

		    	/////////////
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
