package com.eng.anglo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eng.anglo.entity.Student;
import com.eng.anglo.service.StudentService;

@RestController
@RequestMapping("/wadiacollege")
public class StudentController {

	@Autowired
	StudentService studService;

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studService.addStudent(student);
	}
	
	@GetMapping("/getStudentByRno/{rno}")
	public Student getStudentByRno(@PathVariable("rno")int rno) {
		return studService.getStudentByRno(rno);
	}
	
	@GetMapping("/getStudentByDno/{dno}")
	public List<Student> getStudentByDno(@PathVariable("dno")int dno){
		return studService.getStudentByDno(dno);
	}
}
