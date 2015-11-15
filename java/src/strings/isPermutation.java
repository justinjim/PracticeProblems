package strings;

import java.util.HashMap;
import java.util.Map;

public class isPermutation {

  public static void main(String[] args) {
    // Find out if one string is a permutation of another.
    // For this, each string needs to have an equal amount of characters. 
    
    String str1 = "hello wordl";
    String str2 = "world hello";
    
    if (str1.length() != str2.length()) {
      System.out.println("Not permutations");
      return;
    }
    
    HashMap<Character, Integer> str1Set = charCounter(str1);
    HashMap<Character, Integer> str2Set = charCounter(str2);
    
    if (hasAllTheChars(str1Set, str2Set) && hasAllTheChars(str2Set, str1Set)) {
      System.out.println("Strings are permutations of each other");
    } else {
      System.out.println("Strings are not permutations of each other");
    }
  }
  
  
  static boolean hasAllTheChars(HashMap<Character, Integer> set1, HashMap<Character, Integer> set2) {
    boolean permutation = true;
    for (Map.Entry<Character, Integer> entry : set1.entrySet()) {
      Character cr = entry.getKey();
      Integer value = entry.getValue();
      Integer value2 = set2.get(cr);
      if (value != value2) {
        permutation = false;
        break;
      }
    }
    
    if (permutation) {
      return true;
    } else {
      return false;
    }
  }
  
  
  static HashMap<Character, Integer> charCounter (String str) {
    
    HashMap<Character, Integer> charset = new HashMap<Character, Integer>();
    for (int i = 0; i < str.length(); i++) {
      Integer value = charset.get(str.charAt(i));
      if (value == null) {
        value = 1;
      } else {
        value++;
      }
      charset.put(str.charAt(i), value);
    }
    return charset;
  }

}
