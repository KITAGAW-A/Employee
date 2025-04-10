package com.example.emplyeesreview.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.emplyeesreview.entity.Employee;
import com.example.emplyeesreview.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService; 
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//社員一覧表示
	@GetMapping
	public String listEmployees(Model model) {
		
		List<Employee> employees = employeeService.getAllEmployees();
		for(Employee e : employees) {
			System.out.println("名前："+e.getName()+"/写真："+e.getPhotoUrl());
		}
		model.addAttribute("employees", employees);
		return "employee/list";

//		model.addAttribute("employees",employeeService.getAllEmployees());
//		return "employee/list";
	}
	
	//社員詳細表示
	@GetMapping("/{id}")
	public String ViewEmployee(@PathVariable Long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "employee/detail";
	}
	
	//新規登録フォームの表示
	@GetMapping("/new")
	public String showCreateForm(Model model) {
		model.addAttribute("employee",new Employee());
		return "employee/form";
	}
	
	//新規登録処理
	@PostMapping
	public String createEmployee(@ModelAttribute Employee employee) {
		employeeService.createEmployee(employee);
		return "redirect:/employees";
	}
	
	//編集フォームの表示
	@GetMapping("/{id}/edit")
	public String showEditForm(@PathVariable Long id,Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "employee/form";
	}
	
	//編集処理
	@PostMapping("/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
		employee.setId(id);
		employeeService.updateEmployee(employee);
		return "redirect:/employees";
	}
	
	//削除処理
	@PostMapping("/{id}/delete")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}

	

	
	
	
}
