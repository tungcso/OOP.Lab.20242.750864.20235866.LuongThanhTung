package hust.soict.hedspi.aims.media;

import java.util.Comparator;

import hust.soict.hedspi.aims.comparable.comparator.MediaComparatorByCostTitle;
import hust.soict.hedspi.aims.comparable.comparator.MediaComparatorByTitleCost;

public abstract class Media implements Comparable<Media>{
	private int id;
    private String title;
    private String category;
    private double cost;
    private String type;
	private static int nbDigitalVideoDiscs = 0; 
    public Media() {}
    public Media(String title, String category, double cost, String type) {
    	nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.type = type;
    }
    public Media(String title, String type) {
    	nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.type = type;
    }
	public boolean isMatch(String title, String type) {
	    return this.getTitle().toLowerCase().contains(title.toLowerCase());
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public double getCost() {
		return cost;
	}
	public String getType() {
		return type;
	}
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	@Override
	public int compareTo(Media other) {
		if (other == null) throw new NullPointerException("Compared Media is null");

		int titleCompare = this.title.compareToIgnoreCase(other.title);
		if (titleCompare != 0) {
			return titleCompare;
		} else {
			return Float.compare((float) this.cost, (float) other.cost);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true; // cùng tham chiếu
		if (obj == null) return false;
		if (!(obj instanceof Media)) return false;

		Media other = (Media) obj;

		return this.title.equalsIgnoreCase(other.title) && this.cost == other.cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
