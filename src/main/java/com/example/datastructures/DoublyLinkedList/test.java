package com.example.datastructures.DoublyLinkedList;

public class test {

	public static void main (String[] args) {
		DoublyLinkedList<String> list = new DoublyLinkedList<>();

		list.addToEnd("Adam");
		System.out.println(list.getSize());
		list.printList();

		list.addToFront("Samuel");
		System.out.println(list.getSize());
		list.printList();

		list.addToEnd("abcdef");
		System.out.println(list.getSize());
		list.printList();

		list.deleteFromFront();
		System.out.println(list.getSize());
		list.printList();
	}

}
