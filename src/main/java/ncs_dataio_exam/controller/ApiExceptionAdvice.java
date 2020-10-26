package ncs_dataio_exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ncs_dataio_exam.exception.EmployeeNotFoundException;
import ncs_dataio_exam.exception.ErrorResponse;

@RestControllerAdvice("ncs_dataio_exam.controller")
public class ApiExceptionAdvice {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoData(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no employee"));
    }

}
