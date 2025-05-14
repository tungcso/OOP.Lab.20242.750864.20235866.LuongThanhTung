package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.playable.Playable;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.*;

public class Aims {
	static Scanner scanner = new Scanner(System.in);
	static Store store = new Store();
	static Cart cart = new Cart();

	public static void showMenu() {

		int choice;
		do {
			System.out.println("AIMS:");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				storeMenu();
				break;
			case 2:
				updateStoreMenu();
				break;
			case 3:
				cartMenu();
				break;
			case 0:
				System.out.println("Exiting AIMS. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}

	public static void storeMenu() {
		store.printStore();
		int choice;

		do {
			System.out.println("Options:");
			System.out.println("--------------------------------");
			System.out.println("1. See a media's details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-0");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				seeMediaDetails();
				break;
			case 2:
				addMediaToCart();
				break;
			case 3:
				playMediaInStore();
				break;
			case 4:
				cartMenu();
				break;
			case 0:
				System.out.println("Back to main menu.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}

	public static void seeMediaDetails() {
		System.out.println("Enter the title of the media to see details:");
		String title = scanner.nextLine();
		boolean found = false;
		for (Media media : store.getItemsInStore()) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Details for \"" + media.getTitle() + "\":");
				System.out.println(media.toString());
				found = true;
//	                if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
//	                    playMediaDetailsMenu(media);
//	                }
				break;
			}
		}
		if (!found) {
			System.out.println("Media with title \"" + title + "\" not found in the store.");
		}
	}

	public static void playMediaDetailsMenu(Media media) {
		int choice;
		do {
			System.out.println("Options for playing:");
			System.out.println("--------------------------------");
			System.out.println("1. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				if (media instanceof Playable) {
					((Playable) media).play();
				} else {
					System.out.println("This media is not playable.");
				}
				break;
			case 0:
				System.out.println("Back to store menu.");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (true);
	}

	public static void addMediaToCart() {
		System.out.println("Enter the title of the media to add to cart:");
		String title = scanner.nextLine();
		boolean found = false;
		for (Media media : store.getItemsInStore()) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				cart.addMedia(media);
				found = true;
				if (media instanceof DigitalVideoDisc) {
					System.out.println("Number of DVDs in cart: "
							+ cart.getItemsOrdered().stream().filter(item -> item instanceof DigitalVideoDisc).count());
				}
				break;
			}
		}
		if (!found) {
			System.out.println("Media with title \"" + title + "\" not found in the store.");
		}
	}

	public static void playMediaInStore() {
		System.out.println("Enter the title of the media to play:");
		String title = scanner.nextLine();
		boolean found = false;
		for (Media media : store.getItemsInStore()) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				if (media instanceof Playable) {
					((Playable) media).play();
				} else {
					System.out.println("This media is not playable.");
				}
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Media with title \"" + title + "\" not found in the store.");
		}
	}

	public static void updateStoreMenu() {
		int choice;
		do {
			System.out.println("Update Store:");
			System.out.println("--------------------------------");
			System.out.println("1. Add media to store");
			System.out.println("2. Remove media from store");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				addMediaToStore();
				break;
			case 2:
				removeMediaFromStore();
				break;
			case 0:
				System.out.println("Back to main menu.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}

	public static void addMediaToStore() {
		System.out.println("Enter the title of the media to add:");
		String title = scanner.nextLine();
		System.out.println("Enter the category:");
		String category = scanner.nextLine();
		System.out.println("Enter the cost:");
		float cost = scanner.nextFloat();
		scanner.nextLine(); // Consume newline

		System.out.println("Enter the type (book, dvd, cd):");
		String type = scanner.nextLine().toLowerCase();

		switch (type) {
		case "book":
			System.out.println("Enter author name:");
			String author = scanner.nextLine();
			Book book = new Book(title, category, cost);
			book.addAuthor(author);
			store.addMedia(book);
			break;
		case "dvd":
			System.out.println("Enter director:");
			String dir = scanner.nextLine();
			System.out.println("Enter length:");
			int length = scanner.nextInt();
			scanner.nextLine(); // Consume newline
			DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, dir, length, cost);
			store.addMedia(dvd);
			break;
		case "cd":
			System.out.println("Enter artist:");
			String artist = scanner.nextLine();
			CompactDisc cd = new CompactDisc(title, category,  "IDK", artist,0,cost); // Length and director might be
																						// unknown initially
			store.addMedia(cd);
			// You might want to add tracks here as well, but we'll keep it simple for now
		default:
			System.out.println("Invalid media type.");
		}
	}

	public static void removeMediaFromStore() {
		System.out.println("Enter the title of the media to remove from the store:");
		String title = scanner.nextLine();
		boolean found = false;
		Media mediaToRemove = null;
		for (Media media : store.getItemsInStore()) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				mediaToRemove = media;
				found = true;
				break;
			}
		}
		if (found) {
			store.removeMedia(mediaToRemove);
		} else {
			System.out.println("Media with title \"" + title + "\" not found in the store.");
		}
	}

