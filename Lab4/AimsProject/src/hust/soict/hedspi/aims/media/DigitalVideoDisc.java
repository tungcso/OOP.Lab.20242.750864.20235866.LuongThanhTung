package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.playable.Playable;

public class DigitalVideoDisc extends Disc implements Playable {

	public DigitalVideoDisc(String title, String category, String director, float cost) {

		super(title, category, cost, 0, director);
	}

	public DigitalVideoDisc(String title, String category, float cost) {

		super(title, category, cost, 0, "IDK");
	}

	public DigitalVideoDisc(String title) {
		super(title, "IDK", 0.0f, 0, "IDK");
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {

		super(title, category, cost, length, director);

	}

	@Override
	public String toString() {
		return String.format("%d. DVD - %-15s - %-15s - %-15s - %-5d: $%.2f", this.getId(), this.getTitle(),
				this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
	}

	public boolean isMatch(String searchedTitle) {
		return this.getTitle().equals(searchedTitle);
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		if (this.getLength() > 0) {
			System.out.println("DVD length: " + this.getLength());
		}
		if (this.getDirector() != null && !this.getDirector().isEmpty()) {
			System.out.println("Director: " + this.getDirector());
		}
	}

}
