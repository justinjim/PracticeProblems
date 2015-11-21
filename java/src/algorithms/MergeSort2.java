package algorithms;

import java.util.Arrays;

public class MergeSort2 {

  public static void main(String[] args) {
    int nums [] =  {4,2,1,9,3,0};
    
    mergeSort(nums);
    System.out.println(Arrays.toString(nums));

  }
    
  static void mergeSort(int nums []) {
    int helper [] = new int[nums.length];
    mergeSortHelper(nums, helper, 0, nums.length -1);
  }
  
  static void mergeSortHelper(int nums [], int helper[], int low, int high) {
    if (high == low) {
      return;
    }
    if (high - low == 1) {
      if (nums[low] > nums[high]) {
        int tmplow = nums[low];
        nums[low] = nums[high];
        nums[high] = tmplow;
      }
      return;
    }
    
    int middle = (low+high) / 2;
    int rightIndex = middle+1;
    mergeSortHelper(nums, helper, low, middle);
    mergeSortHelper(nums, helper, rightIndex, high);
    merge(nums, helper, low, rightIndex, high);
  }
  
  static void merge (int nums [], int helper [], int aStart, int bStart, int high) {
    
    // copy range into helper.
    for (int i = aStart; i <= high; i++) {
      helper[i] = nums[i];
    }
    int a = aStart;
    int b = bStart;
    
    // Iterate over left & right side, copy smallest number into original. 
    for (int i = aStart; i <= high; i++) {
      // b++ high+1 should be first, otherwise uncaught exception can occur.
      if (a < bStart && (b == high+1 || helper[a] < helper[b])) {
        nums[i] = helper[a];
        a++;
      } else {
        nums[i] = helper[b];
        b++;
      }
    }
  }

}
