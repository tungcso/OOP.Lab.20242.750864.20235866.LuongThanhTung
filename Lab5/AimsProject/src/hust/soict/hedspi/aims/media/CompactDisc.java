package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private ArrayList<Track> tracks = new ArrayList<Track>();
	private String artist;
	public CompactDisc(String title, String category, double cost, int length, String director, String artist) {
        super(title, category, cost, length, director);
        this.artist = artist;
    }
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
            System.out.println("Track already exists in the list.");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been added to the CD.");
        }
	}

    public void removeTrack(Track track) {
    	 if (tracks.contains(track)) {
             tracks.remove(track);
         } else {
             System.out.println("Track not found in the list.");
         }
    }
    
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            for (Track track : tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    public String toString() {
        return getId() + " . CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }
	public String getArtist() {
		return artist;
	}
	@Override
	public int compareTo(Media other) {
	    if (other instanceof CompactDisc) {
	        CompactDisc cd = (CompactDisc) other;
	        int titleCompare = this.getTitle().compareToIgnoreCase(cd.getTitle());
	        if (titleCompare != 0) return titleCompare;
	        int artistCompare = this.getArtist().compareToIgnoreCase(cd.getArtist());
	        if (artistCompare != 0) return artistCompare;
	        return Double.compare(this.getCost(), cd.getCost());
	    }
	    return super.compareTo(other);
	}

}
