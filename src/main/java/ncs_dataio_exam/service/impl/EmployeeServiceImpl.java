package ncs_dataio_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import ncs_dataio_exam.dto.Employee;
import ncs_dataio_exam.exception.DuplicateEmployeeException;
import ncs_dataio_exam.mapper.EmployeeMapper;
import ncs_dataio_exam.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeMapper mapper;
    
    @Override
    public List<Employee> getLists() {
        return mapper.selectEmployeeAll();
    }

    @Override
    public Employee getEmployee(int empNo) {
        return mapper.selectEmployeeByNo(empNo);
    }

    @Override
    public int registerEmployee(Employee employee) {
        int res = -1;
        Employee emp = null;
        try {
            emp = mapper.selectEmployeeByNo(employee.getEmpNo());
            if (emp != null) {
                throw new DuplicateEmployeeException("dup empNo " + employee.getEmpNo());
            }
        }finally {
            res = mapper.insertEmployee(employee);
        }
        
        return res;
    }

    @Override
    public int modifyEmployee(Employee employee) {
        return mapper.updateEmployee(employee);
    }

    @Override
    public int removeEmployee(Employee employee) {
        return mapper.deleteEmployee(employee);
    }

}
