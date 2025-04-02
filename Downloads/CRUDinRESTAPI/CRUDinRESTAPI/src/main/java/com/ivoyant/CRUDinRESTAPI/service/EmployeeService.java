package com.ivoyant.CRUDinRESTAPI.service;

import com.ivoyant.CRUDinRESTAPI.model.Employee;
import com.ivoyant.CRUDinRESTAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class EmployeeService {
    //by autowiring employeeRepository bean to some reference we can refer to methods provided by JpaRepository to interact with DB
    @Autowired
    EmployeeRepository emp;
    public ResponseEntity<String> add(Employee e){
        emp.save(e);//method provided by Jpa Repository
        return new ResponseEntity<>("employee added successfully", HttpStatus.CREATED);
    }
    public Employee getById(int id){
        Optional<Employee> e=emp.findById(id);//method provided by Jpa Repository
        if(e.isPresent()){
            //if employee is present
            return e.get();//get that single employee in e
        }
        else{
            //employee by id is not present
            return null;
        }
    }
    public List<Employee> getAll(){
        List<Employee> al=emp.findAll();
        return al;
    }
    public ResponseEntity<String> deleteAll(){
        //deletes all employees in table
        emp.deleteAll();
        return new ResponseEntity<>("all employees data has been deleted..",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteById(int id){
        emp.deleteById(id);

        return new ResponseEntity<>("employee with id "+id+" deleted successfully...",HttpStatus.OK);
    }
    public void updateLastName(int id,String lastName){
        emp.updateLastNameById(id,lastName);
    }
    public void updateFirstName(int id,String firstName){
        emp.updateFirstNameById(id,firstName);
    }

    public Employee update(int id,Employee e) {
        //get the employee by id
        //manually set all properties of employee
        Employee updatedEmp=getById(id);
        if(updatedEmp==null)return null;
        updatedEmp.setFirstName(e.getFirstName());
        updatedEmp.setLastName(e.getLastName());
        updatedEmp.setEmail(e.getEmail());
        return emp.save(updatedEmp);
    }

    public Employee patchUpdate(int id, Map<String,Object> map) {
        //get the employee vth id
        Employee originalEmp=getById(id);
        if(originalEmp==null)return null;//exception is thrown by controller
        for(String s:map.keySet()){
            if(s.equals("firstName")){
                originalEmp.setFirstName((String)map.get(s));
            }
            else if(s.equals("lastName")){
                originalEmp.setLastName((String)map.get(s));
            }
            else if(s.equals("email")){
                originalEmp.setEmail((String)map.get(s));
            }
        }
        emp.save(originalEmp);
        return originalEmp;


    }
}
