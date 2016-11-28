/* List.java
 * Written by Vincent Zelinsky
 * 
 * Contains the necessary methods to create a Doubly Linked List, interacts with Node.java
 */
public class List {
  //Private fields
  //Contains a reference to the head Node object
  private Node head;
  //Contains a reference to the tail Node object
  private Node tail;
  
  //Constructors
  //No argument constructor that when called creates an empty List
  public List() {
    //Sets head to null
    this.head = null;
    //Sets tail to null
    this.tail = null;
  }
  
  //Methods
  //Getter methods
  //Returns the reference to the Node stored at head
  public Node getHead() {
    return head;
  }
  //Returns the reference to the Node stored at tail
  public Node getTail() {
    return tail;
  }
  
  //addNode method
  /* Adds a Node to the List in alphabetical order
   * Compares Strings of pre-existing Nodes with the String passed in the argument with the compareTo method
   * Sorts where the new Node should go depending on the output returned by compareTo and its relationship to 0
   */
  public void addNode(String dataInput) {
    //Case 1: if the List is empty (head = null)
    //Inserts the new Node at head and makes it the tail as it is the only Node
    if(head == null) {
      //Add the Node as the head
      head = new Node(dataInput);
      //Set the tail to the same Node as head
      tail = head;
    }
    else {
      //Initializes a traversal Node, t, to head
      Node t = head;
      //While the String stored in Node t compared to the argument passed to the method returns a negative (A.compareTo(B)==-1) loop
      /*(While the String stored in Node t is alphabetically less than the argument (a<b) loop)
       */ 
      while((t.getData()).compareTo(dataInput) < 0) {
        //Case 2: if next Node is null (if the tail is alphabetically less than the argument)
        //Inserts the new Node at tail.next and makes it the new tail
        if(t.getNext() == null) {
          //Creates a new Node and calls the second constructor in Node
          //The argument gets passed as the String, the next Node is null, and the prev Node is the tail 
          Node n = new Node(dataInput, null, tail);
          //The new Node is added as the next Node of the current tail
          tail.setNext(n);
          //The new Node is the new tail
          tail = tail.getNext();
          //Breaks the loop
          break;
        }
        //Case 3: if the String stored in the next Node after Node t compared to the argument returns a positive (C.compareTo(B)==1)
        /* (if the String stored in the next Node after Node t is alphabetically greater than the argument (c>b) 
         * then the argument must be between Node t and Node t.next)
         */
        //Inserts the new Node between Node t and Node t.next
        else if((t.getNext().getData()).compareTo(dataInput) >= 0) {
          //Initializes a juggler Node, j, to Node t.next to hold it
          Node j = t.getNext();
          //Creates a new Node and calls the second constructor in Node
          //The arugment gets passed as the String, the next Node is j(t.next), and the prev Node is Node t
          Node n = new Node(dataInput, j, t);
          //The new Node is added as the next Node after Node t
          t.setNext(n);
          //The new Node(t.next) is set as the prev Node before Node j
          j.setPrev(t.getNext());
          //Breaks the loop
          break;
        }
        else {
          //Traverse Node t to the Next Node in the List
          t = t.getNext();
        }
      }
      //Case 4: if the String stored in the head compared to the argument returns a positive (Ab.compareTo (Aa) == 1)
      /* (if the head is alphabetically greater than the argument (Ab>Aa) the while statement will end immediately and
       *  the argument must come alphabetically before the head)
       */
      //Inserts the new Node before head and makes it the new head
      if((head.getData()).compareTo(dataInput) >= 0) {
        //Initializes a juggler Node, j, to head to hold it 
        Node j = head;
        //Creates a new Node at head and calls the second constructor in Node
        //The argument gets passed as the String, the next Node is j(head), and the prev Node is Node null
        head = new Node(dataInput, j, null);
        //The new Node(head) is set as the prev Node before Node j
        j.setPrev(head);
      }
    }
  }
  
  //Print methods
  //printListForward method 
  //Traverses list and prints every Node alphabetically forward (from head to tail)
  public void printListForward() {
    //Initializes a traversal Node, t, at head
    Node t = head;
    //While the Node t is not equal to null loop
    while(t != null) {
      //Print the data stored in the current Node that Node t is at
      System.out.println(t.getData());
      //Traverse Node t to the next Node in the List
      t = t.getNext();
    }
  }
  //printListBackward method 
  //Traverses list and prints every Node alphabetically backward (from tail to head)
  public void printListBackward() {
    //Initializes a traversal Node, t, at tail
    Node t = tail;
    //While the Node t is not equal to null loop
    while(t != null) {
      //Print the data stored in the current Node that Node t is at
      System.out.println(t.getData());
      //Traverse Node t to the prev Node in the List
      t = t.getPrev();
    }
  }
  
  //findNode method
  //Traverses the List until it finds a Node with the same String as the arugment and returns that Node
  public Node findNode(String dataInput) {
    //Initializes a traversal Node, t, at head
    Node t = head;
    //Initializes an counter int variable, i, with 1
    int i = 1;
    //While the String stored in Node t compared to the argument passed to the method returns an int not equal to null loop
    while((t.getData()).compareTo(dataInput) != 0) {
      //if t.next is null (if t.next is null then we've traversed the whole list found no Node matching the String)
      /* Implement a Null object pattern if time allows to save from null.getNext() in the deleteNode method
       */
      if(t.getNext() == null) {
        return null;
      }
      else {
        //Traverse Node t to the next Node in the List
        t = t.getNext();
        //Increment the variable i
        i++;
      }
    }
    //Print the String and the int i (The index number of the Node in the List)
    /* Only for testing purposes
     */ 
    System.out.println("The String "+dataInput+" matches Node number "+i);
    //Return the Node reference
    return t;
  }
  
  //deleteNode method
  //Calls the findNode method and passes the argument, then deletes the returned Node
  public void deleteNode(String dataInput) {
    //Calls the findNode method, passes the argument to it, and initializes a Node to be deleted, d, as the returned Node
    Node d = findNode(dataInput);
    //if the Node returned is null
    if(d == null) {
      //Print that the Node does not exist
      System.out.println("Node did not exist");
    }
    else {
      //Initializes the Node next to the Node after Node d
      Node next = d.getNext();
      //Initializes the Node prev to the Node before Node d
      Node prev = d.getPrev();
      //if the Node before Node d is null (Node d is head)
      if(prev == null)
        //head is now the Node after Node d
        head = next;
      else
        //The next Node after Node prev is Node next (routing around Node d) 
        prev.setNext(next);
      //if the Node after Node d is null (Node d is tail)
      if(next == null)
        //tail is now the Node before Node d
        tail = prev;
      else
        //The prev Node before Node next is Node prev (routing around Node d)
        next.setPrev(prev);
      //Print success
      System.out.println("The Node "+dataInput+" has been deleted");
    }
  }
  
  //deleteList method
  //Removes references to the List, deleting the List
  public void deleteList() {
    //Makes head null
    this.head = null;
    //Makes tail null
    this.tail = null;
    /* Everything else is swept up by garbage collection
     */
    //Print success
    System.out.println("The List has been deleted");
  }
}