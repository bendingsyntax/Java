/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsortds;
import java.io.*;
/**
 *
 * @author daniel
 */
class Node
{
    private int iData;
    
    public Node(int key)
    {
        iData = key;
    }
    
    public int getKey()
    {
        return iData;
    }
}

class Heap
{
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;
    public int num = 0;
    
    public Heap(int mx)
    {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }
    
    public Node Remove()
    {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }
    
    public void trickleDown(int index)
    {
        int largerChild;
        Node top = heapArray[index];
        while(index < currentSize/2)
        {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            
            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
                largerChild = rightChild;
            else
                largerChild = leftChild;
            
            if(top.getKey() >= heapArray[largerChild].getKey())
                break;
            
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
            num++;
        }
        
        heapArray[index] = top;
    }
    
    public void displayHeap()
    {
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots + dots);
        
        while(currentSize > 0)
        {
            if(column == 0)
                for(int k = 0 ; k < nBlanks; k++)
                    System.out.print(" ");
            System.out.print(heapArray[j].getKey());
            
            if(++j == currentSize)
                break;
            
            if(++column == itemsPerRow)
            {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            }
            else
                for(int k = 0; k < nBlanks*2-2; k++)
                    System.out.print(" ");
        }
        System.out.println("\n" + dots + dots);
    }
    
    public void displayArray()
    {
        for(int j = 0; j < maxSize; j++)
            System.out.print(heapArray[j].getKey() + " ");
        System.out.println("");
    }
    
    public void insertAt(int index, Node newNode)
    {
        heapArray[index] = newNode;
    }
    
    public void incrementSize()
    {
        currentSize++;
    }
}

public class HeapSortDS 
{
    public static void main(String[] args) throws IOException
    {
        int size = 1000;
        Heap theHeap = new Heap(size);
        
        System.out.println("This is Heap Sort with random numbers:\n");
        
        for(int j = 0; j < size; j++)
        {
            int random = (int)(java.lang.Math.random()*999);
            Node newNode = new Node(random);
            theHeap.insertAt(j, newNode);
            theHeap.incrementSize();
        }
        
        System.out.print("Random: ");
            theHeap.displayArray();
            
        for(int j = size/2-1; j >= 0; j--)
            theHeap.trickleDown(j);
        
        System.out.print("Heap:   ");
        theHeap.displayArray();
        theHeap.displayHeap();
        
        for(int j = size - 1; j >= 0; j--)
        {
            Node biggestNode = theHeap.Remove();
            theHeap.insertAt(j, biggestNode);
        }
        System.out.print("Sorted: ");
        theHeap.displayArray();
        
        System.out.println("");
        
        System.out.print("Number of changes in the array: " + theHeap.num + "\n");
        
        theHeap.num = 0;
        
        Heap theHeap2 = new Heap(size);
        
        System.out.println("This is Heap Sort with In order numbers:\n");
        
        for(int j = 0; j < size; j++)
        {
            Node jn = new Node(j);
            theHeap2.insertAt(j, jn);
            theHeap2.incrementSize();
        }
        
        System.out.print("In Order: ");
            theHeap2.displayArray();
            
        for(int j = size/2-1; j >= 0; j--)
            theHeap2.trickleDown(j);
        
        System.out.print("Heap:   ");
        theHeap2.displayArray();
        theHeap2.displayHeap();
        
        for(int j = size - 1; j >= 0; j--)
        {
            Node biggestNode = theHeap2.Remove();
            theHeap2.insertAt(j, biggestNode);
        }
        System.out.print("Sorted: ");
        theHeap2.displayArray();
        
        System.out.println("");
        
        System.out.print("Number of changes in the array: " + theHeap2.num + "\n");
        
        theHeap2.num = 0;
        
        Heap theHeap3 = new Heap(size);
        
        System.out.println("This is Heap Sort with reverse numbers:\n");
        
        for(int j = 0; j < size; j++)
        {
            Node jn2 = new Node(size - j);
            theHeap3.insertAt(j, jn2);
            theHeap3.incrementSize();
        }
        
        System.out.print("Reverse: ");
            theHeap3.displayArray();
            
        for(int j = size/2-1; j >= 0; j--)
            theHeap3.trickleDown(j);
        
        System.out.print("Heap:   ");
        theHeap3.displayArray();
        theHeap3.displayHeap();
        
        for(int j = size - 1; j >= 0; j--)
        {
            Node biggestNode = theHeap3.Remove();
            theHeap3.insertAt(j, biggestNode);
        }
        System.out.print("Sorted: ");
        theHeap3.displayArray();
        
        System.out.println("");
        
        System.out.print("Number of changes in the array: " + theHeap3.num + "\n");
        
        theHeap3.num = 0;
        
    }
    
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}
