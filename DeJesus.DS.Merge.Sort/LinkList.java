/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dejesus.ds.merge.sort;

/**
 *
 * @author daniel
 */
public class LinkList {
    node head = null;
    static class node
    {
        int val;
        node next;
        
        public node(int val)
        {
            this.val = val;
        }
    }
    node sortedMerge(node a, node b)
    {
        node result = null;
        if(a == null)
            return b;
        if (b == null)
            return a;
        if(a.val < b.val)
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else
        {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
    node mergeSort(node h)
    {
        if(h == null || h.next == null)
            return h;
        node middle = getMiddle(h);
        node nextofmiddle = middle.next;
        middle.next = null;
        node left = mergeSort(h);
        node right = mergeSort(nextofmiddle);
        node sortedList = sortedMerge(left, right);
        return sortedList;
    }
    public static node getMiddle(node head)
    {
        if (head == null)
            return head;
        node slow = head;
        node fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
