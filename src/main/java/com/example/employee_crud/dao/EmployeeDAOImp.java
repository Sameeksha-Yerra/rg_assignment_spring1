package com.example.employee_crud.dao;

import com.example.employee_crud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update(
                "INSERT INTO employees (name, department) VALUES (?, ?)",
                employee.getName(), employee.getDepartment());
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update(
                "UPDATE employees SET name=?, department=? WHERE id=?",
                employee.getName(), employee.getDepartment(), employee.getId());
    }

    @Override
    public Employee findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM employees WHERE id=?",
                new Object[]{id},
                (rs, rowNum) ->
                        new Employee(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("department")
                        )
        );
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM employees",
                (rs, rowNum) ->
                        new Employee(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("department")
                        )
        );
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(
                "DELETE FROM employees WHERE id=?", id);
    }
}
