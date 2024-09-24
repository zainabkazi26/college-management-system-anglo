package com.eng.anglo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Data
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rno;
	private String sname;
	private int age;
	private String email;
	private int dno;
	
	
	
}