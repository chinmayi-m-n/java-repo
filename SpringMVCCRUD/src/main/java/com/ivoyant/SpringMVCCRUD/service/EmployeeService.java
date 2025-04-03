package com.ivoyant.SpringMVCCRUD.service;

import com.ivoyant.SpringMVCCRUD.Entity.Employee;
import com.ivoyant.SpringMVCCRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    //service interacts with repository and controller
    @Autowired
    EmployeeRepository repository;

    //create
    public void add(Employee e){
        //this employee object is to be saved in Employee table
        repository.create(e);
    }
    //read
    public List<Employee> getAllEmployees(){
        return repository.readAll();
    }

    //update
    public void updateEmp(int id,String firstName,String lastName,String email){
        repository.update(id,firstName,lastName,email);
    }
    //delete
    public void deleteEmp(int id){
        repository.delete(id);
    }

}
