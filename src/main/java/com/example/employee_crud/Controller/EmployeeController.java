package com.example.employee_crud.Controller;



import com.example.employee_crud.model.Employee;
import com.example.employee_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public int save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping
    public int update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id) {
        return employeeService.deleteById(id);
    }
}
