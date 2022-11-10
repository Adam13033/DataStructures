package com.example.datastructures.DoublyLinkedList;

public class DoublyLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;


	public boolean isEmpty() {
		return head == null;
	}

	public void addToFront(T data) {
		Node<T> node = new Node<>(data);
		node.setNext(head);

		if(head == null) {
			tail = node;
		} else {
			head.setPrevious(node);
		}

		head = node;
		size++;
	}

	public void addToEnd(T data) {
		Node<T> node = new Node<>(data);

		if(tail == null) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
		}

		tail = node;
		size++;
	}

	public boolean insertAfter(T key, T data) {
		Node<T> currentNode = head;

		while(currentNode.data != key) {
			currentNode = currentNode.next;
			if(currentNode == null) {
				return false;
			}
		}

		Node<T> newNode = new Node<T>(data);

		if(currentNode == tail) {
			currentNode.next = null;
			tail = newNode;
		} else {
			newNode.next = currentNode.next;
			currentNode.next.previous = newNode;
		}
		newNode.previous = currentNode;
		currentNode.next = newNode;

		return true;
	}

	public Node<T> deleteFromFront() {
		if(isEmpty()) {
			return null;
		}

		Node<T> removeNode = head;

		if(head.getNext() == null) {
			tail = null;
		} else {
			head.getNext().setPrevious(null);
		}

		head = head.getNext();
		size--;
		removeNode.setNext(null);

		return removeNode;
	}

	public Node<T> deleteKey(T key) {
		Node<T> currentNode = head;

		while(currentNode.data != key) {
			currentNode = currentNode.next;
			if(currentNode == null) {
				return null;
			}
		}
		if(currentNode == head) {
			head = currentNode.next; // point to the following node as this one will be deleted
		} else {
			currentNode.previous.next = currentNode.next;
		}

		if(currentNode == tail) {
			tail = currentNode.previous;
		} else {
			currentNode.next.previous = currentNode.previous;
		}
		return currentNode;
	}

	public int getSize() {
		if(head == null) {
			return 0;
		}
		return size;
	}

	public void printList() {
		Node<T> currentNode = head;
		System.out.print("Head -> ");

		while (currentNode != null) {
			System.out.print(currentNode);
			if(currentNode.getNext() == null) {
				System.out.print(" --> ");
			} else {
				System.out.print(" <--> ");
			}
			currentNode = currentNode.getNext();
		}
		System.out.println("null");
	}
}
