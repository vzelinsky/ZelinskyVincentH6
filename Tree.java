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
  
  //Constructors
  //No argument constructor that when called creates an empty Tree
  public Tree() {
    //Sets root to null
    this.root = null;
  }
  
  //Methods
  //Getter methods
  //Returns the reference to the Node stored at root
  public Node getRoot() {
    return root;
  }
  
  //insertNode method
  /* Adds a Node to the Tree
   * Compares Strings of pre-existing Nodes with the String passed in the argument with the compareTo method
   * Sorts where the new Node should go depending on the output returned by compareTo and its relationship to 0
   */ 
  public void insertNode(String data) {
    //Initializes the new Node as node
    Node node = new Node(data,null,null);
    //if the root is null(Tree is empty)
    if (root == null) {
      //Set the root to the new node
      root = node;
    }
    //if the root contains the same String as the new node
    else if(root.getData().compareTo(node.getData()) == 0){
      //increment the counter for that Node
      root.incCount();
    }
    else {
      //Call the overloaded method that will traverse the Tree
      insertNode(node, root);
    }
  }
  //Accepts 2 arguments: the node to be added and the current Node we are traversing
  private void insertNode(Node node, Node currNode) {
    //if node is alphabetically less than currNode
    if(node.getData().compareTo(currNode.getData()) < 0) {
      //if the left child of the currNode doesn't exist
      if (currNode.getLeft() == null) {
        //set the left child to the new node
        currNode.setLeft(node);
      } 
      else {
        //Recursive call traversing the currNode to the left child
        insertNode(node, currNode.getLeft());
      }
    }
    //if node is the same String as the String contained in currNode
    else if(node.getData().compareTo(currNode.getData()) == 0){
      //increment the counter for that Node
      currNode.incCount();
    }
    //(left has been exhausted)
    else {
      //if the right child of the currNode doesn't exist
      if (currNode.getRight() == null) {
        //set the right child to the new Node
        currNode.setRight(node);
      }
      else {
        //Recursive call traversing the currNode to the right child
        insertNode(node, currNode.getRight());
      }
    }
  }
  
  //Print methods
  //printInOrder method 
  //Traverses list and prints every Node in order(left center right)
  //Convience method
  public void printInOrder() {
    //Calls overloaded method
    printInOrder(root);
  }
  //Accepts 1 argument: the current Node it is traversing
  private void printInOrder(Node currNode){
    //if currNode exists
    if(currNode !=  null) {
      //recursively call this method passing the left child
      printInOrder(currNode.getLeft());  
      //Print the currNode   
      System.out.println(currNode.getData());
      //recursively call this method passing the right child
      printInOrder(currNode.getRight());  
    }  
  }
  
  //find method
  //Finds and returns a Node in the Tree
  //Convience method
  public Node find(String data){
    //passes root to start traversal there
    return find(data,root);
  }
  //Accepts 2 arguments: the String trying to be matched and the currNode
  private Node find(String data, Node currNode){
    //if the currNode exists
    if(currNode != null){
      //if the data in currNode is the same as the String 
      if(currNode.getData().compareTo(data) == 0){
        //(We've found the Node!)
        return currNode;
      } 
      else {
        //Make a temp Node called foundNode to the ouput of the recursive call 
        //Recursively call this method passing the left child to it
        Node foundNode = find(data, currNode.getLeft());
        //(if left is exhausted)
        if(foundNode == null) {
          //Set the temp Node to the output of the recursive call
          //Recursively call this method passing the right child to it
          foundNode = find(data, currNode.getRight());
        }
        //return the foundNode
        return foundNode;
      }
    } 
    else {
      //(if we didn't find it)
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
  
  //importTxt method
  //Imports a .txt File, fileLocation, to the tree splitting each word
  public void importTxt(String fileLocation) {
    //delete anything currently stored in the Tree
    this.deleteTree();
    //creates a file object which passes our example text file as an arugment
    File inputFile = new File(fileLocation);
    try {
      //Scanner reads the file
      Scanner scanner = new Scanner(inputFile);
      
      /* I know that .nextLine should split the String by spaces by default but I could not get it to work
       */
      //Makes sure everything is lowercase and splits by spaces into an array
      String[] splited = scanner.nextLine().toLowerCase().split("\\s+");
      //For i < length of array
      for(int i = 0; i < splited.length; i++)
        //Add contents of the array to the Tree
        this.insertNode(splited[i]);
      //Close the scanner
      scanner.close();
    }
    //Catch the FileNotFoundException(from StackOverflow)
    catch (FileNotFoundException e) {   
      System.out.println("Oh nooo");
    }
  }
  
  //printFrequencyHist method
  /* Would have liked to have this method just call printInOrder but could not find a way to do so while adding counts
   */ 
  //Copies printInOrder but adds the count of each Node in the prints
  public void printFrequencyHist(){
   printFrequencyHist(root);
  }
  public void printFrequencyHist(Node currNode){
    if(currNode !=  null) {  
      printFrequencyHist(currNode.getLeft());  
      //Adds counter of the currNode after a space    
      System.out.println(currNode.getData()+" "+currNode.getCount());
      printFrequencyHist(currNode.getRight());  
    }  
  }
}