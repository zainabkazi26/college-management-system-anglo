package com.eng.anglo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eng.anglo.entity.Student;
import com.eng.anglo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studRepo;
	public Student addStudent(Student student) {
		return studRepo.save(student);
	}
	public Student getStudentByRno(int rno) {	
		return studRepo.findById(rno).get();
	}
	public List<Student> getStudentByDno(int dno) {
		return studRepo.findByDno(dno);
	}

}
