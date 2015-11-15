package data_structures;

import java.util.LinkedList;

/** 
 * Implement a stack that supports a 'min' operation. 
 * pop/push/min run in O(1).
 * 
 * This is done by holding auxiliry meta information at each value.
 * @author lufimtse
 *
 */
public class StackWithMinimum {
  
  public static void main(String[] args) {
    StackWithMinimum swm = new StackWithMinimum();
    
    swm.push(4);
    swm.push(5);
    swm.push(3);
    swm.push(6);
    swm.push(0);
    swm.push(7);
    for (int i = 0; i < 6; i++) {
     System.out.println("Current min: " + swm.min());
     swm.pop();
    }
  }
  
  
  class StackValue {
    int number;
    int curMin;
    
    public StackValue(int num, int min) {
      this.number = num;
      this.curMin = min;
    }
  }
  
  LinkedList<StackValue> array;
  
  public StackWithMinimum() {
    array = new LinkedList<StackValue>();
  }
  
  public int min() {
    return array.getLast().curMin;
  }
  
  public int pop() {
    StackValue sv = array.removeLast();
    return sv.number;
  }
  
  public void push (int value) {
    if (array.size() == 0) {
      StackValue sv = new StackValue(value, value);
      array.add(sv);
    } else {
      int lastMin = array.getLast().curMin;
      int newMin = lastMin < value ? lastMin : value;
      StackValue sv = new StackValue(value, newMin);
      array.add(sv);
    }
  }
  
  

}
