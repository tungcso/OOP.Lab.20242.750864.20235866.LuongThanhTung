package hust.soict.hedspi.aims.screen.manager;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class AddCDToStoreScreen extends AddMediaToStoreScreen {
	private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfPrice;
	private JTextField tfDirector;
	private JTextField tfArtist;
	private JTextField tfLength;
	private JTextField tfTrack;
	public AddCDToStoreScreen(Store store) {
		super(store,"CD");
		addInputFields();
	}

	
	 protected void addInputFields() {
        tfTitle = new JTextField(20);
        tfCategory = new JTextField(20);
        tfPrice = new JTextField(20);
        tfDirector = new JTextField(20);
        tfLength = new JTextField(20);
        tfArtist = new JTextField(20);
        tfTrack = new JTextField(20);
        
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(tfTitle);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(tfCategory);
        inputPanel.add(new JLabel("Director:"));
        inputPanel.add(tfDirector);
        inputPanel.add(new JLabel("Artist:"));
        inputPanel.add(tfArtist);
        inputPanel.add(new JLabel("Track:"));
        inputPanel.add(tfTrack);
        inputPanel.add(new JLabel("Length:"));
        inputPanel.add(tfLength);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(tfPrice);
        

        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                String artist = tfArtist.getText();
                String track = tfTrack.getText();
                int length  = Integer.parseInt(tfLength.getText());
                float price = Float.parseFloat(tfPrice.getText());
                	
                CompactDisc newCD = new CompactDisc(title, category ,director,artist, length, price);
                newCD.addTrack(new Track(track, length));
                store.addMedia(newCD);

                JOptionPane.showMessageDialog(null, "CD added successfully!");
              
            }
        });
    }

}
