package com.ivoyant.SpringMVCCRUD.controller;

import com.ivoyant.SpringMVCCRUD.Entity.Employee;
import com.ivoyant.SpringMVCCRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService service;


    //controller uses methods provided by service layer to interact with database

    @GetMapping("/employee/list")
    public String getAllEmployees(Model model){
        //this method vl request for employees list to service layer
        List<Employee> lst=service.getAllEmployees();
        //add this list to model as an attribute
        model.addAttribute("employees",lst);
        return "list-employees";
    }
    //this method is mapped return html form when user clicks on add employee button
    @GetMapping("/employee/add")
    public String addEmployee(){
        return "add-employee";
    }
    @PostMapping("/addEmployee")
    public String addEmp(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email, Model model){
        //create object of employee using extracted form values
        //pass that object to service layer to add
        Employee emp=new Employee();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setEmail(email);
        service.add(emp);
        List<Employee> lst=service.getAllEmployees();
        Collections.sort(lst);
        model.addAttribute("employees",lst);
        return "list-employees";
    }
    @GetMapping("/employee/update/{id}")
    public String update(@PathVariable int id,Model model){
        //return html form in which user enters updated  details
        model.addAttribute("id",id);
        return "update-employee";
    }
    @PostMapping("/updateEmployee/{id}")
    public String updateEmp(@PathVariable int id,@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email,Model model){
        //sends the request to service method to update employee of specified id
        service.updateEmp(id,firstName,lastName,email);
        //now the employee of id is updated
        //get list of all employees
        List<Employee> lst=service.getAllEmployees();
        //sort this list according to id
        //as after adding updated employee object , updated employee object gets added at bottom
        Collections.sort(lst);
        model.addAttribute("employees",lst);
        return "list-employees";
    }
    @GetMapping("/employee/delete/{id}")
    public String delete(@PathVariable int id,Model model){
        service.deleteEmp(id);
        //now employee of id is deleted fetch the updated list of employees
        List<Employee> lst=service.getAllEmployees();
        Collections.sort(lst);
        model.addAttribute("employees",lst);
        return "list-employees";
    }


}
