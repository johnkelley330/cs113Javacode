package trees;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	protected boolean addReturn;
	protected E deleteReturn;

	public BinarySearchTree() {
		root = null;
	}

	/**
	 * Starter method add. pre: The object to insert must implement the
	 * Comparable interface.
	 * 
	 * @param item
	 *            The object being inserted
	 * @return true if the object is inserted, false if the object already
	 *         exists in the tree
	 */
	public boolean add(E item) {
		root = add(root, item);
		return addReturn;
	}
	
	/**
	 * Non recursive find method. Finds the target and returns it. If the target is not in the tree it returns null.
	 * 
	 * @param target
	 *            The Comparable object being sought
	 */
	public E find(E target){
		return find(root, target);
	}

	/**
	 * Recursive add method. post: The data field addReturn is set true if the
	 * item is added to the tree, false if the item is already in the tree.
	 * 
	 * @param localRoot
	 *            The local root of the subtree
	 * @param item
	 *            The object to be inserted
	 * @return The new local root that now contains the inserted item
	 */
	private Node<E> add(Node<E> localRoot, E item) {
		if (localRoot == null) {
			addReturn = true;
			return new Node<E>(item);
		} else if (item.compareTo(localRoot.data) == 0) {
			addReturn = false;
			return localRoot;
		} else if (item.compareTo(localRoot.data) < 0) {
			// item is less than localRoot.data
			localRoot.left = add(localRoot.left, item);
			return localRoot;
		} else {
			// item is greater than localRoot.data
			localRoot.right = add(localRoot.right, item);
			return localRoot;
		}
	}

	/**
	 * Recursive find method. Finds the target and returns it. If the target is not in the tree it returns null.
	 * 
	 * @param target
	 *            The Comparable object being sought
	 * @return The object, if found, otherwise null
	 */
	private E find(Node<E> localRoot, E target){
		if(localRoot == null){
			return null;
		}
		int compResult = target.compareTo(localRoot.data);
		if(compResult == 0){
			return localRoot.data;
		}
		else if(compResult < 0){
			return find(localRoot.left, target);
		}
		else{
			return find(localRoot.right, target);
		}
	}
}
