#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "llist.h"

struct LList* createLList() {
  /* Create an empty linked list. */
  /* DO NOT MODIFY THIS CODE */
  struct LList* list = malloc(sizeof(struct LList));
  list->head = NULL;
  return list;
}

void printList(struct LList *list)
{
  /* Print a list from head to tail. */
  /* DO NOT MODIFY THIS CODE */
  struct LNode *entry;
  if(list == NULL)
  {
    printf("List has not been initialized!\n");
    return;
  }
  entry = list->head;
  printf("List Contents:\n");
  while(entry != NULL)
  {
    printf("  %s is at %f, %f\n", entry->name, entry->latitude, entry->longitude);
    entry = entry->next;
  }
}


int addNode(struct LList *list, char* name, double lat, double lon)
{
  /*  Add a new entry to the linked list. Return the index number of the new entry*/

	/*create an index count*/
	int count = 0;

	/*allocate memory for a new node*/
	struct LNode* new = (struct LNode*)malloc(sizeof(struct LNode));

	/*assign values*/
	new->name = name;
	new->latitude = lat;
	new->longitude = lon;

	/*if the list is empty, make the new node the head of the list. The index is 0*/
	if(list->head == NULL)
	{
		list->head = new;
		return 0;
	}

	/*Create a new node that will determine which node was added last. Set this equal to the head*/
	struct LNode* last= (struct LNode*)malloc(sizeof(struct LNode));
	last = list->head;

	/*While the head does not point to null, iterate through the list. Count the indexes*/
	while(last->next != NULL)
	{
		last = last->next;
		count++;
	}
	last->next = new;
	new->next = NULL;
	//printf("Index of added node = %d\n", count+1);
	return count+1;
}


int remNode(struct LList *list, char* name)
{
  /*  Removes the element named "name" from the list, if it exists. Returns the index of the element removed.*/

	/*create an index count*/
	int count = 0;

	/*if the list is empty, return an error*/
	if(list->head == NULL)
	{
		printf("Error. Attempting to remove from an empty list\n");
		return -1;
	}

	/*create a node named last that points to the current entry and a node that points to the previous entry*/
	struct LNode* last= (struct LNode*)malloc(sizeof(struct LNode));
	last = list->head;
	struct LNode* prev= (struct LNode*)malloc(sizeof(struct LNode));
	prev = list->head;

	/*iterate through the list while there are nodes*/
	while(last!= NULL)
	{
		int ret = strcmp(name, last->name);
		if(ret == 0)
		{
			if(last == list->head)
			{
				list->head = last->next;
				free(last);
				return 0;
			}
			else
			{
				prev->next = last->next;
				free(last);
				//printf("Index of removed node = %d\n", count);
				return count;
			}
		}
		prev = last;
		last = last->next;
		count++;
	}
	printf("The point does not exist\n");
	return -1;

}

int addSortedNode(struct LList *list, char* name, double lat, double lon)
{
  /*  Add a point to the list, sorted by longitude in ascending order. Returns the position of the new point.*/

	/*create an index count*/
	int count = 0;

	/*create new nodes with given name, latitude, and longitude*/
	struct LNode* entry= (struct LNode*)malloc(sizeof(struct LNode));
	entry->name = name;
	entry->latitude = lat;
	entry->longitude = lon;
	struct LNode* iterate= (struct LNode*)malloc(sizeof(struct LNode));


	/*make the added node point to null*/
	entry->next = NULL;

	if(list->head == NULL || entry->longitude <= list->head->longitude)
	{
		entry->next = list->head;
		list->head = entry;
		return 0;
	}

	else
	{
		iterate = list->head;
		while(iterate->next != NULL && iterate->next->longitude < entry->longitude)
		{
			count++;
			iterate = iterate->next;
		}
		entry->next = iterate->next;
		iterate->next = entry;
		//printf("Index of added node = %d\n", count);
		return count;
	}

}

int clearList(struct LList *list)
{
  /* Delete list and free all of the memory associate with its LNodes. */

	/*create a node count*/
	int count = 0;

	/*create a node to iterate through the list*/
	struct LNode* entry= (struct LNode*)malloc(sizeof(struct LNode));
	entry = list->head;

	/*create a temporary node for freeing*/
	struct LNode* temp= (struct LNode*)malloc(sizeof(struct LNode));

	/*check to see if there are any nodes in the list*/
	if(list->head == NULL)
	{
		printf("The list is empty. No nodes to remove\n");
		return -1;
	}

	/*iterate through the list. Count and free all nodes*/
	while(entry->next != NULL)
	{
		temp = entry->next;
		free(entry);
		entry = temp;
		count++;
	}
	list->head = NULL;
	//printf("Number of nodes in list before clear= %d\n", count+1);
	return count+1;

}
