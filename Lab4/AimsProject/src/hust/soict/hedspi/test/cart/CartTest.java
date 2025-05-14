package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class CartTest {
	public static void main(String[] args) {
		// Create a new cart
		Cart cart = new Cart();

		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd01 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd01);

		DigitalVideoDisc dvd02 = new DigitalVideoDisc("Star Was", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd02);

		DigitalVideoDisc dvd03 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addMedia(dvd03);

		// Test the print method
		cart.printCart();
		// To-do: Test the search methods here
		cart.searchMediaByID(1);
		cart.searchMediaByID(4);
		cart.searchMediaByTitle("Star Wars");
		cart.searchMediaByTitle("Lione King");

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers, Rob Minkoff", 88,
				19.99f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements, John Musker", 90, 15.50f);
		Book book1 = new Book("The Hitchhiker's Guide to the Galaxy", "Science Fiction", 12.75f);
		Book book2 = new Book("Pride and Prejudice", "Romance", 12.75f);
		CompactDisc cd1 = new CompactDisc("Abbey Road", "Rock", "The Beatles", "The Beatles", 47,10.99f);
		cd1.addTrack(new Track("Come Together", 4));
		cd1.addTrack(new Track("Something", 3));

		// Add items to the cart
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(book1);
		cart.addMedia(book2);
		cart.addMedia(cd1);
		cart.printCart();
		System.out.println("Order item by title:");

		// Sort the cart by title (then by cost if titles are the same)
		cart.sortByTitle();
		System.out.println("Order item by cost:");

		// Sort the cart by cost (decreasing, then by title if costs are the same)
		cart.sortByCost();

	}
}
