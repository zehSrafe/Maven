package be.intec.service;

import be.intec.dao.EmployeeDAO;
import be.intec.model.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        return null;
    }
}
