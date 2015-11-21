package mathy;

public class IsPrime {

  public static void main(String[] args) {
    
    assert isPrime(2);
    assert isPrime(3);
    assert !isPrime(4);
    assert isPrime(5);
    assert !isPrime(6);
    assert isPrime(7);
    assert !isPrime(8);
    assert !isPrime(9);
    assert !isPrime(10);
    assert isPrime(11);
    assert !isPrime(12);
    assert isPrime(13);
    
    System.out.println("All went well. Running long check...");
    
    for (int i = 1; i < 100000; i++) {
      if (isPrime(i)) {
        System.out.println(" Found prime: " + i);
      }
    }
    
    
    return;
  }
  
  
  // Prime number = not divisible. 
  public static boolean isPrime(int x) {
    for (int i = 2; i < x; i++) {
      if (x % i == 0) {
        return false;
      }
    }
    return true;
  }

}
