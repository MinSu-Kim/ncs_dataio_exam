package ncs_dataio_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ncs_dataio_exam.dto.Employee;
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

}
