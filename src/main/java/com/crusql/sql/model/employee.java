package com.crusql.sql.model;

//important imports (note : javax is depricated , hence we are using jakarta)
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;

    //get id.
    public Integer getId(){
        return id;
    }

    //set id.
    public void setId(Integer id){
        this.id = id;
    }

    //get name.
    public String getName(){
        return name;
    }

    //set name.
    public void setName(String name){
        this.name = name;
    }
}

