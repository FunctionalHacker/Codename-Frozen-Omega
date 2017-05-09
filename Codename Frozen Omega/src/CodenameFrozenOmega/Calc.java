/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CodenameFrozenOmega;

import java.util.ArrayList;
import java.util.Random;
import java.math.*;
        
/**
 *
 * @author ancalego
 */

public class Calc {
	double lifespan;
    double age;
     double habitability;
     public Climate climate;
     public Organism organism;
  public double setLife(int id){
      
        switch (id) {
            //large carnivores      7300 +- 1825
            case 1:  
               lifespan =  (int) randomize(1);
               break;
                     
           // small carnivores
            case 2:  
                 lifespan =  (int) randomize(2);
                break;
        //Herbivores
            case 3:  
                lifespan =  (int) randomize(3);
               break;
         //bacteria
            case 4:  
               lifespan =  (int) randomize(4);
               break;
            case 5:
                lifespan = (int) randomize(5);
                break;
                
  }
      return lifespan;
      
  }
 
  
        public double  randomize(int id){
           
           
            
                      switch (id) {
            //large carnivores  7300 +- 1825
            case 1:  
                      lifespan = (int) (randint(5475 , 9125) * habitability);
                      
                     break;
           // small carnivores 4-6 1460-2190 days
            case 2:  
                  lifespan = (int) (randint(1460 , 2190) * habitability);
                     break;
        //Herbivores 7300 days
            case 3:  
                lifespan = (int) (randint(5475 , 9125)* habitability);
                     break;
         //trees 29200 +-5475 80 +-15 years
            case 4:  
                lifespan = (int) (randint(23725 , 34675)* habitability);
                     break;
                     // non perennials
            case 5:  
                lifespan = (int) (randint(330, 360)*habitability);
                     break;

           
            
        }
                     return lifespan;
      
}
     private static int randint(int min, int max) {
              
    Random rn= new Random();
   int randomValue = min + (max - min) * rn.nextInt();
    return randomValue;
    }
//habitability aging rate weather/temperature changing  method
     /*
     public  double grow(){
        
         if (habitability >1){
             age = age + 0.75;

     } else if (habitability ==1){
         age = age +1;
     } else if (habitability <1){
         age = age +2;
     }
        return age;
     }
      */
     public int getHabitability(int location,ObjectsControl control, Organism organism, ArrayList<Tile> tiles, String species){
    	 double temperature=tiles.get(location).getTemperature();
    	 int nexthabitability;
    	 if (temperature-2 < organism.preferredTemperature && 
                 temperature+2 > organism.preferredTemperature){
    		 nexthabitability=2;
             }
             else if (temperature-10 < organism.preferredTemperature && 
                      temperature+10 > organism.preferredTemperature){
             	nexthabitability=1;
             }
             else{
             	nexthabitability=0;
             }
    	 if (species=="Carnivore") {
    		 if (control.listHerbivoresInTile(location)>control.listHerbivoresInTile(organism.location)) {
    			if (organism.habitability<2) {					
    				nexthabitability++;
				}
			}
		}
    	 if (species=="Carnivore") {
    		 if (control.listHerbivoresInTile(location)<control.listHerbivoresInTile(organism.location)) {
    			if (organism.habitability>0) {					
    				nexthabitability--;
				}
			}
		}
    	 if (species=="Herbivore") {
			if (control.listCarnivoresInTile(location)>control.listCarnivoresInTile(organism.location)) {
				if (organism.habitability>0) {
					nexthabitability--;
				}
			}
		}
    	 if (species=="Herbivore") {
 			if (control.listCarnivoresInTile(location)<control.listCarnivoresInTile(organism.location)) {
 				if (organism.habitability<2) {
 					nexthabitability++;
 				}
 			}
 		}
    	 return nexthabitability;
     }
     public  void setHabitability(ObjectsControl control, double temperature, Organism organism, String species){
    	 			int habitability;
                    if (temperature-2 < organism.preferredTemperature && 
                        temperature+2 > organism.preferredTemperature){
                    	habitability=2;
                    }
                    else if (temperature-10 < organism.preferredTemperature && 
                             temperature+10 > organism.preferredTemperature){
                    	habitability=1;
                    }
                    else{
                    	habitability=0;
                    }
                    if (species=="Carnivore") {
               		 if (control.listHerbivoresInTile(organism.location)<control.listCarnivoresInTile(organism.location)) {
           				if (organism.habitability>0) {
           					habitability--;							
						}
           			}
               		 if (control.listHerbivoresInTile(organism.location)>control.listCarnivoresInTile(organism.location)) {
            				if (organism.habitability<2) {
            					habitability++;							
 						}
            			}
           		}
               	 if (species=="Herbivore") {
           			if (control.listCarnivoresInTile(organism.location)>control.listHerbivoresInTile(organism.location)) {
           				if (organism.habitability>0) {
           					habitability--;
						}
           			}
           		}
               	 organism.habitability=habitability;
               	 
      }
     public void setLocation(int location, Organism organism){
    	 organism.location=location;
     }
     public void setAge(double age, Organism organism){
    	 age++;
    	 lifespan=organism.lifespan;
    	 habitability=organism.habitability;
    	 organism.age=age;
    	 if (habitability>1) { 	        
    	     organism.lifespan=lifespan*1.00001;
    	    } else if (habitability ==1){
    	        organism.lifespan=lifespan*0.99999;
    	    } else if (habitability <1){
    	        organism.lifespan=lifespan*0.9998;
    	    }
    	    
    	 }
		

//saalis ja saalistajien suhteen laskua lisäilyä ja poistoa lotka-Volterra equation
//what?

/*public int Predatorformula(ObjectsControl control, Calc calc){
    
    Tile tile=null;
//any real numbers
    double a=0.1, b=0.02, c=0.4, d=0.02;

  
  for (int i = 1; i<=tile.gettilelocation(); i++){
              int predators = control.listCarnivoresInTile(i);
               int  prey = control.listHerbivoresInTile(i);
                double newprey = (a * prey)-(b*prey*predators);
                double newpredator = (prey*predators*d)-(c*predators);
                control.createObjects("Carnivore", "predator", (int)(newpredator-predators), 1, organism.preferredTemperature,i,(int)calc.setLife(1), 0, 1);
                control.createObjects("Herbivore", "prey", (int)(newprey-prey), 2, organism.preferredTemperature,i, (int)calc.setLife(2), 0, 2);
  }    

            }
 */

}