package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;


public class StoreTest {
	public static void main(String[] args) {
	Store store = new Store();

    // Create new DVD objects and add them to the cart
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    store.addMedia(dvd1);

    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
    store.addMedia(dvd2);

    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
    store.addMedia(dvd3);
    
    DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar: The Way of Water", "Mystic", "James Cameron", 125, 27.99f);
    store.addMedia(dvd4);
    
    store.removeMedia(dvd3);
	}


}
