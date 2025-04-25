package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    // Constructor using super() if possible (assuming Media has a suitable constructor)
    public Disc(String title, String category, float cost, int length, String director) {
        super( title, category, cost); // You might need to adjust the ID generation
        this.length = length;
        this.director = director;
    }

    // Default constructor
    public Disc() {
        super();
    }
}