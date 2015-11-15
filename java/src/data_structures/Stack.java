package data_structures;

import java.util.LinkedList;

public class Stack {

  public static void main(String[] args) {
    
    LinkedList<Integer> myStack = new LinkedList<Integer>();
    
    push(myStack, 5);
    push(myStack, 6);
    System.out.println(pop(myStack) + " " + pop(myStack));
    
  }
  
  static void push(LinkedList<Integer> list, Integer element) {
    list.add(element);
  }
  
  static Integer top(LinkedList<Integer> list) {
    return list.getLast();
  }
  static Integer pop(LinkedList<Integer> list) {
    return list.removeLast();
  }

}
