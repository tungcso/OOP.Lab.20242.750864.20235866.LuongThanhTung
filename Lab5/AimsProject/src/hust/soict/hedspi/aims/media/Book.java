package hust.soict.hedspi.aims.media;
import java.util.ArrayList;


public class Book extends Media implements Comparable<Media>{
	public Book(String title, String category, double cost) {
		super(title, category, cost,"Book");
	}
	private ArrayList<String> authors = new ArrayList<String>();
		public void addAuthor(String authorName) {
		    if (!authors.contains(authorName)) {
		        authors.add(authorName);
		        System.out.println("Author \"" + authorName + "\" has been added.");
		    } else {
		        System.out.println("This author has already existed.");
		    }
		}
		public void removeAuthor(String authorName) {
		    if (authors.contains(authorName)) {
		        authors.remove(authorName);
		        System.out.println("Author \"" + authorName + "\" has been removed.");
		    } else {
		        System.out.println("cannot find this author.");
		    }
		}
		public String toString() {
		    return getId() + " . Book - " + getTitle() + " - " + getCategory() + ": " + getCost() + " $";
		}
		@Override
		public int compareTo(Media other) {
		    if (other instanceof Book) {
		        Book book = (Book) other;
		        int titleCompare = this.getTitle().compareToIgnoreCase(book.getTitle());
		        if (titleCompare != 0) return titleCompare;
		        return Double.compare(this.getCost(), book.getCost()); 
		    }
		    return this.getTitle().compareToIgnoreCase(other.getTitle());
		}


}
