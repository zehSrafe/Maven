package be.intec;

public class Main {
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();


        System.out.println("Beers");
        System.out.println("--------------------------------------------------------------");
        System.out.println("");
        connectionManager.getBeers();
        System.out.println("");
        System.out.println("Categories");
        System.out.println("--------------------------------------------------------------");
        System.out.println("");
        connectionManager.getCategories();
        System.out.println("");
        System.out.println("Brewers");
        System.out.println("--------------------------------------------------------------");
        System.out.println("");
        connectionManager.getBrewers();
    }
}
