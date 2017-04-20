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
 * @author Joey Schauer
 */
public class TestCaseListPane extends JScrollPane implements Serializable, Observer {
	private static final long serialVersionUID = -2210716111020406799L;
	private TestCaseList testCases;
	private JTable table;
	private int[] colWidths = { 50, 50, 50, 50, 50, 50, 50, 50, 50 };
	private TestCaseTableModel tctm;
	
	public TestCaseListPane(TestCaseList testCases) {
		super();
		this.testCases = testCases;
		this.testCases.addObserver(this);
		tctm = new TestCaseTableModel(testCases.get2DArray());
		initView();
	}
	
	public TestCaseTableModel getTestCaseTableModel() {
		return tctm;
	}
	
	public JTable getTable() {
		return table;
	}
	
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
	
	public void clearSelection() {
		table.clearSelection();
	}
	
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
