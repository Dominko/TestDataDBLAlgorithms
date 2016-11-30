/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdata;

import java.util.Random;


/**
 *
 * @author s156035
 */
public class Passenger {
    int location;
    int destination;
    Node nodes[];
    int ranLocation;
    int ranDestination;
    Random rand = new Random();
    
        public Passenger(){
        //Put method to determine location and destination here
        //generate random location and do bfs to find if it comes under destination 
         ranLocation=rand.nextInt(location);
         ranDestination=rand.nextInt(destination);
        
        while(ranLocation == ranDestination){
        ranLocation = rand.nextInt();            
        }
        while(ranLocation != ranDestination){
            
        }
    }
}

