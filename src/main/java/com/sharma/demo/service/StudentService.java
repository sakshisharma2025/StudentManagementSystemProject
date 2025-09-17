package com.sharma.demo.service;

import java.util.List;

import com.sharma.demo.entity.Student;

public interface StudentService {
	
//abstract method hote h interface me so 
	public List<Student> getAllStudent();// eska return type list student  diya bcoz no.of students milenge,now implement this in serviceimpl class

//hm eska access denge controller me ,directly serviceimpl ka access nhi denge because that class hold my buisness logic

	//new student ka data save krna h to  method create kro 
	public Student saveStudent(Student student);// now impl this 
	public Student getById(int id);
	public void deleteById(int id);  // declare deleteById method here
}