/**
 * 
 */
package edu.ncsu.csc216.bbtp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.model.TestCaseList;
import edu.ncsu.csc216.bbtp.model.TestingTypeList;
import edu.ncsu.csc216.bbtp.util.ArrayList;

/**
 * The black box test plan class that handles file functions
 * @author Joey Schauer
 */
public class BBTP extends Observable implements Serializable, Observer {
	/** The serial version UID for BBTP */
	private static final long serialVersionUID = 34992L;
	/** The constant resize value for the test case list array */
	private static final int RESIZE = 10;
	/** The number of list in the test case list array */
	private int numLists;
	/** The filename of the black box test plan */
	private String filename;
	/** True if the BBTP has changed */
	private boolean changed;
	/** The next test case list number */
	private int nextTestCaseListNum;
	/** The array of test case lists */
	private TestCaseList[] testCases;
	/** The testing type list */
	private TestingTypeList testingTypes;
	
	/**
	 * The null constructor for BBTP
	 */
	public BBTP() {
		testCases = new TestCaseList[RESIZE];
		nextTestCaseListNum = 1;
		TestCaseList newList = new TestCaseList("New List", "TCL" + getNextTestCaseListNum());
		newList.addObserver(this);
		testCases[0] = newList;
		incNextTestCaseListNum();
		testingTypes = new TestingTypeList();
		testingTypes.addObserver(this);
		changed = false;
		numLists = 1;
	}
	
	/**
	 * Returns the changed value
	 * @return the changed value
	 */
	public boolean isChanged() {
		return changed;
	}
	
	/**
	 * Sets changed to the given value
	 * @param changed the value to set changed to
	 */
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	
	/**
	 * Returns the filename of the BBTP
	 * @return the filename of the BBTP
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * Sets the BBTP filename
	 * @param filename the filename to set
	 * @throws IllegalArgumentException if the filename is null or an empty string
	 */
	public void setFilename(String filename) {
		if (filename == null || filename.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.filename = filename;
	}
	
	/**
	 * Returns the next test case list number
	 * @return the next test case list number
	 */
	private int getNextTestCaseListNum() {
		return nextTestCaseListNum;
	}
	
	/**
	 * Increments the next test case list number
	 */
	private void incNextTestCaseListNum() {
		nextTestCaseListNum++;
	}
	
	/**
	 * Returns the number of test case lists
	 * @return the number of test case lists
	 */
	public int getNumTestCaseLists() {
		return numLists;
	}
	
	/**
	 * Returns the test case list at the given index
	 * @param index the index to get the test case list from
	 * @return the test case list at the given index
	 * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the number of lists
	 */
	public TestCaseList getTestCaseList(int index) {
		if (index < 0 || index >= numLists) {
			throw new IndexOutOfBoundsException();
		}
		return testCases[index];
	}
	
	/**
	 * Returns the testing type list
	 * @return the testing type list
	 */
	public TestingTypeList getTestingTypeList() {
		return testingTypes;
	}
	
	/**
	 * Adds a test case list to the array
	 * @return the index of the added test case list
	 */
	public int addTestCaseList() {
		TestCaseList newList = new TestCaseList("New List", "TCL" + getNextTestCaseListNum());
		newList.addObserver(this);
		testCases[numLists] = newList;
		setChanged();
		notifyObservers(newList);
		int index = numLists;
		numLists++;
		incNextTestCaseListNum();
		if (numLists == testCases.length) {
			growArray();
		}
		return index;
	}
	
	/**
	 * Removes the test case list at the given index
	 * @param index the index to remove the test case list from
	 * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the number of lists
	 */
	public void removeTestCaseList(int index) {
		if (index < 0 || index >= numLists) {
			throw new IndexOutOfBoundsException();
		}
		TestCaseList list = testCases[index];
		list.deleteObserver(this);
		for (int i = index; i < numLists; i++) {
			testCases[i] = testCases[i + 1];
		}
		testCases[numLists] = null;
		numLists--;
		setChanged();
		notifyObservers(list);
	}
	
    /**
     * Saves the TestingTypeList and the array of TestCaseLists to the given
     * file using object serialization.
     * 
     * @param fname filename to save BBTP information to.
     * @return true is saved successfully
     */
    public boolean saveDataFile(String fname) {
        if (fname == null || fname.trim().equals("")) {
            System.err.println("Invalid filename" + fname);
            return false;
        } else {
            try {
                FileOutputStream fileOut = new FileOutputStream(fname);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                for (int i = 0; i < numLists; i++) {
                    out.writeObject(testCases[i]);
                }
                out.writeObject(testingTypes);
                out.writeObject(filename);
                out.writeInt(nextTestCaseListNum);
                changed = false;
                out.close();
                fileOut.close();
                return true;
            } catch (IOException e) {
                System.err.println("An error occurred while saving file " + fname);
                e.printStackTrace(System.err);
                return false;
            }
        }
    }

    /**
     * Opens a data file with the given name and creates the data structures
     * from the serialized objects in the file.
     * 
     * @param fname filename to create BBTP information from.
     * @return true is opened successfully
     */
    public boolean openDataFile(String fname) {
        if (changed) {
            saveDataFile(filename);
        }
        try {
            FileInputStream fileIn = new FileInputStream(fname);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList temp = new ArrayList();
            Object tl = in.readObject();
            while (tl instanceof TestCaseList) {
                TestCaseList l = (TestCaseList) tl;
                l.addObserver(this);
                temp.add(l);
                tl = in.readObject();
            }
            testCases = new TestCaseList[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                testCases[i] = (TestCaseList) temp.get(i);
            }
            numLists = temp.size();
            testingTypes = (TestingTypeList) tl;
            testingTypes.addObserver(this);
            filename = (String) in.readObject();
            nextTestCaseListNum = (int) in.readInt();
            for (int i = 0; i < numLists; i++) {
                TestCaseList list = testCases[i];
                for (int j = 0; j < list.size(); j++) {
                    list.getTestCaseAt(j).addObserver(list);
                }
            }
            for (int i = 0; i < testingTypes.size(); i++) {
                testingTypes.getTestingTypeAt(i).addObserver(testingTypes);
            }
            changed = false;
            in.close();
            fileIn.close();
            return true;
        } catch (IOException e) {
            System.err.println("An error occurred while reading file " + fname);
            e.printStackTrace(System.err);
            return false;
        } catch (ClassNotFoundException c) {
            System.err.println("Error reconstructing BBTP from file " + fname);
            c.printStackTrace(System.err);
            return false;
        }
    }
	
    /**
     * Updates the given observable with the given object if valid
     * @param o is the observable to check
     * @param arg is the object to notify the observable of
     */
	public void update(Observable o, Object arg) {
		for (int i = 0; i < numLists; i++) {
			testCases[i].update(o, arg);
		}
		testingTypes.update(o, arg);
	}
	
	/**
	 * Private method to grow the array when needed
	 */
	private void growArray() {
		int newSize = testCases.length + RESIZE;
		TestCaseList[] newList = new TestCaseList[newSize];
		for (int i = 0; i < testCases.length; i++) {
			newList[i] = testCases[i];
		}
		testCases = newList;
	}
}
