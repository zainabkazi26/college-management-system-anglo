package com.eng.anglo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eng.anglo.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
}
