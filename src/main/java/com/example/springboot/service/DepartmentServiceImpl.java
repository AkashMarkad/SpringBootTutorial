package com.example.springboot.service;

import com.example.springboot.entity.Department;
import com.example.springboot.error.DepartmentNotFoundException;
import com.example.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

        Department dept = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            dept.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            dept.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            dept.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(dept);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {

//        return departmentRepository.findByDepartmentName(departmentName);
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
