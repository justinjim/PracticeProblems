package bitops;


public class BitOperations {

  public static void main(String[] args) {
    
    int one = 1;
    int two = 2;
    int three = 3;
    int four = 4;
    int five = 5;
    
    printIntAsBinaryString(four);
    System.out.println("");
    
    int seven = setBit(five, 1);
    System.out.print(seven+ " : ");
    printIntAsBinaryString(seven);
    
  }

  public static void printIntAsBinaryString(int five) {
    for (int i = Integer.SIZE-1; i >= 0; i--) {
      if ((i+1) % 8 == 0 && i != 0) {
        System.out.print(" ");
      }      
      System.out.print(getBit(five, i));
    }
  }
  
  public static int getBit(int value, int index) {
    // shift right, and with 1. 
    return ((value >> index) & 1);
  }
  
  public static boolean getBitBoolean(int value, int index) {
    return ((value & (1 << index)) != 0);
  }
  
  public static int setBit(int value, int index) {
    return value | (1 << index);
  }
  
  public static int clearBit(int value, int index) {
    return value & ~(1 << index);
  }
  
  
  public static int setBitSelect(int value, int index, boolean setBint) {
    if (setBint) {
      return value | (1 << index);
    } else  {
      return value & ~(1 << index);
    }
  }

}
