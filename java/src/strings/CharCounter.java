package strings;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CharCounter {

  public static void main(String[] args) {
    String str = "hello world";
    Map <Character, Integer> letterCount = new TreeMap<Character, Integer>();
    for (int i = 0; i < str.length(); i++) {
       Integer count = letterCount.get(str.charAt(i));
       if (count == null) {
         count = 1;
       } else {
         count++;
       }
       letterCount.put(str.charAt(i), count);     
    }
    
    for (Entry<Character, Integer> entry : letterCount.entrySet()) {
      Character key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println(" Letter: " + key + "  is listed:" + value + " times");
    }

  }

}
