package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
		
	 private static int nextId = 1; // bien de co the tu dong tang id moi khi 1 object media duoc tao
	private int id;
    private String title;
    protected String category;
    protected float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public Media(String title, String category, float cost) {
        this(); // Call the no-arg constructor to get the auto-incremented ID
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public Media(String title, String category, float cost, int id) {
        this.id = id; // Allow setting a specific ID if needed (use with caution)
        this.title = title;
        this.category = category;
        this.cost = cost;
        if (id >= nextId) {
            nextId = id + 1; // Update nextId if a larger ID is provided
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

	
	
	
    public Media() {
        this.id = nextId++;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media other = (Media) obj;
        return title != null ? title.equals(other.title) : other.title == null;
    }

}
