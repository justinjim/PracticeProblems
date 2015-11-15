package javaPracticeProb;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

  public static void main(String[] args) {
   
    Queue<Integer> myQ = new LinkedList<Integer>();
    
    
    int nums[] = {1,2,3,4,6,5};
    for (int i : nums) {
      myQ.add(i);
    }
    System.out.println("First element: " + myQ.peek());
    System.out.println("Last element: "+ myQ.poll());
    while (myQ.size() > 0) {
      System.out.println(" element: " + myQ.remove());
    }
    
  }

}
