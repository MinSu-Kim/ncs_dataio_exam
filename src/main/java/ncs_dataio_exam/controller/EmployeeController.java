package ncs_dataio_exam.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
//        mav.addObject("employee", employee);
        session.setAttribute("employee", employee);
        mav.setViewName("/employee/read");
        return mav;
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> newEmployee(@Valid @RequestBody Employee employee, Errors errors, HttpServletResponse response) throws IOException {
        try {
            if (errors.hasErrors()) {
                return ResponseEntity.badRequest().build();
            }
            int newEmpNo = empService.registerEmployee(employee);
            URI uri = URI.create("/employees/" + newEmpNo);
            return ResponseEntity.created(uri).build();

        }catch (DuplicateEmployeeException e) {
            errors.rejectValue("empNo", "duplicate");
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    
    @PatchMapping(value = "/employees/{empNo}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable("empNo") int empNo){
        return ResponseEntity.ok(empService.modifyEmployee(employee));
    }
    
    @DeleteMapping(value = "/employees/{empNo}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable int empNo){
        return ResponseEntity.ok(empService.removeEmployee(new Employee(empNo)));
    }
    
}
