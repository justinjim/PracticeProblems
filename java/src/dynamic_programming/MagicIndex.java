package dynamic_programming;

public class MagicIndex {

  public static void main(String[] args) {
    int magicArray [] = {-4,-2,-1,1,2,5,7,8,10,15}; // 5 is magic index.
    System.out.println(findMagicIndex(magicArray));
  }
  public static int findMagicIndex (int nums []) {
    int upperIndex = nums.length -1;
    int lowerIndex = 0;
    
    while (lowerIndex <= upperIndex) {
      int middleIndex = (upperIndex+lowerIndex) /2 ;
      if (nums[middleIndex] == middleIndex) {
        return  middleIndex;
      } else if (nums[middleIndex] < middleIndex) {
        lowerIndex = middleIndex + 1;
      } else {
        upperIndex = middleIndex -1;
      }
    }
    return -1;
  }
}
