/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;
import java.io.*;
/**
 *
 * @author daniel
 */
public class BinaryTree {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {
        int value;
        Tree theTree = new Tree();
        
        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.5);
        theTree.insert(33, 1.2);
        theTree.insert(87, 1.7);
        theTree.insert(93, 1.5);
        theTree.insert(97, 1.5);
        
        while(true)
        {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            int choice = getChar();
            switch(choice)
            {
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value, value + 0.9);
                    break;
                case 'f':
                    System.out.print("Enter the value to find: ");
                    value = getInt();
                    Nodes found = theTree.find(value);
                    if(found != null)
                    {
                        System.out.print("Found: ");
                        found.displayNodes();
                        System.out.print("\n");
                    }
                    else
                        System.out.print("Could not find ");
                        System.out.print(value + '\n');
                    break;
                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);
                    if(didDelete)
                        System.out.print("Deleted " + value + '\n');
                    else
                        System.out.print("Could not delete ");
                        System.out.print(value + '\n');
                    break;
                case 't':
                    System.out.print("Enter type 1, 2 or 3: ");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }
    
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }
    
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}
