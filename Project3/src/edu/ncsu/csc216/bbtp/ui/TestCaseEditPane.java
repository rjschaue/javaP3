/**
 * 
 */
package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;
import java.util.Date;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.ncsu.csc216.bbtp.model.TestingType;
import edu.ncsu.csc216.bbtp.model.TestingTypeList;

/**
 * @author Joey Schauer
 */
public class TestCaseEditPane extends JPanel implements Serializable, Observer {
	private static final long serialVersionUID = 5479139338455751629L;
	private TestingTypeList testingTypes;
	private JTextField testCaseID;
	private JComboBox<TestingType> tcTestingType;
	private JTextArea expectedResults;
	private JTextArea actualResults;
	private JTextArea testCaseDescription;
	private JSpinner testCreationDate;
	private JSpinner testLastTestedDate;
	private JCheckBox tested;
	private JCheckBox pass;
	private boolean add;
	private boolean edit;
	private TestCaseData data;
	
	public TestCaseEditPane(TestingTypeList testingTypes) {
		//TODO implement constructor
	}
	
	public TestCaseEditPane(TestCaseData data, TestingTypeList testingTypes) {
		//TODO implement constructor
	}
	
	private void init() {
		//TODO implement init
	}
	
	private void initView() {
		//TODO implement initView
	}
	
	JSpinner getTestCreationDateSpinner() {
		return testCreationDate;
	}
	
	JSpinner getLastTestedDateSpinner() {
		return testLastTestedDate;
	}
	
	Date getTestCreationDate() {
		return null;
	}
	
	Date getLastTestedDate() {
		return null;
	}
	
	JTextField getTestCaseID() {
		return testCaseID;
	}
	
	JTextArea getTestCaseDescription() {
		return testCaseDescription;
	}
	
	JComboBox<TestingType> getTestingType() {
		return tcTestingType;
	}
	
	JTextArea getExpectedResults() {
		return expectedResults;
	}
	
	JTextArea getActualResults() {
		return actualResults;
	}
	
	JCheckBox pass() {
		return pass;
	}
	
	JCheckBox tested() {
		return tested;
	}
	
	void setCreationDateTime(Date date) {
		//TODO implement set creation date time
	}
	
	void setLastTestedDateTime(Date date) {
		//TODO implement set last tested date time
	}
	
	boolean isAddMode() {
		return add;
	}
	
	boolean isEditMode() {
		return edit;
	}
	
	void enableAdd() {
		add = true;
	}
	
	void disableAdd() {
		add = false;
	}
	
	void enableEdit(TestCaseData data) {
		//TODO implement enable edit
	}
	
	void disableEdit() {
		edit = false;
	}
	
	boolean fieldsNotEmpty() {
		return false;
	}
	
	void setTestCaseData(TestCaseData data) {
		this.data = data;
	}
	
	void addFieldListener(EventListener eventListener) {
		//TODO implement add field listener
	}
	
	void fillFields() {
		
	}
	
	void clearFields() {
		
	}
	
	TestCaseData getFields() {
		return null;
	}
	
	public void update(Observable o, Object arg) {
		
	}
}
