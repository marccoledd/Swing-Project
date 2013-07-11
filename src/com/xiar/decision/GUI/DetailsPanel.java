package com.xiar.decision.GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

import com.xiar.decision.events.DetailEvent;
import com.xiar.decision.events.DetailListener;

public class DetailsPanel extends JPanel{

	private static final long serialVersionUID = 1123581321345589L;
	
	private EventListenerList listList = new EventListenerList();

	public DetailsPanel() {
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Personal Details"));
		
		JLabel nameLabel = new JLabel("Name: ");
		JLabel occupationLabel = new JLabel("Occupation: ");
		JLabel happinessLabel = new JLabel("Happiness: ");
		
		final JTextField nameField = new JTextField(10);
		final JTextField occupationField = new JTextField(10);
		
		final JSlider happinessSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		happinessSlider.setMajorTickSpacing(1);
		happinessSlider.setPaintTicks(true);
		happinessSlider.setPaintLabels(true);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String name = nameField.getText();
				String occupation= occupationField.getText();
				int sliderValue = happinessSlider.getValue();
				
				String text = name + ": " + occupation + ": " + sliderValue + "\n";
				
				fireDetailEvent(new DetailEvent(this, text));
			}
		});
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		////First Column/////////////////////////////////////
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridx = 0;
		
		gc.gridy = 0;
		add(nameLabel, gc);
		
		gc.gridy = 1;
		add(occupationLabel, gc);
		
		gc.gridy = 2;
		add(happinessLabel, gc);
		
		
		////Second Column////////////////////////////////////
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		
		gc.gridy = 0;
		add(nameField, gc);
		
		gc.gridy = 1;
		add(occupationField, gc);
		
		////Slider Row///////////////////////////////////////
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridwidth = 2;
		gc.gridy = 3;
		
		gc.gridx = 0;
		add(happinessSlider, gc);
		
		////Button Row///////////////////////////////////////
		gc.weighty = 20;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridwidth = 1;
		gc.gridy = 4;
		
		gc.gridx = 1;
		add(addBtn, gc);
	}

	private void fireDetailEvent(DetailEvent detailEvent) {
		Object[] listeners = listList.getListenerList();
		
		for(int i = 0; i < listeners.length; i += 2) {
			if(listeners[i] == DetailListener.class) {
				((DetailListener) listeners[i+1]).detailEventOccured(detailEvent);
			}
		}
	}

	public void addDetailListener(DetailListener detailListener) {
		listList.add(DetailListener.class, detailListener);
	}
	
	public void removeDetailListener(DetailListener detailListener) {
		listList.remove(DetailListener.class, detailListener);
	}
}
