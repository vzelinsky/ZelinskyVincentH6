/* Tree.java
 * Written by Vincent Zelinsky
 * 
 * Tests methods of List to confirm the creation of a correct Tree
 */
public class Tree
{
  public static void main (String[] args)
  {
    List myList = new List();
    
    System.out.println("Prints forwards");
    myList.addNode("Alpha");
    myList.addNode("Bravo");
    myList.addNode("Charlie");
    System.out.println("The List forwards: ");
    myList.printListForward(); //Demonstrates traversing forward and printing
    System.out.println("---------------------------------");
    
    System.out.println("Add Nodes alphabetically");
    myList.addNode("Aa");
    myList.addNode("Foxtrot");
    myList.addNode("Echo");
    myList.addNode("Delta");
    myList.addNode("Zulu");
    System.out.println("The List: ");
    myList.printListForward(); //Demonstrates that Nodes add in alphabetical order
    System.out.println("---------------------------------");
    
    System.out.println("Prints backwards");
    System.out.println("The List backwards: ");
    myList.printListBackward(); //Demonstrates traversing backwards and printing
    System.out.println("---------------------------------");
    
    System.out.println("Finds Nodes matching a String");
    System.out.println(myList.findNode("Echo").getData()); //Demonstrates that it can find a Node that matches a String
    System.out.println("---------------------------------");
    
    System.out.println("Deletes Node");
    myList.deleteNode("Echo");
    System.out.println("The List: ");
    myList.printListForward(); //Demonstrates that a Node can be specified and deleted
    System.out.println("---------------------------------");

    System.out.println("Deletes List");
    myList.deleteList();
    System.out.println("Head is "+myList.getHead());
    System.out.println("Tail is "+myList.getTail()); //Demonstrates that the List can be deleted
  }
}