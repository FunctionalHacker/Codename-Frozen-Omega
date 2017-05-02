/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CodenameFrozenOmega;

import java.util.Random;

        
/**
 *
 * @author ancalego
 */
public class Calc {
    int lifespan = 0;
    double age =0;
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
     public  Double sethabitability(){
                    if (organism.preferredTemperature-10 < organism.preferredTemperature || 
                            organism.preferredTemperature+10>organism.preferredTemperature){
                        habitability =2;
        } else if (organism.preferredTemperature-2 < organism.preferredTemperature || 
                            organism.preferredTemperature+2>organism.preferredTemperature){
              habitability =1;
        } else if ((organism.preferredTemperature -15< organism.preferredTemperature || 
                            organism.preferredTemperature+15>organism.preferredTemperature)){
                 habitability =0;
     }
     return habitability;
     }
     public void timeToExpire(){
         
         if (age==lifespan){
             
         }
     }
 
}


