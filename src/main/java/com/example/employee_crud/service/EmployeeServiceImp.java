package com.example.employee_crud.service;

import com.example.employee_crud.dao.EmployeeDAO;
import com.example.employee_crud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDao;

    @Override
    public int save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public int update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public int deleteById(int id) {
        return employeeDao.deleteById(id);
    }
}
