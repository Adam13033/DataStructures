package com.example.datastructures.BinarySearchTree;

public class BST {

	private Node root;

	public void insert(int value) {
		if (root == null) {
			root = new Node(value);
		}
		else {
			root.insert(value);
		}
	}

	public Node get(int value) {
		if (root != null) {
			return root.get(value);
		}

		return null;
	}

	public void delete(int value) {
		root = delete(root, value);
	}

	private Node delete(Node subtreeRoot, int value) {
		if (subtreeRoot == null) {
			return subtreeRoot;
		}

		if (value < subtreeRoot.getData()) {
			subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
		}
		else if (value > subtreeRoot.getData()) {
			subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
		}
		else {
			if (subtreeRoot.getLeftChild() == null) {
				return subtreeRoot.getRightChild();
			}
			else if (subtreeRoot.getRightChild() == null) {
				return subtreeRoot.getLeftChild();
			}
		}

		return subtreeRoot;
	}

	public int min() {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		else {
			return root.min();
		}
	}

	public int max() {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		else {
			return root.max();
		}
	}

	public void traverseInOrder() {
		if (root != null) {
			root.traverseInOrder();
		}
	}

}
