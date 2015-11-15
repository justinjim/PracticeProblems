package javaPracticeProb;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * '-ea' (enable asserts) should be added to run time configuration.
 * 
 * @author leo ufimtsev LeosPostBox@gmail.com
 */
public class DeduplicateAnArray {

  public static void main(String[] args) {

    int nums[] = {1, 1, 4, 3, 5, 2, 2, 5};
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));

    // Dedup an array.
    LinkedList<Integer> unums = new LinkedList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      // Last element.
      if (i == nums.length - 1) {
        unums.add(nums[i]); //add last element.
        break;
      }
      if (nums[i] == nums[i+1]) {
        continue;
      }
      unums.add(nums[i]);
    }
    System.out.println(unums);

  }
}
