package dynamic_programming;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RobotWalker {
  
  
  static class Pos {
    int x;
    int y;
    public Pos (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean biggerThan(Pos p) {
      if (x > p.x || y > p.y) {
        return true;
      } else {
        return false;
      }
    }

    
    @Override
    public boolean equals(Object obj) {
      if (obj == null) return false;
      if (this == obj) return true;
  
      Pos pos = (Pos) obj;
      if (x == pos.x && y == pos.y) {
        return true;
      }
      return false;
    }
    
    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + x;
      result = prime * result + y;
      return result;
    }
  }

  /*
   * 9.2 Imagine a robot sitting on the upper left corner of an X by Y grid. 
   * The robot can only move in two directions: right and down. How many possible 
   * paths are there for the robot to go from (0,0) to (X,Y)?
FOLLOW UP
Imagine certain spots are "off limits," such that the robot cannot step on them.
Design an algorithm to find a path for the robot from the top left to the bottom right.
   */
  public static void main(String[] args) {
    
    Set <Pos> cache = new HashSet<Pos>();
    cache.add(new Pos(1, 1));
    System.out.println(cache.contains(new Pos(1, 1)));
    
    for (int i = 0; i < 1000; i++) {
      Pos dest = new Pos(i,i);
      long startTime = System.currentTimeMillis();
      BigInteger pathCount = pathCalc(dest);
      long endTime = System.currentTimeMillis();
      long timeTaken = endTime-startTime;
      System.out.println("i: " + i + " Paths :" + pathCount + " Run time: " + timeTaken);
      if (timeTaken > 120) {
        System.out.println("Too long!");
        break;
      }
    }
    
    // 15 = 155117520
    return;
  }
  
  public static BigInteger pathCalc(Pos dest) {
    Pos curr = new Pos(0, 0);
    Map <Pos, BigInteger> cache = new HashMap<Pos, BigInteger>();
    return pathCalcHelper(curr, dest, cache);
  }

  private static BigInteger pathCalcHelper(Pos curr, Pos dest, Map <Pos,BigInteger> cache) {
    if (curr.equals(dest)) {
      return new BigInteger("1");
    }
    if (curr.biggerThan(dest)) {
      return new BigInteger("0");
    }
    if (cache.containsKey(curr)) {
      return cache.get(curr);
    }
    Pos down = new Pos(curr.x, curr.y + 1);
    Pos right = new Pos(curr.x + 1, curr.y);
    BigInteger downCall = pathCalcHelper(down, dest, cache);
    BigInteger rightCall = pathCalcHelper(right, dest, cache);
    BigInteger pathCount = downCall.add(rightCall);
    cache.put(curr, pathCount);
    return pathCount;
  }
  

}
