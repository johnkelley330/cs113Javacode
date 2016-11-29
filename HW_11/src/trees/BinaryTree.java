package trees;

import java.io.Serializable;
import java.util.Scanner;

/**
 * This is a basic tree class with the basic methods to operate a tree.
 * 
 * @author John Kelley
 *
 * @param <E>
 */
public class BinaryTree<E> {

	protected static class Node<E> implements Serializable {

		protected E data;
		protected Node<E> left;
		protected Node<E> right;

		/**
		 * Constructor for the node object and initializes all variables
		 * 
		 * @param data
		 */
		public Node(E data) {
			this.data = data;
			left = null;
			right = null;
		}

		/**
		 * Returns the data inside the node as a string.
		 * 
		 * @return the data inside the node as a string
		 */
		public String toString() {
			return data.toString();
		}
	}

	protected Node<E> root;

	/**
	 * Constructor for an empty binary tree.
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Constructor for a binary tree with the given node as the root.
	 * 
	 * @param root
	 *            The root of the tree
	 */
	protected BinaryTree(Node<E> root) {
		this.root = root;
	}

	/**
	 * Constructor for a binary tree with the given data at the root and the two
	 * given subtrees.
	 * 
	 * @param data
	 *            The root node's data.
	 * @param leftTree
	 *            The left subtree.
	 * @param rightTree
	 *            The right subtree.
	 */
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new Node<E>(data);
		if (leftTree != null) {
			root.left = leftTree.root;
		} else {
			root.left = null;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		} else {
			root.right = null;
		}
	}

	/**
	 * Returns the left subtree.
	 * 
	 * @return The left subtree.
	 */
	public BinaryTree<E> getLeftSubtree() {
		if (root != null && root.left != null) {
			return new BinaryTree<E>(root.left);
		} else {
			return null;
		}
	}

	/**
	 * Returns the right subtree.
	 * 
	 * @return The right subtree.
	 */
	public BinaryTree<E> getRightSubtree() {
		if (root != null && root.right != null) {
			return new BinaryTree<E>(root.right);
		} else {
			return null;
		}
	}

	/**
	 * Returns true if this tree is a leaf, false otherwise.
	 * 
	 * @return True if this tree is a leaf, false otherwise.
	 */
	public boolean isLeaf() {
		return (root.left == null && root.right == null);
	}

	/**
	 * Performs a preorder traversal of the subtree whose root is node. Appends
	 * the representation to the StringBuilder. Increments the value of depth
	 * (the current tree level).
	 * 
	 * @param node
	 *            The root of the tree that is to be traversed.
	 * @param depth
	 *            The current level of the tree.
	 * @param sb
	 *            Appends the node's data to sb.
	 */
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append(" ");
		}
		if (node == null) {
			sb.append("null\n");
		} else {
			sb.append(node.toString() + "\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}

	/**
	 * Returns the String representation of the tree.
	 * 
	 * @return The String representation of the tree.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}

	/**
	 * Constructs a binary tree by its data using Scanner scan.
	 * 
	 * @param scan
	 *            The scanner to be used.
	 * @return The constructed binary tree.
	 */
	public static BinaryTree<String> readBinaryTree(Scanner scan) {
		String data = scan.next();
		if (data.equals("null")) {
			return null;
		} else {
			BinaryTree<String> leftTree = readBinaryTree(scan);
			BinaryTree<String> rightTree = readBinaryTree(scan);
			return new BinaryTree<String>(data, leftTree, rightTree);
		}
	}
}