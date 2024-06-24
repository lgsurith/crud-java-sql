package com.crusql.sql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


    @PostMapping("/add")
    Employee addEmployee(@RequestBody Employee employee){
        employerepo.save(employee);
        return employee;
    }
    
    @GetMapping("/getall")
    List<Employee> getEmployee(){
        List<Employee> employee = employerepo.findAll();
        return employee;
    }

    //delete by id
    @DeleteMapping("/delete")
    String deleteEmployee(@RequestParam Integer id){
        if(employerepo.existsById(id)){
            employerepo.deleteById(id);
            return "Employee's Data Deleted Successfully";
        }
        else{
            return "Employee Not Found";
        }
    }
}
