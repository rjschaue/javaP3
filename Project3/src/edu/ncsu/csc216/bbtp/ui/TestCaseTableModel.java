/**
 * 
 */
package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import edu.ncsu.csc216.bbtp.model.TestingType;

/**
 * @author Joey Schauer
 */
public class TestCaseTableModel extends AbstractTableModel implements Serializable {
	private static final long serialVersionUID = 5954551753060998701L;
	private String[] colNames = {"ID", "Description", "Test Type", "Creation Date", "Last Tested Date", "Tested?", "Expected Results", "Actual Results", "Pass?" };
	private Object[][] data;
	
	public TestCaseTableModel(Object[][] data) {
		super();
		this.data = data;
	}
	
	public int getRowCount() {
		return data.length;
	}
	
	public int getColumnCount() {
		return colNames.length;
	}
	
	public String getColumnName(int col) {
		return colNames[col];
	}
	
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public void setValueAt(Object data, int row, int col) {
		this.data[row][col] = data;
		fireTableCellUpdated(row, col);
	}
	
	public TestCaseData getTestCaseRowData(int row) {
		return new TestCaseData((String) data[row][0], (String) data[row][1], (TestingType) data[row][2], (Date) data[row][3], (Date) data[row][4], (boolean) data[row][5], (String) data[row][6], (String) data[row][7], (boolean) data[row][8]);
	}
	
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
