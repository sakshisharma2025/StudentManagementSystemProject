package com.sharma.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharma.demo.entity.Student;
import com.sharma.demo.repository.StudentRepository;
import com.sharma.demo.service.StudentService;
@Service // beacause it has buisness logic
public class ServiceImpl implements StudentService{
	// inject StudentRepository because it perform all operation
	@Autowired//automatic dependency injection at runtime using its IoC
	com.sharma.demo.repository.StudentRepository StudentRepository;// now we get all method of student repositary here
	
	@Override
	public List<Student>getAllStudent(){
		//return StudentRepository.findAll(); directly return all students
	List<Student> list = StudentRepository.findAll();// another way = store in list and return the list
	return list;
		}
	@Override
	public Student saveStudent(Student student) {
		return StudentRepository.save(student);
	}
	@Override
    public Student getById(int id) {
		return StudentRepository.findById(id).get();
	}
    @Override
    public void deleteById(int id) {
        StudentRepository.deleteById(id);
    }
	}


