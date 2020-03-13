import java.awt.List;

public class LList 
{

  public LNode head;
  /* You may not add more data members to this class. */
  
  public void printList()
  {
    LNode entry = head;
    System.out.println("List Contents:");
    while (entry != null) 
    {
      System.out.printf("  %s is at %f, %f\n", entry.name, entry.latitude, entry.longitude);
      entry = entry.next;
    }
  }

  public int addNode(String name, double lat, double lon)
  {
	/*create an index count*/
	int count =0; 
	
	/*create a new node with the given name, lat, and lon*/
	LNode add = new LNode(name, lat, lon); 
	
	/*if the list is empty, make the new node the head of the list. The index is 0*/
	if(this.head == null)
	{
		this.head = add;
		return 0;
	}
	
	/*Create a new node that will determine which node was added last. Set this equal to the head*/
	LNode last = this.head;;

	
	/*while the head does not point to null, iterate through the list. Count the indexes*/
	while(last.next != null)
	{
		last = last.next;
		count++;

	}
	last.next = add;
    return count+1; 

  }

  public int remNode(String name)
  {
	/*create an index count*/
	int count = 0;
	
	/*if the list is empty, return an error*/
	if(this.head == null)
	{
		return -1;
	}
	
	/*create a node named last that points to the current entry and a node that points to the previous entry*/
	LNode last = this.head;
	LNode prev = this.head; 
	
	/*iterate through the list while there are nodes*/
	while(last.next != null)
	{
			if(name.equals(last.name))
			{
				if(last == this.head)
				{
					this.head = last.next; 
					//System.out.println("removing the first node");
					return 0; 
				}
				else
				{
					//System.out.println("removing the " + count+ " node");
					prev.next = last.next; 
					return count; 
				}
		
			}
			prev = last; 
			last = last.next; 
			count++;
	}
	
	return -1; 
  }

  public int addSortedNode(String name, double lat, double lon)
  {
	  /*create an index count*/
		int count = 0; 
		
		/*create new nodes with given name, latitude, and longitude*/
		LNode entry = new LNode(name, lat, lon);
		LNode prev = entry;
		
		/*make the added node point to null*/
		entry.next = null;
		prev.next = null; 
		
		/*if the list is empty or the longitude of the entry is smaller than that of the first nodes, make the new node the head of the list. The index is 0*/
		if(this.head == null || entry.longitude <= this.head.longitude)
		{
			entry.next = this.head; 
			this.head = entry; 
			
			return 0; 
		}
		
		/*insert a sorted node to an index other than 0*/
		else
		{
			/*set previous equal to the head of the list*/
			prev = this.head; 
			
			/*iterate through the list until it is empty of until the previous node is greater than the entry node*/
			while(prev.next != null && prev.next.longitude < entry.next.longitude)
			{
				prev = prev.next; 
				count++; 
			}
			entry.next = prev.next; 
			prev.next = entry; 
			
			return count; 
		}
	  
  }

  public int clearList()
  {
	/* start a count for the items in the list*/
	int count = 0; 
	
	/*create a node that will point to the last entry of the list*/
	LNode last = this.head; 
	
	/*check to see if there are any nodes in the list*/
	if(this.head == null)
	{
		System.out.println("There is nothing in the list to clear");
		return -1;
	}
	
	else
	{
		/*iterate through the list to count the number of items*/
		while(last.next != null)
		{
			count ++;  
		}
	
		this.head = null;
		return count;
		
	}
	
  }

}
