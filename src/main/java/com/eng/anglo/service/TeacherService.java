package com.eng.anglo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eng.anglo.entity.Teacher;
import com.eng.anglo.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	public Teacher addTeacher(Teacher t1) {

		return teacherRepository.save(t1);

	}

	public List<Teacher> getAllTeachers() {

		return teacherRepository.findAll();
	}

	public Teacher getTeacherById(int teacherNumber) {
		return teacherRepository.findById(teacherNumber).get();
	}

	public Teacher getTeacherByPathVarible(int teacherNumber) {
		// TODO Auto-generated method stub
		return teacherRepository.findById(teacherNumber).get();
	}

	public List<Teacher> getTeacherByTage(int age) {
		return teacherRepository.findByTageLessThan(age);
	}

	public List<Teacher> getTeacherByRange(int sage, int eage) {

		return teacherRepository.findByTageBetween(sage, eage);
	}

	public List<Teacher> getTeacherByCustomData() {
		
		return teacherRepository.findByCustomizedAgeAndSal();
	}

	public List<Teacher> getTeacherByCustomAgeAndSalParameterized(int sage, double sal) {
	
		return teacherRepository.findByCustomizedAgeAndSalParameterized(sage, sal);
	}

	public void deleteTeacherByTno(int tno) {
	 teacherRepository.deleteById(tno);
		
	}

	public Teacher updateTeacher(int tno, Teacher teacherFE) {
		Teacher teacherDb=teacherRepository.findById(tno).get();//teacherDb  3 Charles 41 8500
		teacherDb.setTname(teacherFE.getTname());
		teacherDb.setTage(teacherFE.getTage());
		teacherDb.setSal(teacherFE.getSal());
	return teacherRepository.save(teacherDb);
	}

	public Teacher updateTeacherName(int tno, String tname) {
		Teacher teacherDb=teacherRepository.findById(tno).get();
		teacherDb.setTname(tname);
		return  teacherRepository.save(teacherDb);
	}
	
	
	


}
