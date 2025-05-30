package hust.soict.hedspi.aims.Aims;
import java.util.Scanner;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.dsai.aims.exception.PlayerException;


public class Aims {
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		}
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	public static void UpdateStore() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add Media");
		System.out.println("2. Remove Media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	public static void addMedia() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Book");
		System.out.println("2. CD");
		System.out.println("3. DVD");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
		public static void main(String[] args) {

		    Cart cart = new Cart();
		    Store store = new Store();
		    Scanner scanner = new Scanner(System.in);
		    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    	    store.addMedia(dvd1);

    	    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
    	    store.addMedia(dvd2);

    	    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
    	    store.addMedia(dvd3);
    	    
    	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar: The Way of Water", "Mystic", "James Cameron", 125, 27.99f);
    	    store.addMedia(dvd4);
		    
		    while (true) {
		    showMenu();
		    int choice = scanner.nextInt();
		    
		    switch(choice) {
		    case 1:
		    	store.displayStore();
		    	storeMenu();
		    	int choice1 = scanner.nextInt();
		    	scanner.nextLine();
		    	switch(choice1) {
			    case 1:
			    	System.out.println("Enter the title of the media: ");
			    	String title11 = scanner.nextLine();
			    	store.ViewDetail(title11);
			    	mediaDetailsMenu();
			    	int choice11 = scanner.nextInt();
			    	scanner.nextLine();
			    	switch(choice11) {
				    case 1:
						System.out.println("Are you sure: Yes/No ");
				    	String answer = scanner.nextLine();
				    	if(answer.equalsIgnoreCase("Yes")) {
				    		Media media = store.findByTitle(title11);
				    		if (media != null) {
				    		    cart.addMedia(media);
				    		    System.out.println("Number of Medias in cart: " + cart.getQtyOrdered());
				    		} else {
				    		    System.out.println("Media not found in store.");
				    		}
				    	} else if(answer.equalsIgnoreCase("No")) {
				    		System.out.println("Cancel succesfully.");
				    	}
				    	break;
				    case 2:
				    	store.playStore(title11);
				    	break;
				    case 0:
				    	break;
			    	}
			    	break;
			    case 2:
			    	System.out.println("Enter the title of the media: ");
			    	String title12 = scanner.nextLine();
			    	System.out.println("Are you sure: Yes/No ");
			    	String answer = scanner.nextLine();
			    	if(answer.equalsIgnoreCase("Yes")) {
			    		Media media = store.findByTitle(title12);
			    		if (media != null) {
			    		    cart.addMedia(media);
			    		    System.out.println("Number of Medias in cart: " + cart.getQtyOrdered());
			    		} else {
			    		    System.out.println("Media not found in store.");
			    		}
			    	} else if(answer.equalsIgnoreCase("No")) {
			    		System.out.println("Cancel succesfully.");
			    	}
			    	break;
			    case 3:
			    	System.out.println("Enter the title of the media: ");
			    	String title13 = scanner.nextLine();
			    	store.playStore(title13);
			    	break;
			    case 4:
			    	cart.print();
                    break;
			    case 0:
			    	break;
			    }
		    	break;
		    case 2:
		    	UpdateStore();
		    	int choice2 = scanner.nextInt();
		    	scanner.nextLine();
		    	switch(choice2) {
		    	case 1:
		    		addMedia();
		    		int choice21 = scanner.nextInt();
		    		scanner.nextLine();
			    	switch(choice21) {
			    	case 1:
			    		System.out.println("Title: ");
			    		String title21 = scanner.nextLine();
			    		System.out.println("Category: ");
			    		String category21 = scanner.nextLine();
			    		System.out.println("Cost: ");
			    		float cost21 = scanner.nextFloat();
			    		scanner.nextLine(); 
			    		Media book = new Book(title21,category21,cost21);
			    		store.addMedia(book);
			    		break;
			    	case 2:
			    		System.out.println("Title: ");
			    		String title22 = scanner.nextLine();
			    		System.out.println("Category: ");
			    		String category22 = scanner.nextLine();
			    		System.out.println("Cost: ");
			    		float cost22 = scanner.nextFloat();
			    		scanner.nextLine(); 
			    		System.out.println("Length: ");
			    		int Length22 = scanner.nextInt();
			    		scanner.nextLine(); 
			    		System.out.println("Director: ");
			    		String Director22 = scanner.nextLine();
			    		System.out.println("artist: ");
			    		String Artist22 = scanner.nextLine(); 
			    		Media cd = new CompactDisc(title22,category22,cost22,Length22,Director22,Artist22);
			    		store.addMedia(cd);
			    		break;
			    	case 3:
			    		System.out.println("Title: ");
			    		String title23 = scanner.nextLine(); 
			    		System.out.println("Category: ");
			    		String category23 = scanner.nextLine();
			    		System.out.println("Director: ");
		    			String Director23 = scanner.nextLine();
		    			System.out.println("Length: ");
		    			int Length23 = scanner.nextInt();
		    			scanner.nextLine(); 
		    			System.out.println("Cost: ");
		    			float cost23 = scanner.nextFloat();
		    			scanner.nextLine(); 
		    			Media dvd = new DigitalVideoDisc(title23,category23,Director23,Length23,cost23);
		    			store.addMedia(dvd);
		    			break;
			    	}
			    	break;
		    	case 2:
		    		System.out.println("Enter the title of the media: ");
			    	String title12 = scanner.nextLine();
			    	store.removeByTitle(title12);
			    	break;
		    	case 0:
		    		break;
		    	}
		    	break;
		    case 3:
		    	cartMenu();
		    	int choice3 = scanner.nextInt();
		    	scanner.nextLine();
		    	switch(choice3) {
		    	case 1:
		    		System.out.println("Filter by: 1. ID  2. Title");
	                int filterOption = scanner.nextInt();
	                scanner.nextLine();
	                if (filterOption == 1) {
	                    System.out.print("Enter ID: ");
	                    int id = scanner.nextInt();
	                    cart.searchById(id);
	                } else if (filterOption == 2) {
	                    System.out.print("Enter title: ");
	                    String title = scanner.nextLine();
	                    cart.searchByTitle(title);
	                }
	                break;
		    	case 2:
		    		 System.out.println("Sort by: 1. Title  2. Cost");
		                int sortOption = scanner.nextInt();
		                if (sortOption == 1) {
		                    cart.sortByTitle();
		                } else if (sortOption == 2) {
		                    cart.sortByCost();
		                }
		                cart.print();
		                break;
		    	case 3:
		    		System.out.print("Enter title to remove: ");
	                String titleToRemove = scanner.nextLine();
	                System.out.println("Are you sure: Yes/No ");
			    	String answer = scanner.nextLine();
			    	if(answer.equalsIgnoreCase("Yes")) {
			                cart.removeByTitle(titleToRemove);
					    	System.out.println("Number of Medias in cart: " + cart.getQtyOrdered());
			    	} else if(answer.equalsIgnoreCase("No")) {
			    		System.out.println("Cancel succesfully.");
			    	}
	                break;
		    	case 4:
					System.out.print("Enter title to play: ");
					String titleToPlay = scanner.nextLine();
					Media mediaToPlay = cart.searchByTitle(titleToPlay);

					if (mediaToPlay instanceof Playable) {
						try {
							((Playable) mediaToPlay).play();
						} catch (PlayerException e) {
							System.err.println("Error playing media: " + e.getMessage());
							e.printStackTrace(); // Hoặc hiển thị dialog nếu dùng giao diện
						}
					} else {
						System.out.println("This media is not playable.");
					}
	                break;
		    	case 5:
		    		System.out.println("Order has been placed.");
	                cart.clearCart();
	                break;
		    	case 0:
		    		break;
		    	}
		    break;
		    case 0:
		    	System.out.println("Exiting the program.");
                scanner.close();
                return;		
		    }
		    
		}
		}
}
