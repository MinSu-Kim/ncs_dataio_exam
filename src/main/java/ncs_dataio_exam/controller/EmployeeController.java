package ncs_dataio_exam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ncs_dataio_exam.dto.Employee;
import ncs_dataio_exam.exception.DuplicateEmployeeException;
import ncs_dataio_exam.exception.EmployeeNotFoundException;
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
        mav.setViewName("/employee/list");
        return mav;
    }
    
    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> employees(){
        return empService.getLists();
    }
    

    @GetMapping("/employees/{empNo}")
    public ModelAndView employee(@PathVariable int empNo, HttpServletResponse response, HttpSession session) throws IOException {
        Employee employee = empService.getEmployee(empNo);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        ModelAndView mav = new ModelAndView();
        session.setAttribute("employee", employee);
        mav.setViewName("/employee/read");
        return mav;
    }
   
    @PostMapping("/employees")
    public ResponseEntity<Object> newEmployee(@RequestBody Employee employee, HttpServletResponse response) throws IOException {
        try {
            empService.registerEmployee(employee);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (DuplicateEmployeeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
         
    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(empService.modifyEmployee(employee));
    }
    
    @GetMapping("/update")
    @ResponseBody
    public ModelAndView update(Employee employee, HttpSession session){
        employee = (Employee) session.getAttribute("employee");
        ModelAndView nav =new ModelAndView("/employee/update", "employee", employee);
        return nav;
    }
    
    @PostMapping("/delete")
    @ResponseBody
    public ResponseEntity<Object> deleteEmployee(@RequestParam(value="empNo") int empNo){
        return ResponseEntity.ok(empService.removeEmployee(new Employee(empNo)));
    }
    
}
