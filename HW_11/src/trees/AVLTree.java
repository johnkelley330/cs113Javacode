package trees;

/**
 * Implementation of the AVL tree. The AVL tree is a binary search tree with
 * methods built in to auto balance its self.
 * 
 * @author W7258645
 *
 * @param <E>
 *            The type of data to be stored
 */
public class AVLTree<E extends Comparable<E>> extends BinarySearchTree<E> {

	private boolean increase;

	/**
	 * The inner class for the nodes to be stored in the AVL tree.
	 * 
	 * @author W7258645
	 *
	 * @param <E>
	 *            The type of data to be stored in the node
	 */
	protected static class AVLNode<E> extends Node<E> {

		public static final int LEFT_HEAVY = -1;
		public static final int BALANCED = 0;
		public static final int RIGHT_HEAVY = 1;
		private int balance;

		/**
		 * Initializes the balance to zero and the data inside to the data
		 * passed.
		 * 
		 * @param data
		 *            The data to be stored in the node.
		 */
		public AVLNode(E data) {
			super(data);
			balance = BALANCED;
		}

		/**
		 * Return the string representation of this object. It also shows the
		 * balance value.
		 * 
		 * @return the string representation of this object
		 */
		public String toString() {
			return balance + ": " + super.toString();
		}
	}

	/**
	 * Adds the item to the tree if it does not already exist. It also keeps the
	 * balance of the tree by rebalancing it if the item added puts it out of
	 * balance.
	 * 
	 * @param item
	 *            The item to be inserted
	 * @return True if the item was inserted, false otherwise
	 */
	public boolean add(E item) {
		increase = false;
		root = add((AVLNode<E>) root, item);
		// toString();
		return addReturn;
	}

	/**
	 * The recursive add method. Adds to the ordered position in the tree and
	 * then balances the tree if it is out of balance.
	 * 
	 * @param localRoot
	 *            The local root of the current binary tree.
	 * @param item
	 *            The item to be inserted
	 * @return The new local root of the subtree with the item inserted
	 */
	private AVLNode<E> add(AVLNode<E> localRoot, E item) {
		if (localRoot == null) {
			addReturn = true;
			increase = true;
			return new AVLNode<E>(item);
		} else if (item.compareTo(localRoot.data) == 0) {
			increase = false;
			addReturn = false;
			return localRoot;
		} else if (item.compareTo(localRoot.data) < 0) {
			localRoot.left = add((AVLNode<E>) localRoot.left, item);
			if (increase) {
				decrementBalance(localRoot);
				if (localRoot.balance < AVLNode.LEFT_HEAVY) {
					increase = false;
					return rebalanceLeft(localRoot);
				}
			}
			return localRoot;
		} else {
			localRoot.right = add((AVLNode<E>) localRoot.right, item);
			if (increase) {
				incrementBalance(localRoot);
				if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
					increase = false;
					return rebalanceRight(localRoot);
				}
			}
			return localRoot;
		}
	}

	/**
	 * Rebalances the tree in all cases of the left is out of balance. Also
	 * resets all the balances of the nodes to the current balance.
	 * 
	 * @param localRoot
	 *            The root to perform the rebalancing on.
	 * @return The new root after the rebalancing
	 */
	private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot) {
		AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
		if (leftChild.balance > AVLNode.BALANCED) {
			AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
			if (leftRightChild.balance < AVLNode.BALANCED) {
				leftChild.balance = AVLNode.BALANCED;
				leftRightChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.RIGHT_HEAVY;
			} else if (leftRightChild.balance > AVLNode.BALANCED) {
				leftChild.balance = AVLNode.LEFT_HEAVY;
				leftRightChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;

			} else {
				leftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			}
			localRoot.left = rotateLeft(leftChild);
		} else {
			leftChild.balance = AVLNode.BALANCED;
			localRoot.balance = AVLNode.BALANCED;
		}
		return (AVLNode<E>) rotateRight(localRoot);
	}

	/**
	 * Rebalances the tree in all cases of the right is out of balance. Also
	 * resets all the balances of the nodes to the current balance.
	 * 
	 * @param localRoot
	 *            The root to perform the rebalancing on.
	 * @return The new root after the rebalancing
	 */
	private AVLNode<E> rebalanceRight(AVLNode<E> localRoot) {
		AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
		if (rightChild.balance < AVLNode.BALANCED) {
			AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;
			if (rightLeftChild.balance > AVLNode.BALANCED) {
				rightChild.balance = AVLNode.BALANCED;
				rightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.LEFT_HEAVY;
			} else if (rightLeftChild.balance < AVLNode.BALANCED) {
				rightChild.balance = AVLNode.RIGHT_HEAVY;
				rightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;

			} else {
				rightChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			}
			localRoot.right = rotateRight(rightChild);
		} else {
			rightChild.balance = AVLNode.BALANCED;
			localRoot.balance = AVLNode.BALANCED;
		}
		return (AVLNode<E>) rotateLeft(localRoot);
	}

	/**
	 * Decrements the balance of the node.
	 * 
	 * @param node
	 *            The node to decrement the balance of.
	 */
	private void decrementBalance(AVLNode<E> node) {
		node.balance--;
		if (node.balance == AVLNode.BALANCED) {
			increase = false;
		}
	}

	/**
	 * Increments the balance of the node.
	 * 
	 * @param node
	 *            The node to increment the balance of.
	 */
	private void incrementBalance(AVLNode<E> node) {
		node.balance++;
		if (node.balance == AVLNode.BALANCED) {
			increase = false;
		}
	}

	/**
	 * Rotates to the right around the root.
	 * 
	 * @param root
	 *            The root on which to perform the rebalance.
	 * @return The new root after the rebalance
	 */
	private Node<E> rotateRight(AVLNode<E> root) {
		AVLNode<E> temp = (AVLNode<E>) root.left;
		root.left = temp.right;
		temp.right = root;
		return temp;
	}

	/**
	 * Rotates to the left around the root.
	 * 
	 * @param root
	 *            The root on which to perform the rebalance.
	 * @return The new root after the rebalance
	 */
	private Node<E> rotateLeft(AVLNode<E> root) {
		AVLNode<E> temp = (AVLNode<E>) root.right;
		root.right = temp.left;
		temp.left = root;
		return temp;
	}
}
