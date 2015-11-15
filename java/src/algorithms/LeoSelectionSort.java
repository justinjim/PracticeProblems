package algorithms;

import java.util.Arrays;

/**
 * Note, ineffective compared to other algorithms, but simple.
 * @author lufimtse
 *
 */
public class LeoSelectionSort {

  public static void main(String[] args) {
    int nums [] = {3,5,4,1,8,10};
    for (int i = 0; i < nums.length; i++) {
      for (int j = i+1; j < nums.length; j++) {
        if (nums[j] < nums[i]) {
          swap(nums, i, j);
        }
      }
    }
    System.out.println(Arrays.toString(nums));

  }
  static void swap(int nums[], int i, int j) {
    int tmpi = nums[i];
    nums[i] = nums[j];
    nums[j] = tmpi;
  }

}
