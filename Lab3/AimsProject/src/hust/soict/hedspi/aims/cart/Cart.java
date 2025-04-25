package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.JOptionPane;


import hust.soict.hedspi.aims.media.Media;
public class Cart {
		public static final int MAX_NUMBERS_ORDERED = 20;
//	    private  int qtyOrdered = 0;
	    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	    public void sortByTitle() {
	        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	        System.out.println("Cart sorted by title (then by cost if titles are the same).");
	        this.printCart(); // Print the sorted cart
	    }

	    public void sortByCost() {
	        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	        System.out.println("Cart sorted by cost (decreasing, then by title if costs are the same).");
	        this.printCart(); // Print the sorted cart
	    }
	    
	    
	    public void addMedia(Media media) {
	        if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
	            JOptionPane.showMessageDialog(null, "CART IS FULL CANNOT ADD \"" + media.getTitle() + "\" ", null, JOptionPane.ERROR_MESSAGE);
	        } else {
	            itemsOrdered.add(media);
	            System.out.println("The item \"" + media.getTitle() + "\" has been added");
	            if (itemsOrdered.size() == MAX_NUMBERS_ORDERED - 1) {
	                JOptionPane.showMessageDialog(null, "The cart is almost full", null, JOptionPane.INFORMATION_MESSAGE);
	            }
	        }
	    }

	    public void removeMedia(Media media) {
	        boolean removed = itemsOrdered.remove(media);
	        if (removed) {
	            System.out.println("The item \"" + media.getTitle() + "\" has been removed.");
	        } else {
	            System.out.println("Item not found in cart.");
	        }
	    }
	    
	    public float totalCost() {
	        float total = 0;
	        for (Media media : itemsOrdered) {
	            total += media.getCost();
	        }
	        return total;
	    }
	  
	    public void printCart() {
	        if (itemsOrdered.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "The cart is empty.", null, JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("***********************CART***********************");
	            System.out.println("Ordered Items:");
	            float totalCost = 0.0f;
	            for (int i = 0; i < itemsOrdered.size(); i++) {
	                Media media = itemsOrdered.get(i);
	                System.out.printf("%-2d. %-10d - %-20s - %-15s - $%.2f\n",
	                        (i + 1), media.getId(), media.getTitle(), media.getCategory(), media.getCost());
	                totalCost += media.getCost();
	            }
	            System.out.println("-----------------------------------------");
	            System.out.printf("Total cost: $%.2f\n", totalCost);
	            System.out.println("********************************************");
	        }
	    }
	
//					   public static void main(String[] args) {
//						   Cart ok = new Cart();
//						   DigitalVideoDisc dvd = new DigitalVideoDisc("2","2" , 15.6f);
//						   ok.addDigitalVideoDisc(new DigitalVideoDisc("1","2" , 15.6f));
//						   ok.addDigitalVideoDisc(new DigitalVideoDisc("3","2" , 15.6f));
//						  ok.addDigitalVideoDisc(dvd);
//						   
//						   ok.printCart();
//						   ok.removeDigitalVideoDisc(dvd);
//						   ok.printCart();
//						   
//						 
//					   }
	    public void searchMediaByID(int id) {
	        boolean found = false;
	        for (Media media : itemsOrdered) {
	            if (media.getId() == id) {
	                System.out.printf("Found: %s\n", media.toString()); // Assuming toString() is implemented in Media and subclasses
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("No matched id " + id + " in the cart");
	        }
	    }

	    public void searchMediaByTitle(String title) {
	        boolean found = false;
	        for (Media media : itemsOrdered) {
	            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
	                System.out.printf("Found: %s\n", media.toString()); // Assuming toString() is implemented
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("No matched title \"" + title + "\" in the cart");
	        }
	    }

		public ArrayList<Media> getItemsOrdered() {
			return itemsOrdered;
		}

		
	   }
	   
	   
	   
	   
					

