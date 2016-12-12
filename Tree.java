/* Tree.java
 * Written by Vincent Zelinsky
 * 
 * Contains the necessary methods to create a Tree, interacts with Node.java
 */
public class Tree {
  //Private fields
  //Contains a reference to the root Node object
  private Node root;
  
  //Constructors
  //No argument constructor that when called creates an empty List
  public Tree() {
    //Sets root to null
    this.root = null;
  }
  
  //Methods
  //Getter methods
  //Returns the reference to the Node stored at head
  public Node getRoot() {
    return root;
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
  public void printInOrder(Node root){
  if(root !=  null) {  
   printInOrder(root.getLeft());  
   //Visit the node by Printing the node data    
   System.out.println(root.getData());  
   printInOrder(root.getRight());  
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
}