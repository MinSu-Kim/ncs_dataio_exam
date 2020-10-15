package ncs_dataio_exam.mapper;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ncs_dataio_exam.config.ContextRoot;
import ncs_dataio_exam.dto.Department;
import ncs_dataio_exam.dto.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeMapperTest {
    protected static final Log log = LogFactory.getLog(DepartmentMapperTest.class);
    
    @After
    public void tearDown() throws Exception {
        System.out.println();
    }
    
    @Autowired
    private EmployeeMapper mapper;
    
    @Test
    public void test1SelectEmployeeAll() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        List<Employee> list = mapper.selectEmployeeAll();
        Assert.assertNotNull(list);
        list.forEach(emp->log.debug(emp.toString()));
    }
    
    @Test
    public void test2SelectEmployeeByNo() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Employee employee = mapper.selectEmployeeByNo(4377);
        Assert.assertNotNull(employee);
        log.debug(employee.toString());
    }
    
    
    @Test
    public void test3InsertEmployee() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Employee employee = new Employee(9999, "이유영", "과장", new Employee(4377), 2000000, new Department(1));
        int res = mapper.insertEmployee(employee);
        Assert.assertEquals(1, res);
        mapper.selectEmployeeAll().forEach(emp->log.debug(emp.toString()));
    }

    @Test
    public void test3UpdateEmployee() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Employee findEmp = mapper.selectEmployeeByNo(9999);
        findEmp.setEmpName("박규영");
        findEmp.setTitle("대리");
        findEmp.setSalary(1500000);
        findEmp.setDept(new Department(2));
        int res = mapper.updateEmployee(findEmp);
        Assert.assertEquals(1, res);
        log.debug(mapper.selectEmployeeByNo(9999).toString());
    }


    @Test
    public void test5DeleteEmployee() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        int res = mapper.deleteEmployee(new Employee(9999));
        Assert.assertEquals(1, res);
        mapper.selectEmployeeAll().forEach(emp->log.debug(emp.toString()));
    }
}
