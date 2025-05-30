package hust.soict.hedspi.aims.store;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;


public class Store {
	public static final int MaxNumber = 40;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
	    if (!itemsInStore.contains(media)) {
	        itemsInStore.add(media);
	        System.out.println("Added to store: " + media.getTitle());
	    } else {
	        System.out.println("This media is already in the store.");
	    }
	}

	public void removeMedia(Media media) {
	    if (itemsInStore.contains(media)) {
	        itemsInStore.remove(media);
	        System.out.println("Removed from store: " + media.getTitle());
	    } else {
	        System.out.println("Media not found in the store.");
	    }
	}
	public void displayStore() {
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }
	public void ViewDetail(String title) {
		 boolean found = false;
 	    System.out.println("Search results for title: \"" + title + "\"");
 	    for (Media media : itemsInStore) {
 	        if (media.getTitle().equalsIgnoreCase(title)) {
 	            System.out.println(media.toString());
 	            found = true;
 	        }
 	    }
 	    if (!found) {
 	        System.out.println("No match found for title: \"" + title + "\"");
 	    }
    }
	public void removeByTitle(String title) {
	    boolean found = false;
	    int removedId = -1;

	    for (int i = 0; i < itemsInStore.size(); i++) {
	        Media media = itemsInStore.get(i);
	        if (media.getTitle().equalsIgnoreCase(title)) {
	            removedId = media.getId();
	            itemsInStore.remove(i);
	            found = true;
	            i--;
	        }
	    }

	    for (Media media : itemsInStore) {
	        if (media.getId() > removedId) {
	            media.setId(media.getId() - 1);
	        }
	    }
	    

	    if (!found) {
	        System.out.println("No match found for title: \"" + title + "\"");
	    }
	}
	    public void playStore(String title) {
		    for (Media media : itemsInStore) {
		        if (media.getTitle().equalsIgnoreCase(title)) {
		        	if(media.getType().equalsIgnoreCase("Book")) {
		        		System.out.println("We cannot play mussic with a book.");
		        	} else {
		        		System.out.println("The music will start now.");
		        	}
		        }
		    }
   }
	    public ArrayList<Media> getItemsInStore() {
	        return itemsInStore;
	    }

	    public Media findByTitle(String title) {
	        for (Media media : itemsInStore) {
	            if (media.getTitle().equalsIgnoreCase(title)) {
	                return media;
	            }
	        }
	        return null;
	    }
}
