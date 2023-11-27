package com.ses11.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ses11.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);
}
