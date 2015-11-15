package algorithms;

import java.util.Arrays;

/**
 * '-ea' (enable asserts) should be added to run time configuration.
 *  
 * @author leo ufimtsev LeosPostBox@gmail.com
 * 
 * Resources:
 * http://java2novice.com/java-sorting-algorithms/merge-sort/
 *
 */
public class MergeSort {
	static int comparisons = 0;

	public static void main(String[] args) {
					// 0 1 2 3 4
		int nums1 [] = {1,3,2,4};
		int nums2[] = {1,4,3,2,6};
		int nums3[] = {38, 27, 43, 3, 9, 82, 10};
		int nums4 [] = {};
		int nums5 [] = {3,2,1};
		int nums6 [] = {3,2,2,1};
		
		
		System.out.println(Arrays.toString(mergeSort(nums1)));
		System.out.println(Arrays.toString(mergeSort(nums2)));
		System.out.println(Arrays.toString(mergeSort(nums3)));
		System.out.println(Arrays.toString(mergeSort(nums4)));
		System.out.println(Arrays.toString(mergeSort(nums5)));
		System.out.println(Arrays.toString(mergeSort(nums6)));
		
	}
	
	static int [] mergeSort (int nums []) {
		doMergeSort(nums, 0, Math.max(nums.length-1, 0));
		return nums;
	}
	
	static void doMergeSort(int nums[], int from, int to) {
		int range = to - from;
		//Base case: 1 element (return)
		if (range == 0)
			return;
		//Base case: 2 elements (fix order)
		if (range == 1) {
			if (nums[from] > nums[to]) {
				int tmp = nums[from];
				nums[from] = nums[to];
				nums[to]= tmp;
				return;
			}else 
				return;
		}
		
		//Otherwise: 
		//Split array into parts, sort each part
		int midleft = to - (to - from)/2 - 1;  //e.g  3,0, mid = 1 // e.g 4,7 = 5,
		doMergeSort(nums, from, midleft);
		doMergeSort(nums, midleft+1, to);
		//merge parts
		merge(nums, from, midleft+1, to);
	}
	
	
	//Threre is probably a more elegant way to write this.
	static void merge(int [] nums, int a, int b, int end) {
		int originalA = a;
		int originalB = b;
		int outLen = end -a + 1;
		int out[] = new int [outLen];
		boolean bEnd = false;
		for (int i = 0; i < (outLen); i++) {
			if ((bEnd || nums[a] < nums[b]) && a < originalB)	{
				out[i] = nums[a];
				a++;
			} else {
				out[i] = nums[b];
				b++;
				if (b > end)
					bEnd = true;
			}
		}
		for (int i = 0; i < (outLen);i++, originalA++) {
			nums[originalA] = out[i];
		}
		
		
		return;
		// In place sort is complicated, have to 'bubble up' after a swap.
	}
}
