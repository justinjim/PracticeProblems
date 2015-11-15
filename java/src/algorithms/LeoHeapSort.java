package algorithms;

import java.util.Arrays;

/**
 * Based on:
 * https://www.youtube.com/watch?v=JhCe8nhndPA
 * But with index at 0.
 * Parent = floor (  (i-1)  /2  )
 * left child = parent*2 + 1
 * right child = parent*2 + 2
 * @author lufimtse
 *
 */
public class LeoHeapSort {
  public static void main(String[] args) {
      
    int nums [] = {3,5,8,7,1,13,11,15,6};
    heapSort(nums);
    
    //Test validity of sort.
    int expectedNums [] = {1, 3, 5, 6, 7, 8, 11, 13, 15};
    assert Arrays.equals(nums, expectedNums);
    
    System.out.println("All is well");
  }

  private static void heapSort(int[] nums) {
    heapify(nums);
    
    //Test that heapify worked well. 
    int expectedNumsAfterHeapify [] = {15, 7, 13, 6, 1, 8, 11, 5, 3};
    assert Arrays.equals(nums, expectedNumsAfterHeapify);
   
    for (int last = nums.length-1; last >= 0; last--) {
      swap(nums, last, 0);
      int lastItemOfHeap = last -1;  //Note, we don't want to heapify down to last element that we swapped into.
      maxHeapify(nums, 0, lastItemOfHeap);
    }
    System.out.println(Arrays.toString(nums));
  }
  
  static void heapify(int nums[]) {
    
    // For every node with children (I.e starting in the middle) in reverse order, 
    // max-heapify things up.
    int lastElement = nums.length - 1;
    int middle = (lastElement-1) /2;    // Floor applied by integer devision.
    for (int i = middle; i >= 0; i--) {
         maxHeapify(nums, i, lastElement);
    }
    
  }
  
  static void maxHeapify(int nums[], int parentIndex, int lastItem) {
    //Child is at first left, but can change to right child if right is bigger.
    int childIndex = leftChildIndex(parentIndex); //left child as default.
    
    //continue while not at the end of list without recursion:
    while (childIndex <= lastItem) {
    
      //Identify biggest child. (right or left child) (ensuring right child exists).
      if (rightChildIndex(parentIndex) <= lastItem &&
         leftChild(nums, parentIndex) < rightChild(nums, parentIndex)) {
        childIndex = childIndex+1;
      }

      //See if child is bigger than parent.
      if (nums[childIndex] > nums[parentIndex]) {
        //Swap parent and child.
        swap(nums, parentIndex, childIndex);
      }
      
      //Go deeper
      parentIndex = childIndex;
      childIndex = leftChildIndex(parentIndex);
    } 
  }
  
  static int leftChild (int nums[], int parentIndex) {
    return nums[leftChildIndex(parentIndex)];
  }
  
  static int rightChild (int nums[], int parentIndex) {
    return nums[rightChildIndex(parentIndex)];
  }
  
  static int leftChildIndex(int parent) {
    return parent*2 + 1;
  }
  
  static int rightChildIndex(int parent) {
    return parent*2 + 2;
  }
  
  static void swap(int nums[], int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }
  
}
