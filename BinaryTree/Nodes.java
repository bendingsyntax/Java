/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;
import java.util.*;
/**
 *
 * @author daniel
 */
class Nodes 
{
    public int iData;
    public double dData;
    public Nodes leftChild;
    public Nodes rightChild;
    
    public void displayNodes()
    {
        System.out.print('{');
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }
}

class Tree
{
    private Nodes root;
    
    public Tree()
    {
        root = null;
    }
    
    public Nodes find(int key)
    {
        Nodes current = root;
        while(current.iData != key)
        {
            if(key < current.iData)
                current = current.leftChild;
            else
                current = current.rightChild;
            if(current == null)
                return null;
        }
        return current;
    }
    
    public void insert(int id, double dd)
    {
        Nodes newNodes = new Nodes();
        newNodes.iData = id;
        newNodes.dData = dd;
        if(root == null)
            root = newNodes;
        else
        {
            Nodes current = root;
            Nodes parent;
            while(true)
            {
                parent = current;
                if(id < current.iData)
                {
                    current = current.leftChild;
                    if(current == null)
                    {
                        parent.leftChild = newNodes;
                        return;
                    }
                }
                else
                {
                    current = current.rightChild;
                    if(current == null)
                    {
                        parent.rightChild = newNodes;
                        return;
                    }
                }
            }
        }
    }
    
    public boolean delete(int key)
    {
        Nodes current = root;
        Nodes parent = root;
        boolean isLeftChild = true;
        
        while(current.iData != key)
        {
            parent = current;
            if(key < current.iData)
            {
                isLeftChild = true;
                current = current.leftChild;
            }
            else
            {
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null)
                return false;
        }
        
        if(current.leftChild == null && current.rightChild == null)
        {
            if(current == root)
                root = null;
            else if(isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }
        else if(current.rightChild == null)
            if(current == root)
                root = current.leftChild;
            else if(isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        else if(current.leftChild == null)
            if(current == root)
                root = current.rightChild;
            else if(isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        else
        {
            Nodes successor = getSuccessor(current);
            
            if(current == root)
                root = successor;
            else if(isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            
            successor.leftChild = current.leftChild;
        }
        return true;
    }
    
    private Nodes getSuccessor(Nodes delNodes)
    {
        Nodes successorParent = delNodes;
        Nodes successor = delNodes;
        Nodes current = delNodes.rightChild;
        
        while(current != null)
        {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        
        if(successor != delNodes.rightChild)
        {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNodes.rightChild;
        }
        return successor;
    }
    
    public void traverse(int traverseType)
    {
        switch(traverseType)
        {
            case 1: System.out.print("\nPreorder traversal: ");
                    preOrder(root);
                    break;
            case 2: System.out.print("\nInorder traversal: ");
                    inOrder(root);
                    break;
            case 3: System.out.print("\nPostorder traversal: ");
                    postOrder(root);
                    break;
        }
        System.out.println();
    }
    
    private void preOrder(Nodes localRoot)
    {
        if(localRoot != null)
        {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
    
    private void inOrder(Nodes localRoot)
    {
        if(localRoot != null)
        {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }
    
    private void postOrder(Nodes localRoot)
    {
        if(localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }
    
    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while(isRowEmpty == false)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;
            
            for(int j = 0; j < nBlanks; j++)
                System.out.print(' ');
            
            while(globalStack.isEmpty() == false)
            {
                Nodes temp = (Nodes)globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    
                    if(temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j = 0; j < nBlanks*2-2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty() == false)
                globalStack.push( localStack.pop() );
        }
        System.out.println("......................................................");
    }
}
