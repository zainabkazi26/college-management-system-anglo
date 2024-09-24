package com.eng.anglo.controller;

import java.util.List;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eng.anglo.entity.Department;
import com.eng.anglo.service.DepartmentService;
//Author Zainab Kazi
@RestController
@RequestMapping("/wadiacollege")
public class DepartmentController {
	@Autowired
	DepartmentService deptService;
	
	public static final Logger logger=Logger.getLogger(DepartmentController.class);

	@PostMapping("/addDept/{dname}")
	public Department addDept(@PathVariable("dname")String dname) {
		Department dept=new Department();
		dept.setDname(dname);
		logger.info("Department added by name "+dname);
		return deptService.addDept(dept);
	}
	
	@GetMapping("/getDept/{dno}")
	public Department getDept(@PathVariable("dno")int dno) {
	
		return deptService.getDept(dno);
	}
	
	@GetMapping("/getAllDept")
	public List<Department> getAllDept() {
	
		return deptService.getAllDept();
	}
}
