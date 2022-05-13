/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author daniel
 */
public class JavaApplication1 {

    static int newValue;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Linkll bob = new Linkll(6);
        newValue = bob.value;
        Linkll next;
        System.out.println("Bob's Value " + bob.value + " \n " + newValue);
    }
    
}
