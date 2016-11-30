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
public class Calllist {
    Passenger[] passengers;
    Random rng = new Random();
    
    public Calllist(int amount_of_passengers, int node_amount){
        passengers = new Passenger[amount_of_passengers];
        
        for(int x = 0; x < amount_of_passengers; x++){
            passengers[x] = new Passenger(node_amount);
        }
    }
}
