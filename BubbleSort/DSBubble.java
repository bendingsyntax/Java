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
public class DSBubble
{
    private long[] a;
    private int nElems;
    public int num;
    
    public DSBubble(int max)
    {
        a = new long[max];
        nElems = 0;
    }
    
    public void insert(long value)
    {
        a[nElems] = value;
        nElems++;
    }
    
    public void display()
    {
        for(int j = 0; j < nElems; j++)
        {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }
    
    public void bubbleSort()
    {
        int out, in;
        
        for(out = nElems-1; out > 1; out--)
            for(in = 0; in < out; in++)
                if( a[in] > a[in+1] )
                {
                    swap(in, in+1);
                    num++;
                }

    }
    
    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
