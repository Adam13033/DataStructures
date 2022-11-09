package com.example.datastructures.CircularLinkedList;

public interface CircularList<T> {
	void addFirst(T data);

	void addLast(T data);

	void delete(T value);

	void deleteFirst();

	void addAfterIndex(T value, int index);

	void deleteAtIndex(int index);

	void traverse();

	void size();

}
