package com.example.emplyeesreview.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.emplyeesreview.entity.Employee;
import com.example.emplyeesreview.mapper.EmployeeMapper;

@Service
public class EmployeeService {
	
	private final EmployeeMapper employeeMapper;
	
	public EmployeeService(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}
	public List<Employee> getAllEmployees(){
		return employeeMapper.findAll();
	}
	public Employee getEmployeeById(Long id) {
		return employeeMapper.findById(id);
	}
	@Transactional
	public void createEmployee(Employee employee) {
		employeeMapper.insert(employee);
	}
	@Transactional
	public void updateEmployee(Employee employee) {
		employeeMapper.update(employee);
	}
	@Transactional
	public void deleteEmployee(Long id) {
		employeeMapper.delete(id);
	}
	

}
