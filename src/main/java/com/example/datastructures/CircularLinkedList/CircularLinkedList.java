package com.example.datastructures.CircularLinkedList;

public class CircularLinkedList {

	private Node firstNode;
	private Node lastNode;

	public CircularLinkedList() {
		firstNode = null;
		lastNode = null;
	}

	private boolean isEmpty() {
		return firstNode == null;
	}

	public void insertFirstNode(int data) {
		Node newNode = new Node();
		newNode.data = data;

		if(isEmpty()) {
			lastNode = newNode;
		}
		newNode.next = firstNode;
		firstNode = newNode;
	}

	public void insertLastNode(int data) {
		Node newNode = new Node();
		newNode.data = data;

		if(isEmpty()) {
			firstNode = newNode;
		} else {
			lastNode.next = newNode;
			lastNode = newNode;
		}
	}

	public int deleteFirstNode() {
		int temp = firstNode.data;

		if(firstNode.next == null) {
			lastNode = null;
		}

		firstNode = firstNode.next;

		return temp;
	}

	public void displayList() {
		System.out.println("List (first --> last ");
		Node currentNode = firstNode;

		while(currentNode != null) {
			currentNode.displayNode();
			currentNode = currentNode.next;
		}
		System.out.println();
	}

}
