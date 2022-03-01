package be.intec;

import be.intec.data.ConnectionManager;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try {
            ConnectionManager.getInstance().init();
            Connection connection = ConnectionManager.getInstance().getConnection();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
