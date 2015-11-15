package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LeoQuickSort {

  public static void main(String[] args) {
    Integer nums [] = {1,5,4,2,7,4,5,8,9,66,3,1,23,1,23,12,11,81};
    List<Integer> numsL = new ArrayList <Integer>(Arrays.asList(nums));
    
    numsL = leosQuickSort(numsL);
    System.out.println(numsL);
    
  }
  
  static List<Integer> leosQuickSort(List<Integer> list) {
    //base cases
    if (list.size() == 0 || list.size() == 1) {
      return list;
    }
    
    //Split arrays, recurse.
    int pivotIndex = randNum(list.size() - 1);
    List<Integer> leftList = new ArrayList<Integer>(); //left list
    List<Integer> rightList = new ArrayList<Integer>(); //right list.
    for (int i = 0; i < list.size(); i++) {
      if (i == pivotIndex) {
        continue;
      }
      if (list.get(i) < list.get(pivotIndex)) {
        leftList.add(list.get(i));
      } else {
        rightList.add(list.get(i));
      }
    }
    List <Integer> ra = new ArrayList<Integer> ();
    ra.addAll(leosQuickSort(leftList));
    ra.add(list.get(pivotIndex));
    ra.addAll(leosQuickSort(rightList));
    return ra;
    
    
  }
  
  static int randNum(int upper) {
     Random rand = new Random();
     return rand.nextInt(upper);
  }

}