	public static void cartMenu() {
		int choice;
		do {
			System.out.println("Cart Options:");
			System.out.println("--------------------------------");
			System.out.println("1. Filter media in cart");
			System.out.println("2. Sort media in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				filterMediaInCartMenu();
				break;
			case 2:
				sortMediaInCartMenu();
				break;
			case 3:
				removeMediaFromCart();
				break;
			case 4:
				playMediaInCart();
				break;
			case 5:
				placeOrder();
				break;
			case 0:
				System.out.println("Back to main menu.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}

	public static void filterMediaInCartMenu() {
		int choice;
		do {
			System.out.println("Filter Cart by:");
			System.out.println("--------------------------------");
			System.out.println("1. By ID");
			System.out.println("2. By Title");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				System.out.println("Enter the ID to filter:");
				int id = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				cart.searchMediaByID(id);
				break;
			case 2:
				System.out.println("Enter the title to filter:");
				String title = scanner.nextLine();
				cart.searchMediaByTitle(title);
				break;
			case 0:
				System.out.println("Back to cart menu.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}

	public static void sortMediaInCartMenu() {
		int choice;
		do {
			System.out.println("Sort Cart by:");
			System.out.println("--------------------------------");
			System.out.println("1. By Title (then Cost)");
			System.out.println("2. By Cost (then Title)");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				cart.sortByTitle();
				break;
			case 2:
				cart.sortByCost();
				break;
			case 0:
				System.out.println("Back to cart menu.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}

	public static void removeMediaFromCart() {
		System.out.println("Enter the title of the media to remove from the cart:");
		String title = scanner.nextLine();
		boolean found = false;
		Media mediaToRemove = null;
		for (Media media : cart.getItemsOrdered()) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				mediaToRemove = media;
				found = true;
				break;
			}
		}
		if (found) {
			cart.removeMedia(mediaToRemove);
		} else {
			System.out.println("Media with title \"" + title + "\" not found in the cart.");
		}
	}

	public static void playMediaInCart() {
		System.out.println("Enter the title of the media to play from the cart:");
		String title = scanner.nextLine();
		boolean found = false;
		for (Media media : cart.getItemsOrdered()) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				if (media instanceof Playable) {
					((Playable) media).play();
				} else {
					System.out.println("This media is not playable.");
				}
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Media with title \"" + title + "\" not found in the cart.");
		}
	}

	public static void placeOrder() {
		if (cart.getItemsOrdered().isEmpty()) {
			System.out.println("Your cart is empty. Nothing to order.");
		} else {
			System.out.println("Order placed successfully!");
			System.out.println("Items ordered:");
			cart.printCart();
			cart.getItemsOrdered().clear(); // Empty the cart after placing the order
		}
	}

	public static void main(String[] args) {

		Store store = new Store();

		// Add some initial items to the store for testing
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers, Rob Minkoff", 88,
				19.99f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements, John Musker", 90, 15.50f);
		Book book1 = new Book("The Hitchhiker's Guide to the Galaxy", "Science Fiction", 12.75f);
		CompactDisc cd1 = new CompactDisc("Abbey Road", "Rock","The Beatles", "The Beatles", 47,10.99f );
		cd1.addTrack(new Track("Come Together", 4));
		cd1.addTrack(new Track("Something", 3));

		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(book1);
		store.addMedia(cd1);

		Aims.store = store; // Assign the local store to the class's static variable. Important!
		showMenu();

	}
}
