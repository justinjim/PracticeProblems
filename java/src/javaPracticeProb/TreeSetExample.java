package javaPracticeProb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
  
  public static void main(String[] args) {
    
    //--- Trees
    System.out.println("Trees sets are auto-sorted.");
    Set<Integer> mytree = new TreeSet<Integer>();
    mytree.add(5);
    mytree.add(1);
    mytree.add(3);
    mytree.add(6);
    mytree.add(8);
    mytree.add(20);
    Iterator<Integer> myit = mytree.iterator();
    while (myit.hasNext()) {
      System.out.print(myit.next() + " ");
    }
    System.out.println("");
    
    System.out.println(mytree.contains(6));
    
    
    System.out.println("Reverse Traversal of a List");
    List <Integer> mylist = new ArrayList<Integer>();
    for (int i = 0; i < 20; i = i + 2) {
      mylist.add(i);
    }
    
    ListIterator<Integer> listIt = mylist.listIterator(mylist.size());
    while (listIt.hasPrevious()) {
      System.out.print(listIt.previous() + " ");
    }
    System.out.println("");
    
    
    System.out.println("Deduplicate an array via a hash set:");
    int nums[] = {1,5,2,2,7,8,2,78,9,3,2};
    Set<Integer> hashSet = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      hashSet.add(nums[i]);
    }
    System.out.println(hashSet.toString());
    
    
    return;
  }
  
}
