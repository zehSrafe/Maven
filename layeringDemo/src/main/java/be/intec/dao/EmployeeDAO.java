package be.intec.dao;

import be.intec.data.Employee;
import be.intec.exception.NonUniqueResultException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO {
    private Connection connection;

    private EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Employee> getAllEmployeesFromDB() {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees");

        List<Employee> result = new ArrayList<>();
        while (resultSet.next()) {
            Employee employee = new Employee();
            result.add(employee);
        }
        return result;
    }

    public Optional<Employee> getEmployeeById(int id) {
        connection = DriverManager.getConnection("", "", "");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Employees WHERE Id = ?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) throw new NonUniqueResultException("Given ID is not unique.");

        return Optional.empty();
    }
}
