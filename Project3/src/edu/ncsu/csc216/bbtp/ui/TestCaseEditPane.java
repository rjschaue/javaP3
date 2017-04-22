/**
 * 
 */
package edu.ncsu.csc216.bbtp.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.Date;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

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
		this(new TestCaseData(), testingTypes);
	}
	
	/**
	 * The constructor for TestCaseEditPane with given testing types and test case data
	 * @param data the test case data
	 * @param testingTypes the testing types
	 */
	public TestCaseEditPane(TestCaseData data, TestingTypeList testingTypes) {
		super();
		
		this.data = data;
		this.testingTypes = testingTypes;
		
		init();
	}
	
	/**
	 * Initializes the view with no data
	 */
	private void init() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.black));
		initView();
		fillFields();
	}
	
	/**
	 * Initializes the view with data
	 */
	private void initView() {		
		JPanel pnlTestCaseEditPane = new JPanel();
		pnlTestCaseEditPane.setLayout(new GridLayout(6, 1));
		
		JPanel pnlIDTypeDateTime = new JPanel(new FlowLayout(FlowLayout.LEADING));
		pnlIDTypeDateTime.add(new JLabel("Test Case ID: ", SwingConstants.LEFT));
		pnlIDTypeDateTime.add(getTestCaseID());
		pnlIDTypeDateTime.add(new JLabel("Testing Type: ", SwingConstants.LEFT));
		pnlIDTypeDateTime.add(getTestingType());
		pnlIDTypeDateTime.add(new JLabel("Test Creation Date & Time: ", SwingConstants.LEFT));
		pnlIDTypeDateTime.add(getTestCreationDateSpinner());
		
		JPanel pnlDescription = new JPanel(new BorderLayout());
		pnlDescription.add(new JLabel("Description: "), BorderLayout.NORTH);
		pnlDescription.add(getTestCaseDescription(), BorderLayout.CENTER);
		
		JPanel pnlTested = new JPanel(new FlowLayout(FlowLayout.LEADING));
		pnlTested.add(new JLabel("Tested? "));
		pnlTested.add(tested());
		pnlTested.add(new JLabel("Last Tested Date & Time: "), SwingConstants.LEFT);
		pnlTested.add(getLastTestedDateSpinner());
		
		JPanel pnlExpectedResults = new JPanel(new BorderLayout());
		pnlExpectedResults.add(new JLabel("Expected Results: "), BorderLayout.NORTH);
		pnlExpectedResults.add(getExpectedResults(), BorderLayout.CENTER);
		
		JPanel pnlActualResults = new JPanel(new BorderLayout());
		pnlActualResults.add(new JLabel("Actual Results: "), BorderLayout.NORTH);
		pnlActualResults.add(getActualResults(), BorderLayout.CENTER);
		
		JPanel pnlPass = new JPanel(new FlowLayout(FlowLayout.LEADING));
		pnlPass.add(new JLabel("Pass? "));
		pnlPass.add(pass());
		
		pnlTestCaseEditPane.add(pnlIDTypeDateTime);
		pnlTestCaseEditPane.add(pnlDescription);
		pnlTestCaseEditPane.add(pnlTested);
		pnlTestCaseEditPane.add(pnlExpectedResults);
		pnlTestCaseEditPane.add(pnlActualResults);
		pnlTestCaseEditPane.add(pnlPass);
		this.add(pnlTestCaseEditPane);
	}
	
	/**
	 * Returns the test creation date spinner
	 * @return the test creation date spinner
	 */
	JSpinner getTestCreationDateSpinner() {
		if (testCreationDate == null) {
			testCreationDate = new JSpinner(new SpinnerDateModel());
		}
		return testCreationDate;
	}
	
	/**
	 * Returns the last tested date spinner 
	 * @return the last tested date spinner
	 */
	JSpinner getLastTestedDateSpinner() {
		if (testLastTestedDate == null) {
			testLastTestedDate = new JSpinner(new SpinnerDateModel());
		}
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
		if (testCaseID == null) {
			testCaseID = new JTextField(5);
			testCaseID.setEditable(false);
	        testCaseID.setVisible(true);
	        testCaseID.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return testCaseID;
	}
	
	/**
	 * Returns the test case description text area
	 * @return the test case description text area
	 */
	JTextArea getTestCaseDescription() {
		if (testCaseDescription == null) {
			testCaseDescription = new JTextArea();
			testCaseDescription.setEditable(false);
            testCaseDescription.setVisible(true);
            testCaseDescription.setLineWrap(true);
            testCaseDescription.setAutoscrolls(true);
		}
		return testCaseDescription;
	}
	
	/**
	 * Returns the testing type combo box
	 * @return the testing type combo box
	 */
	JComboBox<TestingType> getTestingType() {
		if (tcTestingType == null) {
			tcTestingType = new JComboBox<TestingType>();
		}
		for (int i = 0; i < testingTypes.size(); i++) {
			tcTestingType.addItem(testingTypes.getTestingTypeAt(i));
		}
		return tcTestingType;
	}
	
	/**
	 * Returns the expected results text area
	 * @return the expected results text area
	 */
	JTextArea getExpectedResults() {
		if (expectedResults == null) {
			expectedResults = new JTextArea();
			expectedResults.setEditable(false);
            expectedResults.setVisible(true);
            expectedResults.setLineWrap(true);
            expectedResults.setAutoscrolls(true);
		}
		return expectedResults;
	}
	
	/**
	 * Returns the actual results text area
	 * @return the actual results text area
	 */
	JTextArea getActualResults() {
		if (actualResults == null) {
			actualResults = new JTextArea();
			actualResults.setEditable(false);
            actualResults.setVisible(true);
            actualResults.setLineWrap(true);
            actualResults.setAutoscrolls(true);
		}
		return actualResults;
	}
	
	/**
	 * Returns the pass check box
	 * @return the pass check box
	 */
	JCheckBox pass() {
		if (pass == null) {
			pass = new JCheckBox();
		}
		return pass;
	}
	
	/**
	 * Returns the tested check box
	 * @return the tested check box
	 */
	JCheckBox tested() {
		if (tested == null) {
			tested = new JCheckBox();
		}
		return tested;
	}
	
	/**
	 * Sets the creation date time to the given date
	 * @param date the date to set the creation time to
	 */
	void setCreationDateTime(Date date) {
		testCreationDate.setValue(date);
	}
	
	/**
	 * Sets the last tested date time to the given date
	 * @param date the date to set the last tested date time to
	 */
	void setLastTestedDateTime(Date date) {
		testLastTestedDate.setValue(date);
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
		if (!add) {
			add = true;
			edit = false;
			clearFields();
		}
	}
	
	/**
	 * Sets add to false
	 */
	void disableAdd() {
		add = false;
		clearFields();
	}
	
	/**
	 * Sets edit to true and sets data to the given data
	 * @param data the data to set
	 */
	void enableEdit(TestCaseData data) {
		if (!edit) {
            edit = true;
            add = false;
            this.data = data;
            fillFields();
        }
	}
	
	/**
	 * Sets edit to false
	 */
	void disableEdit() {
		edit = false;
		clearFields();
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
		//TODO Implement method
	}
	
	/**
	 * Fills the fields
	 */
	void fillFields() {
		if (data == null) {
			testCaseID.setText("");
			testCaseID.setEnabled(false);
			tcTestingType.setEditable(false);
			testCreationDate.setEnabled(false);
			testCaseDescription.setText("");
			testCaseDescription.setEditable(false);
			tested.setEnabled(false);
			testLastTestedDate.setEnabled(false);
			expectedResults.setText("");
			expectedResults.setEditable(false);
			actualResults.setText("");
			actualResults.setEditable(false);
			pass.setEnabled(false);
		} else {
			testCaseID.setText(data.getTestCaseID());
			tcTestingType.setSelectedItem(data.getTestingType());
			if (data.getCreationDateTime() != null) {
				testCreationDate.setValue(data.getCreationDateTime().toString());
			}
			if (data.getLastTestedDateTime() != null) {
				testLastTestedDate.setValue(data.getLastTestedDateTime().toString());
			}
			testCaseDescription.setText(data.getDescription());
			tested.setSelected(data.tested());
			expectedResults.setText(data.getExpectedResults());
			actualResults.setText(data.getActualResults());
			pass.setSelected(data.pass());
		}
		if (add || edit) {
			testCaseID.setEnabled(true);
			testCreationDate.setEnabled(true);
			testCaseDescription.setEditable(true);
			tested.setEnabled(true);
			testLastTestedDate.setEnabled(true);
			expectedResults.setEditable(true);
			actualResults.setEditable(true);
			pass.setEnabled(true);
		}
	}
	
	/**
	 * Clears the fields
	 */
	void clearFields() {
		data = null;
		fillFields();
	}
	
	/**
	 * Returns the fields
	 * @return the fields
	 */
	TestCaseData getFields() {
		return new TestCaseData(testCaseID.getText(), testCaseDescription.getText(), (TestingType) tcTestingType.getSelectedItem(), (Date) testCreationDate.getValue(), 
				(Date) testLastTestedDate.getValue(), tested.isSelected(), expectedResults.getText(), actualResults.getText(), pass.isSelected());
	}
	
	/**
	 * Updates the given observable with the given object
	 * @param o is the observable to notify
	 * @param arg is the object to send over
	 */
	public void update(Observable o, Object arg) {
		o.notifyObservers(arg);
	}
}
