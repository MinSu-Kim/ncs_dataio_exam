package ncs_dataio_exam.dto;

import javax.validation.constraints.NotEmpty;

public class Employee {
    @NotEmpty
    private int empNo;
    @NotEmpty
    private String empName;
    @NotEmpty
    private String title;
    @NotEmpty
    private Employee manager;
    @NotEmpty
    private int salary;
    @NotEmpty
    private Department dept;

    public Employee() {
    }

    public Employee(int empNo) {
        this.empNo = empNo;
    }

    public Employee(int empNo, String empName, String title, Employee manager, int salary, Department dept) {
        this.empNo = empNo;
        this.empName = empName;
        this.title = title;
        this.manager = manager;
        this.salary = salary;
        this.dept = dept;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return String.format("Employee [empNo=%s, empName=%s, title=%s, manager=%s, salary=%s, dept=%s]", empNo,
                empName, title, manager==null?"":manager.getEmpNo(), salary, dept==null?"":dept.getDeptNo());
    }

}
