/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdata;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author s156035
 */
public class Passenger {
    int location;
    int destination;
    Node nodes[];
    
    Scanner sc= new Scanner(System.in);
    public Passenger(int location){
        //Put method to determine location and destination here
        //generate random location and do bfs to find if it comes under destination 
        
        Random rand = new Random();
        int n=rand.nextInt(location);
        }
        public void bfs(Node passengerNode, Node destinationNode){
            
    }
}
