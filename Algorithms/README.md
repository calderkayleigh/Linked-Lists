## Phase 1: Algorithms
Before writing your code you must prepare pseudo code algorithms for each of the different functions. You must submit these in your Readme.md file in the Algorithms folder *by Wednesday 3/04 at 11:00PM*. You are encouraged to submit much sooner so that you can make progress on your coding -- if you submit sooner, you will get feedback sooner! Keep in mind that your algorithms should be language agnostic since you will be using this for both C and Java.

`addNode:` This should add a location to the end of the list.
  * Inputs: name, latitude, and longitude of the new location
  * Return the index of where the element was added (i.e., if the list was empty, it should return 0; if the new entry is the 4th entry, it should return 3), or -1 on an error.
  * Note: Our LList data structure only contains a reference to the head of the list, so you will *not* be able to directly add to the rear like was done in our class example!

```
Create a new node "rear" and make it a pointer to the front of the list. 
If the list is empty, make the front of the list equal to a new node with a given name, latitude, and longitude.   
While the list is not empty (in other words if rear-> next does not equal NULL), traverse through the list to set rear equal to the last value in the list. 
Add a new node with a given name, latitude, and longitude to the next space after rear. 
```

`addSortedNode:` Add a location to the list sorted by longitude (i.e. the one that changes as you go east/west).
  * Inputs: name, latitude, and longitude of the new location
  * Return the index of where the element was added (i.e., if the list was empty, it should return 0; if the new entry is the 4th entry, it should return 3), or -1 on an error.
  * You can assume that if a user wants a list to be sorted, they will only use `addSortedNode` (not a mix of that and `addNode`).

```

```

`remNode:` Remove a location by name
  * Input: The name of the location to remove.
  * Note: If there happen to be two entries in the list with the same name, you should remove the entry closest to the head of the list.
  * Implementation tip: you cannot test if two strings are equal with `==` in C or Java! In C you will have to learn to use the [strcmp](https://www.tutorialspoint.com/c_standard_library/c_function_strcmp.htm) function and in Java you will want to use `.equals`
  * Return the index where the element was removed, or -1 on an error.

```

```

`clearList:` Clear a list
  * Remove all locations in the list
  * Return the total number of entries that were removed.

```

```
