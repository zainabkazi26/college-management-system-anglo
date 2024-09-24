package com.eng.anglo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eng.anglo.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public List<Student> findByDno(int dno);
}
