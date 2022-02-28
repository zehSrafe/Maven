package be.intec;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public ConnectionManager() {
        createConnection();
    }

    public void createConnection() {
        try {
            // make connection to database using these.
            connection = DriverManager.getConnection("jdbc:mysql://moktok.intecbrussel.org:33061/beers", "loic", "loic2021");
            // satement will be used to send querries to db
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getBeers() {
        try {
            // executes a SQL querry and saves it to a resultset
            ResultSet result = statement.executeQuery("SELECT * FROM Beers WHERE Id < 100");

            // print returned table from sql querry
            List<Beer> beers = new ArrayList<>();
            while (result.next()) {
                Beer beer = new Beer(result.getInt("Id"), result.getString("Name"), result.getInt("BrewerId"),
                        result.getInt("CategoryId"), result.getDouble("Price"), result.getInt("Stock"
                ), result.getDouble("Alcohol"), result.getInt("Version"), result.getString("Image"));
                beers.add(beer);
            }
            beers.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getCategories() {
        try {
            // executes a SQL querry and saves it to a resultset
            ResultSet result = statement.executeQuery("SELECT * FROM Categories");

            // print returned table from sql querry
            List<BeerCategory> categories = new ArrayList<>();
            while (result.next()) {
                BeerCategory category = new BeerCategory(result.getInt("Id"), result.getString("Category"));
                categories.add(category);
            }
            categories.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getBrewers() {
        try {
            // executes a SQL querry and saves it to a resultset
            ResultSet result = statement.executeQuery("SELECT * FROM Brewers");

            // print returned table from sql querry
            List<BeerBrewer> brewers = new ArrayList<>();
            while (result.next()) {
                BeerBrewer brewer = new BeerBrewer(result.getInt("Id"), result.getString("Name"), result.getString("Address"),
                        result.getString("ZipCode"), result.getString("City"), result.getInt("Turnover"));
                brewers.add(brewer);
            }
            brewers.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCategoryTables(String categoryName) {
        try {
            int updateResult = statement.executeUpdate("INSERT INTO Categories(Category) VALUES ('" + categoryName + "')");
            String successState = updateResult == 1 ? "Insert successful" : "Insert failed";
            System.out.println("Update with code " + updateResult + ". " + successState);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBrewerTables(String brewerName) {
        try {
            int updateResult = statement.executeUpdate("INSERT INTO Brewers(Name) VALUES ('" + brewerName + "')");
            String successState = updateResult == 1 ? "Insert successful" : "Insert failed";
            System.out.println("Update with code " + updateResult + ". " + successState);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBeerTables(String beer) {
        try {
            int updateResult = statement.executeUpdate("INSERT INTO Beers(Name) VALUES ('" + beer + "')");
            String successState = updateResult == 1 ? "Insert successful" : "Insert failed";
            System.out.println("Update with code " + updateResult + ". " + successState);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBrewer(String brewerName) {
        try {
            int updateResult = statement.executeUpdate("UPDATE Brewers SET Address = 'Die ene straat', " +
                    "Zipcode = '1000', City = 'Bxl', Turnover = 69 WHERE Name = '" + brewerName + "'");
            String successState = updateResult == 1 ? "Update successful" : "Update failed";
            System.out.println("Update with code " + updateResult + ". " + successState);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Prepared statement comes in handy to protect against SQL injection
    public void preparedStatementBrewerInsert(String brewerName) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Brewers(Name, Address, Zipcode, City, Turnover) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, brewerName);
            preparedStatement.setString(2, "Street street");
            preparedStatement.setString(3, "9872");
            preparedStatement.setString(4, "BXLZoo");
            preparedStatement.setInt(5, 999);
            int updateResult = preparedStatement.executeUpdate();
            String successState = updateResult == 1 ? "Update successful" : "Update failed";
            System.out.println("Update with code " + updateResult + ". " + successState);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
