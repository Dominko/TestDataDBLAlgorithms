/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdata;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author s156035
 */
public class Node {
    int di;
    List neighbour;
    Random rng = new Random();
    
    public Node(int j, int number_nodes){
        neighbour = new LinkedList();
        
        //Make connection between n, n-1 and n+1, to ensure the graph is connected
        if(j != 0){
            neighbour.add(j - 1);
        }
        if(j != number_nodes-1){
            neighbour.add(j + 1);
        }
    }
}
