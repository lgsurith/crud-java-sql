package com.crusql.sql.model;

//important imports (note : javax is depricated , hence we are using jakarta)
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "employee_table")
public class Employee {

    //id = primary key and is auto generated.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String contact;
    private Date DOB;


    //get id.
    public Integer getId(){
        return id;
    }

    //set id.
    public void setId(Integer id){
        this.id = id;
    }
    
    //get employee id.
    public String getEmployeeId() {
        return employeeId;
    }

    //set employee id.
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    //get first name.
    public String getFirstName() {
        return firstName;
    }

    //set first name.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //get last name.
    public String getLastName() {
        return lastName;
    }

    // set last name.
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //get gender.
    public String getGender() {
        return gender;
    }

    //set gender.
    public void setGender(String gender){
        this.gender = gender;
    }

    //get age.
    public Integer getAge() {
        return age;
    }

    //set age.
    public void setAge(Integer age){
        this.age = age;
    }

    //get contact.
    public String getContact() {
        return contact;
    }

    //set contact.
    public void setContact(String contact){
        this.contact = contact;
    }

    //get DOB.
    public Date getDOB() {
        return DOB;
    }

    //set DOB.
    public void setDOB(Date DOB){
        this.DOB = DOB;
    }
}