# Data Structures 
 
After auto-save somehow disabling and losing notes, they're being stored here for safe keeping.


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
The reason we're setting the next value to the element being added is due to SinglyLinkedList
tail being a null pointer, something which is required to be maintained to signify the end of the List.
In addition to th above, in a SingleLinkedList the head isn't actually a node, instead acting as a pointer to the first node 
and can be considered an <b><i>'Ivalue'</b></i>
As a result of this, we pass the data into the next node and leave both the head and tail as Null pointers. 

#### What are the benefits? 
Unlike the popular <i> ArrayList </i> which requires resizing and enhanced associated time complexities with resizing, a 
LinkedList has no resizing requirements due to no backing of a statically sized array. Instead, the LinkedList increases 
in size as its requirements and sizing capacities enhance.
Needless to say, this is a vast performance enhancement over instantiating a new array, providing the new sizing capacity 
and then copying the data over. 

#### What are the negatives? 
In order to add something at a specific point in the List, such as by index position, the time complexities are enhanced 
by the requirement of traversing the List in order to get to the location specified for insertion. This leads to linear time
complexities (O(n)).
This could be overcome by adding a pointer to the tail of the list, although this isn't a 'true' SinglyLinkedList.
An alternative would be a <b><i> CircularLinkedList </b></i> in which the head points to the tail, and the tail points to the head.
This dramatically enhances traversal speeds, offering constant time (O(1)) traversal. 

Due to the usage of nodes and pointers between nodes, LinkedLists require more memory, something which was previously
quite a harsh diminishing returns although with the advancements of technology and affordability of memory, has been largely
negated. 

#### What are the ideal use-cases? 
If you want to load a bunch of data and will remain largely interested in the data contained at the front of the list,
then a SingleLinkedList would be a useful choice. However, if you wanted to do a bunch of random access there's a requirement
for traversal which is very costly as discussed requiring linear time (O(n)) and as such, an ArrayList would be significantly
more performant.

Ultimately, if the argument is ArrayList or SinglyLinkedList it would boil down to the above - 
Data additions with prime focus on first entries - SinglyLinkedList offering constant time (O(1)).
Random access requirements - ArrayList offering constant time random access (O(1)).

### DoublyLinkedList 
Much like SinglyLinkedList a DoublyLinkedList utilises nodes, a head and a tail. The difference between the two is that 
a DoublyLinkedList contains pointers to both the next and previous nodes, with null pointers at both the start and end 
of the List.
As a result of this additional link, removing and adding from the end (tail) of the list can be achieved in constant 
time (O(1)), although having the same time constraints in relation to traversal worst case scenario being linear time (O(n)).
This also provides the utility and ability to traverse the List in reverse, from tail back down to the head. 

#### How is this achieved? 
Much like the SinglyLinkedList, this is achieved through connections/pointers between the nodes of the List.
For example, the second index position will contain a pointer to index 1 and 3, just as index 3 will point to indexes 2 and 4.
When inserting into the head, the previous index position will be null and the next will be index 2 and for the sake of reference,
the previous pointer of the tail will be length - 1 and the next pointer will be null signifying the end of the List. 


