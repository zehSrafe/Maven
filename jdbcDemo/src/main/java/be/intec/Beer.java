package be.intec;

public class Beer {
    private int id;
    private String name;
    private int brewerId;
    private int CategoryId;
    private double price;
    private int stock;
    private double Alcohol;
    private int version;
    private String image;

    public Beer(int id, String name, int brewerId, int categoryId, double price, int stock, double alcohol, int version, String image) {
        this.id = id;
        this.name = name;
        this.brewerId = brewerId;
        CategoryId = categoryId;
        this.price = price;
        this.stock = stock;
        Alcohol = alcohol;
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
        return CategoryId;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public double getAlcohol() {
        return Alcohol;
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
                ", CategoryId=" + CategoryId +
                ", price=" + price +
                ", stock=" + stock +
                ", Alcohol=" + Alcohol +
                ", version=" + version +
                ", image='" + image + '\'' +
                '}';
    }
}
