package com.example.emplyeesreview.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.emplyeesreview.entity.Employee;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employees")
    List<Employee> findAll();

    @Select("SELECT * FROM employees WHERE id = #{id}")
    Employee findById(Long id);

    @Insert("INSERT INTO employees(name, gender, hobby, department, position, photo_url) " +
            "VALUES(#{name}, #{gender}, #{hobby}, #{department}, #{position}, #{photoUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Employee employee);

    @Update("UPDATE employees SET name = #{name}, gender = #{gender}, hobby = #{hobby}, " +
            "department = #{department}, position = #{position}, photo_url = #{photoUrl} " +
            "WHERE id = #{id}")
    void update(Employee employee);

    @Delete("DELETE FROM employees WHERE id = #{id}")
    void delete(Long id);
}

