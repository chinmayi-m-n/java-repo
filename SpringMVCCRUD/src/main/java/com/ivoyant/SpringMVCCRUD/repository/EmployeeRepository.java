package com.ivoyant.SpringMVCCRUD.repository;

import com.ivoyant.SpringMVCCRUD.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

//use JDBC template
@Repository
public class EmployeeRepository {
    //has methods which perform querying on DB
    //at the time of application startup datasource bean is created and injected to jdbc template bean
    //we can autowire jdbc template bean to some refernce and use methods provided by it
    @Autowired
    JdbcTemplate jdbcTemplate;
    //create
    public void create(Employee e){
        //add employee e object to DB
        String firstName=e.getFirstName();
        String lastName=e.getLastName();
        String email=e.getEmail();
        String sql="insert into employee (first_name,last_name,email) values (?,?,?)";
        jdbcTemplate.update(sql,firstName,lastName,email);

    }
    //read
    public List<Employee> readAll(){
        String sql="select * from employee";
        //returns list of employee objects
        List<Employee> lst=jdbcTemplate.query(sql,new EmployeeRowMapper());
        return lst;
    }
    //update
    public void update(int id,String firstName,String lastName,String email){
        String sql="update employee set first_name=? , last_name=? , email=? where id=?";
        jdbcTemplate.update(sql,firstName,lastName,email,id);
    }
    //delete
    public void delete(int id){
        String sql="delete from employee where id=?";
        jdbcTemplate.update(sql,id);
    }



}
