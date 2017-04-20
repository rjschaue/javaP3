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
 * @author Joey Schauer
 */
public class BBTP extends Observable implements Serializable, Observer {
	private static final long serialVersionUID = 34992L;
	private static final int RESIZE = 10;
	private int numLists;
	private String filename;
	private boolean changed;
	private int nextTestCaseListNum;
	private TestCaseList[] testCases;
	private TestingTypeList testingTypes;
	
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
	
	public boolean isChanged() {
		return changed;
	}
	
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		if (filename == null || filename.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.filename = filename;
	}
	
	private int getNextTestCaseListNum() {
		return nextTestCaseListNum;
	}
	
	private void incNextTestCaseListNum() {
		nextTestCaseListNum++;
	}
	
	public int getNumTestCaseLists() {
		return numLists;
	}
	
	public TestCaseList getTestCaseList(int index) {
		if (index < 0 || index >= numLists) {
			throw new IndexOutOfBoundsException();
		}
		return testCases[index];
	}
	
	public TestingTypeList getTestingTypeList() {
		return testingTypes;
	}
	
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
	
	public void update(Observable o, Object arg) {
		o.notifyObservers(arg);
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
