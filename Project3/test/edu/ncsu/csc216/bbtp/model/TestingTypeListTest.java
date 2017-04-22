/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import static org.junit.Assert.*;

import java.util.Observable;

import org.junit.Test;

/**
 * Test class for TestingTypeList
 * @author Joey Schauer
 */
public class TestingTypeListTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#addTestingType(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddTestingType() {
		TestingTypeList list = new TestingTypeList();
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
		assertEquals(list.getName(), "Testing Types");
		
		//test adding valid type
		assertTrue(list.addTestingType("Type", "It's a type"));
		assertEquals(list.getTestingTypeAt(0).getName(), "Type");
		assertEquals(list.getTestingTypeAt(0).getDescription(), "It's a type");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#getTestingTypeAt(int)}.
	 */
	@Test
	public void testGetTestingTypeAt() {
		TestingTypeList list = new TestingTypeList();
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
		assertEquals(list.getName(), "Testing Types");
		
		//test get valid testing type at
		assertTrue(list.addTestingType("Type", "It's a type"));
		assertEquals(list.getTestingTypeAt(0).getName(), "Type");
		assertEquals(list.getTestingTypeAt(0).getDescription(), "It's a type");
		
		//test getting testing type out of bounds lower
		try {
			list.getTestingTypeAt(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(list.size(), 1);
		}
		
		//test getting testing type out of bounds upper
		try {
			list.getTestingTypeAt(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(list.size(), 1);
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#indexOf(java.lang.String)}.
	 */
	@Test
	public void testIndexOf() {
		TestingTypeList list = new TestingTypeList();
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
		assertEquals(list.getName(), "Testing Types");
		
		assertTrue(list.addTestingType("Type", "It's a type"));
		
		//test getting index of invalid type
		assertEquals(list.indexOf("Nope"), -1);
		
		//test getting valid index
		assertEquals(list.indexOf("TT1"), 0);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#indexOfName(java.lang.String)}.
	 */
	@Test
	public void testIndexOfName() {
		TestingTypeList list = new TestingTypeList();
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
		assertEquals(list.getName(), "Testing Types");
		
		assertTrue(list.addTestingType("Type", "It's a type"));
		
		//test getting index of invalid name
		assertEquals(list.indexOfName("Nope"), -1);
		
		//test getting valid index
		assertEquals(list.indexOfName("Type"), 0);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#removeTestingTypeAt(int)}.
	 */
	@Test
	public void testRemoveTestingTypeAt() {
		TestingTypeList list = new TestingTypeList();
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
		assertEquals(list.getName(), "Testing Types");
		
		assertTrue(list.addTestingType("Type", "It's a type"));
		
		//test removing testing type out of bounds lower
		try {
			list.removeTestingTypeAt(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(list.size(), 1);
		}
		
		//test removing testing type out of bounds upper
		try {
			list.removeTestingTypeAt(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(list.size(), 1);
		}
		
		//test removing valid type
		assertEquals(list.removeTestingTypeAt(0).getTestingTypeID(), "TT1");
		assertEquals(list.size(), 0);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#removeTestingType(java.lang.String)}.
	 */
	@Test
	public void testRemoveTestingType() {
		TestingTypeList list = new TestingTypeList();
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
		assertEquals(list.getName(), "Testing Types");
		
		assertTrue(list.addTestingType("Type", "It's a type"));
		
		//test removing invalid id
		assertFalse(list.removeTestingType("Nope"));
		
		//test removing valid id
		assertTrue(list.removeTestingType("TT1"));
		assertEquals(list.size(), 0);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#get2DArray()}.
	 */
	@Test
	public void testGet2DArray() {
		TestingTypeList list = new TestingTypeList();
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
		assertEquals(list.getName(), "Testing Types");
		
		assertTrue(list.addTestingType("Type", "It's a type"));
		
		//test 2d array
		Object[][] array = list.get2DArray();
		assertEquals(array[0][0], "TT1");
		assertEquals(array[0][1], "Type");
		assertEquals(array[0][2], "It's a type");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#update(java.util.Observable, java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		TestingTypeList list = new TestingTypeList();
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
		assertEquals(list.getName(), "Testing Types");
		
		assertTrue(list.addTestingType("Type", "It's a type"));
		
		//test update
		Observable o = new Observable();
		list.update(o, "String");
		
	}

}
