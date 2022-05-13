/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dejesus.ds.ll;

/**
 *
 * @author daniel
 */
public class DeJesusDsLl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);
        
        theList.displayList();
        
        while( !theList.isEmpty() )
        {
            Link aLink = theList.deleteFirst();
            System.out.println("Deleted ");
            aLink.displayLink();
            System.out.println("");
        }
        theList.displayList();
    }
    
}
