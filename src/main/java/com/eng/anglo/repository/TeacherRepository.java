package com.eng.anglo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eng.anglo.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
	public List<Teacher>findByTageLessThan(int x);
	

	public List<Teacher> findByTageBetween(int sage, int eage);
	
	//hard coded values are given
	@Query(value="select * from Teacher where sal>=10000 and tage<=50", nativeQuery=true )
	public List<Teacher> findByCustomizedAgeAndSal();
	
	//acceptingvaluesfrom user
		@Query(value="select * from Teacher where tage<=?1 and sal>=?2 ", nativeQuery=true )
		public List<Teacher> findByCustomizedAgeAndSalParameterized(int sage,double sal);
}
