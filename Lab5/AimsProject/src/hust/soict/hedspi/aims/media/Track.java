package hust.soict.hedspi.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private int length;

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	@Override
	public void play() throws PlayerException {
		if (this.length > 0) {
			System.out.println("Playing track: " + this.title);
			System.out.println("Track length: " + this.length);
		} else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
	}
	
	public int getLength() {
		return length;
	}

	public String getTitle() {
		return title;
	}
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;

	    Track track = (Track) o;
	    return this.length == track.length &&
	    		(this.title != null ? this.title.equalsIgnoreCase(track.title) : track.title == null);
	}
}
