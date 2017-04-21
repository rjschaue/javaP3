/**
 * 
 */
package edu.ncsu.csc216.bbtp.ui;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
		super(new GridBagLayout());
		
		this.data = new TestCaseData();
		this.testingTypes = testingTypes;
		
		init();
	}
	
	public TestCaseEditPane(TestCaseData data, TestingTypeList testingTypes) {
		super(new GridBagLayout());
		
		this.data = data;
		this.testingTypes = testingTypes;
		
		initView();
	}
	
	private void init() {
		testCaseID = new JTextField();
		tcTestingType = new JComboBox<TestingType>();
		for (int i = 0; i < testingTypes.size(); i++) {
			tcTestingType.addItem(this.testingTypes.getTestingTypeAt(i));
		}
		expectedResults = new JTextArea();
		actualResults = new JTextArea();
		testCaseDescription = new JTextArea();
		testCreationDate = new JSpinner();
		testLastTestedDate = new JSpinner();
		tested = new JCheckBox();
		pass = new JCheckBox();
		
		JPanel pnlTestCaseEditPane = new JPanel();
		pnlTestCaseEditPane.setLayout(new GridLayout(6, 1));
		
		JPanel pnlIDTypeDateTime = new JPanel();
		pnlIDTypeDateTime.setLayout(new GridBagLayout());
		pnlIDTypeDateTime.add(testCaseID);
		pnlIDTypeDateTime.add(tcTestingType);
		pnlIDTypeDateTime.add(testCreationDate);
		
		JPanel pnlDescription = new JPanel();
		pnlDescription.setLayout(new GridBagLayout());
		pnlDescription.add(testCaseDescription);
		
		JPanel pnlTested = new JPanel();
		pnlTested.setLayout(new GridBagLayout());
		pnlTested.add(tested);
		pnlTested.add(testLastTestedDate);
		
		JPanel pnlExpectedResults = new JPanel();
		pnlExpectedResults.setLayout(new GridBagLayout());
		pnlExpectedResults.add(expectedResults);
		
		JPanel pnlActualResults = new JPanel();
		pnlActualResults.setLayout(new GridBagLayout());
		pnlActualResults.add(actualResults);
		
		JPanel pnlPass = new JPanel();
		pnlPass.setLayout(new GridBagLayout());
		pnlPass.add(pass);
		
		pnlTestCaseEditPane.add(pnlIDTypeDateTime);
		pnlTestCaseEditPane.add(pnlDescription);
		pnlTestCaseEditPane.add(pnlTested);
		pnlTestCaseEditPane.add(pnlExpectedResults);
		pnlTestCaseEditPane.add(pnlActualResults);
		pnlTestCaseEditPane.add(pnlPass);
	}
	
	private void initView() {
		testCaseID = new JTextField(data.getTestCaseID());
		tcTestingType = new JComboBox<TestingType>();
		for (int i = 0; i < testingTypes.size(); i++) {
			tcTestingType.addItem(this.testingTypes.getTestingTypeAt(i));
		}
		expectedResults = new JTextArea(data.getExpectedResults());
		actualResults = new JTextArea(data.getActualResults());
		testCaseDescription = new JTextArea(data.getDescription());
		testCreationDate = new JSpinner();
		testLastTestedDate = new JSpinner();
		tested = new JCheckBox();
		pass = new JCheckBox();
		
		JPanel pnlTestCaseEditPane = new JPanel();
		pnlTestCaseEditPane.setLayout(new GridLayout(6, 1));
		
		JPanel pnlIDTypeDateTime = new JPanel();
		pnlIDTypeDateTime.setLayout(new GridBagLayout());
		pnlIDTypeDateTime.add(testCaseID);
		pnlIDTypeDateTime.add(tcTestingType);
		pnlIDTypeDateTime.add(testCreationDate);
		
		JPanel pnlDescription = new JPanel();
		pnlDescription.setLayout(new GridBagLayout());
		pnlDescription.add(testCaseDescription);
		
		JPanel pnlTested = new JPanel();
		pnlTested.setLayout(new GridBagLayout());
		pnlTested.add(tested);
		pnlTested.add(testLastTestedDate);
		
		JPanel pnlExpectedResults = new JPanel();
		pnlExpectedResults.setLayout(new GridBagLayout());
		pnlExpectedResults.add(expectedResults);
		
		JPanel pnlActualResults = new JPanel();
		pnlActualResults.setLayout(new GridBagLayout());
		pnlActualResults.add(actualResults);
		
		JPanel pnlPass = new JPanel();
		pnlPass.setLayout(new GridBagLayout());
		pnlPass.add(pass);
		
		pnlTestCaseEditPane.add(pnlIDTypeDateTime);
		pnlTestCaseEditPane.add(pnlDescription);
		pnlTestCaseEditPane.add(pnlTested);
		pnlTestCaseEditPane.add(pnlExpectedResults);
		pnlTestCaseEditPane.add(pnlActualResults);
		pnlTestCaseEditPane.add(pnlPass);
	}
	
	JSpinner getTestCreationDateSpinner() {
		return testCreationDate;
	}
	
	JSpinner getLastTestedDateSpinner() {
		return testLastTestedDate;
	}
	
	Date getTestCreationDate() {
		return data.getCreationDateTime();
	}
	
	Date getLastTestedDate() {
		return data.getLastTestedDateTime();
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
