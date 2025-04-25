package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.playable.Playable;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }    // Constructor using super() if possible
    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
        super(title, category, cost, length, director); // Adjust ID generation in superclass
        this.artist = artist;
    }

    // Default constructor
    public CompactDisc() {
        super();
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" added to the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" removed from the CD.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" not found in the CD.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        if (!this.tracks.isEmpty()) {
            System.out.println("Tracks:");
            for (Track track : this.tracks) {
                track.play(); // Call the play() method of each Track
            }
            System.out.println("Total length: " + this.getLength());
        } else {
            System.out.println("No tracks on this CD.");
        }
       
    }
    @Override
    public String toString() {
        return String.format("%d. DVD - %-15s - %-15s - %-15s - %-5d: $%.2f",
                this.getId(), this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
    }
}