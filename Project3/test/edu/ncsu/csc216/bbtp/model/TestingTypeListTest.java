/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import static org.junit.Assert.*;

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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#indexOf(java.lang.String)}.
	 */
	@Test
	public void testIndexOf() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#indexOfName(java.lang.String)}.
	 */
	@Test
	public void testIndexOfName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#removeTestingTypeAt(int)}.
	 */
	@Test
	public void testRemoveTestingTypeAt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#removeTestingType(java.lang.String)}.
	 */
	@Test
	public void testRemoveTestingType() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#get2DArray()}.
	 */
	@Test
	public void testGet2DArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingTypeList#update(java.util.Observable, java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
