package be.intec.view;

import be.intec.data.Employee;
import be.intec.service.EmployeeService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class EmployeeView {
    private EmployeeService employeeService;

    public EmployeeView(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    public Optional<Employee> getEmployee(int id) {
        return employeeService.getEmployeeById(id);
    }

    public BigDecimal calculateSalary() {   // BigDecimal is slower than Float(/Double) but preciser
        return null;
    }
}
