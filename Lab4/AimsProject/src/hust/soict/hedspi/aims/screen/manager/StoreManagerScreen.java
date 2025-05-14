package hust.soict.hedspi.aims.screen.manager;

import java.util.ArrayList;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.*;

public class StoreManagerScreen extends JFrame {
	private Store store;
	private JPanel centerPanel;  
	
	 public StoreManagerScreen(Store store) {
	        this.store = store;

	        Container cp = getContentPane();
	        cp.setLayout(new BorderLayout());
	        cp.add(createNorth(), BorderLayout.NORTH);
	        centerPanel = createCenter();
	        cp.add(centerPanel, BorderLayout.CENTER);

	        setTitle("Store");
	        setSize(1024, 768);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Added this for proper closing
	        setVisible(true);
	    }
	
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		JMenuItem menuItemViewStore = new JMenuItem("View Store"); 
		
		menuItemViewStore.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                NewScreen(createCenter()); // Show the store view
            }
        });
		menu.add(menuItemViewStore);
		
		JMenu smupdateStore = new JMenu("Update Store");
		
			JMenuItem menuAddBook =	new JMenuItem("Add Book");
			menuAddBook.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	            	System.out.println("book");
	                NewScreen((new AddBookToStoreScreen(store))); // Show the store view
	            }
	        });
				
		smupdateStore.add(menuAddBook);
		
		JMenuItem menuAddDVD = new JMenuItem("Add DVD");
		
		menuAddDVD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	
                NewScreen((new AddDVDToStoreScreen(store))); // Show the store view
            }
        });
		smupdateStore.add(menuAddDVD);
		
		JMenuItem menuAddCD = new JMenuItem("Add CD"); 
		
		menuAddCD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	
                NewScreen((new AddCDToStoreScreen(store))); // Show the store view
            }
        });
		smupdateStore.add(menuAddCD);
		menu.add(smupdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	
	JPanel createHeader()
	{
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
		
		
		
	}
	
	JPanel createCenter() {
			JPanel center = new JPanel();
			center.setLayout(new GridLayout(3, 3, 2, 2));
			 ArrayList<Media> mediaInStore = store.getItemsInStore();
			 for(int i=0 ; i < mediaInStore.size(); i++) {
				 MediaStore cell = new MediaStore(mediaInStore.get(i));
				 center.add(cell);
			 }
			 
			 
		return center;
	}
	
	

	    // Constructor to setup the GUI components and event handlers
	    private void NewScreen(JPanel newPanel) {
	    	  getContentPane().removeAll();
	    	  getContentPane().add(createNorth() ,BorderLayout.NORTH); // Re-create the menu bar (or keep it if you don't removeAll)
	    	    getContentPane().add(newPanel, BorderLayout.CENTER);
	    	    getContentPane().revalidate(); // Important: Refresh the layout
	    	    getContentPane().repaint();   // Important: Repaint the window
	    }
	
	

	public static void main (String[] args) {
		Store store = new Store();
		store.printStore();
		
	new StoreManagerScreen(store);
	}
	
	
	
	
	
}
