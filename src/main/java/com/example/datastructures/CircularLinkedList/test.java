package com.example.datastructures.CircularLinkedList;

public class test {
	public static void main (String[] args) {
		CircularList<String> list = new CircularLinkedList<>();
		list.addFirst("aaa");
		list.size();
		list.addFirst("bbbb");
		System.out.println("Added value");
		list.size();
		list.addLast("sddfsf");
		System.out.println("Added value");
		list.size();
		list.addFirst("sdfdsfsd");
		System.out.println("Added value");
		list.size();
		list.traverse();
		list.delete("aaa");
		System.out.println("deleted value");
		list.size();
		list.delete("bbbb");
		System.out.println("deleted value");
		list.size();
		list.traverse();

		list.addAfterIndex("should be index 3", 2);
		System.out.println("added value");

		list.size();
		list.traverse();

		list.deleteAtIndex(2);
		System.out.println("deleted value");

		list.size();

		list.traverse();
	}
}
