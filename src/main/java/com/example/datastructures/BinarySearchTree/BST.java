package com.example.datastructures.BinarySearchTree;

import java.util.Stack;

public class BST {

	private Node root;

	public void insert (int key, String value) {
		Node newNode = new Node(key, value);

		if (root == null) {
			root = newNode;
		} else {
			Node currentNode = root;
			Node parentNode;

			while (true) {
				parentNode = currentNode;
				if (key < currentNode.key) {
					currentNode = currentNode.left;
					if (currentNode == null) {
						parentNode.left = newNode;
						return;
					}
				} else {
					currentNode = currentNode.right;
					if (currentNode == null) {
						parentNode.right = newNode;
						return;
					}
				}
			}
		}
	}

	public Node findMinimum () {
		Node currentNode = root;
		Node lastNode = null;

		while (currentNode != null) {
			lastNode = currentNode;
			currentNode = currentNode.left;
		}
		return lastNode;
	}

	public Node findMaximum () {
		Node currentNode = root;
		Node lastNode = null;

		while (currentNode != null) {
			lastNode = currentNode;
			currentNode = currentNode.right;
		}
		return lastNode;
	}

	public boolean deleteNode (int key) {
		Node currentNode = root;
		Node parentNode = root;

		boolean leftChild = false;

		while (currentNode.key != key) {
			parentNode = currentNode;
			if (key < currentNode.key) {
				leftChild = true;
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
				leftChild = false;
			}
			if (currentNode == null) {
				return false;
			}
		}

		Node nodeToDelete = currentNode;

		if (nodeToDelete.left == null && nodeToDelete.right == null) {
			if (nodeToDelete == root) {
				root = null;
			} else if (leftChild) {
				parentNode.left = null;
			} else {
				parentNode.right = null;
			}
		} else if (nodeToDelete.left == null) {
			if (nodeToDelete == root) {
				root = nodeToDelete.right;
			} else if (leftChild) {
				parentNode.left = nodeToDelete.right;
			} else {
				parentNode.right = nodeToDelete.right;
			}
		} else {
			Node successor = getSuccessor(nodeToDelete);
			if (nodeToDelete == root) {
				root = successor;
			} else if (leftChild) {
				parentNode.left = successor;
			} else {
				parentNode.right = successor;
			}
			successor.left = nodeToDelete.left;
		}
		return true;
	}

	private Node getSuccessor (Node nodeToDelete) {
		Node parent = nodeToDelete;
		Node successor = nodeToDelete;

		Node currentNode = nodeToDelete.right;

		while (currentNode != null) {
			parent = successor;
			successor = currentNode;
			currentNode = currentNode.left;
		}
		if (successor != nodeToDelete.right) {
			parent.left = successor.right;
			successor.right = nodeToDelete.right;
		}
		return successor;
	}

	public void displayTree () {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");

		while (isRowEmpty == false) {
			Stack localStack = new Stack();
			isRowEmpty = true;
			for (int j = 0; j < nBlanks; j++) {
				System.out.print(" ");
			}

			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.key);
					localStack.push(temp.left);
					localStack.push(temp.right);
					if (temp.left != null || temp.right != null) {
						isRowEmpty = false;
					}
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}

				for (int j = 0; j < nBlanks * 2 - 2; j++) {
					System.out.print(" ");
				}
			}

			System.out.println();
			nBlanks = nBlanks / 2;

			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		}
		System.out.println("......................................................");

	}
}
