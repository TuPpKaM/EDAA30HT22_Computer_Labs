package testqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import queue_delegate.FifoQueue;
import queue_singlelinkedlist.FifoQueue;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;

class TestAppendFifoQueue {
    private FifoQueue<Integer> myIntQueue;
    private FifoQueue<Integer> myIntQueue2;
	private Queue<String> myStringQueue;

	@BeforeEach
	void setUp() {
		myIntQueue = new FifoQueue<Integer>();
        myIntQueue2 = new FifoQueue<Integer>();
		myStringQueue = new FifoQueue<String>();
	}

	@AfterEach
	void tearDown(){
		myIntQueue = null;
        myIntQueue2 = null;
		myStringQueue = null;
	}

	/**
	 * Test if a newly created queue is empty.
	 */
	@Test
	void testNewFifoQueue() {
		assertTrue(myIntQueue.isEmpty(), "Wrong result from empty of queue");
		assertEquals(0, myIntQueue.size(), "Wrong size of empty queue");
	}

    /**
	 * Test append of two empty queues
	 */
	@Test
	void testEmptyAppendEmptyQueue() {
        myIntQueue.append(myIntQueue2);
        assertEquals(0, myIntQueue.size(), "Wrong size of empty queue");
        assertEquals(0, myIntQueue2.size(), "Wrong size of empty queue");
    }

    /**
	 * Test append of the same queue
	 */
	@Test
	void testAppendSameQueue() {
        assertThrows(IllegalArgumentException.class, () -> myIntQueue.append(myIntQueue));
    }

    /**
	 * Test append of queue with multiple elements to empty queue
	 */
	@Test
	void testEmptyAppendMultipleQueue() {
        int nbr = 5;
		for (int i = 1; i <= nbr; i++) {
			myIntQueue2.offer(i);
		}
        assertEquals(0, myIntQueue.size(), "Wrong size before append");
        myIntQueue.append(myIntQueue2);
        Iterator<Integer> itr = myIntQueue.iterator();
        for (int i = 1; i <= nbr; i++) {
            assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from next");
        }
        assertEquals(5, myIntQueue.size(), "Wrong size after append");
        assertEquals(0, myIntQueue2.size(), "Wrong size");
    }

     /**
	 * Test append of queue with multiple elements to empty queue
	 */
	@Test
	void testMultipleAppendEmptyQueue() {
        int nbr = 5;
		for (int i = 1; i <= nbr; i++) {
			myIntQueue2.offer(i);
		}
        assertEquals(0, myIntQueue.size(), "Wrong size before append");
        myIntQueue2.append(myIntQueue);
        Iterator<Integer> itr = myIntQueue2.iterator();
        for (int i = 1; i <= nbr; i++) {
            assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from next");
        }
        assertEquals(5, myIntQueue2.size(), "Wrong size after append");
        assertEquals(0, myIntQueue.size(), "Wrong size");
    }

     /**
	 * Test append of queue with multiple elements to empty queue
	 */
	@Test
	void testAppendQueue() {
        int nbr = 5;
		for (int i = 1; i <= nbr; i++) {
			myIntQueue.offer(i);
		}
        for (int i = 1; i <= nbr; i++) {
			myIntQueue2.offer(i);
		}
        assertEquals(5, myIntQueue.size(), "Wrong size before append");
        assertEquals(5, myIntQueue2.size(), "Wrong size before append");
        myIntQueue.append(myIntQueue2);
        assertEquals(10, myIntQueue.size(), "Wrong size before append");
        Iterator<Integer> itr = myIntQueue.iterator();
        for (int i = 1; i <= nbr; i++) {
            int r = itr.next();
            assertEquals(Integer.valueOf(i), r, "Wrong result from next");
        }
        for (int i = 1; i <= nbr; i++) {
            assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from next");
        }
        assertEquals(0, myIntQueue2.size(), "Wrong size before append");
        assertTrue(myIntQueue2.isEmpty(), "Queue not empty after append");
    }
}
