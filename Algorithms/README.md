## Phase 1: Algorithms
Before writing your code you must prepare pseudo code algorithms for each of the different functions. You must submit these in your Readme.md file in the Algorithms folder *by Wednesday 3/04 at 11:00PM*. You are encouraged to submit much sooner so that you can make progress on your coding -- if you submit sooner, you will get feedback sooner! Keep in mind that your algorithms should be language agnostic since you will be using this for both C and Java.

`addNode:` This should add a location to the end of the list.
  * Inputs: name, latitude, and longitude of the new location
  * Return the index of where the element was added (i.e., if the list was empty, it should return 0; if the new entry is the 4th entry, it should return 3), or -1 on an error.
  * Note: Our LList data structure only contains a reference to the head of the list, so you will *not* be able to directly add to the rear like was done in our class example!

```
Create a new node "rear" and make it a pointer to the front of the list. 
If the list is empty, make the front of the list equal to a new node with a given name, latitude, and longitude. Return 0, the index at which this new node is located.  
Set a count integer equal to zero. 
While the list is not empty (in other words if rear-> next does not equal NULL), traverse through the list to set rear equal to the last value in the list. Increase the count by 1 each iteration. Return this value. It is the index. 
Add a new node with a given name, latitude, and longitude to the next space after rear. 
```

`addSortedNode:` Add a location to the list sorted by longitude (i.e. the one that changes as you go east/west).
  * Inputs: name, latitude, and longitude of the new location
  * Return the index of where the element was added (i.e., if the list was empty, it should return 0; if the new entry is the 4th entry, it should return 3), or -1 on an error.
  * You can assume that if a user wants a list to be sorted, they will only use `addSortedNode` (not a mix of that and `addNode`).

``` 
If the list is empty, make the front of the list equal to a new node with a given name, latitude, and logitude. Return 0, the index at which this new node is located. 
Identify a count integer and set it equal to zero. 
While the current node's longitude value is less than the next nodes longitude value and the list does not equal null, iterate through the linked list. Increase count through each iteration. Return the value of count. Create a new node once these conditions are not met. Make the previous node point to this node, and have this node point to the next node in the list, or NULL if the list is empty. 

```

`remNode:` Remove a location by name
  * Input: The name of the location to remove.
  * Note: If there happen to be two entries in the list with the same name, you should remove the entry closest to the head of the list.
  * Implementation tip: you cannot test if two strings are equal with `==` in C or Java! In C you will have to learn to use the [strcmp](https://www.tutorialspoint.com/c_standard_library/c_function_strcmp.htm) function and in Java you will want to use `.equals`
  * Return the index where the element was removed, or -1 on an error.

```
Create a count integer and set it equal to zero. 
Iterate through the linked list while it is not empty. Increment the count function by 1 for each iteration. If the current node's name is equal to the name we are trying to remove, free the contents of that node or set it equal to NULL. Then, make the previous node point to the node after the removed. Return the count value, which is the index. Exit the command. 
If the current node's name is not equal to the name we are trying to remove, continue iterating through the list. 
If the list is iterated through without finding the name, return -1. The name does not exist in the list. 
```

`clearList:` Clear a list
  * Remove all locations in the list
  * Return the total number of entries that were removed.

```
Create a new node that will act as a pointer to the next node. 
Create a new integer, count, and set it equal to zero. 
While the list is not empty (head->next does not equal NULL), set the next node in the linked list equal to the head, free the head or set it equal to null, and set the head equal to the next node. Increment count by 1. Return the value of count. This is the total number of entries that were removed. 
```
