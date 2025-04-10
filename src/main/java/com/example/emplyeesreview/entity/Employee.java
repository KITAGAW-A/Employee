package com.example.emplyeesreview.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String gender;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	private String hobby;
	private String department;
	private String position;
	
	@Column(name = "employment_type")
	private String employmentType;
	
	private String photoUrl;
}
