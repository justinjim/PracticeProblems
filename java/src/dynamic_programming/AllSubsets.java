package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AllSubsets {

  public static void main(String[] args) {
    int nums [] = {1,2,3};
    // all subsets: 
    // (1) (2) (3) (1,2) (1,3) (2,3)
    
    //allSubsets(nums);
 
    // allSubSets(nums);
    ArrayList<Integer> nums2 = new ArrayList<Integer>(Arrays.asList(1,2,3));
    ArrayList<ArrayList<Integer>> subSets = getAllSets(nums2);
    for (int i = 0; i < subSets.size(); i++) {
      System.out.println(subSets.get(i).toString());
    }
  }

  
  /**
   * Each element can be a 'yes' or a 'no'.
   * 
   * like in binary
   * 00
   * 01
   * 10
   * 11 etc.. 
   * 
   */
  static  ArrayList<ArrayList<Integer>> getAllSets(ArrayList<Integer> set) {
    
    ArrayList<ArrayList<Integer>> outSets = new ArrayList<ArrayList<Integer>>();
    
    int subsetCount = (int) Math.pow(2, set.size());
    for (int i = 0; i < subsetCount; i++) {
      ArrayList<Integer> innerList = new ArrayList<Integer>();
      outSets.add(innerList);
      for (int j = 0; j < set.size(); j++) {
        if (bitSet(i, j)) {
          innerList.add(set.get(j));
        }
      }
    }
    return outSets;
  }
  
  static boolean bitSet(int val, int index) {
    return ((val & (1 << index )) != 0);
  }
  
  
  
  
  
  
  
  
  
  
  
  static void allSubSets(int[] nums) {
    ArrayList<Integer> currSet = new ArrayList<Integer>();
    ArrayList<Integer> chooseSet = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      chooseSet.add(nums[i]);
    }
    allSubSetsHelper(chooseSet, currSet);
  }
  
  static void allSubSetsHelper(ArrayList<Integer> chooseSet, ArrayList<Integer> currSet) {
    System.out.println(currSet);
    
    for (int i = 0; i < chooseSet.size(); i++) {
      // Select each element, add to current set.
      ArrayList<Integer> newCurSet = new ArrayList<Integer>(currSet);
      newCurSet.add(chooseSet.get(i));
      
      // Trailing set = all elements after that element.
      ArrayList<Integer> trailingSet = new ArrayList<Integer>();
      for (int j = i+1; j < chooseSet.size(); j++) {
        trailingSet.add(chooseSet.get(j));
      }
      
      //Recurse deeper
      allSubSetsHelper(trailingSet, newCurSet);
    }
  }

}
