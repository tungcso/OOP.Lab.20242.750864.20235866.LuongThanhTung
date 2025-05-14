package hust.soict.hedspi.aims.screen.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddMediaToStoreScreen {
	private JTextField tfTitle;
    private JTextField tfAuthor;
    private JTextField tfPrice;
	public AddBookToStoreScreen(Store store) {
		super(store,"Book");
		addInputFields();
	}

	
	 protected void addInputFields() {
        tfTitle = new JTextField(20);
        tfAuthor = new JTextField(20);
        tfPrice = new JTextField(20);

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(tfTitle);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(tfAuthor);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(tfPrice);
        

        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String title = tfTitle.getText();
                String author = tfAuthor.getText();
                float price = Float.parseFloat(tfPrice.getText());

                Book newBook = new Book(title, author, price);
                store.addMedia(newBook);

                JOptionPane.showMessageDialog(AddBookToStoreScreen.this, "Book added successfully!");
                
            }
        });
    }

}
