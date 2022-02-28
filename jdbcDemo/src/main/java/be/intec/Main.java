package be.intec;

public class Main {
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();


//        System.out.println("Beers");
//        System.out.println("--------------------------------------------------------------");
//        System.out.println("");
//        connectionManager.getBeers();
//        System.out.println("");
//        System.out.println("Categories");
//        System.out.println("--------------------------------------------------------------");
//        System.out.println("");
//        connectionManager.getCategories();
//        System.out.println("");
//        System.out.println("Brewers");
//        System.out.println("--------------------------------------------------------------");
//        System.out.println("");
//        connectionManager.getBrewers();
//        System.out.println("");
//        System.out.println("Category insert");
//        System.out.println("--------------------------------------------------------------");
//        System.out.println("");


//        connectionManager.insertCategoryTables("Very strong pils");
//        connectionManager.insertBrewerTables("Loïc");
//        connectionManager.updateBrewer("Loïc");
//        connectionManager.preparedStatementBrewerInsert("Loïc_V2");

        System.out.println("Brewers");
        System.out.println("--------------------------------------------------------------");
        System.out.println("");
        connectionManager.getBrewers();
    }
}
