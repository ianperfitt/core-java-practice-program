package com.practice.datastructures.Trees.BinaryTree;

import java.util.ArrayList;

//A binary tree is a tree data structure in which
//each node can have at most two children, 
//which are referred to as the left child and the right child. 
public class BinaryTree {

	Node root;

	BinaryTree(int key) {
		root = new Node(key);
	}

	BinaryTree() {
		root = null;
	}

	public void insert(int key) {
		root = insertRec(root, key);
	}

	public void inorder() {
		inorderRec(root);
	}

	public void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key + " ");
			inorderRec(root.right);
		}
	}

	private Node insertRec(Node root, int key) {
		// tree is empty so return new node
		if (root == null) {
			root = new Node(key);
			return root;
		}

		// traverse tree recursively
		else if (key < root.key) {
			root.left = insertRec(root.left, key);
		} else if (key > root.key) {
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	public static void main(String[] args) {

		// 1. instantiate
		BinaryTree tree = new BinaryTree();

		// 2. populate
		tree.root = new Node(10);
		tree.root.left = new Node(20);
		tree.root.right = new Node(500);
		tree.root.left.left = new Node(10);
		tree.root.left.right = new Node(30);

		// 3. add at specific index using recursion
		//	- The worst-case time complexity of insert operations is O(h) where h is the height of the Binary Search Tree. 
		//	- In the worst case, we may have to travel from the root to the deepest leaf node.
		//	- The height of a skewed tree may become n and the time complexity of insertion operation may become O(n). 
		BinaryTree tree2 = new BinaryTree();
		tree2.insert(50);
		tree2.insert(30);
		tree2.insert(20);
		tree2.insert(70);
		tree2.insert(60);
		tree2.insert(80);
		tree2.insert(40);
		
		// 3. add at specific index using iterative method
		//	- The worst-case time complexity of insert operations is O(h) where h is the height of the Binary Search Tree. 
		//	- In the worst case, we may have to travel from the root to the deepest leaf node.
		//	- The height of a skewed tree may become n and the time complexity of insertion operation may become O(n). 
		// https://www.geeksforgeeks.org/insertion-in-binary-search-tree/
		// https://leetcode.com/discuss/study-guide/1733447/Become-Master-In-Recursion
        
		// 4. print all elements
		tree2.inorder();
		
		// 5. print specific element

		// 6. remove at specific index

	
	}
}
