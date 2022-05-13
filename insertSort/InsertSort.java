/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertsort;

/**
 *
 * @author daniel
 */

class ArrayIns
{
    private long[] a;
    private int nElems;
    public int num = 0;
    
    public ArrayIns(int max)
    {
        a = new long[max];
        nElems =0;
    }
    
    public void insert(long value)
    {
        a[nElems] = value;
        nElems++;
    }
    
    public void display()
    {
        for(int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }
    
    public void insertionSort()
    {
        int in, out;
        
        for(out = 1; out < nElems; out++)
        {
            long temp = a[out];
            in = out;
            while(in > 0 && a[in - 1] >= temp)
            {
                a[in] = a[in - 1];
                --in;
                num++;
            }
            a[in] = temp;
        }
    }
    
    public int insertionCount()
    {
        return num;
    }
}


class InsertSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("This is Insertion Sort:\n");
        System.out.println("Random Order:");
        int maxSize = 1000;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);
        
        for(int j = 0; j < maxSize; j++)
        {
            int n = (int)(java.lang.Math.random()*999);
            arr.insert(n);
        }
        
        arr.display();
        
        arr.insertionSort();
        
        arr.display();
        
        System.out.println("Number of actions taken: " + arr.num);
        
        arr.num = 0;
        
        arr = new ArrayIns(maxSize);
        
        System.out.println("Now an array in Reverse Order: ");
        
        for(int j = maxSize; j <= maxSize && j != 0; j--)
        {
            arr.insert(j);
        }
        
        arr.display();
        
        arr.insertionSort();
        
        arr.display();
        
        System.out.println("Number of actions taken: " + arr.num);
        
        arr = new ArrayIns(maxSize);
        
        System.out.println("Now an array already in Order: ");
        
        for(int j = 0; j < maxSize; j++)
        {
            arr.insert(j);
        }
        
        arr.display();
        
        arr.insertionSort();
        
        arr.display();
        
        System.out.println("Number of actions taken: " + arr.num);
    }
    
}
