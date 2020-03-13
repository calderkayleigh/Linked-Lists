
# Linked List Makefile

CFLAGS=-g
DEPS=llist.h

all: c java

%.o: %.c $(DEPS)
	gcc -c -o $@ $< $(CFLAGS)

%.class: %.java 
	javac -cp . $< 

llist: tests.o llist.o
	gcc tests.o llist.o -o llist $(CFLAGS)

c: llist

java: LList.class LNode.class Tests.class

runc: c
	./llist

runjava: java
	java -cp . Tests
	
clean:
	rm -f *.class *.o llist
