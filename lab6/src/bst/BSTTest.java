package bst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;

class BESTest {
	private BinarySearchTree<Integer> intTree;
	private BinarySearchTree<String> stringTree;

    /*
	@BeforeEach
	void setUp() {
		myIntQueue = new FifoQueue<Integer>();
		myStringQueue = new FifoQueue<String>();
	}

	@AfterEach
	void tearDown(){
		myIntQueue = null;
		myStringQueue = null;
	} */

    
	// /**
	//  * Test if a newly created queue is empty.
	//  */
	// @Test
	// void testNewFifoQueue() {
	// 	assertTrue(myIntQueue.isEmpty(), "Wrong result from empty of queue");
	// 	assertEquals(0, myIntQueue.size(), "Wrong size of empty queue");
	// }

	// /** Test a single offer followed by a single peek. */
	// @Test
	// void testPeek() {
	// 	myIntQueue.offer(1);
	// 	int i = myIntQueue.peek();
	// 	assertEquals(1, i, "peek on queue of size 1");
	// 	assertEquals(1, myIntQueue.size(), "peek on queue of size 1");
	// }
    
}
