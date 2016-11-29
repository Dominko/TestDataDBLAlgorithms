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
public class TestData {
    float alpha;
    int max_time;
    int number_taxis;
    int max_passengers;
    int number_nodes;  
    
    Node[] nodes;
    
    Calllist[] calllist;
    
    int training_period;
    int total_time;
    
    Random rng = new Random();
    
    //Max amount of passengers to be generated every minute
    int max_new_passengers = 20;
    
    //the amount of zeros we want after the amount of taxis
    int taxi_order;
    int node_order;
    
    public void output(){
        String temp;
        
        generatePreamble();
        //Preamble
        System.out.println(5 + number_nodes);
        System.out.println(alpha);
        System.out.println(max_time);
        System.out.println(number_taxis + " " + max_passengers);
        System.out.println(number_nodes);
        for(int x = 0; x < number_nodes; x++){
            temp = ""+nodes[x].di;
            for(int y = 0; y < nodes[x].di; y++){
                temp = temp.concat(" " + nodes[x].neighbour[y]);
            };
        }
        
        generatePassengers();
        System.out.println(training_period + " " + total_time);
        for(int x = 0; x < total_time; x++){
            temp = ""+calllist[x].passengers.length;
            for(int y = 0; y < nodes[x].di; y++){
                temp = temp.concat(" " + calllist[x].passengers[y].location + 
                                   " " + calllist[x].passengers[y].destination);
            };
        }
        
        
    }
    
    public void generatePassengers(){
        //initialise the set of passengers
        calllist = new Calllist[total_time];

        //Geneate the amount of passengers at all points in time
        for(int x = 0; x < total_time; x++){
            int amount_of_passengers = rng.nextInt(max_new_passengers);
            
            calllist[x] = new Calllist(amount_of_passengers);
        }
        
    }
    
    public void generatePreamble(){
        alpha = rng.nextFloat();
        number_taxis = rng.nextInt(1000) * taxi_order;
        max_passengers = rng.nextInt(5) + 1;
        number_nodes = rng.nextInt(1000) * node_order;; 
        max_time = number_nodes * 10;
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
