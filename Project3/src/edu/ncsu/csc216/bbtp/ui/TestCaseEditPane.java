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
 * The class for the test case edit pane
 * @author Joey Schauer
 */
public class TestCaseEditPane extends JPanel implements Serializable, Observer {
	/** the serial version UID for TestCaseEditPane */
	private static final long serialVersionUID = 5479139338455751629L;
	/** the testing type list */
	private TestingTypeList testingTypes;
	/** the test case id text field */
	private JTextField testCaseID;
	/** the testing type combo box */
	private JComboBox<TestingType> tcTestingType;
	/** the expected results text area */
	private JTextArea expectedResults;
	/** the actual results text area */
	private JTextArea actualResults;
	/** the test case description text area */
	private JTextArea testCaseDescription;
	/** the test creation date spinner */
	private JSpinner testCreationDate;
	/** the test last tested date spinner */
	private JSpinner testLastTestedDate;
	/** the tested check box */
	private JCheckBox tested;
	/** the pass check box */
	private JCheckBox pass;
	/** true if able to add */
	private boolean add;
	/** true if able to edit */
	private boolean edit;
	/** the test case data */
	private TestCaseData data;
	
	/** The constructor for TestCaseEditPane with given testing types
	 * @param testingTypes the testing types for the pane
	 */
	public TestCaseEditPane(TestingTypeList testingTypes) {
		super(new GridBagLayout());
		
		this.data = new TestCaseData();
		this.testingTypes = testingTypes;
		
		init();
	}
	
	/**
	 * The constructor for TestCaseEditPane with given testing types and test case data
	 * @param data the test case data
	 * @param testingTypes the testing types
	 */
	public TestCaseEditPane(TestCaseData data, TestingTypeList testingTypes) {
		super(new GridBagLayout());
		
		this.data = data;
		this.testingTypes = testingTypes;
		
		initView();
	}
	
	/**
	 * Initializes the view with no data
	 */
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
	
	/**
	 * Initializes the view with data
	 */
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
	
	/**
	 * Returns the test creation date spinner
	 * @return the test creation date spinner
	 */
	JSpinner getTestCreationDateSpinner() {
		return testCreationDate;
	}
	
	/**
	 * Returns the last tested date spinner 
	 * @return the last tested date spinner
	 */
	JSpinner getLastTestedDateSpinner() {
		return testLastTestedDate;
	}
	
	/**
	 * Returns the test creation date time
	 * @return the test creation date time
	 */
	Date getTestCreationDate() {
		return data.getCreationDateTime();
	}
	
	/**
	 * Returns the last tested date
	 * @return the last tested date
	 */
	Date getLastTestedDate() {
		return data.getLastTestedDateTime();
	}
	
	/**
	 * Returns the test case id text field
	 * @return the test case id text field
	 */
	JTextField getTestCaseID() {
		return testCaseID;
	}
	
	/**
	 * Returns the test case description text area
	 * @return the test case description text area
	 */
	JTextArea getTestCaseDescription() {
		return testCaseDescription;
	}
	
	/**
	 * Returns the testing type combo box
	 * @return the testing type combo box
	 */
	JComboBox<TestingType> getTestingType() {
		return tcTestingType;
	}
	
	/**
	 * Returns the expected results text area
	 * @return the expected results text area
	 */
	JTextArea getExpectedResults() {
		return expectedResults;
	}
	
	/**
	 * Returns the actual results text area
	 * @return the actual results text area
	 */
	JTextArea getActualResults() {
		return actualResults;
	}
	
	/**
	 * Returns the pass check box
	 * @return the pass check box
	 */
	JCheckBox pass() {
		return pass;
	}
	
	/**
	 * Returns the tested check box
	 * @return the tested check box
	 */
	JCheckBox tested() {
		return tested;
	}
	
	/**
	 * Sets the creation date time to the given date
	 * @param date the date to set the creation time to
	 */
	void setCreationDateTime(Date date) {
		data = new TestCaseData(data.getTestCaseID(), data.getDescription(), data.getTestingType(), date, data.getLastTestedDateTime(),
				data.tested(), data.getExpectedResults(), data.getActualResults(), data.pass());
	}
	
	/**
	 * Sets the last tested date time to the given date
	 * @param date the date to set the last tested date time to
	 */
	void setLastTestedDateTime(Date date) {
		data = new TestCaseData(data.getTestCaseID(), data.getDescription(), data.getTestingType(), data.getCreationDateTime(), date,
				data.tested(), data.getExpectedResults(), data.getActualResults(), data.pass());
	}
	
	/**
	 * Returns the value of add
	 * @return the value of add
	 */
	boolean isAddMode() {
		return add;
	}
	
	/**
	 * Returns the value of edit
	 * @return the value of edit
	 */
	boolean isEditMode() {
		return edit;
	}
	
	/**
	 * Sets add to true
	 */
	void enableAdd() {
		add = true;
	}
	
	/**
	 * Sets add to false
	 */
	void disableAdd() {
		add = false;
	}
	
	/**
	 * Sets edit to true and sets data to the given data
	 * @param data the data to set
	 */
	void enableEdit(TestCaseData data) {
		this.data = data;
		edit = true;
	}
	
	/**
	 * Sets edit to false
	 */
	void disableEdit() {
		edit = false;
	}
	
	/**
	 * Returns true if the fields are not empty
	 * @return true if the fields are not empty
	 */
	boolean fieldsNotEmpty() {
		return false;
	}
	
	/**
	 * Sets the test case data to the given data
	 * @param data the data to set the test case to
	 */
	void setTestCaseData(TestCaseData data) {
		this.data = data;
	}
	
	/**
	 * Adds a field listener
	 * @param eventListener the event listener
	 */
	void addFieldListener(EventListener eventListener) {
		//TODO implement add field listener
	}
	
	/**
	 * Fills the fields
	 */
	void fillFields() {
		
	}
	
	/**
	 * Clears the fields
	 */
	void clearFields() {
		
	}
	
	/**
	 * Returns the fields
	 * @return the fields
	 */
	TestCaseData getFields() {
		return data;
	}
	
	/**
	 * Updates the given observable with the given object
	 */
	public void update(Observable o, Object arg) {
		
	}
}
