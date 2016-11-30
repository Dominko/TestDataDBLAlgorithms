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
    Random rand = new Random();
    
        public Passenger(int node_amount){
        //Put method to determine location and destination here
        //generate random location and do bfs to find if it comes under destination 
        location = rand.nextInt(node_amount);
        destination = rand.nextInt(node_amount);
        
        while(location == destination){
            location = rand.nextInt(node_amount);            
        }
    }
}

