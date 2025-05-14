package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

public class TestMedia {

	public static void main(String[] args) {
		// Create an ArrayList of Media
		List<Media> mediae = new ArrayList<>();

		// Create some media items (CD, DVD, Book)
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers, Rob Minkoff", 88,
				24.99f);
		CompactDisc cd = new CompactDisc("Abbey Road", "Rock", "The Beatles", "The Beatles",  47, 10.99f);
		Book book = new Book("The Hitchhiker's Guide to the Galaxy", "Science Fiction", 15.50f);

		// Add some tracks to the CD
		cd.addTrack(new Track("Come Together", 4));
		cd.addTrack(new Track("Something", 3));

		// Add the media items to the list
		mediae.add(dvd);
		mediae.add(cd);
		mediae.add(book);

		// Iterate through the list and print the information of each media item
		System.out.println("Information of media items in the list:");
		for (Media m : mediae) {
			System.out.println(m.toString());
		}
	}
}
