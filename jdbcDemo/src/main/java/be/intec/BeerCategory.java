package be.intec;

public class BeerCategory {
    private int id;
    private String category;

    public BeerCategory(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "BeerCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
