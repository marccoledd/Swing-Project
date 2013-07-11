package com.xiar.decision.GUI;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.xiar.decision.events.DetailEvent;
import com.xiar.decision.events.DetailListener;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1123581321345589L;
	
	private DetailsPanel detailsPanel;
	
	public MainWindow(String title) {
		super(title);
		
		//Set Layout
		setLayout(new BorderLayout());
		
		//Create Components
		final JTextArea textArea = new JTextArea();
		
		detailsPanel = new DetailsPanel();
		detailsPanel.addDetailListener(new DetailListener() {
			public void detailEventOccured(DetailEvent event) {
				String text = event.getText();
				
				textArea.append(text);
			}
		});
		
		//Add Components
		Container c = getContentPane();
		
		c.add(textArea, BorderLayout.CENTER);
		c.add(detailsPanel, BorderLayout.WEST);
	}
}
