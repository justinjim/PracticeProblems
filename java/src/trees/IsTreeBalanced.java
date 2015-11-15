package trees;


public class IsTreeBalanced {
  
  static class Node {
    Node left;
    Node right;
    int value;
    
    public Node(int val) {
      this.value = val;
    }
  }
    
    /** Find out if a tree is balanced. 
     * A balanced tree is defined to be a tree such that the 
     * heights of the two subtrees of any node never differ by more than one.A
     * 
     * Tree 1:  balanced. 
     *       5
     *    3     8
     *  2  4   7  6
     * 
     * Tree 2:  // balanced
     *        1
     *    2       3
     *  4   5        7
     *    10
     *     
     * Tree 3:   //not balanced at root.
     *        1
     *    2       3
     *  4   5        
     *    10
     
     * Tree 4: // not balanced on right.
     *        1
     *    2       3
     *  4   5        7
     *     10          11
     *    
     *    
     *    
     * @param args
     */

  public static void main(String[] args) {
    
    Node tree1 = new Node(5);
    tree1.left = new Node(3);
    tree1.left.left = new Node(2);
    tree1.left.right = new Node(4);
    tree1.right = new Node(8);
    tree1.right.left = new Node(7);
    tree1.right.right = new Node(6);
    
    
    Node tree2 = new Node(1);
    tree2.left = new Node(2);
    tree2.left.left = new Node(4);
    tree2.left.right = new Node(5);
    tree2.left.right.left = new Node(10);
    tree2.right = new Node(3);
    tree2.right.right = new Node(7);
    
    Node tree3 = new Node(1);
    tree3.left = new Node(2);
    tree3.left.left = new Node(4);
    tree3.left.right = new Node(5);
    tree3.left.right.left = new Node(10);
    tree3.right = new Node(3);

    
    Node tree4 = new Node(1);
    tree4.left = new Node(2);
    tree4.left.left = new Node(4);
    tree4.left.right = new Node(5);
    tree4.left.right.left = new Node(10);
    tree4.right = new Node(3);
    tree4.right.right = new Node(7);
    tree4.right.right.right = new Node(11);
    
    System.out.println("Tree 1 is balanced: " + isBalanced(tree1));
    System.out.println("Tree 2 is balanced: " + isBalanced(tree2));
    System.out.println("Tree 3 is balanced: " + isBalanced(tree3));
    System.out.println("Tree 4 is balanced: " + isBalanced(tree4));
  }
  
  static boolean isBalanced(Node node) {
    if (isBalancedCheck(node) >= 0) {
      return true;
    } else {
      return false;
    }
  }
  
  static int isBalancedCheck(Node node) {
  //base case.
    if (node == null) {
      return 0;
    }
    
    int leftDepth = isBalancedCheck(node.left);
    if (leftDepth == -1) {
      return -1;
    }
    int rightDpeth = isBalancedCheck(node.right);
    if (rightDpeth == -1) {
      return -1;
    }
    
    int diff = Math.abs(leftDepth - rightDpeth);
    if (diff > 1) {
      return -1;
    } else {
      return Math.max(leftDepth, rightDpeth) + 1;
    }
  }
  

}
