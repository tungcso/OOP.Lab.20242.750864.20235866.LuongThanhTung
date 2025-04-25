package hust.soict.hedpsi.aims.disc;

public class DigitalVideoDisc {

	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;	
	private int id;
	private static int nbDigitalVideoDiscs = 0;

	
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		
		this.id = ++nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		
		this.title = title;
		this.category = category;
		
		this.director = "IDK";
		this.cost = cost;
		this.id = ++nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title) {
		this.category = "IDK";
		this.director = "IDK";
		this.cost = 0;
		this.title = title;
		this.id = ++nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = ++nbDigitalVideoDiscs;
	}
	
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
	public int getId() {
		return id;
	}
	@Override
    public String toString() {
		
        return String.format("%d. DVD - %-15s - %-15s - %-15s - %-5s: $%.2f",id,title,category,director,length,cost);
    }
	public boolean isMatch(String searchedTitle) {
		return title.equals(searchedTitle);
	}
}
