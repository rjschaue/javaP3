/**
 * 
 */
package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;

/**
 * @author Joey Schauer
 */
public class TestCaseTableModel implements Serializable {
	private static final long serialVersionUID = 5954551753060998701L;
	private String[] colNames;
	private Object[][] data;
	
	public TestCaseTableModel(Object[][] data) {
		//TODO implement constructor
	}
	
	public int getRowCount() {
		return 0;
	}
	
	public int getColumnCount() {
		return 0;
	}
	
	public String getColumnName() {
		return null;
	}
	
	public Object getValueAt(int row, int col) {
		return null;
	}
	
	public void setValueAt(Object data, int row, int col) {
		
	}
	
	public TestCaseData getTestCaseRowData(int row) {
		return null;
	}
	
	public void setTaskRowData(int row, TestCaseData data) {
		//TODO implement set task row data
	}
}
