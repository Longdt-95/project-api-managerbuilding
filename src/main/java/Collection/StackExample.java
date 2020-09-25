package Collection;

import java.util.Stack;

/**
 *
 * @author Admin
 */
public class StackExample {

    /**
     * The stack is a linear data structure that is used to store the collection
     * of objects. It is based on Last-In-First-Out (LIFO) In Java, Stack is a
     * class that falls under the Collection framework that extends the Vector
     * class. It also implements interfaces List, Collection, Iterable,
     * Cloneable, Serializable
     */
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //push() method (insert) an element onto the top of the stack.
        stack.push("java");
        stack.push("php");
        stack.push("ruby");
        stack.push("javascript");
        stack.push("python");
        System.out.println(stack);
        System.out.println("=========================");
        // pop() method removes an element from the top of the stack and returns the same element as the value of that function.
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println("=============================");
        // The peek() method looks at the top element of the stack without removing it.
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println("=============================");
        // the search() method searches the specified object and returns the object location from the top of the stack.
        System.out.println(stack.search("javascript"));
        System.out.println(stack);
        System.out.println("=============================");
    }
}
