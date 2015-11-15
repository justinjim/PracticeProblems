package data_structures;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class comparableInterface {
  
  // Static so that we don't have to instantiate 'comparableInterface'.     
  public static class LeoPerson implements Comparable<LeoPerson>{
    final String name;
    final int age;
    
    public LeoPerson(String name, int age) {
      this.name = name;
      this.age = age;
    }
    
    public String toString() {
      String string = "meh";
      return name + " " + age;
    }
    
    @Override
    public int compareTo(LeoPerson p) {
      if (age < p.age)   return -1;
      if (age == p.age) return 0;
      return 1;
    }
  }

  public static void main(String[] args) {
    List<LeoPerson> personList = new LinkedList<LeoPerson>();
    
    personList.add(new LeoPerson("bob", 20));
    personList.add(new LeoPerson("mike", 24));
    personList.add(new LeoPerson("john", 16));
    personList.add(new LeoPerson("dan", 10));
    personList.add(new LeoPerson("julie", 23));
    personList.sort(null);
    Iterator itr = personList.iterator();
    while (itr.hasNext()) {
      LeoPerson person = (LeoPerson) itr.next();
      System.out.println(person.toString());
    }
    
    return;
  }
  
  

}
