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
public class ArrayIns {
    private int[]theArray;
    private int nElems;
    public int num = 0;
    public int num2 = 0;
    
    public ArrayIns(int max)
    {
        theArray = new int[max];
        nElems = 0;
    }
    
    public void insert(int value)
    {
        theArray[nElems] = value;
        nElems++;
    }
    
    public void display()
    {
        for(int j = 0; j < nElems; j++)
            System.out.print(theArray[j] + " ");
    }
    
    public void quickSort()
    {
        recQuickSort(0, nElems - 1);
    }
    
    public void recQuickSort(int left, int right)
    {
        if(right-left <= 0)
            return;
        else
        {
            int pivot = theArray[right];
            
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition+1, right);
        }
    }
    
    public int partitionIt(int left, int right, int pivot)
    {
        int leftPtr = left-1;
        int rightPtr = right;
        
        while(true)
        {
            while(theArray[++leftPtr] < pivot);
            
            while(rightPtr > 0 && theArray[--rightPtr] > pivot);
            
            if (leftPtr >= rightPtr)
                break;
            else
            {
                swap(leftPtr, rightPtr);
                num++;
            }
        }
        swap(leftPtr, right);
        num2++;
        return leftPtr;
    }
    
    public void swap(int dex1, int dex2)
    {
        int temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}
