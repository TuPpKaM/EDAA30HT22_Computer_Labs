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
		root = null;
		size = 0;
		this.ccomparator = (e1,e2) -> ((Comparable<E>) e1).compareTo(e2);
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		root = null;
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
		int compareValue = ccomparator.compare(x, node.element);
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
			printer(root);
		}
	}

	private void printer(BinaryNode<E> node){
		if (node!= null){
			printer(node.left);
			System.out.print(" "+node.element);
			printer(node.right);
		}
		
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> sorted = new ArrayList<E>();
		toArray(root, sorted);
		root = buildTree(sorted, 0, size-1);
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if (n!= null){
			toArray(n.left,sorted);
			sorted.add(n.element);
			toArray(n.right,sorted);
		}
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if (last<first) {  // out of elements to place
			return null;
		} else if (first==last) { // last element, put it in
			return new BinaryNode<E>(sorted.get(first));
		}

		int middle = (first+last)/2; // + first incase e dont start at 0
		BinaryNode<E> midNode = new BinaryNode<E>(sorted.get(middle));

		midNode.right = buildTree(sorted, middle+1, last); //right side
		midNode.left = buildTree(sorted, first, middle-1); //left side

		return midNode;
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