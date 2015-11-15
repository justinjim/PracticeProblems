package javaPracticeProb;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapExamples {

  public static void main(String[] args) {
    
    
    HashMap hm = new HashMap();
    hm.put("Leo", 20);
    hm.put("John", 50);
    hm.put("Marry", 30);
    hm.put("Goldy", 70);
    System.out.println(hm);
    
    System.out.println(hm.containsKey("Leo"));
    System.out.println(hm.get("Leo"));
    hm.remove("John");
    System.out.println(hm);
    
    //Iterate over Keys
    Iterator hitr = hm.keySet().iterator();
    while (hitr.hasNext()){
      System.out.println(hitr.next());
    }
    
    //Iterate over values. 
    Iterator vitr = hm.values().iterator();
    while (vitr.hasNext()) {
      System.out.println(vitr.next());
    }
    
    
  }
  

}
