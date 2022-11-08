package com.example.datastructures.DoublyLinkedList;

public class DoublyLinkedList {

	private Node firstNode;
	private Node lastNode;

	public DoublyLinkedList() {
		this.firstNode = null;
		this.lastNode = null;
	}

	public boolean isEmpty() {
		return firstNode == null;
	}

	public void insertFirstNode(int data) {
		Node newNode = new Node();
		newNode.data = data;

		if(isEmpty()) {
			lastNode = newNode;
		} else {
			firstNode.previous = newNode;
		}

		newNode.next = firstNode;
		this.firstNode = newNode;
	}

	public void insertLastNode(int data) {
		Node newNode = new Node();
		newNode.data = data;

		if(isEmpty()) {
			firstNode = newNode;
		} else {
			lastNode.next = newNode;
			newNode.previous = lastNode;
		}
		lastNode = newNode;
	}

	public Node deleteFirst() {
		Node temp = firstNode;

		if(firstNode.next == null) {
			lastNode = null;
		} else {
			firstNode.next.previous = null; // node before last is now null
		}
		firstNode = firstNode.previous; // restructures, since node has been deleted makes the node following first.
		return temp;
	}

	public Node deleteLast() {
		Node temp = lastNode;

		if(firstNode.next == null) {
			firstNode = null;
		} else {
			lastNode.previous.next = null;
		}
		lastNode = lastNode.previous;
		return temp;
	}

	public boolean insertAfter(int key, int data) {
		Node currentNode = firstNode;

		while(currentNode.data != key) {
			currentNode = currentNode.next;
			if(currentNode == null) {
				return false;
			}
		}

		Node newNode = new Node();
		newNode.data = data;

		if(currentNode == lastNode) {
			currentNode.next = null;
			lastNode = newNode;
		} else {
			newNode.next = currentNode.next;
			currentNode.next.previous = newNode;
		}
		newNode.previous = currentNode;
		currentNode.next = newNode;

		return true;
	}

	public Node deleteKey(int key) {
		Node currentNode = firstNode;

		while(currentNode.data != key) {
			currentNode = currentNode.next;
			if(currentNode == null) {
				return null;
			}
		}
		if(currentNode == firstNode) {
			firstNode = currentNode.next; // point to the following node as this one will be deleted
		} else {
			currentNode.previous.next = currentNode.next;
		}

		if(currentNode == lastNode) {
			lastNode = currentNode.previous;
		} else {
			currentNode.next.previous = currentNode.previous;
		}
		return currentNode;
	}
}
