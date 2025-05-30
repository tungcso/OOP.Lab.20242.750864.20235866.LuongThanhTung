package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;


public class StoreManagerScreen extends JFrame{
	private static final long serialVersionUID = 1L;
	private Store store;
	
	JPanel createNorth() {
	    JPanel north = new JPanel();
	    north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
	    north.add(createMenuBar());
	    north.add(createHeader());
	    return north;
	}
	
	private void addBook() {
	    JDialog dialog = new JDialog(this, "Add New Book", true);
	    dialog.setLayout(new GridLayout(4, 2, 10, 10));

	    JLabel titleLabel = new JLabel("Enter Title: ");
	    JTextField titleField = new JTextField(10);
	    JLabel categoryLabel = new JLabel("Enter Category: ");
	    JTextField categoryField = new JTextField(10);
	    JLabel costLabel = new JLabel("Enter Cost: ");
	    JTextField costField = new JTextField(10);

	    JButton submitButton = new JButton("Add Book");

	    dialog.add(titleLabel);
	    dialog.add(titleField);
	    dialog.add(categoryLabel);
	    dialog.add(categoryField);
	    dialog.add(costLabel);
	    dialog.add(costField);
	    dialog.add(new JLabel()); // empty cell
	    dialog.add(submitButton);

	    submitButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String title = titleField.getText();
	            String category = categoryField.getText();
	            String costText = costField.getText();

	            double cost = 0;
	            try {
	                cost = Double.parseDouble(costText);
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(dialog, "Invalid cost input!", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            Media book = new Book(title, category, cost);
	            store.addMedia(book);

	            JOptionPane.showMessageDialog(dialog, "Book added successfully!");
	            dialog.dispose(); // close dialog after successful addition
	        }
	    });

