package algorithms;

/**
 * '-ea' (enable asserts) should be added to run time configuration.
 * 
 *  Given an array of sorted numbers and a value, 
 *  return the index on which the value occurs.
 *  Run time is O(log n)
 *  
 * @author leo ufimtsev LeosPostBox@gmail.com
 *
 */
public class BinarySearch {
	static int comparisons = 0;

	public static void main(String[] args) {
		
		assert middle(0, 2) == 1 : 1;
		assert middle(1, 3) == 2 : 2;
		assert middle(0, 7) == 3 : 3;
		assert middle(3,7) == 5 : 5;
		assert middle(3,5) == 4 : 4;
		assert middle(2,4) == 3 : 3;
		
		// Test data structures.
		int simpleNumbers [] = {0, 1,2,3,4,5,6,7};
		int emptyNumbers [] = {};
		int messyNumbers [] = {1,5,7,9,12,14,20,21};
		
		//Test binary search. (My messy implementation. 
		for (int i = 0; i < 8; i++) {
			assert binarySearchLeo(simpleNumbers, i) == i : 0;
		}
		assert binarySearchLeo(simpleNumbers, -5) == -1;
		assert binarySearchLeo(simpleNumbers, 20) == -1;
		assert binarySearchLeo(emptyNumbers, 10) == -1;
		for (int i = 0; i < messyNumbers.length; i++) {
			assert binarySearchLeo(messyNumbers, messyNumbers[i]) == i;
		}
		
		//Test binary search Better
		for (int i = 0; i < 8; i++) {
			assert binarySearchBetter(simpleNumbers, i) == i : 0;
		}
		assert binarySearchBetter(simpleNumbers, -5) == -1;
		assert binarySearchBetter(simpleNumbers, 20) == -1;
		assert binarySearchBetter(emptyNumbers, 10) == -1;
		for (int i = 0; i < messyNumbers.length; i++) {
			assert binarySearchBetter(messyNumbers, messyNumbers[i]) == i;
		}
		
		System.out.println("All went well");
	}
	
	// Run time: O(log n)
	static int binarySearchLeo (int [] array, int value) {
		comparisons = 0;
		//case where array is of len 0
		if (array.length == 0)
			return -1;
		//case where array is of len 1
		if (array.length == 1) {
			if (value == array[0])
				return 0;
			else 
				return -1;
		}
			
		int upper = array.length - 1;
		int lower = 0;
		while (true) {
					comparisons++;
			// Case where u - l = 1.
			if (upper - lower == 1) {  //e.g (0,1), (5,6), have no middle value.
				if (value == array[upper]) {
					return upper;
				} else if (value == array[lower]){
					return lower;
				} else {
					return -1;
				}
			}
			
			int mid = middle(upper, lower);
			if (value == array[mid]) {
				return mid;
			} else if (value < array[mid]) {
				upper = mid;
			} else {
				lower = mid;
			}
		}
	}
	
	// I should practice this before Google Interview.
	static int binarySearchBetter (int [] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = hi - (hi - lo )/2;
			if 		(key == arr[mid]) return mid;
			else if (key < arr[mid]) hi = mid - 1; //-1 to avoid comparing mid again.
			else if (key > arr[mid]) lo = mid + 1; //+1 to avoid comparing mid again.
		}
		return -1;
	}
	
	
	
	// Run time = O(n)
	static int loopSearch(int array [], int value) {
		for (int i = 0; i < array.length; i++) {
		if (value == array[i]) {
			return i;
		}
	}
	return -1;
	}
	
	
	static int middle (int a, int b) {
		//ensure a < b.
		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		int diff = b - a;
		int res = a + (diff / 2);
		return res;
	}

}
