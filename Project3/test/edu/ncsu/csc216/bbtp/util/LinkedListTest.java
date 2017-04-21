/**
 * 
 */
package edu.ncsu.csc216.bbtp.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for LinkedList
 * @author Joey Schauer
 */
public class LinkedListTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.LinkedList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		LinkedList list = new LinkedList();
		assertTrue(list.isEmpty());
		assertEquals(list.size(), 0);
		
		//Test for string not in empty array
		assertFalse(list.contains("String"));
		
		//Test for null object
		assertFalse(list.contains(null));
		
		//Test for valid string
		list.add("String");
		assertFalse(list.isEmpty());
		assertEquals(list.size(), 1);
		assertTrue(list.contains("String"));
		
		//Test for string not in populated array
		assertFalse(list.contains("String-1"));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.LinkedList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddObject() {
		LinkedList list = new LinkedList();
		assertTrue(list.isEmpty());
		assertEquals(list.size(), 0);
		
		//Add null object to array
		assertFalse(list.add(null));
		
		//Add valid object to array
		assertTrue(list.add("String0"));
		assertTrue(list.contains("String0"));
		assertEquals(list.get(0), "String0");
		
		//Add another object to array
		assertTrue(list.add("String1"));
		assertEquals(list.get(0), "String0");
		assertEquals(list.get(1), "String1");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.LinkedList#get(int)}.
	 */
	@Test
	public void testGet() {
		LinkedList list = new LinkedList();
		
		for (int i = 0; i < 10; i++) {
			assertTrue(list.add("String" + i));
			assertEquals(list.get(i), "String" + i);
		}
		
		//Test lower bounds for index
		try {
			list.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(list.size(), 10);
		}
		
		//Test upper bounds for index
		try {
			list.get(10);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(list.size(), 10);
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.LinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntObject() {
		LinkedList list = new LinkedList();
		
		//Test index out of lower bounds
		try {
			list.add(-1, "String-1");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(list.isEmpty());
		}
		
		//Test index out of upper bounds
		try {
			list.add(1, "String-1");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(list.isEmpty());
		}
		
		//Test null object
		try {
			list.add(0, null);
			fail();
		} catch (NullPointerException e) {
			assertTrue(list.isEmpty());
		}
		
		//Test adding valid string
		list.add(0, "String0");
		assertEquals(list.get(0), "String0");
		assertEquals(list.size(), 1);
		
		//Test adding a duplicate string
		try {
			list.add(1, "String0");
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(list.size() == 1);
		}
		
		//Test adding multiple strings
		for (int i = 1; i < 10; i++) {
			list.add(i, "String" + i);
			assertEquals(list.get(i), "String" + i);
		}
		
		//Test adding at the front of the list
		list.add(0, "NewFront");
		assertEquals(list.get(0), "NewFront");
		assertEquals(list.get(1), "String0");
		assertEquals(list.size(), 11);
		
		//Test adding at the end of the list
		list.add(11, "NewEnd");
		assertEquals(list.get(11), "NewEnd");
		assertEquals(list.get(10), "String9");
		assertEquals(list.size(), 12);
		
		//Test adding at the end of the list
		list.add(6, "NewMiddle");
		assertEquals(list.get(5), "String4");
		assertEquals(list.get(6), "NewMiddle");
		assertEquals(list.get(7), "String5");
		assertEquals(list.size(), 13);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.LinkedList#remove(int)}.
	 */
	@Test
	public void testRemove() {
		LinkedList list = new LinkedList();
		
		//Test remvoing out of low bounds
		try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(list.isEmpty());
		}
		
		//Test removing out of upper bounds
		try {
			list.remove(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(list.isEmpty());
		}
		
		//Add to the list
		for (int i = 0; i < 10; i++) {
			assertTrue(list.add("String" + i));
			assertEquals(list.get(i), "String" + i);
		}
		assertEquals(list.size(), 10);
		
		//Try removing the front string
		assertEquals(list.remove(0), "String0");
		assertFalse(list.contains("String0"));
		assertEquals(list.get(0), "String1");
		assertEquals(list.size(), 9);
		
		//Try removing from end
		assertEquals(list.remove(8), "String9");
		assertFalse(list.contains("String9"));
		assertEquals(list.size(), 8);
		
		//Try removing from the middle
		assertEquals(list.remove(4), "String5");
		assertEquals(list.get(4), "String6");
		assertFalse(list.contains("String5"));
		assertEquals(list.size(), 7);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.LinkedList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void testIndexOf() {
		LinkedList list = new LinkedList();
		
		//Add to the list
		for (int i = 0; i < 10; i++) {
			assertTrue(list.add("String" + i));
			assertEquals(list.get(i), "String" + i);
		}
		assertEquals(list.size(), 10);
		
		//Test getting index with null object
		assertEquals(list.indexOf(null), -1);
			
		//Test getting index with string not in list
		assertEquals(list.indexOf("NotInList"), -1);
		
		//Test getting valid index at beginning
		assertEquals(list.indexOf("String0"), 0);
		
		//Test getting valid index at end
		assertEquals(list.indexOf("String9"), 9);
		
		//Test getting valid index in middle
		assertEquals(list.indexOf("String4"), 4);
	}

}
