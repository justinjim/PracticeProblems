package javaPracticeProb;

import java.util.Iterator;
import java.util.TreeMap;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class TreeMapExamples {

  public static void main(String[] args) {
    TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
    tm.put(1, "leo");
    tm.put(2, "John");
    tm.put(2, "mike");
    tm.put(3, "hola");
    System.out.println(tm);
    
    System.out.println(tm.get(1));
    System.err.println(tm.containsKey(2));
    System.out.println(tm.containsValue("leo"));
    
    System.out.println("Pint all keys:");
    Iterator itr = tm.keySet().iterator();
    while (itr.hasNext()) {
      System.out.print(itr.next());
    }
    
    System.out.println("Print all values");
    Iterator itr2 = tm.values().iterator();
    while (itr2.hasNext()) {
      System.out.println(itr2.next());
    }
    
    System.out.println("getting certain values: ");
    System.out.println("Keys: "  + tm.firstKey() + " " + tm.lastKey());
    
    System.out.println("Entries: " + tm.firstEntry() + " " + tm.lastEntry());
    
  }

}
