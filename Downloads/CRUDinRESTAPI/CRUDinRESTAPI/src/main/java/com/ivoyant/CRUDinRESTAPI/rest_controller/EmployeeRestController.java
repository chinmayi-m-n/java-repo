package com.ivoyant.CRUDinRESTAPI.rest_controller;

import com.ivoyant.CRUDinRESTAPI.exception.EmployeeNotFoundException;
import com.ivoyant.CRUDinRESTAPI.exception.RequestBodyShouldNotHavePrimaryKey;
import com.ivoyant.CRUDinRESTAPI.model.Employee;
import com.ivoyant.CRUDinRESTAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeRestController {
    //handle the "get" request to fetch all employee details and return
    @Autowired
    EmployeeService service;
    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        //fetch all the employee objects using the method provided by service layer
        List<Employee> lst=service.getAll();
        return lst;
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee emp=service.getById(id);
        if(emp==null){
            //this custom exception throwed is catched by method inside @ControlleAdvice class
            throw new EmployeeNotFoundException("employee of id - "+id+"  doesnot exist");
        }
        else{
            return emp;
        }
    }



    //handle "post "request to add employee
    @PostMapping("/employee")
    public ResponseEntity<String>  addEmp(@RequestBody Employee emp){
        //id should not be passed in request body
        //JSON data provided in request body is mapped to employee object
        if(emp.getId()!=0){//default value for id is 0 if it is not 0 in emp object => user has specified id in request body
            //user has specified id in request body
            throw new RequestBodyShouldNotHavePrimaryKey("Request body should not contain primary key like id");
        }
          return service.add(emp);
    }



    //handle "put" request to update an employee
    //update existing employee get id which is passed as a path variable
    //if employee is not found for given id throw employeenotfoundexception
    @PutMapping("/employee/{id}")
    public Employee updateEmp(@RequestBody Employee emp,@PathVariable int id){
        if(emp.getId()!=0){//default value for id is 0 if it is not 0 in emp object => user has specified id in request body
            //user has specified id in request body
            throw new RequestBodyShouldNotHavePrimaryKey("Request body should not contain primary key like id");
        }
        Employee newEmp=service.update(id,emp);
        if(newEmp==null)throw new EmployeeNotFoundException("Employee for id "+id+" not found");
        return newEmp;
    }

    //handle "patch" request to update some fields of existing employee by id

    @PatchMapping("/employee/{id}")
    public Employee patch(@PathVariable int id, @RequestBody Map<String,Object> map){
        Employee updatedEmp=service.patchUpdate(id,map);
        if(map.containsKey("id"))throw new RequestBodyShouldNotHavePrimaryKey("request body should not contain primary key");
        if(updatedEmp==null)throw new EmployeeNotFoundException("employee with id "+id+" not found");
        return updatedEmp;
    }

    //delete an employee by id
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String>  deletebyId(@PathVariable int id){
         return service.deleteById(id);

    }
    @DeleteMapping("employee/deleteAll")
    public ResponseEntity<String>  deleteall(){
        return service.deleteAll();

    }






}
