package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.playable.Playable;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Length: " + this.getLength());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track other = (Track) obj;
        return length == other.length &&
               (title != null ? title.equals(other.title) : other.title == null);
    }

}
