/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsquicksort;

/**
 *
 * @author daniel
 */
public class DSQuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int maxSize = 1000;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);
        
        for(int j = 0; j < maxSize; j++)
        {
            int n = (int)(java.lang.Math.random()*999);
            arr.insert(n);
        }
        
        System.out.println("Random Order Array: ");
        arr.display();
        arr.quickSort();
        
        System.out.println("\nAfter quick sort: ");
        arr.display();
        
        System.out.println("\nNumber of changes in the array: " + arr.num);
        
        arr.num = 0;
        
        arr = new ArrayIns(maxSize);
        
        for(int j = 0; j < maxSize; j++)
            arr.insert(j);
        
        System.out.println("An Ordered Array: ");
        arr.display();
        arr.quickSort();
        
        System.out.println("\nAfter quick sort: ");
        arr.display();
        
        System.out.println("\nNumber of changes in the array: " + arr.num);
        
        
        arr.num2 = 0;
        
        arr = new ArrayIns(maxSize);
        
        for(int j = 0; j < maxSize; j++)
        {
            int temp = maxSize - j;
            arr.insert(temp);            
        }

        
        System.out.println("A Revesed Array: ");
        arr.display();
        arr.quickSort();
        
        System.out.println("\nAfter quick sort: ");
        arr.display();
        
        System.out.println("\nNumber of changes in the array: " + arr.num2);
    }
    
}
