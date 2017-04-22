/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * Test class for TestCase
 * @author Joey Schauer
 */
public class TestCaseTest {
	private static final String TEST_CASE_ID = "TC1";
	private static final Date CREATION_DATE_TIME = new Date();
	private static final String DESCRIPTION = "Description";
	private static final String EXPECTED_RESULTS = "It will pass";
	private static final String ACTUAL_RESULTS = "It passed";
	private static final Date LAST_TESTED_DATE_TIME = new Date();
	private static final boolean TESTED_STATUS = true;
	private static final boolean PASS = true;
	private static final TestingType TESTING_TYPE = new TestingType("Functional", "It is functional", "TT1");

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCase#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		TestCase testCase1 = new TestCase(TEST_CASE_ID, DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		TestCase testCase2 = new TestCase(TEST_CASE_ID, DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		TestCase testCase3 = new TestCase("TC3", DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		
		assertEquals(testCase1.hashCode(), testCase2.hashCode());
		assertNotEquals(testCase1.hashCode(), testCase3.hashCode());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCase#TestCase(java.lang.String, java.lang.String, edu.ncsu.csc216.bbtp.model.TestingType, java.util.Date, java.lang.String, boolean, java.util.Date, java.lang.String, boolean)}.
	 */
	@Test
	public void testTestCase() {
		TestCase testCase = new TestCase(TEST_CASE_ID, DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		assertEquals(testCase.getTestCaseID(), TEST_CASE_ID);
		assertEquals(testCase.getDescription(), DESCRIPTION);
		assertEquals(testCase.getTestingType(), TESTING_TYPE);
		assertEquals(testCase.getCreationDateTime(), CREATION_DATE_TIME);
		assertEquals(testCase.getExpectedResults(), EXPECTED_RESULTS);
		assertEquals(testCase.tested(), TESTED_STATUS);
		assertEquals(testCase.getLastTestedDateTime(), LAST_TESTED_DATE_TIME);
		assertEquals(testCase.getActualResults(), ACTUAL_RESULTS);
		assertEquals(testCase.pass(), PASS);
		
		//Test passing a null id
		try {
			testCase = new TestCase(null, DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
					LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
			fail();
		} catch (Exception e) {
			assertEquals(testCase.getTestCaseID(), TEST_CASE_ID);
		}
		
		//Test passing a empty string id
		try {
			testCase = new TestCase("", DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
					LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
			fail();
		} catch (Exception e) {
			assertEquals(testCase.getTestCaseID(), TEST_CASE_ID);
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCase#setDescription(java.lang.String)}.
	 */
	@Test
	public void testSetDescription() {
		TestCase testCase = new TestCase(TEST_CASE_ID, DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		assertEquals(testCase.getTestCaseID(), TEST_CASE_ID);
		assertEquals(testCase.getDescription(), DESCRIPTION);
		assertEquals(testCase.getTestingType(), TESTING_TYPE);
		assertEquals(testCase.getCreationDateTime(), CREATION_DATE_TIME);
		assertEquals(testCase.getExpectedResults(), EXPECTED_RESULTS);
		assertEquals(testCase.tested(), TESTED_STATUS);
		assertEquals(testCase.getLastTestedDateTime(), LAST_TESTED_DATE_TIME);
		assertEquals(testCase.getActualResults(), ACTUAL_RESULTS);
		assertEquals(testCase.pass(), PASS);
		
		//Test null
		try {
			testCase.setDescription(null);
		} catch (IllegalArgumentException e) {
			assertEquals(testCase.getDescription(), DESCRIPTION);
		}
		
		//Test an empty string
		try {
			testCase.setDescription("");
		} catch (IllegalArgumentException e) {
			assertEquals(testCase.getDescription(), DESCRIPTION);
		}
		
		//Test a string with only spaces
		try {
			testCase.setDescription("          ");
		} catch (IllegalArgumentException e) {
			assertEquals(testCase.getDescription(), DESCRIPTION);
		}
		
		//Test valid description
		testCase.setDescription("New description");
		assertEquals(testCase.getDescription(), "New description");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCase#setExpectedResults(java.lang.String)}.
	 */
	@Test
	public void testSetExpectedResults() {
		TestCase testCase = new TestCase(TEST_CASE_ID, DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		assertEquals(testCase.getTestCaseID(), TEST_CASE_ID);
		assertEquals(testCase.getDescription(), DESCRIPTION);
		assertEquals(testCase.getTestingType(), TESTING_TYPE);
		assertEquals(testCase.getCreationDateTime(), CREATION_DATE_TIME);
		assertEquals(testCase.getExpectedResults(), EXPECTED_RESULTS);
		assertEquals(testCase.tested(), TESTED_STATUS);
		assertEquals(testCase.getLastTestedDateTime(), LAST_TESTED_DATE_TIME);
		assertEquals(testCase.getActualResults(), ACTUAL_RESULTS);
		assertEquals(testCase.pass(), PASS);
		
		//Test null 
		try {
			testCase.setExpectedResults(null);
		} catch (IllegalArgumentException e) {
			assertEquals(testCase.getExpectedResults(), EXPECTED_RESULTS);
		}
		
		//Test an empty string
		try {
			testCase.setExpectedResults("");
		} catch (IllegalArgumentException e) {
			assertEquals(testCase.getExpectedResults(), EXPECTED_RESULTS);
		}
		
		//Test a string with only spaces
		try {
			testCase.setExpectedResults("          ");
		} catch (IllegalArgumentException e) {
			assertEquals(testCase.getExpectedResults(), EXPECTED_RESULTS);
		}
		
		//Test valid string
		testCase.setExpectedResults("New expected results");
		assertEquals(testCase.getExpectedResults(), "New expected results");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCase#setActualResults(java.lang.String)}.
	 */
	@Test
	public void testSetActualResults() {
		TestCase testCase = new TestCase(TEST_CASE_ID, DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		assertEquals(testCase.getTestCaseID(), TEST_CASE_ID);
		assertEquals(testCase.getDescription(), DESCRIPTION);
		assertEquals(testCase.getTestingType(), TESTING_TYPE);
		assertEquals(testCase.getCreationDateTime(), CREATION_DATE_TIME);
		assertEquals(testCase.getExpectedResults(), EXPECTED_RESULTS);
		assertEquals(testCase.tested(), TESTED_STATUS);
		assertEquals(testCase.getLastTestedDateTime(), LAST_TESTED_DATE_TIME);
		assertEquals(testCase.getActualResults(), ACTUAL_RESULTS);
		assertEquals(testCase.pass(), PASS);
		
		//Test null 
		try {
			testCase.setActualResults(null);
		} catch (IllegalArgumentException e) {
			assertEquals(testCase.getActualResults(), ACTUAL_RESULTS);
		}
		
		//Test an empty string
		try {
			testCase.setActualResults("");
		} catch (IllegalArgumentException e) {
			assertEquals(testCase.getActualResults(), ACTUAL_RESULTS);
		}
		
		//Test a string with only spaces
		try {
			testCase.setActualResults("          ");
		} catch (IllegalArgumentException e) {
			assertEquals(testCase.getActualResults(), ACTUAL_RESULTS);
		}
		
		//Test valid string
		testCase.setActualResults("New actual results");
		assertEquals(testCase.getActualResults(), "New actual results");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCase#setCreationDateTime(java.util.Date)}.
	 */
	@Test
	public void testSetCreationDateTime() {
		TestCase testCase = new TestCase(TEST_CASE_ID, DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		assertEquals(testCase.getTestCaseID(), TEST_CASE_ID);
		assertEquals(testCase.getDescription(), DESCRIPTION);
		assertEquals(testCase.getTestingType(), TESTING_TYPE);
		assertEquals(testCase.getCreationDateTime(), CREATION_DATE_TIME);
		assertEquals(testCase.getExpectedResults(), EXPECTED_RESULTS);
		assertEquals(testCase.tested(), TESTED_STATUS);
		assertEquals(testCase.getLastTestedDateTime(), LAST_TESTED_DATE_TIME);
		assertEquals(testCase.getActualResults(), ACTUAL_RESULTS);
		assertEquals(testCase.pass(), PASS);
		
		//Test null 
		try {
			testCase.setCreationDateTime(null);
		} catch (IllegalArgumentException e) {
			assertEquals(testCase.getCreationDateTime(), CREATION_DATE_TIME);
		}
		
		//test valid date
		Date newDate = new Date();
		testCase.setCreationDateTime(newDate);
		assertEquals(testCase.getCreationDateTime(), newDate);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCase#setLastTestedDateTime(java.util.Date)}.
	 */
	@Test
	public void testSetLastTestedDateTime() {
		TestCase testCase = new TestCase(TEST_CASE_ID, DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		assertEquals(testCase.getTestCaseID(), TEST_CASE_ID);
		assertEquals(testCase.getDescription(), DESCRIPTION);
		assertEquals(testCase.getTestingType(), TESTING_TYPE);
		assertEquals(testCase.getCreationDateTime(), CREATION_DATE_TIME);
		assertEquals(testCase.getExpectedResults(), EXPECTED_RESULTS);
		assertEquals(testCase.tested(), TESTED_STATUS);
		assertEquals(testCase.getLastTestedDateTime(), LAST_TESTED_DATE_TIME);
		assertEquals(testCase.getActualResults(), ACTUAL_RESULTS);
		assertEquals(testCase.pass(), PASS);
		
		//test null date for tested case
		testCase.setLastTestedDateTime(null);
		assertEquals(testCase.getLastTestedDateTime(), LAST_TESTED_DATE_TIME);
		
		//Test null date for not tested case
		testCase.setTestedStatus(false);
		testCase.setLastTestedDateTime(null);
		assertNull(testCase.getLastTestedDateTime());
		
		//test valid date
		Date newDate = new Date();
		testCase.setLastTestedDateTime(newDate);
		assertEquals(testCase.getLastTestedDateTime(), newDate);
		
		//Test pass
		assertTrue(testCase.pass());
		testCase.setPass(false);
		assertFalse(testCase.pass());
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCase#setTestingType(edu.ncsu.csc216.bbtp.model.TestingType)}.
	 */
	@Test
	public void testSetTestingType() {
		TestCase testCase = new TestCase(TEST_CASE_ID, DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		assertEquals(testCase.getTestCaseID(), TEST_CASE_ID);
		assertEquals(testCase.getDescription(), DESCRIPTION);
		assertEquals(testCase.getTestingType(), TESTING_TYPE);
		assertEquals(testCase.getCreationDateTime(), CREATION_DATE_TIME);
		assertEquals(testCase.getExpectedResults(), EXPECTED_RESULTS);
		assertEquals(testCase.tested(), TESTED_STATUS);
		assertEquals(testCase.getLastTestedDateTime(), LAST_TESTED_DATE_TIME);
		assertEquals(testCase.getActualResults(), ACTUAL_RESULTS);
		assertEquals(testCase.pass(), PASS);
		
		//Test null testing type
		try {
			testCase.setTestingType(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(testCase.getTestingType(), TESTING_TYPE);
		}
		
		//Test valid testing type
		TestingType newType = new TestingType("New Type", "It's new", "TT2");
		testCase.setTestingType(newType);
		assertEquals(testCase.getTestingType(), newType);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCase#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		TestCase testCase1 = new TestCase(TEST_CASE_ID, DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		TestCase testCase2 = new TestCase(TEST_CASE_ID, "New description", TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		TestCase testCase3 = new TestCase("TC3", DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		
		//Test for true and false equal values
		assertTrue(testCase1.equals(testCase1));
		assertTrue(testCase1.equals(testCase2));
		assertFalse(testCase1.equals(testCase3));
		assertFalse(testCase1 == null);
		assertFalse(testCase1.equals("String"));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestCase#compareTo(edu.ncsu.csc216.bbtp.model.TestCase)}.
	 */
	@Test
	public void testCompareTo() {
		TestCase testCase1 = new TestCase(TEST_CASE_ID, DESCRIPTION, TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		TestCase testCase2 = new TestCase(TEST_CASE_ID, "New description", TESTING_TYPE, CREATION_DATE_TIME, EXPECTED_RESULTS, TESTED_STATUS, 
				LAST_TESTED_DATE_TIME, ACTUAL_RESULTS, PASS);
		
		//Test exact comparison
		assertEquals(testCase1.compareTo(testCase2), 0);
	}

}
