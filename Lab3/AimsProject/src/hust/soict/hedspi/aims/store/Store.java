package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Store {
    private static final int MAX_ITEMS = 1000;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.size() >= MAX_ITEMS) {
            System.out.println("Maximum storage capacity reached. Unable to add more items.");
            return;
        }
        itemsInStore.add(media);
        System.out.println("Added \"" + media.getTitle() + "\" to the store.");
    }

    public void removeMedia(Media media) {
        boolean removed = itemsInStore.remove(media);
        if (removed) {
            System.out.println("The item \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("Item not found in the store.");
        }
    }

    public void printStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty.");
            return;
        }

        System.out.println("***********************STORE***********************");
        System.out.println("The following items are currently in the store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            Media media = itemsInStore.get(i);
            System.out.println((i + 1) + ". " + media.toString()); // Assuming toString() in Media
        }
        System.out.println("**************************************************");
    }

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
}