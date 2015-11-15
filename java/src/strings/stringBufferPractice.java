package strings;

public class stringBufferPractice {

  public static void main(String[] args) {
    // StringBuffer is used for concatination of strings. 
    
    String str1 = "hello ";
    String str2 = "World! ";
    String str3 = "What is does it mean to be human?";
    
    StringBuffer combined = new StringBuffer(); 
    combined.append(str1);
    combined.append(str2);
    combined.append(str3);
    combined.insert(5, " meh");
    System.out.println(combined);
    System.out.println();
  }

}
