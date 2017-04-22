/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for TestingType
 * @author Joey Schauer
 */
public class TestingTypeTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingType#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		TestingType testType1 = new TestingType("T1", "Type1", "Desc1");
		TestingType testType2 = new TestingType("T1", "Type1", "Desc1");
		TestingType testType3 = new TestingType("T2", "Type2", "Desc2");
		
		//test hash code
		assertEquals(testType1.hashCode(), testType2.hashCode());
		assertNotEquals(testType1.hashCode(), testType3.hashCode());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingType#TestingType(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testTestingType() {
		TestingType testType1 = new TestingType("T1", "Type1", "Desc1");
		
		//test null id
		try {
			testType1 = new TestingType(null, "Nope", "Nope");
		} catch (IllegalArgumentException e) {
			assertEquals(testType1.getTestingTypeID(), "T1");
			assertEquals(testType1.getName(), "Type1");
			assertEquals(testType1.getDescription(), "Desc1");
		}
		
		//test empty id string
		try {
			testType1 = new TestingType("", "Nope", "Nope");
		} catch (IllegalArgumentException e) {
			assertEquals(testType1.getTestingTypeID(), "T1");
			assertEquals(testType1.getName(), "Type1");
			assertEquals(testType1.getDescription(), "Desc1");
		}
		
		//test null name
		try {
			testType1 = new TestingType("T2", null, "Nope");
		} catch (IllegalArgumentException e) {
			assertEquals(testType1.getTestingTypeID(), "T1");
			assertEquals(testType1.getName(), "Type1");
			assertEquals(testType1.getDescription(), "Desc1");
		}
		
		//test empty name string
		try {
			testType1 = new TestingType("T2", "", "Nope");
		} catch (IllegalArgumentException e) {
			assertEquals(testType1.getTestingTypeID(), "T1");
			assertEquals(testType1.getName(), "Type1");
			assertEquals(testType1.getDescription(), "Desc1");
		}
		
		//test null description
		try {
			testType1 = new TestingType("T2", "Type2", null);
		} catch (IllegalArgumentException e) {
			assertEquals(testType1.getTestingTypeID(), "T1");
			assertEquals(testType1.getName(), "Type1");
			assertEquals(testType1.getDescription(), "Desc1");
		}
		
		//test empty description string
		try {
			testType1 = new TestingType("T2", "Type2", "");
		} catch (IllegalArgumentException e) {
			assertEquals(testType1.getTestingTypeID(), "T1");
			assertEquals(testType1.getName(), "Type1");
			assertEquals(testType1.getDescription(), "Desc1");
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingType#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		TestingType testType1 = new TestingType("T1", "Type1", "Desc1");
		TestingType testType2 = new TestingType("T1", "Type1", "Desc1");
		TestingType testType3 = new TestingType("T2", "Type2", "Desc2");
		
		//test invalid
		assertFalse(testType1 == null);
		assertFalse(testType1.equals("String"));
		
		//test equals
		assertTrue(testType1.equals(testType1));
		assertTrue(testType1.equals(testType2));
		assertFalse(testType1.equals(testType3));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingType#compareTo(edu.ncsu.csc216.bbtp.model.TestingType)}.
	 */
	@Test
	public void testCompareTo() {
		TestingType testType1 = new TestingType("T1", "Type1", "Desc1");
		TestingType testType2 = new TestingType("T1", "Type1", "Desc1");
		TestingType testType3 = new TestingType("T2", "Type2", "Desc2");
		
		//test compare to
		assertEquals(testType1.compareTo(testType2), 0);
		assertEquals(testType1.compareTo(testType3), -1);
		assertEquals(testType3.compareTo(testType1), 1);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.model.TestingType#toString()}.
	 */
	@Test
	public void testToString() {
		TestingType testType1 = new TestingType("T1", "Type1", "Desc1");
		
		String toString = "Type1";
		
		assertEquals(testType1.toString(), toString);
	}

}
