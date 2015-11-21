
package bitops;





public class BitInserter_MandN {

  public static void main(String[] args) {
    int n = 0b10000000000;
    int m = 0b10011;
    int i = 2;
    int j = 6;
    int result = insertMIntoN(n, m, i, j);
    BitOperations.printIntAsBinaryString(result); // 10001001100    OK.
  }
  
  public static int insertMIntoN(int n, int m, int i, int j) {
    int output = n;
    for (int k = i; k <= j; k++) {
      boolean isTrue = getBitAt(m, k-i);
      output = setBitAt(output, k, false); //clear existing.
      output = setBitAt(output, k, isTrue);
    }
    return output;
  }
  
  static boolean getBitAt(int val, int i) {
    return ((val & (1 << i)) !=0);
  }
  
  public static int setBitAt(int n, int i, boolean set) {
    if (set) {
      return (n | (1 << i));
    } else {
      return (n & ~(1 << i));
    }
  }
  
  

}
