/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdata;

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
    
    public void output(){
        System.out.println();
        System.out.println(alpha);
        System.out.println(max_time);
        System.out.println(number_taxis + " " + max_passengers);
        System.out.println(number_nodes);
        System.out.println();
        System.out.println();
        System.out.println();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
