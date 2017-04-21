/**
 * 
 */
package edu.ncsu.csc216.bbtp.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class to test ArrayList
 * @author Joey Schauer
 */
public class ArrayListTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.ArrayList#ArrayList(int)}.
	 */
	@Test
	public void testArrayListInt() {
		ArrayList list = null;
		//Test setting list to size less than 0
		try {
			list = new ArrayList(-1);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(list);
		}
		
		//Test setting list to valid size
		list = new ArrayList(5);
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.ArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		ArrayList list = new ArrayList();
		list.add("String");
		//Test to ensure a null object is false
		assertFalse(list.contains(null));
		
		//Test for object not in list
		assertFalse(list.contains("string"));
		
		//Test for object in list
		assertTrue(list.contains("String"));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.ArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddObject() {
		ArrayList list = new ArrayList();
		
		//Test adding null object
		assertFalse(list.add(null));
		
		//Test adding valid object
		assertTrue(list.add("String"));
		assertFalse(list.isEmpty());
		
		//Test adding duplicate object
		assertFalse(list.add("String"));
		
		//Test growing array
		for (int i = 0; i < 10; i++) {
			assertTrue(list.add("String" + i));
			assertTrue(list.size() == (i + 2));
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.ArrayList#get(int)}.
	 */
	@Test
	public void testGet() {
		ArrayList list = new ArrayList();
		
		//Add elements to array
		for (int i = 1; i < 10; i++) {
			assertTrue(list.add("String" + i));
			assertTrue(list.size() == (i));
		}
		
		//Get out of bounds (lower)
		try {
			list.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(list.size() == 9);
		}
		
		//Get out of bounds (upper)
		try {
			list.get(9);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(list.size() == 9);
		}
		
		//Get at beginning
		assertEquals(list.get(0), "String1");
		
		//Get at end
		assertEquals(list.get(8), "String9");
		
		//Get in middle
		assertEquals(list.get(4), "String5");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.ArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntObject() {
		ArrayList list = new ArrayList();
		
		//try adding out of bounds (upper)
		try {
			list.add(5, "String");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(list.isEmpty());
		}
		
		//try adding out of bounds (lower)
		try {
			list.add(-1, "String");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(list.isEmpty());
		}
		
		//try adding null object
		try {
			list.add(0, null);
			fail();
		} catch (NullPointerException e) {
			assertTrue(list.isEmpty());
		}
		
		//Add a valid object
		list.add(0, "String0");
		assertEquals(list.get(0), "String0");
		
		//try adding duplicate object
		try {
			list.add(0, "String0");
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(list.size() == 1);
		}
		
		//Add multiple objects to grow array
		for (int i = 1; i < 11; i++) {
			list.add(i, "String" + i);
			assertEquals(list.get(i), "String" + i);
		}
		
		//Add object at the beginning of the array
		list.add(0, "NewString");
		assertEquals(list.get(0), "NewString");
		assertEquals(list.get(1), "String0");
		
		//Add object in the middle of the array
		list.add(5, "NewMiddle");
		assertEquals(list.get(4), "String3");
		assertEquals(list.get(5), "NewMiddle");
		assertEquals(list.get(6), "String4");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.ArrayList#remove(int)}.
	 */
	@Test
	public void testRemove() {
		ArrayList list = new ArrayList();
		
		//Add multiple objects to array
		for (int i = 0; i < 10; i++) {
			list.add(i, "String" + i);
			assertEquals(list.get(i), "String" + i);
		}
		
		//Try removing from an index out of bounds (lower)
		try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(list.size(), 10);
		}
		
		//Try removing from an index out of bounds (upper)
		try {
			list.remove(10);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(list.size(), 10);
		}
		
		//Remove from the beginning of the list
		assertEquals(list.remove(0), "String0");
		assertTrue(list.size() == 9);
		
		//Remove from the end of the list
		assertEquals(list.remove(8), "String9");
		assertTrue(list.size() == 8);
		
		//Remove from the middle of the list
		assertEquals(list.remove(4), "String5");
		assertTrue(list.size() == 7);
		assertEquals(list.get(4), "String6");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.util.ArrayList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void testIndexOf() {
		ArrayList list = new ArrayList();
		
		//Add multiple objects to array
		for (int i = 0; i < 10; i++) {
			list.add(i, "String" + i);
			assertEquals(list.get(i), "String" + i);
		}
		
		//Testing for string not in array
		assertEquals(-1, list.indexOf("NotInArray"));
		
		//Testing with null string
		assertEquals(-1, list.indexOf(null));
		
		//Testing for string at the beginning of array
		assertEquals(0, list.indexOf("String0"));
		
		//Testing for string at the end of array
		assertEquals(9, list.indexOf("String9"));
		
		//Testing for string in the middle of array
		assertEquals(4, list.indexOf("String4"));
	}

}
