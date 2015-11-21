package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class ChildStepJumper {
  
  static int possibilityCount;
  static int recursiveCalls;

  /*
   * 
   * 9.1 A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. 
   * Implement a method to count how many possible ways the child can run up the stairs.
   */
  public static void main(String[] args) {
    possibilityCount = 0;
    recursiveCalls = 0;
    int steps = 33;
    // bfStepCounterBF(steps);  // Brute force.
    // stepCounter(steps);
    // System.out.println("Possibilities: " + possibilityCount);
    // System.out.println("calculated: " + rawStepCounter(steps));
    
    // At 33 steps. Without caching: 398845537  with caching: 33 calls.
    System.out.println("Smart calc: " + smartStepCounter(steps));
    System.out.println("Recursive calls: " + recursiveCalls);
  }

  
  public static int smartStepCounter (int steps) {
    Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    return sStepCountHelper(steps, cache);
    
  }
  
  public static int sStepCountHelper(int steps, Map<Integer, Integer> cache) {
    if (steps < 0) {
      return 0;
    } if (steps == 0) {
      return 1;
    } else {
      if (cache.containsKey(steps)) {
        return cache.get(steps);
      }
      recursiveCalls++;
      int result = sStepCountHelper(steps -1, cache) +
          sStepCountHelper(steps -2, cache) + sStepCountHelper(steps -3, cache);
      cache.put(steps, result);
      return result;
    }
  }
  
  
  public static int rawStepCounter(int steps) {
   if (steps == 1) {
     return 1;
   } else if (steps == 2) {
     return 2;
   } else if (steps == 3) {
     return 4;
   }
   int one = 0;
   int two = 0;
   int three = 0;
   if (steps >= 1) {
     one = rawStepCounter(steps-1);
   }
   if (steps >= 2) {
     two = rawStepCounter(steps-2);
   } 
   if (steps >= 3) {
     three = rawStepCounter(steps -3);
   }
   

   return one + two + three;
  }
  
  
  
  
  
  /** Elegant way, use a single array.
   * 
   * @param steps
   */
  public static void printAllSteps(int steps) {
    if (steps <= 0) {
      return;
    }
    
    int curPos = 0;
    int lastStepIndex = steps;
    
    int stepPath [] = new int [steps];
    int pathIndex = 0;
    printStepHelper(curPos, lastStepIndex, stepPath, pathIndex);
    
  }
  
  public static void printStepHelper(int curPos, int lastPos, int stepPath [], int curPathIndex) {
    if (curPos == lastPos) {
      possibilityCount++;
      for (int i = 0; i < curPathIndex; i++) {
         System.out.print(stepPath[i] + " ");
      }
      System.out.println("");
      return;
    }
    
    // if 1 step possible, do 1 step.
    if (curPos + 1 <= lastPos) {
      //Add a step.
      stepPath[curPathIndex] = 1;
      printStepHelper(curPos+1, lastPos, stepPath, curPathIndex+1);
    }
    if (curPos + 2 <= lastPos) {
      stepPath[curPathIndex] = 2;
      printStepHelper(curPos+2, lastPos, stepPath, curPathIndex+1);
    }
    if (curPos + 3 <= lastPos) {
      stepPath[curPathIndex] = 3;
      printStepHelper(curPos+3, lastPos, stepPath, curPathIndex+1);
    }
  }
}
