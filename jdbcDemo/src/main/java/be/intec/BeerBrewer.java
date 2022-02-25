package be.intec;

public class BeerBrewer {
    private int id;
    private String name;
    private String address;
    private String zipcode;
    private String city;
    private int turnover;

    public BeerBrewer(int id, String name, String address, String zipcode, String city, int turnover) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.turnover = turnover;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public int getTurnover() {
        return turnover;
    }

    @Override
    public String toString() {
        return "BeerBrewer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", turnover=" + turnover +
                '}';
    }
}
