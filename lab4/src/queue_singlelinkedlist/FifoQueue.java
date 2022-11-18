package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		if(last==null) { //empty list, create a new node and link it back to itself
			last = new QueueNode<E>(e);
			last.next = last;
		} else { //nonempty, put the new node last and link it up
			QueueNode<E> save = last;
			last = new QueueNode<E>(e);
			last.next = save.next;
			save.next = last;
		}

		size++; //added 1
		return true;
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if (last==null){
			return null;
		}
		return last.next.element;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if (last==null){  //null if the queue is empty 
			return null;
		}
		if(size==1) { //only one element left, remove it and return
			E element = last.element;
			last=null;
			size--;
			return element;
		}
		E element = last.next.element; //multiple elements, remove it and move on
		last.next = last.next.next;
		size--;
		return element;
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	/**
	* Appends the specified queue to this queue
	* post: all elements from the specified queue are appended
	* to this queue. The specified queue (q) is empty after the call.
	* @param q the queue to append
	* @throws IllegalArgumentException if this queue and q are identical
	*/
	public void append(FifoQueue<E> q) {
		if(this==q){
			throw new IllegalArgumentException();
		} else if (this.last==null){
			this.last=q.last;
		} else if (q.last!=null){
			QueueNode<E> saveFirst = this.last.next; //save your own first element
			this.last.next = q.last.next;
			q.last.next = saveFirst;  //link upp the last och the new queue with own first element
		}
		this.size = this.size + q.size();
		q.size=0;
		q.last=null;
	}


	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		private QueueIterator(){
			pos = last;
		}

		public boolean hasNext() {
			if(pos==null){  //unless it's null we have more to return
				return false;
			}
			return true;
		}

		public E next() {
			if(pos==null){ //nothing to return
				throw new NoSuchElementException();
			}

			if(pos.next.equals(last)){ //if we have reached the end, return the last element and set the remaining to null
				E element = pos.next.element;
				pos=null;
				return element;
			}
			pos=pos.next; //if in the middle of que, return element and move forward
			return pos.element;
		}
	
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
