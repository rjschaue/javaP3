/**
 * 
 */
package edu.ncsu.csc216.bbtp.ui;

import java.awt.Color;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import edu.ncsu.csc216.bbtp.model.TestCaseList;

/**
 * This class is for the test case list pane
 * @author Joey Schauer
 */
public class TestCaseListPane extends JScrollPane implements Serializable, Observer {
	/** the serial version UID for TestCaseListPane */
	private static final long serialVersionUID = -2210716111020406799L;
	/** The test case list */
	private TestCaseList testCases;
	/** the table for the pane */
	private JTable table;
	/** the widths for the columns */
	private int[] colWidths = { 50, 50, 50, 50, 50, 50, 50, 50, 50 };
	/** the test case table model */
	private TestCaseTableModel tctm;
	
	/** 
	 * Constructor for TestCaseListPane
	 * @param testCases the tests cases to set for the list pane
	 */
	public TestCaseListPane(TestCaseList testCases) {
		super();
		this.testCases = testCases;
		this.testCases.addObserver(this);
		tctm = new TestCaseTableModel(testCases.get2DArray());
		initView();
	}
	
	/**
	 * Returns the test case table model
	 * @return the test case table model
	 */
	public TestCaseTableModel getTestCaseTableModel() {
		return tctm;
	}
	
	/**
	 * Returns the table
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}
	
	/**
	 * Initializes the pane view
	 */
	private void initView() {
		table = new JTable(tctm);
		for (int i = 0; i < colWidths.length; i++) {
			TableColumn col = table.getColumnModel().getColumn(i);
			col.setPreferredWidth(colWidths[i]);
		}
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(false);
		setViewportView(table);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	/**
	 * Clears the selection of the table
	 */
	public void clearSelection() {
		table.clearSelection();
	}
	
	/**
	 * Updates the observers for the class
	 * @param o is the observable to update
	 * @param arg is the object to send over
	 */
	public void update(Observable o, Object arg) {
		if (o instanceof TestCaseList) {
            TestCaseList tcl = (TestCaseList) o;
            if (tcl.size() != tctm.getRowCount()) {
                tctm = new TestCaseTableModel(tcl.get2DArray());
                table.setModel(tctm);
            } else {
                Object[][] arr = tcl.get2DArray();
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < tctm.getColumnCount(); j++) {
                        tctm.setValueAt(arr[i][j], i, j);
                    }
                }
            }
        }
	}
}
