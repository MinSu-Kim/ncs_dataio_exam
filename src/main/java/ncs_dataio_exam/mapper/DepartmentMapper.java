package ncs_dataio_exam.mapper;

import java.util.List;

import ncs_dataio_exam.dto.Department;

public interface DepartmentMapper {
    int deleteDepartment(Department department);
    int insertDepartment(Department department);
    int updateDepartment(Department department);
    List<Department> selectDepartmentByAll();
    Department selectDepartmentByNo(Department department);
}
