/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * The test class for TestCaseList
 * @author Joey Schauer
 */
public class TestCaseListTest {
	private static final Date CREATION_DATE_TIME = new Date();
	private static final String DESCRIPTION = "Description";
	private static final String EXPECTED_RESULTS = "It will pass";
	private static final String ACTUAL_RESULTS = "It passed";
	private static final Date LAST_TESTED_DATE_TIME = new Date();
	private static final boolean TESTED_STATUS = true;
	private static final boolean PASS = true;
	private static final TestingType TESTING_TYPE = new TestingType("Functional", "It is functional", "TT1");

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#TestCaseList(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testTestCaseList() {
		TestCaseList list = new TestCaseList("List1", "TCL1");
		assertEquals(list.getName(), "List1");
		assertEquals(list.getTestCaseListID(), "TCL1");
		assertTrue(list.isEmpty());
		assertTrue(list.size() == 0);
		
		//Try creating a list with a null id
		try {
			list = new TestCaseList("List2", null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(list.getName(), "List1");
			assertEquals(list.getTestCaseListID(), "TCL1");
		}
		
		//Try creating a list with an empty string id
		try {
			list = new TestCaseList("List2", "");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(list.getName(), "List1");
			assertEquals(list.getTestCaseListID(), "TCL1");
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		TestCaseList list = new TestCaseList("List1", "TCL1");
		assertEquals(list.getName(), "List1");
		list.setName("NewName");
		assertEquals(list.getName(), "NewName");
		
		//Try setting a null name
		try {
			list.setName(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(list.getName(), "NewName");
		}
		
		//Try setting an empty string name
		try {
			list.setName("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(list.getName(), "NewName");
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#addTestCase(java.lang.String, edu.ncsu.csc216.bbtp.model.TestingType, java.util.Date, java.lang.String, boolean, java.util.Date, java.lang.String, boolean)}.
	 */
	@Test
	public void testAddTestCase() {
		TestCaseList list = new TestCaseList("List1", "TCL1");
		
		//Add valid test case
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS));
		
		//Add valid test case with different date
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#getTestCaseAt(int)}.
	 */
	@Test
	public void testGetTestCaseAt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#indexOf(java.lang.String)}.
	 */
	@Test
	public void testIndexOf() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#removeTestCaseAt(int)}.
	 */
	@Test
	public void testRemoveTestCaseAt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#removeTestCase(java.lang.String)}.
	 */
	@Test
	public void testRemoveTestCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#get2DArray()}.
	 */
	@Test
	public void testGet2DArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#update(java.util.Observable, java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
