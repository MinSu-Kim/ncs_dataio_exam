package ncs_dataio_exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ncs_dataio_exam.dto.Employee;
import ncs_dataio_exam.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService empService;

    @GetMapping("/emplist")
    public ModelAndView emplist() {
        List<Employee> emplist = empService.getLists(); 
        ModelAndView mav = new ModelAndView();
        mav.addObject("emplist", emplist);
        mav.setViewName("/employee/employeeList");
        return mav;
    }
    
    @GetMapping("/employees")
    public List<Employee> employees(){
        return empService.getLists();
    }
}
