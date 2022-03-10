package be.intec;

import be.intec.dao.ConnectionManager;
import be.intec.model.Employee;

public class Main {
    public static void main(String[] args) {
        try {
            ConnectionManager.getInstance().init();

            Employee employee = new Employee().setName("John").setFamilyName("Dogh");

            ConnectionManager.getInstance().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
