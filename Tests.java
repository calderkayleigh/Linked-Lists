public class Tests 
{

  
  public static void addTestSimple() 
  {
    LList list  = new LList();
    int i;
    
    /*test to see if the list has been created. If it has been created, it will not equal null*/
    if(list == null)
    {
    	System.out.println("The list has not been created");
    }
  
    System.out.printf("Add Test #1\n-------------\n");
    System.out.printf("creaing first entry...\n");
    LNode office = new LNode("My office", 38.9005, -77.049318);
    list.head = office;
    office.next = null;
    list.head = office;
    System.out.printf("now adding more with function...\n");
    list.addNode("Washington Monument", 38.889404, -77.035194);
    i = list.addNode("Melbourne", -37.84232, 144.989318);
    //System.out.println("after add index is " + i);
    if(i != 2)
    {
      System.out.printf("ERROR: Not returning correct index in add!\n");
    }
    System.out.printf("Should print list with 3 locations: My Office, Washington Monument, and Melbourne.\n");
    list.printList();
    System.out.printf("\n-------------\n\n");
    
    /*test removing a node*/
    System.out.println("The system should print list with My Office and Melbourne");
    list.remNode("Washington Monument");
    list.printList();
    
    /*test clearing the list*/
    System.out.println("This should print nothing: the list is being cleared");
    list.clearList();
    list.printList();

  
    /*test creating a sorted list*/
    System.out.println("This should print a list that is sorted by longitude");
    list.addSortedNode("Washington Monument", 38.889404, -77.035194);
    list.addSortedNode("Melbourne", -37.84232, 144.989318);
    list.addSortedNode("My office", 38.9005, -77.049318);
    list.printList();

    
    
  }
  
  public static void main (String[] argv) 
  {
   
    addTestSimple();
  }
}
