package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> ccomparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		size = 0;
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		size = 0;
		this.ccomparator=comparator;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (size == 0) {
			root = new BinaryNode<E>(x);
			size++;
			return true;
		}
		return addNode(root, x);
	}

	private Boolean addNode(BinaryNode<E> node, E x){
		Comparable newElement = (Comparable) x;
		Comparable ourElement = (Comparable) node.element;
		int compareValue = (newElement).compareTo(ourElement);
		System.out.println(compareValue +""+x);
		if (compareValue<0) { //smaller
			if (node.left == null) {
				node.left = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return addNode(node.left, x);
		} else if (compareValue>0) { //bigger
			if (node.right == null) {
				node.right = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return addNode(node.right, x);
		} else {
			return false;
		}
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		int height = 0;
		if (size != 0){
			height = climber(root, 1);
		}
		return height;
	}

	private int climber(BinaryNode<E> node, int height){
		int leftHeight = 0;
		int rightHeight = 0;
		if (node.left == null & node.right == null){
			return height;
		} else {
			if (node.left != null){
				leftHeight = climber(node.left,height+1);
			}
			if(node.right != null){
				rightHeight = climber(node.right,height+1);
			}
		}
		return Math.max(leftHeight, rightHeight);
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		if (root == null){
			System.out.println("Empty tree");
		} else {
			printer(root, 1);
		}
	}

	private void printer(BinaryNode<E> node, int height){
		if (node.left != null){
			printer(node.left,height+1);
		}
		if (node.right != null){
			printer(node.right,height+1);
		}
		System.out.println("ELEMENT: "+node.element + "    HEIGHT: " + height + ">");
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
	
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		return null;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}