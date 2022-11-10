package com.example.datastructures.SinglyLinkedList;

public class SinglyLinkedList<T> implements LinkedList<T> {

	private Node<T> head;
	private int size;

	public void addToFront(T data) {
		Node<T> node = new Node<>(data);
		node.setNext(head);
		head = node;
		size++;
	}

	public Node<T> removeFromFront() {
		if(isEmpty()) {
			return null;
		}

		Node<T> removeNode = head;
		head = head.getNext();
		removeNode.setNext(null);
		size--;

		return removeNode;
	}

	public int getSize() {
		if(head == null) {
			return 0;
		}
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void printList() {
		Node<T> currentNode = head;
		System.out.print("Head -> ");

		while (currentNode != null) {
			System.out.print(currentNode);
			System.out.print(" -> ");
			currentNode = currentNode.getNext();
		}
		System.out.println("null");
	}
}
