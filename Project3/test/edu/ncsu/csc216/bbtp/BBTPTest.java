/**
 * 
 */
package edu.ncsu.csc216.bbtp;

import static org.junit.Assert.*;

import java.util.Observable;

import org.junit.Test;

import edu.ncsu.csc216.bbtp.model.TestCaseList;

/**
 * Test class for BBTP
 * @author Joey Schauer
 */
public class BBTPTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.BBTP#setFilename(java.lang.String)}.
	 */
	@Test
	public void testSetFilename() {
		BBTP bbtp = new BBTP();
		assertNull(bbtp.getFilename());
		
		//set null filename
		try {
			bbtp.setFilename(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(bbtp.getFilename());
		}
		
		//set empty string filename
		try {
			bbtp.setFilename("");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(bbtp.getFilename());
		}
		
		//set valid filename
		bbtp.setFilename("filename");
		assertEquals(bbtp.getFilename(), "filename");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.BBTP#addTestCaseList()}.
	 */
	@Test
	public void testAddTestCaseList() {
		BBTP bbtp = new BBTP();
		assertEquals(bbtp.getNumTestCaseLists(), 1);
		
		//Test getting invalid list lower
		try {
			bbtp.getTestCaseList(-1);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(bbtp.getNumTestCaseLists(), 1);
		}
		
		//Test getting invalid list upper
		try {
			bbtp.getTestCaseList(1);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(bbtp.getNumTestCaseLists(), 1);
		}
		
		//Test getting valid list
		TestCaseList list = bbtp.getTestCaseList(0);
		assertEquals(list.getTestCaseListID(), "TCL1");
		
		//Add a new list to the bbtp
		assertEquals(bbtp.addTestCaseList(), 1);
		list = bbtp.getTestCaseList(1);
		assertEquals(list.getTestCaseListID(), "TCL2");
		
		//Add multiple to grow
		for (int i = 2; i < 11; i++) {
			assertEquals(bbtp.addTestCaseList(), i);
			list = bbtp.getTestCaseList(i);
			assertEquals(list.getTestCaseListID(), "TCL" + (i + 1));
		}
		
		bbtp.getTestingTypeList();
		
		//Check changed
		assertFalse(bbtp.isChanged());
		bbtp.setChanged(true);
		assertTrue(bbtp.isChanged());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.BBTP#removeTestCaseList(int)}.
	 */
	@Test
	public void testRemoveTestCaseList() {
		BBTP bbtp = new BBTP();
		assertEquals(bbtp.getNumTestCaseLists(), 1);
		
		//test removing invalid index lower
		try {
			bbtp.removeTestCaseList(-1);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(bbtp.getNumTestCaseLists(), 1);
		}
		
		//test removing invalid index upper
		try {
			bbtp.removeTestCaseList(1);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(bbtp.getNumTestCaseLists(), 1);
		}
		
		//Add a new list to the bbtp
		assertEquals(bbtp.addTestCaseList(), 1);
		TestCaseList list = bbtp.getTestCaseList(1);
		assertEquals(list.getTestCaseListID(), "TCL2");
		
		//Remove from beginning
		bbtp.removeTestCaseList(0);
		assertEquals(bbtp.getNumTestCaseLists(), 1);
		assertEquals(bbtp.getTestCaseList(0).getTestCaseListID(), "TCL2");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.BBTP#saveDataFile(java.lang.String)}.
	 */
	@Test
	public void testSaveDataFile() {
		BBTP bbtp = new BBTP();
		assertEquals(bbtp.getNumTestCaseLists(), 1);
		
		//invalid filenames
		assertFalse(bbtp.saveDataFile(null));
		assertFalse(bbtp.saveDataFile(""));
		
		//valid filename
		assertTrue(bbtp.saveDataFile("test-files/BBTP_Test.txt"));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.BBTP#openDataFile(java.lang.String)}.
	 */
	@Test
	public void testOpenDataFile() {
		BBTP bbtp = new BBTP();
		assertEquals(bbtp.getNumTestCaseLists(), 1);
		
		try {
			bbtp.openDataFile("Nope");
		} catch(Exception e) {
			assertEquals(bbtp.getNumTestCaseLists(), 1);
		}
		
		assertTrue(bbtp.saveDataFile("test-files/BBTP_Test.txt"));
		
		bbtp.openDataFile("test-files/BBTP_Test.txt");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.bbtp.BBTP#update(java.util.Observable, java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		BBTP bbtp = new BBTP();
		assertEquals(bbtp.getNumTestCaseLists(), 1);
		
		Observable o = new Observable();
		bbtp.update(o, "String");
	}

}
