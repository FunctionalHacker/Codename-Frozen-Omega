/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CodenameFrozenOmega;

import java.util.Random;
import java.math.*;

/**
 *
 * @author ancalego
 */
public class Calc {
    
  public double setLife(int id){
      int lifespan = 0;
        switch (id) {
            //large carnivores      7300 +- 1825
            case 1:  
               lifespan =  randomize(1);
               break;
                     
           // small carnivores
            case 2:  
                 lifespan =  randomize(2);
                break;
        //Herbivores
            case 3:  
                lifespan =  randomize(3);
               break;
         //bacteria
            case 4:  
               lifespan =  randomize(4);
               break;
            case 5:
                lifespan = randomize(5);
                break;
                
  }
      return lifespan;
  }
  
        public int  randomize(int id){
           int lifespan = 0;
           int habitability =1;
                      switch (id) {
            //large carnivores  7300 +- 1825
            case 1:  
                      lifespan = randint(5475 , 9125) * habitability;
                      
                     break;
           // small carnivores 4-6 1460-2190 days
            case 2:  
                  lifespan = randint(1460 , 2190) * habitability;
                     break;
        //Herbivores 7300 days
            case 3:  
                lifespan = randint(5475 , 9125)* habitability;
                     break;
         //trees 29200 +-5475 80 +-15 years
            case 4:  
                lifespan = randint(23725 , 34675)* habitability;
                     break;
                     // non perennials
            case 5:  
                lifespan = randint(330, 360)*habitability;
                     break;

           
            
        }
                     return lifespan;
      
}
     private static int randint(int min, int max) {
              
    Random rn= new Random();
   int randomValue = min + (max - min) * rn.nextInt();
    return randomValue;
    }
//habitability aging rate 
}


