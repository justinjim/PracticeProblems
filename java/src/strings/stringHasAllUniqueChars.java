package strings;

import java.util.Map;
import java.util.TreeMap;

public class stringHasAllUniqueChars {

  public static void main(String[] args) {
   String str = "hello world";
   Map<Character, Integer> map = new TreeMap<Character, Integer>();
   for (int i = 0; i < str.length(); i++) {
     Integer value = map.get(str.charAt(i));
     if (value == null) {
       value = 1;
       map.put(str.charAt(i), value);
     } else  {
       System.out.println(str.charAt(i) + " is found to be duplicate");
     }
   }
  }
}
