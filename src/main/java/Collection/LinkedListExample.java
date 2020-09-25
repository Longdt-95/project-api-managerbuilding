/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.Deque;

/**
 *
 * @author Admin
 */
public class LinkedListExample {

    /* 
      Java LinkedList class inherits the AbstractList class and implements List and Deque interfaces
      Java LinkedList class can contain duplicate elements.
      Java LinkedList class maintains insertion order.
      Java LinkedList class is non synchronized.
      In Java LinkedList class, manipulation is fast because no shifting needs to occur.
      Java LinkedList class can be used as a list, stack or queue. 
     */

    public static void main(String[] args) {
        Deque<Integer> ll = new java.util.LinkedList<>();
        ll.add(1);
        ll.add(3);
        ll.add(6);
        ll.add(4);
        /*        System.out.println(ll);
        ll.addFirst(0);
        ll.addLast(7);
        System.out.println("after uses addFisrt and addLast methods");
        System.out.println(ll);
        System.out.println("----------------");
        System.out.println(ll.element());
        System.out.println(ll.getFirst()); */
        // uses adds the specified element at the end of a list
        ll.offer(3);
        ll.offerFirst(4);
        ll.offerLast(6);
        System.out.println(ll);
        System.out.println("-----------");
        ll.push(8);
        System.out.println(ll);
    }
}
