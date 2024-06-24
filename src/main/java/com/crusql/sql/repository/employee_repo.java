package com.crusql.sql.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crusql.sql.model.Employee;

public interface employee_repo extends JpaRepository<Employee,Integer> {

}
