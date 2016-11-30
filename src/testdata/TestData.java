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
    int taxi_order = 1;
    int node_order = 1;
    int repetitions;
    
    public void output(){
        String temp;
        
        System.out.println("set the amount of repetitions");
        repetitions = System.in.toString()
        
        
        generatePreamble();
        //Preamble
        System.out.println(5 + number_nodes);
        System.out.println(alpha);
        System.out.println(max_time);
        System.out.println(number_taxis + " " + max_passengers);
        System.out.println(number_nodes);
        
        generateNodes();
        for(int x = 0; x < number_nodes; x++){
            temp = ""+nodes[x].neighbour.size();
            for(int y = 0; y < nodes[x].neighbour.size(); y++){
                temp = temp.concat(" " + nodes[x].neighbour.get(y));
            };
            System.out.println(temp);
        }
        
        generatePassengers();
        System.out.println(training_period + " " + total_time);
        for(int x = 0; x < total_time; x++){
            temp = ""+calllist[x].passengers.length;
            for(int y = 0; y < nodes[x].di; y++){
                temp = temp.concat(" " + calllist[x].passengers[y].location + 
                                   " " + calllist[x].passengers[y].destination);
            };
            System.out.println(temp);
        }
        
        
    }
    
    public void generatePassengers(){
        //initialise the set of passengers
        calllist = new Calllist[total_time];

        //Geneate the amount of passengers at all points in time
        for(int x = 0; x < total_time; x++){
            int amount_of_passengers = rng.nextInt(max_new_passengers);
            
            calllist[x] = new Calllist(amount_of_passengers, number_nodes);
        }
        
    }
    
    public void generatePreamble(){
        alpha = rng.nextFloat();
        number_taxis = (rng.nextInt(10) * taxi_order) + 1;
        max_passengers = rng.nextInt(5) + 1;
        number_nodes = (rng.nextInt(10) * node_order) + 1; 
        max_time = number_nodes * 10;
        
    }
    
    public void generateNodes(){
        nodes = new Node[number_nodes];
        for(int x = 0; x < number_nodes; x++){
            nodes[x] = new Node(x, number_nodes);
        }
        
        //Represents the triangular expansion at n, which incidentally
        //is the amount of edges in a graph with n vertices. Math BITCH.
        int max_edges = rng.nextInt((number_nodes*(number_nodes+1)/2));
        
        for(int x = 0; x < max_edges; x++){
            int new_node_1, new_node_2;
            
            
            //generate 2 random nodes which are NOT the same
            new_node_1 = rng.nextInt(number_nodes);
            
            new_node_2 = rng.nextInt(number_nodes);
            while(new_node_2 == new_node_1){
                new_node_2 = rng.nextInt(number_nodes);
            }
            
            //Check for redundant connection. The connection is skipped if it already is in place
            //This favours graphs with quite a few connections, but not complete ones either.
            if(!nodes[new_node_1].neighbour.contains(new_node_2)){
                nodes[new_node_1].neighbour.add(new_node_2);
                nodes[new_node_2].neighbour.add(new_node_1);
            }
        }
    }
    
    public static void main(String[] args) {
        (new TestData()).output();
    }
    
}
