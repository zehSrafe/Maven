package be.intec;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // make connection to database using these.
            Connection connection = DriverManager.getConnection("jdbc:mysql://moktok.intecbrussel.org:33061/beers", "loic", "loic2021");

            // satement will be used to send querries to db
            Statement statement = connection.createStatement();

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

            //brwers
            // beers (best to limit output to like 100)


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
