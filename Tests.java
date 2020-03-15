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
  
    
    /*test clearing the list*/
    System.out.println("This should print nothing: the list is being cleared");
    list.clearList();
    list.printList();
  }

   public static void addTestFull()
   {
 
   	/*create the list*/
   	LList newList  = new LList();
   	
   	if(newList == null)
    {
    	System.out.println("The list has not been created");
    }
   	
   	System.out.printf("Add Test #2\n-------------\n");
   	System.out.printf("Should print list with 3 locations: My Office, Washington Monument, and Melbourne.\n");
   	newList.addNode("My office", 38.9005, -77.049318); 
   	newList.addNode("Washington Monument", 38.889404, -77.035194);
   	newList.addNode("Melbourne", -37.84232, 144.989318);
   	newList.printList(); 
   	
   } 
   
   public static void removeTestFull()
   {
    
   	/*create the list*/
   	LList removeList  = new LList();
   	
   	if(removeList == null)
    {
    	System.out.println("The list has not been created");
    }
   	
   	System.out.printf("Remove Test #1\n-------------\n");
   	System.out.printf("Should print list with 3 locations: My Office, Washington Monument, and Melbourne.\n");
   	removeList.addNode("My office", 38.9005, -77.049318); 
   	removeList.addNode("Washington Monument", 38.889404, -77.035194);
   	removeList.addNode("Melbourne", -37.84232, 144.989318);
   	removeList.printList(); 
   	System.out.printf("\n-------------\n");
   	
   	System.out.printf("Remove First Item in List\n-------------\n");
   	removeList.printList();
   	removeList.remNode("My office");
   	removeList.printList();
   	System.out.printf("\n-------------\n");
   	
   	System.out.printf("Remove Middle Item in List\n-------------\n");
   	removeList.addNode("My office", 38.9005, -77.049318); 
   	removeList.printList(); 
   	removeList.remNode("Melbourne"); 
   	removeList.printList();
   	System.out.printf("\n-------------\n");
   	
   	System.out.printf("Remove Last Item in List\n-------------\n");
   	removeList.addNode("Melbourne", -37.84232, 144.989318);
   	removeList.printList();
   	removeList.remNode("Melbourne"); 
   	removeList.printList(); 
   	System.out.printf("\n-------------\n");
   	
   	System.out.println("Remove a fake Item In List\n-------------\n");
   	removeList.printList(); 
   	removeList.remNode("Fake Node"); 
   	removeList.printList(); 
   	System.out.printf("\n-------------\n");
   	
   }
   
   public static void clearTestFull()
   {
    
   	/*create the list*/
   	LList cList  = new LList();
   	
   	if(cList == null)
    {
    	System.out.println("The list has not been created");
    }
   	
   	System.out.printf("Clear List without Nodes\n-------------\n");
   	System.out.println("Clearing list..."); 
   	cList.clearList();
   	System.out.println("Done Clearing... should be empty");  
   	cList.printList();
   	System.out.printf("\n-------------\n");
   	
   	
   	System.out.printf("Clear List with Nodes\n-------------\n");
   	cList.addNode("My office", 38.9005, -77.049318); 
   	cList.addNode("Washington Monument", 38.889404, -77.035194);
   	cList.addNode("Melbourne", -37.84232, 144.989318);
   	cList.printList(); 
   	System.out.println("Clearing list..."); 
   	cList.clearList(); 
   	System.out.println("Done Clearing... should be empty"); 
   	cList.printList(); 
   	System.out.printf("\n-------------\n");

   	
   }
    
  
  public static void main (String[] argv) 
  {
   
    addTestSimple();
    addTestFull(); 
    removeTestFull(); 
    clearTestFull(); 
  }
}
