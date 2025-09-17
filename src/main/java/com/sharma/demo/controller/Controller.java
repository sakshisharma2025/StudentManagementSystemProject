package com.sharma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sharma.demo.entity.Student;
import com.sharma.demo.service.StudentService;


@org.springframework.stereotype.Controller

public class Controller {
	@Autowired
	private StudentService service;// via autowired es interface k regarding jo bhi chije like creation,intialization,destroytion
	// sb kuchh autowired inject kr leta h after this create method
	
	
	@GetMapping("/home")// view page created end point home dediya
	public String home() {//home method execution
		return "home";//view page html file -> home.html
	}
	@GetMapping("/students")
	//method 
	public String getAllStudent(Model model){//Model is a interface jo bhi data aata h usko view ko bhejna ka kaam ye kr leta h 
		model.addAttribute("students",service.getAllStudent());//service.getAllStudent ye call kr rhi h StudentReposiratory ko jo call ->service -> service impl k andr list me findAll sara data de rhi h
		//students is a key jb eska use krenge tabhi data recive hoga or model show krega
		 
	    return "students";//view ko return krna h jo complete data show krega(students.html ) with help of model
	}
	
	//methods for add new students
	
	@GetMapping("students/new")
	    public String createStudentForm(Model model) {
	    	
	    	Student student=new Student();//to hold the student object
	    	model.addAttribute("student",student);
	    	return "create-student";
	    	
	}
	@PostMapping("/students")// used to map HTTP POST requests ,enabling the submission and processing of new data sent by the client
	public String saveStudent(@ModelAttribute("student") Student student) {
	//student me data kese get kr payenge using @ModelAttribute annotation esme sidha us key ko pass kro jis se data get kr payenge
	// save krna h data to service me method create krna pdega
	
		//upr mene autowired annotation use kiys service k liye
	     service.saveStudent(student);//call krega repo ko or repo degi Database ko
	     return "redirect:/students";//data save hone k baad students pr show hona chahiye
	}
	
	
	// methods for update
	
	    @GetMapping("/students/edit/{id}")// used to map HTTP GET requests to a specific handler method ,making it easier to retrieve data from RESTful web services.
	     public String editStudentForm(@PathVariable int id, Model model){
	    	 model.addAttribute("student",service.getById(id));
	    	 return "edit_student";
	
	     }
	    @PostMapping("/students/edit/{id}")
	    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {//create a method for update student detail
	     Student existingStudent=service.getById(id);//upr jo getMapping me student key me jo data aa rha h sevice.getById se @modelAttribute se data aa rha h jo student key me es method me 
	     existingStudent.setFirstName(student.getFirstName());//set..here used to show existing data jisme hm changes krenge or get data use to get data after update we will recive updated data on home page
	     existingStudent.setLastName(student.getLastName());
	     existingStudent.setEmail(student.getEmail());
	     service.saveStudent(existingStudent);
	       return "redirect:/students";

	    }
	    //methods for delete student
	    @GetMapping("/students/{id}")
	    public String deleteById(@PathVariable int id) {
	    	service.deleteById(id);
	    	return "redirect:/students";
	    }
	}
