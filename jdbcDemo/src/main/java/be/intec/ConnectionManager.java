package be.intec;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {
    private Connection connection;
    private Statement statement;

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
            //updating, deleting, ... tables with below command
            //statement.executeUpdate();

            // print returned table from sql querry
            List<Beer> beers = new ArrayList<>();
            while (result.next()) {
                Beer category = new Beer(result.getInt("Id"), result.getString("Name"), result.getInt("BrewerId"),
                        result.getInt("CategoryId"), result.getDouble("Price"), result.getInt("Stock"
                ), result.getDouble("Alcohol"), result.getInt("Version"), result.getString("Image"));
                beers.add(category);
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
            //updating, deleting, ... tables with below command
            //statement.executeUpdate();

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
            ResultSet result = statement.executeQuery("SELECT * FROM Brewers WHERE Id < 100");
            //updating, deleting, ... tables with below command
            //statement.executeUpdate();

            // print returned table from sql querry
            List<BeerBrewer> categories = new ArrayList<>();
            while (result.next()) {
                BeerBrewer brewers = new BeerBrewer(result.getInt("Id"), result.getString("Name"), result.getString("Address"),
                        result.getString("ZipCode"), result.getString("City"), result.getInt("Turnover"));
                categories.add(brewers);
            }
            categories.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
