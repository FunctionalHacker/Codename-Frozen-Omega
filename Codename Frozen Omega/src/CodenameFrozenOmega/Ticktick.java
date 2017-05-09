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
		    		control.createObjects("Herbivore", "vegans", 550, 2, 20, 0, calc.setLife("Herbivore"), 20, 0, 0,true);
		    		control.createObjects("Herbivore", "vegans", 500, 2, 13, 3, calc.setLife("Herbivore"), 20, 0, 0,true);
		    		control.createObjects("Herbivore", "vegans", 1150, 2, 30, 2, calc.setLife("Herbivore"), 20, 0, 0,true);
		    		control.createObjects("Herbivore", "vegans", 500, 2, 25, 1, calc.setLife("Herbivore"), 20, 0, 0,true);
		    		
		    		control.createObjects("Carnivore", "Dropbear", 1250, 1, 22, 1, calc.setLife("Carnivore"), 0, 0, 0, true);
		    		control.createObjects("Carnivore", "Dropbear", 1375, 1, 10, 2, calc.setLife("Carnivore"), 0, 0, 0, true);
		    		control.createObjects("Carnivore", "Dropbear", 500, 1, 15, 0, calc.setLife("Carnivore"), 0, 0, 0, true);
		    		control.createObjects("Carnivore", "Dropbear", 200, 1, 17, 3, calc.setLife("Carnivore"), 0, 0, 0, true);
		    		
		    		control.createObjects("Plant", "Paskakukka", 1300, 3, 21, 0, calc.setLife("Plant"), 0, 0, 0, true);
		    		control.createObjects("Plant", "Paskakukka", 1400, 3, 21, 1, calc.setLife("Plant"), 0, 0, 0, true);
		    		control.createObjects("Plant", "Paskakukka", 500, 3, 21, 2, calc.setLife("Plant"), 0, 0, 0, true);
		    		control.createObjects("Plant", "Paskakukka", 200, 3, 21, 3, calc.setLife("Plant"), 0, 0, 0, true);
		    		for(int i=0; i<=4; i++){
		    			tiles.add(new Tile(i, 21));
		    		}
		    	}
		    	if (tickcount>=1) {
					
				
		    	//MANDATORY FOR EACH RUN
		    	control.setHabitabilities(calc, control, tiles);
		    	control.populationControl(control, calc);
		    	control.age(control, calc);
		    	control.removeDeadObjects(control);
		    	///////////////////
		    	
		    	//tiles.get(0).setTemperature(10);
		    	System.out.println("Number of ticks: "+tickcount+"\n");
		    	System.out.println("Tile0: Herbivores: "+control.listHerbivoresInTile(0)+" Carnivores: "+control.listCarnivoresInTile(0)+" Plants: "+control.listPlantsInTile(0));
		    	System.out.println("Tile1: Herbivores: "+control.listHerbivoresInTile(1)+" Carnivores: "+control.listCarnivoresInTile(1)+" Plants: "+control.listPlantsInTile(1));
		    	System.out.println("Tile2: Herbivores: "+control.listHerbivoresInTile(2)+" Carnivores: "+control.listCarnivoresInTile(2)+" Plants: "+control.listPlantsInTile(2));
		    	System.out.println("Tile3: Herbivores: "+control.listHerbivoresInTile(3)+" Carnivores: "+control.listCarnivoresInTile(3)+" Plants: "+control.listPlantsInTile(3));
		    	System.out.println();
		    	System.out.println("Temperature tile 0: "+(tiles.get(0).temperature));
		    	System.out.println("Temperature tile 1: "+(tiles.get(1).temperature));
		    	System.out.println("Temperature tile 2: "+(tiles.get(2).temperature));
		    	System.out.println("Temperature tile 3: "+(tiles.get(3).temperature));
		    	System.out.println();
		    	System.out.println("Total: Herbivores: "+control.herbivore.size()+" Carn: "+control.carnivore.size()+" Plant: "+control.plant.size());
		    	System.out.println();
		    	
		    	//COUNTERS
		    	if (tickcount%2==0 && tickcount!=0) {
		    		tile.randTemperature(tiles);
		    	}if (tickcount%10==0 && tickcount!=0){
			    	control.move(control, calc, tiles);
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
