/* Main.java(H6)
 * Written by Vincent Zelinsky
 * 
 * Contains the methods to test trees
 */
public class Main {
  public static void main(String[] args) {
    Tree myTree = new Tree();
    myTree.insertNode("Sarah");
    myTree.insertNode("Bart");
    myTree.insertNode("Al");
    myTree.insertNode("Zach");
    myTree.insertNode("Alberto");
    myTree.insertNode("Alberto");
    myTree.insertNode("Alberto");
    myTree.insertNode("Alberto");
    myTree.insertNode("Sarah");
    myTree.printInOrder();
    System.out.println(myTree.getRoot().getCount());
  }
}