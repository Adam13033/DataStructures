# Data Structures 

### SinglyLinkedList
SinglyLinkedLists are an efficient data structure in relation to storage, manipulation and data access.
They offer constant time O(1) complexities for traversal through the List, which is achieved through the usage and linking
of nodes contained within the List.
As a result of the nodes, each element added to the List is aware of the next entrant as a result of the node pointing 
to the next entry. This is how O(1) constant time complexity is achieved.

Although very performant, LinkedLists have larger memory requirements than an ArrayList, although data insertion and manipulation
can be dramatically faster. With modern machines, memory is more readily available providing a vast reduction in the diminishing
returns associated with the additional memory requirements of a LinkedList, enhancing the use-case and efficacy offered.


#### How is this achieved? 

As mentioned above, SinglyLinkedLists point to the next node, which is achieved by repositioning the structure of the List 
and providing a pointer reference to the next entry, as is displayed beneath. 
```java
	public void addToFront(T data) {
		Node<T> node = new Node<>(data);
		node.setNext(head);
		head = node;
		size++;
	}
```

In the above, we've added a new Node and set the data of the <i> next </i> entry to the value being added. 
The reason we're setting the next value to the element being added is due to both SinglyLinkedList and DoublyLinkedLists
head and tail both being null pointers, something which is required to be maintained. 
As a result of this, we pass the data into the next node and leave both the head and tail as Null pointers. 

### What are the benefits? 
Unlike the popular <i> ArrayList </i> which requires resizing and enhanced associated time complexities with resizing, a 
LinkedList has no resizing requirements due to no backing of a statically sized array. Instead, the LinkedList increases 
in size as its requirements and sizing capacities enhance.
Needless to say, this is a vast performance enhancement over instantiating a new array, providing the new sizing capacity 
and then copying the data over. 

### What are the negatives? 
In order to add something at a specific point in the List, such as by index position, the time complexities are enhanced 
by the requirement of traversing the List in order to get to the location specified for insertion. This leads to linear time
complexities (O(n)).
This could be overcome by adding a pointer to the tail of the list, although this isn't a 'true' SinglyLinkedList.
An alternative would be a <b><i> CircularLinkedList </b></i> in which the head points to the tail, and the tail points to the head.
This dramatically enhances traversal speeds, offering constant time (O(1)) traversal. 

Due to the usage of nodes and pointers between nodes, LinkedLists require more memory, something which was previously
quite a harsh diminishing returns although with the advancements of technology and affordability of memory, has been largely
negated. 