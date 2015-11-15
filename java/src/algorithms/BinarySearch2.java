package algorithms;

public class BinarySearch2 {

  public static void main(String[] args) {
    int nums [] = {1,5,6,7,8,9,10,14,16};
    
    int nums2[] = {0,1,2,3,4};
 
    assert binarySearch(nums2, 0) == 0;
    assert binarySearch(nums2, 1) == 1;
    assert binarySearch(nums2, 2) == 2;
    assert binarySearch(nums2, 3) == 3;
    
    assert binarySearch(nums, 6) == 2;
    assert binarySearch(nums, 5) == 1;
    assert binarySearch(nums, 1) == 0;
    assert binarySearch(nums, 10) == 6;

    System.out.println("All went well.");
    

  }
  
  static int binarySearch(int nums[], int val) {
    int upperi = nums.length-1;
    int loweri = 0;
    
    //0  4
    while (loweri <= upperi) {
      // int midi = upperi - (upperi - loweri)/2;  //2
      int midi = (loweri+upperi)/2; //more simple way.
      
      if (nums[midi] == val) {
        return midi;
      } else if (nums[midi] < val) {
        loweri = midi+1;
      } else if (nums[midi] > val) {
        upperi = midi-1;
      }
    }
    return -1;
  }

}
