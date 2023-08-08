package com.example.springboot.repository;

import com.example.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


    public Department findByDepartmentName(String departmentName);

//    @Query(value = "" , nativeQuery = true)   // ?1 for dynamic value
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
