package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {
		public static void main(String [] args) {
			Store CuaHang = new Store();
			
			   //Create new dvd objects and add them to the cart
	        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
	                "Animation", "Roger Allers", 87, 19.95f);
	        CuaHang.addMedia(dvd1);

	        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
	                "Science Fiction", "George Lucas", 87, 24.95f);
	        CuaHang.addMedia(dvd2);

	        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
	                "Animation", 18.99f);
	        CuaHang.addMedia(dvd3);

			CuaHang.printStore();
			CuaHang.removeMedia(dvd2); // xoa StarWar
			CuaHang.printStore();
			CuaHang.removeMedia(dvd1);      // xoa dvd1 
			CuaHang.printStore();
		}
	
	
}
