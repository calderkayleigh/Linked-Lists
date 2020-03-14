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
	return count+1;
}


int remNode(struct LList *list, char* name)
{
  /*  Removes the element named "name" from the list, if it exists. Returns the index of the element removed.*/

	/*create an index count*/
	int count = 0;
	int ret;

	/*if the list is empty, return an error*/
	if(list->head == NULL)
	{
		return -1;
	}

	/*create a node named last that points to the current entry and a node that points to the previous entry*/
	struct LNode* last= (struct LNode*)malloc(sizeof(struct LNode));
	last = list->head;
	struct LNode* prev= (struct LNode*)malloc(sizeof(struct LNode));
	prev = list->head;

	/*iterate through the list while there are nodes*/
	while(last->next != NULL)
	{
		ret = strcmp(name, last->name);

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
				return count;
			}
		}
		prev = last;
		last = last->next;
		count++;
	}
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
	struct LNode* prev= (struct LNode*)malloc(sizeof(struct LNode));
	prev = entry;

	/*make the added node point to null*/
	entry->next = NULL;
	prev->next = NULL;

	/*if the list is empty or the longitude of the entry is smaller than that of the first nodes, make the new node the head of the list. The index is 0*/
	if(list->head == NULL || entry->longitude <= list->head->longitude)
	{
		entry->next = list->head;
		list->head = entry;

		return 0;
	}

	/*insert a sorted node to an index other than 0*/
	else
	{
		/*set previous equal to the head of the list*/
		prev = list->head;

		/*iterate through the list until it is empty or until the previous node is greater than the entry node*/
		while(prev->next != NULL && prev->next->longitude < entry->next->longitude)
		{
			prev = prev->next;
			count++;
		}
		entry->next = prev->next;
		prev->next = entry;

		return count;
	}

}

int clearList(struct LList *list)
{
  /* Delete list and free all of the memory associate with its LNodes. */
  return 0;
}
