package ncs_dataio_exam.service;

import java.util.List;

import ncs_dataio_exam.dto.Employee;

public interface EmployeeService {
    List<Employee> getLists();
    Employee getEmployee(int empNo);
    int registerEmployee(Employee employee);
    int modifyEmployee(Employee employee);
    int removeEmployee(Employee employee);
}
