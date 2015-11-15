package data_structures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Remove duplicates by keeping track of values in a hashmap.
 * @author lufimtse
 *
 */
public class RemoveDuplicateInLinkedList {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<Integer>(Arrays.asList(1,6,5,3,2,5,3,1,5,6,9));
    Set<Integer> dupTracker = new HashSet<Integer>();
    Iterator<Integer> iterator = ll.iterator();
    while (iterator.hasNext()) {
      Integer val = iterator.next();
      if (dupTracker.contains(val)) {
        iterator.remove();
      } else {
        dupTracker.add(val);
      }
    }
    System.out.println(ll);
  }

}
