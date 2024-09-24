package com.eng.anglo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eng.anglo.entity.Department;
import com.eng.anglo.repository.DepartmentRepository;
import com.eng.anglo.repository.DepartmentRepositoryCL;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository deptRepo;
	
	@Autowired
	DepartmentRepositoryCL deptRepoCL;

	public Department addDept(Department dept) {
		return deptRepo.save(dept);
		
	}

	public Department getDept(int dno) {
		
		return deptRepoCL.getDept(dno);
	}

	public List<Department> getAllDept() {
		return deptRepoCL.getAllDept();
	}



}
