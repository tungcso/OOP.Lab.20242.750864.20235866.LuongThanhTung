package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

	public void addMedia(Media media) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
	        System.out.println("The cart is full. Cannot add more items.");
		} else if (itemsOrdered.contains(media)) {
	        System.out.println("This item is already in the cart.");
	    } else {
	        itemsOrdered.add(media);
	        System.out.println("The item has been added to the cart.");
	    }
	}
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
        } else {
            System.out.println("Track not found in the list.");
        }
	}

 	public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("\nCart contains:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println(i + ". " + media.getTitle() + " - $" + media.getCost());
            i++;
        }
        System.out.println("Total cost: $" + totalCost());
    }

    public void print() {
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
    	System.out.println("Total cost: " + totalCost());
    	System.out.println("***************************************************");
    }
    public Media searchByTitle(String title) {
        System.out.println("Search results for title: \"" + title + "\"");
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        System.out.println("No match found for title: \"" + title + "\"");
        return null;
    }
    public Media searchById(int id) {
        System.out.println("Search results for Id: \"" + id + "\"");
        for (Media media : itemsOrdered) {
            if (media.getId()==id) {
                return media;
            }
        }
        System.out.println("No match found for Id: \"" + id + "\"");
        return null;
    }
    public void addByTitle(String title) {
   	    for (Media media : itemsOrdered) {
   	        if (media.getTitle().equalsIgnoreCase(title)) {
   	        	addMedia(media);
   	        }
   	    }
}
    public void removeByTitle(String title) {
        boolean found = false;
        Iterator<Media> iterator = itemsOrdered.iterator();
        while (iterator.hasNext()) {
            Media media = iterator.next();
            if (media.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("Removed: " + media.getTitle());
                found = true;
                break; // Nếu chỉ xóa một media
            }
        }
        if (!found) {
            System.out.println("No media found with title: " + title);
        }
    }

    public void sortByTitle() {
        itemsOrdered.sort(Comparator.comparing(Media::getTitle, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Sort by title successfully.");
    }
    public void sortByCost() {
        itemsOrdered.sort(Comparator.comparing(Media::getCost));
        System.out.println("Sort by cost successfully.");
    }
    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("Clear Successfully.");
    }
    public int getQtyOrdered() {
	    return itemsOrdered.size();
	}


}