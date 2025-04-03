package com.ivoyant.SpringMVCCRUD.repository;

import com.ivoyant.SpringMVCCRUD.Entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee e=new Employee();
        e.setId(rs.getInt("id"));
       e.setFirstName(rs.getString("first_name"));
       e.setLastName(rs.getString("last_name"));
       e.setEmail(rs.getString("email"));
       return e;
    }
}
