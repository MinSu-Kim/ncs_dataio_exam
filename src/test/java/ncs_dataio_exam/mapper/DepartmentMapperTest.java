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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentMapperTest {
    protected static final Log log = LogFactory.getLog(DepartmentMapperTest.class);
    
    @After
    public void tearDown() throws Exception {
        System.out.println();
    }
    
    @Autowired
    private DepartmentMapper mapper;

    @Test
    public void test01SelectDepartmentByAll() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        List<Department> list = mapper.selectDepartmentByAll();
        Assert.assertNotNull(list);
        list.forEach(dept->log.debug(dept.toString()));
    }
    
    @Test
    public void test02InsertDepartment() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Department department = new Department(5, "마케팅", 10);
        int res = mapper.insertDepartment(department);
        Assert.assertEquals(1, res);
    }
    
    @Test
    public void test03UpdateDepartment() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

        Department department = new Department(5, "마케팅2", 30);
        int res = mapper.updateDepartment(department);
        Assert.assertEquals(1, res);
    }
    
    @Test
    public void test04SelectDepartmentByNo() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Department department = mapper.selectDepartmentByNo(new Department(5));
        Assert.assertNotNull(department);
        log.debug(department.toString());
    }
    
    @Test
    public void test05DeleteDepartment() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

        Department department = new Department(5, "마케팅2", 30);
        int res = mapper.deleteDepartment(department);
        Assert.assertEquals(1, res);
    }


}