	    dialog.setSize(350, 200);
	    dialog.setLocationRelativeTo(this); // center relative to main frame
	    dialog.setVisible(true); // show dialog
	}
	
	private void addDVD() {
	    JDialog dialog = new JDialog(this, "Add New DVD", true);
	    dialog.setLayout(new GridLayout(6, 2, 10, 10));

	    JLabel titleLabel = new JLabel("Enter Title: ");
	    JTextField titleField = new JTextField(10);
	    JLabel categoryLabel = new JLabel("Enter Category: ");
	    JTextField categoryField = new JTextField(10); 
	    JLabel directorLabel = new JLabel("Enter Director: ");
	    JTextField directorField = new JTextField(10); 
	    JLabel lengthLabel = new JLabel("Enter Length: ");
	    JTextField lengthField = new JTextField(10); 
	    JLabel costLabel = new JLabel("Enter Cost: ");
	    JTextField costField = new JTextField(10); 

	    JButton submitButton = new JButton("Add DVD");

	    dialog.add(titleLabel);
	    dialog.add(titleField);
	    dialog.add(categoryLabel);
	    dialog.add(categoryField);
	    dialog.add(directorLabel);
	    dialog.add(directorField);
	    dialog.add(lengthLabel);
	    dialog.add(lengthField);
	    dialog.add(costLabel);
	    dialog.add(costField);
	    dialog.add(new JLabel()); // empty cell
	    dialog.add(submitButton);

	    submitButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String title = titleField.getText();
	            String category = categoryField.getText();
	            String director = directorField.getText();
	            String lengthText = lengthField.getText();
	            String costText = costField.getText();

	            int length = 0;
	            double cost = 0;

	            try {
	                length = Integer.parseInt(lengthText);
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(dialog, "Invalid length input!", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            try {
	                cost = Double.parseDouble(costText);
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(dialog, "Invalid cost input!", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            Media dvd = new DigitalVideoDisc(title, category, director, length, (float) cost);
	            store.addMedia(dvd);

	            JOptionPane.showMessageDialog(dialog, "DVD added successfully!");
	            dialog.dispose(); // close the dialog
	        }
	    });

	    dialog.setSize(400, 300);
	    dialog.setLocationRelativeTo(this); // center the dialog on parent
	    dialog.setVisible(true);
	}
	
	private void addCD() {
	    JDialog dialog = new JDialog(this, "Add New CD", true);
	    dialog.setLayout(new GridLayout(7, 2, 10, 10));

	    JLabel titleLabel = new JLabel("Enter Title: ");
	    JTextField titleField = new JTextField(10);
	    JLabel categoryLabel = new JLabel("Enter Category: ");
	    JTextField categoryField = new JTextField(10); 
	    JLabel directorLabel = new JLabel("Enter Director: ");
	    JTextField directorField = new JTextField(10); 
	    JLabel lengthLabel = new JLabel("Enter Length: ");
	    JTextField lengthField = new JTextField(10); 
	    JLabel costLabel = new JLabel("Enter Cost: ");
	    JTextField costField = new JTextField(10); 
	    JLabel artistLabel = new JLabel("Enter Artist: ");
	    JTextField artistField = new JTextField(10); 

	    JButton submitButton = new JButton("Add CD");

	    dialog.add(titleLabel);
	    dialog.add(titleField);
	    dialog.add(categoryLabel);
	    dialog.add(categoryField);
	    dialog.add(directorLabel);
	    dialog.add(directorField);
	    dialog.add(lengthLabel);
	    dialog.add(lengthField);
	    dialog.add(costLabel);
	    dialog.add(costField);
	    dialog.add(artistLabel);
	    dialog.add(artistField);
	    dialog.add(new JLabel()); // empty cell
	    dialog.add(submitButton);

	    submitButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String title = titleField.getText();
	            String category = categoryField.getText();
	            String director = directorField.getText();
	            String lengthText = lengthField.getText();
	            String costText = costField.getText();
	            String artist = artistField.getText();

	            int length = 0;
	            double cost = 0;

	            try {
	                length = Integer.parseInt(lengthText);
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(dialog, "Invalid length input!", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            try {
	                cost = Double.parseDouble(costText);
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(dialog, "Invalid cost input!", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            Media cd = new CompactDisc(title, category,(float) cost, length, director,artist);
	            store.addMedia(cd);

	            JOptionPane.showMessageDialog(dialog, "DVD added successfully!");
	            dialog.dispose(); // close the dialog
	        }
	    });

	    dialog.setSize(400, 300);
	    dialog.setLocationRelativeTo(this); // center the dialog on parent
	    dialog.setVisible(true);
	}

	JMenuBar createMenuBar() {
	    JMenu menu = new JMenu("Options");
	    JMenuItem viewStoreItem = new JMenuItem("View store");
	    viewStoreItem.addActionListener(e -> {
	        ArrayList<Media> mediaInStore = store.getItemsInStore();

	        StringBuilder mediaList = new StringBuilder();
	        
	        for (int i = 0; i < mediaInStore.size(); i++) {
	            Media media = mediaInStore.get(i);
	            mediaList.append(media.getTitle()).append("\n");
	        }

	        JOptionPane.showMessageDialog(null, mediaList.toString(), "Store Items", JOptionPane.INFORMATION_MESSAGE);
	    });
	    menu.add(viewStoreItem);

	    JMenu smUpdateStore = new JMenu("Update Store");
	    JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });
        smUpdateStore.add(addBookItem);
	    
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCD();
            }
        });
        smUpdateStore.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	addDVD();
            }
        });
        smUpdateStore.add(addDVDItem);
	    menu.add(smUpdateStore);

	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menuBar.add(menu);
	    return menuBar;
	}

	JPanel createHeader() {
	    JPanel header = new JPanel();
	    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

	    JLabel title = new JLabel("AIMS");
	    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	    title.setForeground(Color.CYAN);

	    header.add(Box.createRigidArea(new Dimension(10, 10)));
	    header.add(title);
	    header.add(Box.createHorizontalGlue());
	    header.add(Box.createRigidArea(new Dimension(10, 10)));

	    return header;
	}
	
	public class MediaStore extends JPanel {
	    private Media media;
	    private static final long serialVersionUID = 1L;
	    public MediaStore(Media media) {
	        this.media = media;
	        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	        JLabel title = new JLabel(media.getTitle());
	        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
	        title.setAlignmentX(CENTER_ALIGNMENT);

	        JLabel cost = new JLabel(String.format("%.2f $", media.getCost()));
	        cost.setAlignmentX(CENTER_ALIGNMENT);

	        JPanel container = new JPanel();
	        container.setLayout(new FlowLayout(FlowLayout.CENTER));

	        if (media instanceof Playable) {
	            JButton playButton = new JButton("Play");
	            playButton.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    JOptionPane.showMessageDialog(null, "Playing CD: " + media.getTitle());
	                }
	            });
	            container.add(playButton);
	        }

	        this.add(Box.createVerticalGlue());
	        this.add(title);
	        this.add(cost);
	        this.add(Box.createVerticalGlue());
	        this.add(container);

	        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    }
	}
	
	JPanel createCenter() {
	    JPanel center = new JPanel();
	    center.setLayout(new GridLayout(3, 3, 2, 2));

	    ArrayList<Media> mediaInStore = store.getItemsInStore();
	    for (int i = 0; i < 9; i++) {
	        MediaStore cell = new MediaStore(mediaInStore.get(i));
	        center.add(cell);
	    }

	    return center;
	}
	
	public StoreManagerScreen(Store store) {
	    this.store = store;

	    Container cp = getContentPane();
	    cp.setLayout(new BorderLayout());
	    cp.add(createNorth(), BorderLayout.NORTH);
	    cp.add(createCenter(), BorderLayout.CENTER);

	    setTitle("Store");
	    setSize(1024, 768);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		Store store = new Store();
	    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
	    store.addMedia(dvd1);

	    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
	    store.addMedia(dvd2);

	    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
	    store.addMedia(dvd3);
	    
	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar: The Way of Water", "Mystic", "James Cameron", 125, 27.99f);
	    store.addMedia(dvd4);
	    store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f));
	    store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", 24.95f));
	    store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", 18.99f));
	    store.addMedia(new DigitalVideoDisc("The Dark Knight", "Action", 29.99f));
	    store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", 19.95f));
	    store.addMedia(new DigitalVideoDisc("Matrix", "Action", 24.99f));
	    store.addMedia(new DigitalVideoDisc("The Avengers", "Action", 29.99f));
	    store.addMedia(new DigitalVideoDisc("Frozen", "Animation", 21.99f));
	    store.addMedia(new DigitalVideoDisc("Jurassic Park", "Adventure", 15.99f));
		new StoreManagerScreen(store);
    }

}
