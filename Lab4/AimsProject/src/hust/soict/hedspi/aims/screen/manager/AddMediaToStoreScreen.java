package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;

import hust.soict.hedspi.aims.store.Store;

import java.awt.*;

public abstract class AddMediaToStoreScreen extends JPanel {

    protected JPanel inputPanel; // Panel for input fields
    protected JButton btnAdd;
    protected Store store; // To access the store

    public AddMediaToStoreScreen(Store store, String mediaTypeTitle) { // Constructor with title
        this.store = store;

        setLayout(new BorderLayout());
        add(new JLabel(mediaTypeTitle, SwingConstants.CENTER), BorderLayout.NORTH); // Title

        inputPanel = new JPanel(new GridLayout(0, 2)); // Flexible grid layout
        add(inputPanel, BorderLayout.CENTER);

        btnAdd = new JButton("Add");
        add(btnAdd, BorderLayout.SOUTH);

       
    }

    protected abstract void addInputFields(); // To be implemented by subclasses
}