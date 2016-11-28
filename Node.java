/* Node.java
 * Written by Vincent Zelinsky
 * 
 * Contains the necessary constructors, getters, and setters to create a Node and interact with List.java
 */
public class Node {
  //Private fields
  //Contains the String stored in a Node
  private String data;
  //Contains a reference to the next Node object
  private Node next;
  //Contains a reference to the prev Node object
  private Node prev;
  
  //Constructors
  //Accepts a String argument
  public Node(String dataInput) {
    //Sets data to the argument passed, a String
    this.data = dataInput;
    //Sets next to null
    this.next = null;
    //Sets prev to null
    this.prev = null;
  }
  //Accepts arguments for the fields data, next, and prev
  public Node(String dataInput, Node n, Node p) {
    //Sets data to the first argument passed, a String
    this.data = dataInput;
    //Sets next to the second argument passed, a reference to a Node object
    this.next = n;
    //Sets prev to the third argument passed, a reference to a Node object
    this.prev = p;
  }
  
  //Getter methods
  //Returns data field
  public String getData(){
    return data;
  }
  //Returns the reference to the Node stored at next
  public Node getNext(){
    return next;
  }
  //Returns the reference to the Node stored at prev
  public Node getPrev(){
    return prev;
  }
  //Setter methods
  //Sets the data field to the argument passed
  public void setData(String dataInput){
    this.data = dataInput;
  }
  //Sets the next Node to the referenced Node in the argument
  public void setNext(Node nextInput){
    this.next = nextInput;
  }
  //Sets the prev Node to the referenced Node in the argument
  public void setPrev(Node prevInput){
    this.prev = prevInput;
  }
}