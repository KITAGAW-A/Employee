package com.example.emplyeesreview.entity;

import lombok.Data;

@Data
public class Employee {

	private Long id;
	private String name;
	private String gender;
	private String hobby;
	private String department;
	private String position;
	private String photoUrl;
}
