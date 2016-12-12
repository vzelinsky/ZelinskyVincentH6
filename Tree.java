/* Tree.java
 * Written by Vincent Zelinsky
 * 
 * Contains the necessary methods to create a Tree, interacts with Node.java
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Tree {
  //Private fields
  //Contains a reference to the root Node object
  private Node root;
  private Node current;
  
  //Constructors
  //No argument constructor that when called creates an empty List
  public Tree() {
    //Sets root to null
    this.root = null;
    this.current = null;
  }
  
  //Methods
  //Getter methods
  //Returns the reference to the Node stored at head
  public Node getRoot() {
    return root;
  }
  public Node getCurrent() {
    return current;
  }
  
  //addNode method
  /* Adds a Node to the Tree in order
   * Compares Strings of pre-existing Nodes with the String passed in the argument with the compareTo method
   * Sorts where the new Node should go depending on the output returned by compareTo and its relationship to 0
   */ 
  public void insertNode(String data) {
    Node node = new Node(data,null,null);
    if (root == null) {
      root = node;
    }
    else if(root.getData().compareTo(node.getData()) == 0){
      root.incCount();
    }
    else {
      insert(node, root);
    }
  }
  private void insert(Node node, Node currNode) {
    if(node.getData().compareTo(currNode.getData()) < 0) {
       if (currNode.getLeft() == null) {
            currNode.setLeft(node);
        } else {
            insert(node, currNode.getLeft());
        }
     }
    else if(node.getData().compareTo(currNode.getData()) == 0){
      currNode.incCount();
    }
     else {
        if (currNode.getRight() == null) {
            currNode.setRight(node);
        } 
        else {
            insert(node, currNode.getRight());
        }
     }
  }
  //Print methods
  //printInOrder method 
  //Traverses list and prints every Node alphabetically forward (from head to tail)
  public void printInOrder() { 
    printInOrder(root);
  }
  public void printInOrder(Node currNode){
    if(currNode !=  null) {  
      printInOrder(currNode.getLeft());  
      //Visit the node by Printing the node data    
      System.out.println(currNode.getData());  
      printInOrder(currNode.getRight());  
    }  
  }
  
  public Node find(String data){
    return find(data,root);
  }
  private Node find(String data, Node node){
    if(node != null){
        if(node.getData().compareTo(data) == 0){
           return node;
        } 
        else {
            Node foundNode = find(data, node.getLeft());
            if(foundNode == null) {
                foundNode = find(data, node.getRight());
            }
            return foundNode;
         }
    } 
    else {
        return null;
    }
  }
  
  //deleteTree method
  //Removes references to the Tree, deleting the Tree
  public void deleteTree() {
    //Makes head null
    this.root = null;
    /* Everything else is swept up by garbage collection
     */
    //Print success
    System.out.println("The Tree has been deleted");
  }
  
  public void importTxt() {
    File inputFile = new File("example.txt");
    try {

        Scanner scanner = new Scanner(inputFile);
        
        String[] splited = scanner.nextLine().toLowerCase().split("\\s+");
        for(int i = 0; i < splited.length; i++)
            this.insertNode(splited[i]);

        scanner.close();
    } 
    catch (FileNotFoundException e) {   
      System.out.println("shit");
    }
  }
  public void printFrequencyHist(){
   printFrequencyHist(root);
  }
  public void printFrequencyHist(Node currNode){
    if(currNode !=  null) {  
      printFrequencyHist(currNode.getLeft());  
      //Visit the node by Printing the node data    
      System.out.println(currNode.getData()+" "+currNode.getCount());
      printFrequencyHist(currNode.getRight());  
    }  
  }
}