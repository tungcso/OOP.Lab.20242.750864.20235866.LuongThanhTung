package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
		
	    
	    private List<String> authors = new ArrayList<>();

	  

	    public List<String> getAuthors() {
	        return authors;
	    }
	    public void addAuthor(String authorName) {
	        if (!authors.contains(authorName)) {
	            authors.add(authorName);
	        }
	    }

	    public void removeAuthor(String authorName) {
	        if (authors.contains(authorName)) {
	            authors.remove(authorName);
	        }
	    }
	    public Book(int id, String title, String category, float cost) {
	    	super();
	       this.setId(id);
	        super.setTitle(title);
	        this.category = category;
	        this.cost = cost;
	    }
	    public Book( String title, String category, float cost) {
	    	super();
	       
	        super.setTitle(title);
	        this.category = category;
	        this.cost = cost;
	    }
	    @Override
	    public String toString() {
	        return String.format("%d. Book - %-20s - %-15s - $%.2f - Authors: %s",
	                this.getId(), this.getTitle(), this.getCategory(), this.getCost(), this.authors);
	    }
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

}
