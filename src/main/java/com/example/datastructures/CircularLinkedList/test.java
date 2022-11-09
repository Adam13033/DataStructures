package com.example.datastructures.CircularLinkedList;

public class test {
	public static void main (String[] args) {
		CircularList<String> list = new CircularLinkedList<>();
		list.addFirst("aaa");
		list.addFirst("bbbb");
		list.addLast("sddfsf");
		list.addFirst("sdfdsfsd");
		list.traverse();
		list.delete("aaa");
		list.delete("bbbb");
		list.traverse();

		list.addAfterIndex("should be index 3", 2);
		list.traverse();

		list.deleteAtIndex(2);
		list.traverse();
	}
}
