package bushmissiongen.wizard.pages;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import bushmissiongen.misc.SimData;
import bushmissiongen.wizard.AbstractWizardPage;

@SuppressWarnings("serial")
public class SecondPage extends AbstractWizardPage {
	private final AbstractWizardPage nextPage;

	@SuppressWarnings("unused")
	private Map<String, String> mDefaultValues;

	private final JTextArea tailNumberField = new JTextArea(1, 30);
	private final JTextArea airlineCallSignField = new JTextArea(1, 30);
	private final JTextArea flightNumberField = new JTextArea(1, 30);
	private final JComboBox<String> seasonCombo;
	private final JTextArea yearField = new JTextArea(1, 30);
	private final JTextArea dayField = new JTextArea(1, 30);
	private final JTextArea hoursField = new JTextArea(1, 30);
	private final JTextArea minutesField = new JTextArea(1, 30);
	private final JTextArea secondsField = new JTextArea(1, 30);

	public SecondPage(Map<String, String> defaultValues) {
		mDefaultValues = defaultValues;
		nextPage = new EndPage(defaultValues);

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);

		int currentRow = 0;

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weighty = 1;

		c.weightx = 0.10;
		c.gridx = 0;
		c.gridy = currentRow;
		add(new Label("Tail number:"), c);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = currentRow++;
		c.anchor=GridBagConstraints.EAST;
		tailNumberField.setBorder(border);
		add(tailNumberField, c);

		c.weightx = 0.10;
		c.gridx = 0;
		c.gridy = currentRow;
		add(new Label("Airline call sign:"), c);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = currentRow++;
		c.anchor=GridBagConstraints.EAST;
		airlineCallSignField.setBorder(border);
		add(airlineCallSignField, c);

		c.weightx = 0.10;
		c.gridx = 0;
		c.gridy = currentRow;
		add(new Label("Flight number:"), c);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = currentRow++;
		c.anchor=GridBagConstraints.EAST;
		flightNumberField.setBorder(border);
		add(flightNumberField, c);

		// SPACE
		c.gridwidth = 2;
		c.weightx = 0.10;
		c.gridx = 0;
		c.gridy = currentRow++;
		add(new Label(""), c);
		c.gridwidth = 1;

		c.weightx = 0.10;
		c.gridx = 0;
		c.gridy = currentRow;
		add(new Label("Season:"), c);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = currentRow++;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.anchor=GridBagConstraints.EAST;
		List<String> seasonsList = new ArrayList<>(SimData.getInstance().seasons);
		seasonCombo = new JComboBox<String>(seasonsList.toArray(new String[seasonsList.size()]));
		seasonCombo.setSize(seasonCombo.getPreferredSize());
		seasonCombo.setBorder(border);
		add(seasonCombo, c);
		seasonCombo.setSelectedIndex(2); // Summer is the best!
		
		c.weightx = 0.10;
		c.gridx = 0;
		c.gridy = currentRow;
		add(new Label("Year:"), c);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = currentRow++;
		c.anchor=GridBagConstraints.EAST;
		yearField.setBorder(border);
		add(yearField, c);
		
		c.weightx = 0.10;
		c.gridx = 0;
		c.gridy = currentRow;
		add(new Label("Day:"), c);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = currentRow++;
		c.anchor=GridBagConstraints.EAST;
		dayField.setBorder(border);
		add(dayField, c);
		
		c.weightx = 0.10;
		c.gridx = 0;
		c.gridy = currentRow;
		add(new Label("Hours:"), c);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = currentRow++;
		c.anchor=GridBagConstraints.EAST;
		hoursField.setBorder(border);
		add(hoursField, c);
		
		c.weightx = 0.10;
		c.gridx = 0;
		c.gridy = currentRow;
		add(new Label("Minutes:"), c);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = currentRow++;
		c.anchor=GridBagConstraints.EAST;
		minutesField.setBorder(border);
		add(minutesField, c);
		
		c.weightx = 0.10;
		c.gridx = 0;
		c.gridy = currentRow;
		add(new Label("Seconds:"), c);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = currentRow++;
		c.anchor=GridBagConstraints.EAST;
		secondsField.setBorder(border);
		add(secondsField, c);
	}

	@Override
	protected AbstractWizardPage getNextPage() {
		values.put("tailNumber", tailNumberField.getText().trim());
		values.put("airlineCallSign", airlineCallSignField.getText().trim());
		values.put("flightNumber", flightNumberField.getText().trim());
		values.put("season", seasonCombo.getItemAt(seasonCombo.getSelectedIndex()));
		values.put("year", yearField.getText().trim());
		values.put("day", dayField.getText().trim());
		values.put("hours", hoursField.getText().trim());
		values.put("minutes", minutesField.getText().trim());
		values.put("seconds", secondsField.getText().trim());

		return nextPage;
	}

	@Override
	protected boolean isCancelAllowed() {
		return true;
	}

	@Override
	protected boolean isPreviousAllowed() {
		return true;
	}

	@Override
	protected boolean isNextAllowed() {
		return true;
	}

	@Override
	protected boolean isFinishAllowed() {
		return false;
	}
}
