package com.crusql.sql.controller;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crusql.sql.model.Employee;
import com.crusql.sql.repository.employee_repo;


@RestController
@RequestMapping(value = "/employee")
public class employee_controller {

    @Autowired
    employee_repo employerepo;

    //testing if port works !
    @GetMapping("/test")
    public String test(){
        return "This Port Works !";
    }

    //adding details to the database.
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        employerepo.save(employee);
        return employee;
    }

    //to get all the users as well.
    @GetMapping("/getall")
    public List<Employee> getEmployee(){
        List<Employee> employee = employerepo.findAll();
        return employee;
    }

    //get a user by specifi employee id
    @GetMapping()
    public Employee getEmployeeById(@RequestParam Integer id){
        if(employerepo.existsById(id)){
            return employerepo.findById(id).get();
        }else{
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    //delete by id
    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestParam Integer id){
        if(employerepo.existsById(id)){
            employerepo.deleteById(id);
            return "Employee's Data Deleted Successfully";
        }
        else{
            return "Employee Not Found";
        }
    }

    //updating the details of the employee.
    //can query in specific details to update.
    @PutMapping("/update")
    public Employee updateEmployee(@RequestParam Integer id, 
                               @RequestParam(required = false) String employeeId,
                               @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String lastName,
                               @RequestParam(required = false) String gender,
                               @RequestParam(required = false) Integer age,
                               @RequestParam(required = false) String contact,
                               @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date DOB) {
    return employerepo.findById(id)
        .map(existingEmployee -> {
            if (employeeId != null) existingEmployee.setEmployeeId(employeeId);
            if (firstName != null) existingEmployee.setFirstName(firstName);
            if (lastName != null) existingEmployee.setLastName(lastName);
            if (gender != null) existingEmployee.setGender(gender);
            if (age != null) existingEmployee.setAge(age);
            if (contact != null) existingEmployee.setContact(contact);
            if (DOB != null) existingEmployee.setDOB(DOB);
            return employerepo.save(existingEmployee);
        })
        .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
}