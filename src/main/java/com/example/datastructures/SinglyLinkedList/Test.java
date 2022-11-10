package com.example.datastructures.SinglyLinkedList;

public class Test {

	public static void main (String[] args) {
		LinkedList<String> list = new SinglyLinkedList<>();

		list.addToFront("Adam");
		list.addToFront("Joosh");
		list.addToFront("Houssam");
		list.printList();

		System.out.println(list.getSize());
		list.removeFromFront();

		list.printList();
		System.out.println(list.getSize());
		System.out.println(list.isEmpty());
	}

}
