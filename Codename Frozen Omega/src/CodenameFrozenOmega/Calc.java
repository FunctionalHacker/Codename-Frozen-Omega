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
  public double setLife(String className){
      
        switch (className) {
         //carnivores
            case "Carnivore":  
               lifespan =  (int) randomize(1);
               break;
        //Herbivores
            case "Herbivore":  
                lifespan =  (int) randomize(3);
               break;
//         //bacteria
//            case 4:  
//               lifespan =  (int) randomize(4);
//               break;
            case "Plant":
                lifespan = (int) randomize(4);
                break;
                
  }
      return lifespan;
      
  }
 
  
        public double  randomize(int id){
           
           
            
                      switch (id) {
            //large carnivores  7300 +- 1825
            case 1:  
                      lifespan = (int) (randint(250 , 600));
                      
                     break;
           // small carnivores 4-6 1460-2190 days
//            case 2:  
//                  lifespan = (int) (randint(1460 , 2190) * habitability);
//                     break;
        //Herbivores 7300 days
            case 3:  
                lifespan = (int) (randint(250 , 600));
                     break;
         //trees 29200 +-5475 80 +-15 years
            case 4:  
                lifespan = (int) (randint(300 , 800));
                     break;
                     // non perennials
            case 5:  
                lifespan = (int) (randint(330, 360));
                     break;

           
            
        }
                     return lifespan;
      
}
     public int randint(int min, int max) {
              
    Random rn= new Random();
   int randomValue = min + (max - min) * rn.nextInt();
    return randomValue;
    }


     public double getHabitability(int location,ObjectsControl control, Organism organism, ArrayList<Tile> tiles, String species){
    	 double temperature=tiles.get(location).getTemperature();
    	 double nexthabitability;
    	 if (temperature-2 < organism.preferredTemperature && 
                 temperature+2 > organism.preferredTemperature){
    		 nexthabitability=2;
             }
             else if (temperature-5 < organism.preferredTemperature && 
                      temperature+5 > organism.preferredTemperature){
             	nexthabitability=1.5;
             }
             else if (temperature-7 < organism.preferredTemperature && 
                     temperature+7 > organism.preferredTemperature){
            	nexthabitability=1;
            }
             else if (temperature-10 < organism.preferredTemperature && 
                     temperature+10 > organism.preferredTemperature){
            	nexthabitability=0.5;
            }
             else{
             	nexthabitability=0;
             }
    	 if (species=="Carnivore") {
    		 if (control.listHerbivoresInTile(location)>control.listHerbivoresInTile(organism.location)) {
    			if (organism.habitability<2) {					
    				nexthabitability=nexthabitability+0.25;
				}
			}
		}
    	 if (species=="Carnivore") {
    		 if (control.listHerbivoresInTile(location)<control.listHerbivoresInTile(organism.location)) {
    			if (organism.habitability>0) {					
    				nexthabitability=nexthabitability-0.25;
				}
			}
		}
    	 if (species=="Herbivore") {
			if (control.listCarnivoresInTile(location)>control.listCarnivoresInTile(organism.location)) {
				if (organism.habitability>0) {
					nexthabitability=nexthabitability-0.25;
				}
			}
		}
    	 if (species=="Herbivore") {
 			if (control.listCarnivoresInTile(location)<control.listCarnivoresInTile(organism.location)) {
 				if (organism.habitability<2) {
 					nexthabitability=nexthabitability+0.25; 
 				}
 			}
 		}
    	 return nexthabitability;
     }
     public  void setHabitability(ObjectsControl control, double temperature, Organism organism, String species){
         double habitability;
         /////TEMPERATURE CHECK////////
         if (temperature-2 < organism.preferredTemperature && 
                    temperature+2 > organism.preferredTemperature){
                  habitability=2;
                }
                else if (temperature-5 < organism.preferredTemperature && 
                         temperature+5 > organism.preferredTemperature){
                    habitability = 1.5;
                }
                else if (temperature-7 < organism.preferredTemperature && 
                         temperature+7 > organism.preferredTemperature){
                  habitability=1;
                }
                else if (temperature-10 < organism.preferredTemperature && 
                         temperature+10 > organism.preferredTemperature){
                    habitability = 0.5;
                }
                else{
                  habitability=0;
                }
         ////////////////////////////////////////////////////////////////////
         if (species=="Carnivore") {
        	 if (control.listHerbivoresInTile(organism.location)<control.listCarnivoresInTile(organism.location)) {
        		 if (organism.habitability>0) {
        			 habitability=habitability+0.25;              
        			 }
        		 }
        	 }
         if (control.listHerbivoresInTile(organism.location)>control.listCarnivoresInTile(organism.location)) {
        	 if (organism.habitability<2) {
        		 habitability=habitability-0.25;            
        		 }
        	 }
         if (species=="Herbivore") {
        	 if (organism.habitability>0) {
        		 habitability=habitability+0.25;
                 }
               }
         if(control.listCarnivoresInTile(organism.location)>control.listHerbivoresInTile(organism.location)) {
        	 if(organism.habitability<2) {
        		 habitability=habitability-0.25;
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
    	     organism.lifespan=lifespan*1.0001;
    	    } else if (habitability ==1){
    	        organism.lifespan=lifespan*0.99999;    
    	    } else if (habitability <1&& habitability>0.5){
    	        organism.lifespan=lifespan*0.9998;
    	    }else if (habitability<0.5&& habitability>0){
    	    	organism.lifespan=lifespan*0.90;
    	    }else if (habitability >1.5&& habitability<2){
    	        organism.lifespan=lifespan*1.1;
	     
	    } else if (habitability ==0){
	        organism.lifespan=lifespan*0.5;
 
    	 }
		

     }

}