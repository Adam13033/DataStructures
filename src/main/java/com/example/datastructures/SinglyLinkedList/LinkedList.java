package com.example.datastructures.SinglyLinkedList;

public interface LinkedList<E> {

	void addToFront(E data);

	void printList();

	int getSize();

	boolean isEmpty();

	Node<E> removeFromFront();

}
