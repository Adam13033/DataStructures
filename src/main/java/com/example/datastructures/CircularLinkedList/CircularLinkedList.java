package com.example.datastructures.CircularLinkedList;

public class CircularLinkedList<T> implements CircularList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public CircularLinkedList () {
		head = null;
		tail = null;
	}

	private boolean isEmpty () {
		return head == null;
	}

	@Override
	public void addFirst (T data) {
		Node<T> newNode = new Node();
		newNode.setData(data);

		if (isEmpty()) {
			tail = newNode;
		}
		newNode.next = head;
		head = newNode;
		size++;
	}

	@Override
	public void addLast (T data) {
		Node<T> newNode = new Node();
		newNode.setData(data);

		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	@Override
	public void delete (T value) {
		if (this.head != null) {
			Node<T> currentNode = this.head;
			Node<T> previousNode = this.head;

			while (currentNode != null) {
				if (currentNode.getData() == value) {
					previousNode.setNext(currentNode.getNext());

					if (currentNode.getNext() != null) {
						currentNode.getNext().setPrevious(previousNode);
					}
					System.out.println("Deleted node with value of: " + value);
					size--;
					break;
				} else {
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				}
			}
		}
	}

	@Override
	public void addAfterIndex (T value, int index) {

		if (this.head == null) {
			this.head = new Node<T>();
			this.head.setData(value);
			this.tail = this.head;
		} else {

			int nodeIndex = 0;

			Node<T> currentNode = this.head;

			while (index > nodeIndex) {
				if (currentNode.getNext() != null) {
					currentNode = currentNode.getNext();
				}

				nodeIndex++;
			}

			if (nodeIndex == index) {
				Node<T> newNode = new Node<T>();
				newNode.setData(value);
				newNode.setNext(currentNode.getNext());
				newNode.setPrevious(currentNode);

				if (currentNode.getNext() != null) {
					currentNode.getNext().setPrevious(newNode);
				}

				currentNode.setNext(newNode);
				size++;
			}
		}
	}

	@Override
	public void deleteAtIndex (int index) {

		if (this.head != null) {

			int nodeIndex = 0;

			Node<T> currentNode = this.head;
			Node<T> previousNode = this.head;

			while (nodeIndex != index) {

				previousNode = currentNode;

				if (currentNode.getNext() != null) {
					currentNode = currentNode.getNext();
				}

				nodeIndex++;
			}

			previousNode.setNext(currentNode.getNext());
			size--;
			if (currentNode.getNext() != null) {
				currentNode.getNext().setPrevious(previousNode);
			}
		}
	}

	@Override
	public void deleteFirst () {
		T temp = head.data;

		if (head.next == null) {
			tail = null;
		}

		head = head.next;
		size--;
	}

	@Override
	public Node<T> removeFromEnd () {
		if (isEmpty()) {
			return null;
		}

		Node<T> removedNode = tail;

		if (tail.getPrevious() == null) {
			head = null;
		} else {
			tail.getPrevious().setNext(null);
		}

		tail = tail.getPrevious();
		size--;
		removedNode.setPrevious(null);
		return removedNode;
	}

	@Override
	public void traverse () {
		if (this.head != null) {
			Node<T> currentNode = this.head;
			System.out.print("Start: ");
			while (currentNode != null) {
				System.out.print(currentNode.getData() + "<-->");
				if (currentNode.getNext() == this.head) {
					break;
				}
				currentNode = currentNode.getNext();
			}
			System.out.println("End");
		} else {
			System.out.println("List is empty.");
		}
	}

	@Override
	public void size () {
		System.out.println(size);
	}
}
