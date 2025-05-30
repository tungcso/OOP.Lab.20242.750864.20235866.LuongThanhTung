package hust.soict.hedspi.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
		super(title, category, cost, length, director);
	}
		
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category, double cost) {
		super(title, category, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, double cost) {
		super(title, category, cost);
	}

	public String toString() {
	    return getId() + " . DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
	}
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
	        System.out.println("Playing DVD: " + this.getTitle());
	        System.out.println("DVD length: " + this.getLength() + " minutes");
	    } else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
	@Override
	public int compareTo(Media other) {
		if (other instanceof DigitalVideoDisc) {
	        DigitalVideoDisc dvd = (DigitalVideoDisc) other;
	        int titleCompare = this.getTitle().compareToIgnoreCase(dvd.getTitle());
	        if (titleCompare != 0) return titleCompare;
	        int lengthCompare = Integer.compare(dvd.getLength(), this.getLength()); 
	        if (lengthCompare != 0) return lengthCompare;
	        return Double.compare(this.getCost(), dvd.getCost());
	    }
	    return super.compareTo(other);
	}


}
