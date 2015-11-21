package dynamic_programming;

import java.util.ArrayList;

public class AllPermutationsOfString {

  /** 9.5 Write a method to compute all permutations of a string.
   * 
   * @param args
   */
  public static void main(String[] args) {
    String Leo = "Hello";
    ArrayList<StringBuilder> perms = getPermutations(Leo);
    System.out.println(perms.toString());
 
  }
  
  static ArrayList<StringBuilder> getPermutations(String str) {
    StringBuilder next = new StringBuilder();
    StringBuilder nextChooseSet = new StringBuilder(str);
    ArrayList<StringBuilder> permutations  = new ArrayList<StringBuilder>();
    getPermutationsHelper(next, nextChooseSet, permutations);
    return permutations;
  }
  
  static void getPermutationsHelper(StringBuilder curr, StringBuilder chooseSet, ArrayList<StringBuilder> perms) {
    if (chooseSet.length() == 0) {
      perms.add(curr);
    }
    for (int i = 0; i < chooseSet.length(); i++) {
      StringBuilder next = new StringBuilder(curr);
      next.append(chooseSet.charAt(i));
      StringBuilder nextChoose = new StringBuilder(chooseSet);
      nextChoose.deleteCharAt(i);
      getPermutationsHelper(next, nextChoose, perms);
    }
  }

}
