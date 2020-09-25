/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class QueueExample {

    /**
     * Java Queue interface orders the element in FIFO(First In First Out)
     * manner. In FIFO, first element is removed first and last element is
     * removed at last.
     *
     */
    public static void main(String[] args) {

        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("java");
        priorityQueue.add("php");
        priorityQueue.add("ruby");
        // a different way to insert the specified element into this queue.
//        priorityQueue.offer("C#");
        System.out.println(priorityQueue);
        System.out.println("===============================");
        // the remove() method used to retrieves and removes the head of this queue.
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue);
        System.out.println("===============================");
        // the poll() method used to retrieves and removes the head of this queue, or returns null if this queue is empty.
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue);
        priorityQueue.offer("java");
        priorityQueue.offer("php");
        System.out.println("===============================");
        // the element() used to retrieves, but does not remove, the head of this queue.
        System.out.println(priorityQueue.element());
        System.out.println(priorityQueue);
        System.out.println("================================");
        // the peek() method used to retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue);
        System.out.println("================================");
    }
}
