/**
 * 
 */
package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import edu.ncsu.csc216.bbtp.model.TestingType;

/**
 * This class is for the test case table model
 * @author Joey Schauer
 */
public class TestCaseTableModel extends AbstractTableModel implements Serializable {
	/** the serial version UID for TestCaseTableModel */
	private static final long serialVersionUID = 5954551753060998701L;
	/** the array of column names */
	private String[] colNames = {"ID", "Description", "Test Type", "Creation Date", "Last Tested Date", "Tested?", "Expected Results", "Actual Results", "Pass?" };
	/** the 2d array of test case data */
	private Object[][] data;
	
	/**
	 * The constructor for TestCaseTableModel
	 * @param data the 2d array of test case data
	 */
	public TestCaseTableModel(Object[][] data) {
		super();
		this.data = data;
	}
	
	/**
	 * Returns the number of rows
	 * @return the number of rows
	 */
	public int getRowCount() {
		return data.length;
	}
	
	/**
	 * Returns the number of columns
	 * @return the number of columns
	 */
	public int getColumnCount() {
		return colNames.length;
	}
	
	/**
	 * Returns the column name at the given column
	 * @param col the column number to get the name for
	 * @return the column name at the given column
	 */
	public String getColumnName(int col) {
		return colNames[col];
	}
	
	/**
	 * Returns the data at the given row and column
	 * @param row the row for the data
	 * @param col the column for the data
	 * @return the data at the given row and column
	 */
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	/**
	 * Sets the given row and column value to the given data
	 * @param data is the data to set
	 * @param row is the row to be set
	 * @param col is the column to be set
	 */
	public void setValueAt(Object data, int row, int col) {
		this.data[row][col] = data;
		fireTableCellUpdated(row, col);
	}
	
	/**
	 * Returns the test case data from the given row
	 * @param row the row to get data from
	 * @return the test case data from the given row
	 */
	public TestCaseData getTestCaseRowData(int row) {
		return new TestCaseData((String) data[row][0], (String) data[row][1], (TestingType) data[row][2], (Date) data[row][3], (Date) data[row][4], (boolean) data[row][5], (String) data[row][6], (String) data[row][7], (boolean) data[row][8]);
	}
	
	/**
	 * Sets the given row to the given data
	 * @param row the row to set data for
	 * @param data the data to be set
	 */
	public void setTaskRowData(int row, TestCaseData data) {
		setValueAt(data.getTestCaseID(), row, 0);
		setValueAt(data.getDescription(), row, 1);
		setValueAt(data.getTestingType(), row, 2);
		setValueAt(data.getCreationDateTime(), row, 3);
		setValueAt(data.getLastTestedDateTime(), row, 4);
		setValueAt(data.tested(), row, 5);
		setValueAt(data.getExpectedResults(), row, 6);
		setValueAt(data.getActualResults(), row, 7);
		setValueAt(data.pass(), row, 8);
	}
}
