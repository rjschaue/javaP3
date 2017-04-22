/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Observable;

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
		assertEquals(list.getTestCaseAt(0).getTestCaseID(), "TCL1-TC1" );
		
		//Add another valid test case
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS));
		assertEquals(list.getTestCaseAt(0).getTestCaseID(), "TCL1-TC1" );
		assertEquals(list.getTestCaseAt(1).getTestCaseID(), "TCL1-TC2" );
		
		//Add another valid test case
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, null, ACTUAL_RESULTS, PASS));
		assertEquals(list.getTestCaseAt(0).getTestCaseID(), "TCL1-TC3" );
		assertEquals(list.getTestCaseAt(1).getTestCaseID(), "TCL1-TC1" );
		assertEquals(list.getTestCaseAt(2).getTestCaseID(), "TCL1-TC2" );
		
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#getTestCaseAt(int)}.
	 */
	@Test
	public void testGetTestCaseAt() {
		TestCaseList list = new TestCaseList("List1", "TCL1");
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS));
		assertEquals(list.getTestCaseAt(0).getTestCaseID(), "TCL1-TC1" );
		
		//Get a test case out of bounds (lower)
		try {
			list.getTestCaseAt(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(list.getTestCaseAt(0).getTestCaseID(), "TCL1-TC1" );
		}
		
		//Get a test case out of bounds (upper)
		try {
			list.getTestCaseAt(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(list.getTestCaseAt(0).getTestCaseID(), "TCL1-TC1" );
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#indexOf(java.lang.String)}.
	 */
	@Test
	public void testIndexOf() {
		TestCaseList list = new TestCaseList("List1", "TCL1");
		
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS));
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS));
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, null, ACTUAL_RESULTS, PASS));
		
		//Try invalid string
		assertEquals(list.indexOf("Nope"), -1);
		
		//Try null string
		assertEquals(list.indexOf(null), -1);
		
		//Try valid string
		assertEquals(list.indexOf("TCL1-TC1"), 1);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#removeTestCaseAt(int)}.
	 */
	@Test
	public void testRemoveTestCaseAt() {
		TestCaseList list = new TestCaseList("List1", "TCL1");
		
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS));
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS));
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, null, ACTUAL_RESULTS, PASS));
		
		//try index out of bounds lower
		try {
			list.removeTestCaseAt(-1);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(list.getTestCaseAt(0).getTestCaseID(), "TCL1-TC3" );
			assertEquals(list.getTestCaseAt(1).getTestCaseID(), "TCL1-TC1" );
			assertEquals(list.getTestCaseAt(2).getTestCaseID(), "TCL1-TC2" );
		}
		
		//try index out of bounds upper
		try {
			list.removeTestCaseAt(3);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(list.getTestCaseAt(0).getTestCaseID(), "TCL1-TC3" );
			assertEquals(list.getTestCaseAt(1).getTestCaseID(), "TCL1-TC1" );
			assertEquals(list.getTestCaseAt(2).getTestCaseID(), "TCL1-TC2" );
		}
		
		//try valid removal
		assertEquals(list.removeTestCaseAt(1).getTestCaseID(), "TCL1-TC1");
		assertEquals(list.getTestCaseAt(0).getTestCaseID(), "TCL1-TC3" );
		assertEquals(list.getTestCaseAt(1).getTestCaseID(), "TCL1-TC2" );
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#removeTestCase(java.lang.String)}.
	 */
	@Test
	public void testRemoveTestCase() {
		TestCaseList list = new TestCaseList("List1", "TCL1");
		
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS));
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS));
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, null, ACTUAL_RESULTS, PASS));
		
		//test removing invalid test
		assertFalse(list.removeTestCase(null));
		assertFalse(list.removeTestCase("Nope"));
		assertEquals(list.getTestCaseAt(0).getTestCaseID(), "TCL1-TC3" );
		assertEquals(list.getTestCaseAt(1).getTestCaseID(), "TCL1-TC1" );
		assertEquals(list.getTestCaseAt(2).getTestCaseID(), "TCL1-TC2" );
		
		//test removing valid test
		assertTrue(list.removeTestCase("TCL1-TC1"));
		assertEquals(list.getTestCaseAt(0).getTestCaseID(), "TCL1-TC3" );
		assertEquals(list.getTestCaseAt(1).getTestCaseID(), "TCL1-TC2" );
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#get2DArray()}.
	 */
	@Test
	public void testGet2DArray() {
		TestCaseList list = new TestCaseList("List1", "TCL1");
		
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS));
		
		Object[][] array = list.get2DArray();
		TestCase testCase = list.getTestCaseAt(0);
		assertEquals(array[0][0], testCase.getTestCaseID());
		assertEquals(array[0][1], testCase.getDescription());
		assertEquals(array[0][2], testCase.getTestingType());
		assertEquals(array[0][3], testCase.getCreationDateTime());
		assertEquals(array[0][4], testCase.getLastTestedDateTime());
		assertEquals(array[0][5], testCase.tested());
		assertEquals(array[0][6], testCase.getExpectedResults());
		assertEquals(array[0][7], testCase.getActualResults());
		assertEquals(array[0][8], testCase.pass());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCaseList#update(java.util.Observable, java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		TestCaseList list = new TestCaseList("List1", "TCL1");
		
		assertTrue(list.addTestCase(DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS));
		Observable o = new Observable();
		
		//invalid
		list.update(o, "String");		
	}

}
