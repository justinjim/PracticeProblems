package strings;

public class spaceReplacer {

  /**
   * Given a string like "Hello world today" replace spaces with %20.
   * @param args
   */
  public static void main(String[] args) {
    String str = "hello world today";
    
    
    int spaceCount = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        spaceCount++;
      }
    }
    char chararray [] = new char[str.length() + spaceCount*2];
    // cost: n

    for (int i = 0, j = 0; i < str.length(); i++, j++) {
      if (str.charAt(i) != ' ') {
        chararray[j] = str.charAt(i);
      } else {
        chararray[j] = '%';
        chararray[j+1] = '2';
        chararray[j+2] = '0';
        j = j+2;
      }
    }
    System.out.println(chararray);

  }

}
