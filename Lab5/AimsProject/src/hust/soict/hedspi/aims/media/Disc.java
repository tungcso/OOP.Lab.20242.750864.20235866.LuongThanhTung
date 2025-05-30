package hust.soict.hedspi.aims.media;

public class Disc extends Media implements Comparable<Media>{
	private int length;
	private String director;

	public Disc(String title, String category, double cost, int length, String director) {
		super(title, category, cost, "CD");
		this.length = length;
		this.director = director;
	}
	public Disc(String title) {
		super(title,"CD");
	}
	public Disc(String title, String category, double cost) {
		super(title, category, cost,"CD");
	}
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}
	@Override
	public int compareTo(Media other) {
	    if (other instanceof Disc) {
	        Disc disc = (Disc) other;
	        int titleCompare = this.getTitle().compareToIgnoreCase(disc.getTitle());
	        if (titleCompare != 0) return titleCompare;
	        int lengthCompare = Integer.compare(disc.getLength(), this.getLength()); // length giảm dần
	        if (lengthCompare != 0) return lengthCompare;
	        return Double.compare(this.getCost(), disc.getCost());
	    }
	    return this.getTitle().compareToIgnoreCase(other.getTitle());
	}
}
