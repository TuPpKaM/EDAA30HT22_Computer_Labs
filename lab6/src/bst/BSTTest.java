package bst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTTest {
	private BinarySearchTree<Integer> intTree;
	private BinarySearchTree<String> stringTree;

    
	@BeforeEach
	void setUp() {
		intTree = new BinarySearchTree<Integer>();
		stringTree = new BinarySearchTree<String>();
	}

	@AfterEach
	void tearDown(){
		intTree = null;
		stringTree= null;
	} 

    
	/**
	 * Test if a newly created tree is empty.
	 */
	@Test
	void testNewTreeIsEmpty() {
		assertEquals(0, intTree.size(), "Wrong size of empty tree");
		assertEquals(0, stringTree.size(), "Wrong size of empty tree");
	}

	/**
	 * Test if a tree shows the right size after add
	*/ 
	@Test
	void testTreeSize() {
		intTree.add(12);
		intTree.add(11);
		stringTree.add("b");
		stringTree.add("a");
		assertEquals(2, intTree.size(), "Wrong size for tree of size 2");
		assertEquals(2, stringTree.size(), "Wrong size for tree of size 2");
		intTree.add(9);
		intTree.add(8);
		stringTree.add("c");
		stringTree.add("d");
		assertEquals(4, intTree.size(), "Wrong size for tree of size 4");
		assertEquals(4, stringTree.size(), "Wrong size for tree of size 4");
	}

	/**
	 * Test if a tree accepts duplicates
	*/ 
	@Test
	void testDuplicate() {
		intTree.add(12);
		intTree.add(12);
		stringTree.add("b");
		stringTree.add("b");
		assertEquals(1, intTree.size(), "Wrong size after duplicate entry");
		assertEquals(1, stringTree.size(), "Wrong size after duplicate entry");
	}

	/**
	 * Test if a tree shows the right heigh after adds
	*/ 
	@Test
	void testHeightAfterAdd() {
		for (int i = 1 ; i<10; i++) {
			intTree.add(i);
			assertEquals(i, intTree.height(), "Wrong height after add");
			stringTree.add(((char)i)+"");
			assertEquals(i, stringTree.height(), "Wrong height after add");
		}
		
	}

	/**
	 * Test if height changes to correct after rebuild
	*/ 
	@Test
	void testHeightAfterRebuild() {
		for (int i = 1 ; i<10; i++) {
			intTree.add(i);
			assertEquals(i, intTree.height(), "Wrong height after add");
			stringTree.add(((char)i)+"");
			assertEquals(i, stringTree.height(), "Wrong height after add");
		}
		intTree.rebuild();
		assertEquals(4, intTree.height(), "Wrong height after rebuild");
		
	}

	/**
	 * Test if clear of an empty tree works as intended
	*/ 
	@Test
	void testClearOfEmpty() {
		intTree.clear();
		assertEquals(0, intTree.height(), "Wrong height after clear");
		assertEquals(0, intTree.size(), "Wrong height after clear");
		stringTree.clear();
		assertEquals(0, stringTree.height(), "Wrong height after clear");
		assertEquals(0, stringTree.size(), "Wrong height after clear");
	}

	/**
	 * Test if clear of a full tree sets it to 0
	*/ 
	@Test
	void testClear() {
		for (int i = 1 ; i<10; i++) {
			intTree.add(i);
			assertEquals(i, intTree.height(), "Wrong height after add");
			stringTree.add(((char)i)+"");
			assertEquals(i, stringTree.height(), "Wrong height after add");
		}
		intTree.clear();
		assertEquals(0, intTree.height(), "Wrong height after clear");
		assertEquals(0, intTree.size(), "Wrong height after clear");
		stringTree.clear();
		assertEquals(0, stringTree.height(), "Wrong height after clear");
		assertEquals(0, stringTree.size(), "Wrong height after clear");
		
	}
}
