package com.eng.anglo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eng.anglo.entity.Principal;
import com.eng.anglo.entity.Teacher;
import com.eng.anglo.service.TeacherService;

@RestController
@RequestMapping("/wadiacollege")
public class AngloController {

	@Autowired
	TeacherService teacherService;

	@GetMapping("/greet")
	public String greet() {
		return "Welcome";
	}

	@GetMapping("/addition")
	public String add() {
		int n1 = 10;
		int n2 = 20;
		int n3 = n1 + n2;
		return "Addition = " + n3;
	}

	// taking inputfrom user
	// url="http://localhost:8080/wadiacollege/additionnew?n1=10&n2=20
	@GetMapping("/additionnew")
	public String addition(@RequestParam("n1") int n1, @RequestParam("n2") int n2) {
		int n3 = n1 + n2;
		return "Addition = " + n3;
	}

	@GetMapping("/subtraction")
	public String sub(@RequestParam("g1") int g1, @RequestParam("g2") int g2) {
		int g3 = g1 - g2;
		return "Subration = " + g3;
	}

	@GetMapping("/abc")
	public String abc() {
		return "Welcome to my first springboot application";
	}

	// create

	@PostMapping("/addTeacher")
	public Teacher addTeacher(@RequestParam("p1") String tname, @RequestParam("p2") int tage,
			@RequestParam("p3") double sal) {

		Teacher t1 = new Teacher();
		t1.setTname(tname);
		t1.setTage(tage);
		t1.setSal(sal);

		return teacherService.addTeacher(t1);
	}

	@PostMapping("/addTeacherbByRequestBody")
	public Teacher addTeacherbByRequestBody(@RequestBody Teacher t1) {
		return teacherService.addTeacher(t1);
	}

	@PostMapping("/addTeacherByPathVariable/{t1}/{t2}/{t3}")
	public Teacher addTeacherByPathVariable(@PathVariable("t1") String tname, @PathVariable("t2") int tage,
			@PathVariable("t3") double sal) {
		Teacher t1 = new Teacher();
		t1.setTname(tname);
		t1.setTage(tage);
		t1.setSal(sal);
		return teacherService.addTeacher(t1);
	}

	@PostMapping("/addTeacherBySinglePathVariable/{t1}")
	public Teacher addTeacherBySinglePathVariable(@PathVariable("t1") String tname) {
		Teacher t1 = new Teacher();
		t1.setTname(tname);
		t1.setTage(57);
		t1.setSal(1200);
		return teacherService.addTeacher(t1);
	}

	// read
	// getting all teachers object in json
	@GetMapping("/getAllTeachers")
	public ResponseEntity<List<Teacher>> getAllTeachers() {
		return new  ResponseEntity<List<Teacher>>(teacherService.getAllTeachers(),HttpStatus.OK);
	}

	// reading a specific row using reuqest param
	@GetMapping("/getTeacherById")
	public ResponseEntity<Teacher> getTeacherById(@RequestParam("tno") int teacherNumber) {
		return new  ResponseEntity<Teacher> (teacherService.getTeacherById(teacherNumber),HttpStatus.OK)	;
	}

	@GetMapping("/getTeacherByPathVarible/{tno}")
	public Teacher getTeacherByPathVarible(@PathVariable("tno") int teacherNumber) {
		return teacherService.getTeacherByPathVarible(teacherNumber);
	}

	// geting teacher by tname
	@GetMapping("/getTeacherByTage")
	public List<Teacher> getTeacherByTage(@RequestParam("t1") int age) {
		return teacherService.getTeacherByTage(age);
	}

	@GetMapping("/getTeacherByRange/{t1}/{t2}")
	public List<Teacher> getTeacherByRange(@PathVariable("t1") int sage, @PathVariable("t2") int eage) {
		return teacherService.getTeacherByRange(sage, eage);
	}

	@GetMapping("/getTeacherByCustomData")
	public List<Teacher> getTeacherByCustomData() {
		return teacherService.getTeacherByCustomData();
	}

	@GetMapping("/getTeacherByCustomAgeAndSalParameterized/{t1}/{t2}")
	public List<Teacher> getTeacherByCustomAgeAndSalParameterized(@PathVariable("t1") int sage,
			@PathVariable("t2") double sal) {
		return teacherService.getTeacherByCustomAgeAndSalParameterized(sage, sal);
	}

//	// delete
//	@DeleteMapping("/deleteTeacherByTno")
//	public DeleteResponse deleteTeacherByTno(@RequestParam("tno")int tno) {
//		DeleteResponse deleteResponse=new DeleteResponse();
//		try {
//		teacherService.deleteTeacherByTno(tno);
//		}
//		catch(Exception e){
//			return deleteResponse;
//		}
//		
//		deleteResponse.setStatus(true);
//		deleteResponse.setMessage("Record Deleted Successfully");
//		deleteResponse.setHttpStatusCode(HttpStatus.OK);
//		
//		return deleteResponse;	)
//	}

	// Update-->
	@PutMapping("/updateTeacher")
	public Teacher updateTeacher(@RequestParam("t1") int tno, @RequestBody Teacher teacher) {
		return teacherService.updateTeacher(tno, teacher);
	}

	@PutMapping("/updateTeacherName")
	public Teacher updateTeacherName(@RequestParam("t1") int tno, @RequestParam("t2") String tname) {
		return teacherService.updateTeacherName(tno, tname);
	}

	public void test() {
		Principal p1=Principal.builder().pname("Alice").build();
		Principal p2=Principal.builder().pname("Ben").page(40).build();
	}
}
