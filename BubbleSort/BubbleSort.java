/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

/**
 *
 * @author daniel
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("This is bubble sort:\n");
        System.out.println("Random Order:");
        int maxSize = 1000;
        DSBubble arr;
        arr = new DSBubble(maxSize);
        
        for(int j = 0; j < maxSize; j++)
        {
            int n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }

        arr.display();
        
        arr.bubbleSort();
        
        arr.display();
        
        System.out.println("Number of actions taken: " + arr.num);
        
        arr.num = 0;
        
        arr = new DSBubble(maxSize);
        
        System.out.println("Now an array in Reverse Order: ");
        
        for(int j = maxSize; j <= maxSize && j != 0; j--)
        {
            arr.insert(j);
        }
        
        arr.display();
        
        arr.bubbleSort();
        
        arr.display();
        
        System.out.println("Number of actions taken: " + arr.num);
        
        arr = new DSBubble(maxSize);
        
        System.out.println("Now an array already in Order: ");
        
        for(int j = 0; j < maxSize; j++)
        {
            arr.insert(j);
        }
        
        arr.display();
        
        arr.bubbleSort();
        
        arr.display();
        
        System.out.println("Number of actions taken: " + arr.num);
    }
    
}
