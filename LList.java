public class LList {

  public LNode head;
  /* You may not add more data members to this class. */
  
  public void printList(){
    LNode entry = head;
    System.out.println("List Contents:");
    while (entry != null) {
      System.out.printf("  %s is at %f, %f\n", entry.name, entry.latitude, entry.longitude);
      entry = entry.next;
    }
  }

  public int addNode(String name, double lat, double lon){
    return 0;  
  }

  public int remNode(String name){
    return 0;  
  }

  public int addSortedNode(String name, double lat, double lon){
    return 0;  
  }

  public int clearList(){
    return 0;  
  }

}
