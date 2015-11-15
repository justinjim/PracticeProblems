package trees;

public class TreeTraversal {
  
  static class Node {
    Node left;
    Node right;
    int value;
    
    public Node(int val) {
      this.value = val;
    }
  }
  
  /*
   * Tree 1:
   *       5
   *    3     8
   *  2  4   7  6
   */
  
  public static void main(String args[]) {
    
    Node tree1 = new Node(5);
    tree1.left = new Node(3);
    tree1.left.left = new Node(2);
    tree1.left.right = new Node(4);
    tree1.right = new Node(8);
    tree1.right.left = new Node(7);
    tree1.right.right = new Node(6);
    inOrder(tree1);
   
    
    int nums [] = {0,1,2,3,4,5,6};
    Node tree2 = makeBinaryTree(nums);
    
    
    int nums2[] = {0,1,2,3,4};
    Node tree3 = makeBinaryTree(nums2);
    
    System.out.println("meh");
    
  }
  
  static Node makeBinaryTree(int nums[]) {
    if (nums.length == 0) {
      return null;
    }
    int upper = nums.length-1;
    int lower = 0;    
    return makeBinaryTreeHelper(nums, lower, upper);
  }
  
  static Node makeBinaryTreeHelper(int nums[], int min, int max) {
    // Base case = leaf.
    if (min == max) {
      return new Node(min);
    }
    
    int middle = max - (max-min)/2;
    Node node = new Node(nums[middle]);
    
    if (middle != min) {
      node.left = makeBinaryTreeHelper(nums, min, middle-1);
    }
    if (middle != max) {
      node.right = makeBinaryTreeHelper(nums, middle+1, max);
    }
    return node;
  }
  
  
  
  
  static void inOrder(Node node) {
    if (node.left != null) {
      inOrder(node.left);
    } 
    System.out.println("At node: " + node.value);
    if (node.right != null) {
      inOrder(node.right);
    }
  }
  
  /* This is not a binary tree thou. Just a regular tree. Caution advised.
   * 
   */
  static Node makeTree(int [] nums, int currPos) {
    int lastElement = nums.length-1;
    if (currPos > lastElement) {
      return null;
    }
    
    // Make node.
    Node node = new Node(nums[currPos]);
    
    // Left child. 
    int leftChildIndex = currPos*2 + 1;
    if (leftChildIndex <= lastElement) {
      node.left = makeTree(nums, leftChildIndex);
    }
    
    // Right child.
    int rightChildIndex = currPos*2 + 2;
    if (rightChildIndex <= lastElement) {
      node.right = makeTree(nums, rightChildIndex);
    }
    
    return node;
  }

}
