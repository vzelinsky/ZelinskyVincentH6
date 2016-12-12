/* Node.java
 * Written by Vincent Zelinsky
 * 
 * Contains the necessary constructors, getters, and setters to create a Node and interact with Tree.java
 */
public class Node {
  //Private fields
  //Contains the String stored in a Node
  private String data;
  //Contains a reference to the left child Node object
  private Node left;
  //Contains a reference to the right child Node object
  private Node right;
  private int count;
  
  //Constructors
  //Accepts a String argument
  public Node(String dataInput) {
    //Sets data to the argument passed, a String
    this.data = dataInput;
    //Sets left to null
    this.left = null;
    //Sets right to null
    this.right = null;
    this.count = 1;
  }
  //Accepts arguments for the fields data, left, and right
  public Node(String dataInput, Node l, Node r) {
    //Sets data to the first argument passed, a String
    this.data = dataInput;
    //Sets left to the second argument passed, a reference to a Node object
    this.left = l;
    //Sets right to the third argument passed, a reference to a Node object
    this.right = r;
    this.count = 1;
  }
  
  //Getter methods
  //Returns data field
  public String getData(){
    return data;
  }
  //Returns the reference to the Node stored at left
  public Node getLeft(){
    return left;
  }
  //Returns the reference to the Node stored at right
  public Node getRight(){
    return right;
  }
  public int getCount(){
    return count;
  }
  //Setter methods
  //Sets the data field to the argument passed
  public void setData(String dataInput){
    this.data = dataInput;
  }
  //Sets the right Node to the referenced Node in the argument
  public void setRight(Node rightInput){
    this.right = rightInput;
  }
  //Sets the left Node to the referenced Node in the argument
  public void setLeft(Node leftInput){
    this.left = leftInput;
  }
  public void incCount(){
    this.count++;
  }
}