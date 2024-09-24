package com.eng.anglo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eng.anglo.entity.Department;
import com.eng.anglo.entity.Student;
import com.eng.anglo.util.DepartmentMapper;

@Repository
public class DepartmentRepositoryCL {
	//firing our own query
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	StudentRepository studRepo;
	
	public Department getDept(int dno) {
		String query="select *  from Department where dno=?";
		//mapping of data in the resultset to the Entity object	-->Row mapper
															//the class which is made for doing mapping object,argurment
		Department dept=jdbcTemplate.queryForObject(query, new DepartmentMapper(),dno);//will return an object
		List<Student> studList=studRepo.findByDno(dno);
		dept.setStudents(studList);
		return dept;
	}

	public List<Department> getAllDept() {
		String query="select *  from Department ";
		//mapping of data in the resultset to the Entity object	-->Row mapper
															//the class which is made for doing mapping object	
		List<Department> deptList=jdbcTemplate.query(query, new DepartmentMapper());//will return an object
		for(int i=0;i<deptList.size();i++)
		{
		List<Student> studList=studRepo.findByDno(deptList.get(i).getDno());
		deptList.get(i).setStudents(studList);
	}
		return deptList;
	}

	

}
