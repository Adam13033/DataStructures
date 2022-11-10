package com.example.datastructures.SinglyLinkedList;

public class Node<T> {


	public  Node<T> next;
	public T data;

	public Node(T data) {
		this.data = data;
	}

	public Node<T> getNext () {
		return next;
	}

	public void setNext (Node<T> next) {
		this.next = next;
	}

	public T getData () {
		return data;
	}

	public void setData (T data) {
		this.data = data;
	}

	@Override
	public String toString () {
		return "" + data;
	}
}
