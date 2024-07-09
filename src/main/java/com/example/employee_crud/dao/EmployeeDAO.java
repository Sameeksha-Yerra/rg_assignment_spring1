package com.example.employee_crud.dao;
import com.example.employee_crud.model.Employee;
import java.util.List;
public interface EmployeeDAO {
    int save(Employee employee);
    int update(Employee employee);
    Employee findById(int id);
    List<Employee> findAll();
    int deleteById(int id);
}

