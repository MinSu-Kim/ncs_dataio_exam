package ncs_dataio_exam.mapper;

import java.util.List;

import ncs_dataio_exam.dto.Employee;

public interface EmployeeMapper {
    List<Employee> selectEmployeeAll();
    Employee selectEmployeeByNo(int empNo);
    int insertEmployee(Employee employee);
    int deleteEmployee(Employee employee);
    int updateEmployee(Employee employee);
}   
