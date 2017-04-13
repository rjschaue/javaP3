/**
 * 
 */
package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTable;

import edu.ncsu.csc216.bbtp.model.TestCaseList;

/**
 * @author Joey Schauer
 */
public class TestCaseListPane extends JPanel implements Serializable, Observer {
	private static final long serialVersionUID = -2210716111020406799L;
	private TestCaseList testCases;
	private JTable table;
	private int[] colWidths;
	private TestCaseTableModel tctm;
	
	public TestCaseListPane(TestCaseList testCases) {
		//TODO implement constructor
	}
	
	public TestCaseTableModel getTestCaseTableModel() {
		return tctm;
	}
	
	public JTable getTable() {
		return table;
	}
	
	private void initView() {
		//TODO implement init view
	}
	
	public void clearSelection() {
		//TODO implement clear selection
	}
	
	public void update(Observable o, Object arg) {
		//TODO implement update
	}
}
