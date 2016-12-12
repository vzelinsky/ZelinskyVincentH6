/* Main.java(H6)
 * Written by Vincent Zelinsky
 * 
 * Contains the methods to test Trees.java
 */
public class Main {
  public static void main(String[] args) {
    //Creates a Tree called myTree
    Tree myTree = new Tree();
    
    //Tests insertNode method
    //Adds Nodes to test structure and ordering
    myTree.insertNode("Sarah");
    myTree.insertNode("Bart");
    myTree.insertNode("Al");
    myTree.insertNode("Zach");
    myTree.insertNode("Alberto");
    myTree.insertNode("Alberto");
    myTree.insertNode("Alberto");
    myTree.insertNode("Alberto");
    myTree.insertNode("Sarah");
    
    //Tests printInOrder method
    System.out.println("Prints Tree in order:");
    myTree.printInOrder();
    
    System.out.println("-----------------------");
    
    //Tests find method
    //Tests count field
    System.out.println("Tests count on Alberto:");
    System.out.println(myTree.find("Alberto").getCount());
    
    System.out.println("-----------------------");
    
    //Tests importTxt method
    myTree.importTxt();
    
    System.out.println("-----------------------");
    
    //Tests printFrequencyHist method
    System.out.println("Frequency Histrogram of example.txt:");
    myTree.printFrequencyHist();
  }
}