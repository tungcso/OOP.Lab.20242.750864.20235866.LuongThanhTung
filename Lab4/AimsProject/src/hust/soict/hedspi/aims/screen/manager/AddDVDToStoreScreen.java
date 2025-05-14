package hust.soict.hedspi.aims.screen.manager;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDVDToStoreScreen extends AddMediaToStoreScreen {
	private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfPrice;
	private JTextField tfDirector;
	private JTextField tfLength;
	public AddDVDToStoreScreen(Store store) {
		super(store,"DVD");
		addInputFields();
	}

	
	 protected void addInputFields() {
        tfTitle = new JTextField(20);
        tfCategory = new JTextField(20);
        tfPrice = new JTextField(20);
        tfDirector = new JTextField(20);
        tfLength = new JTextField(20);
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(tfTitle);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(tfCategory);
        inputPanel.add(new JLabel("Director:"));
        inputPanel.add(tfDirector);
        inputPanel.add(new JLabel("Length:"));
        inputPanel.add(tfLength);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(tfPrice);
        

        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                int length  = Integer.parseInt(tfLength.getText());
                float price = Float.parseFloat(tfPrice.getText());

                DigitalVideoDisc newDVD = new DigitalVideoDisc(title,category ,director, price);
                store.addMedia(newDVD);

                JOptionPane.showMessageDialog(null, "DVD added successfully!");
              
            }
        });
    }

}
