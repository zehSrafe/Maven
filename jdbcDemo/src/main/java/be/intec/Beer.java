package be.intec;

public class Beer {
    private int id;
    private String name;
    private int brewerId;
    private int categoryId;
    private double price;
    private int stock;
    private double alcohol;
    private int version;
    private String image;

    public Beer(int id, String name, int brewerId, int categoryId, double price, int stock, double alcohol, int version, String image) {
        this.id = id;
        this.name = name;
        this.brewerId = brewerId;
        this.categoryId = categoryId;
        this.price = price;
        this.stock = stock;
        this.alcohol = alcohol;
        this.version = version;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBrewerId() {
        return brewerId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public int getVersion() {
        return version;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brewerId=" + brewerId +
                ", CategoryId=" + categoryId +
                ", price=" + price +
                ", stock=" + stock +
                ", Alcohol=" + alcohol +
                ", version=" + version +
                ", image='" + image + '\'' +
                '}';
    }
}
