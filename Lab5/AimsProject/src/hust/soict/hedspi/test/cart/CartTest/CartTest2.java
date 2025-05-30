package hust.soict.hedspi.test.cart.CartTest;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class CartTest2 {

	public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<>();
        
        Media cd = new CompactDisc("A Great CD", "Music", 15.99f, 60, "John Doe", "Artist One");
        Media dvd = new DigitalVideoDisc("Movie Night", "Action", "Jane Doe", 120, 19.99f);
        Media book = new Book("The Great Book", "Fiction", 10.50f);

        mediaList.add(cd);
        mediaList.add(dvd);
        mediaList.add(book);


        for (Media media : mediaList) {
            System.out.println(media.toString()); 
        }
    }

}
