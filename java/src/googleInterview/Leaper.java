package googleInterview;

import java.awt.Point;
import java.util.LinkedList;

public class Leaper {

  public static void main(String[] args) {
    try {assert false;} catch (AssertionError e) {System.out.println("Assertions turned on");}
    
    
    isReachableLoop(1, 1, 4);
//    long startTime = System.currentTimeMillis();
//    for (int i = 1; i < 80; i++) {
//      for (int j = 1; j < 80; j++) {
//        for (int n = 3; n < 81; n++) {
////          assert reachable(i, j, n) == 
////              smartReachable(i, j, n) : 
////                i + " " + j + " " + n + "  " + reachable(i, j, n) + " " + smartReachable(i, j, n);
//          
//          assert smartReachable(i, j, n) == isReachableLoop(i, j, n) : i + " " + j + " " + n + " " + smartReachable(i, j, n) + " " + isReachableLoop(i, j, n);
//        }
//      }
//    }
//    long endTime = System.currentTimeMillis();
//    long totalTime = endTime-startTime;
//    System.out.println("test finished: " + totalTime);
    
    System.out.println("Big tests:");
    boolean sm = smartReachable(5, 6, 100000);
    System.out.println("loop test:");
    boolean rl = isReachableLoop(5, 6, 30000);
    assert  sm == rl : sm + " " + rl; 
    
    System.out.println("All went well");
  }

  
  
  static boolean isReachableLoop(int i, int j, int n) {
    boolean [][] grid = new boolean [n][n];
    
    LinkedList<Point> queue = new LinkedList<Point>();
    queue.add(new Point(0,0)); // starting position. 
    
    int nodesVisited = 0;
    while (queue.size() != 0) {
      Point pos = queue.removeFirst();

      if (pos.x >= 0 &&  pos.y >= 0 && pos.x < n && pos.y < n) {
        if (!grid[pos.x][pos.y]) {
          grid[pos.x][pos.y] = true;
          nodesVisited++;
          int i2 = i;
          int j2 = j;
          for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 2; b++) {
              queue.add(new Point(pos.x+i2, pos.y+j2));
              queue.add(new Point(pos.x+j2, pos.y+i2));
              i2 = -i2;
            }
            j2 = -j2;
          }
        }
      }
    }
    if (nodesVisited == (n * n)) {
      return true;
    } else {
      return false;
    }
  }
  


  // Smart hacky approach as per Knuth's Leaper Grpah conditions:
  static boolean smartReachable(int i, int j, int n) {
    int s = Math.max(i, j);
    int r = Math.min(i, j);
    // n > 2, ... (ii) n > 2s ... // (iii) n >= r+s
    if (n <= 2 || !(1 <= r && r <= s) || !(n >= 2*s) || !(n >= (r+s))) {
      return false;
    }
    // (i) r+s is relativley prime to r - s
    if (!relativelyPrime(r+s, Math.abs(r-s))) {
      return false;
    }
    return true;
  }
  /**
   * Relative prime if 1 is only common divisor between number i & j;
   * https://en.wikipedia.org/wiki/Coprime_integers
   */
  private static boolean relativelyPrime(int a, int b) {
    return gcd(a,b) == 1;
  }
  private static int gcd(int a, int b) {  //Euclidean's method of finding gcd.
    int t; 
    while(b != 0){
        t = a;
        a = b;
        b = t%b;
    }
    return a;
  }
  
  
  static boolean reachable(int i, int j, int n) {
    boolean grid[][] = new boolean[n][n];
    reachableHelper(0, 0, grid, i, j, n - 1);
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < n; y++) {
        if (!grid[x][y]) {
          return false;
        }
      }
    }
    return true;
  }

  static void reachableHelper(int x, int y, boolean[][] grid, int i, int j, int max) {
    if (x > max || y > max || x < 0 || y < 0 || grid[x][y]) {
      return;
    }
    grid[x][y] = true;
    int i2 = i;
    int j2 = j;
    for (int a = 0; a < 2; a++) {
      for (int b = 0; b < 2; b++) {
        reachableHelper(x + i2, y + j2, grid, i, j, max);
        reachableHelper(x + j2, y + i2, grid, i, j, max);
        i2 = -i2;
      }
      j2 = -j2;
    }
  }
}
