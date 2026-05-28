package com.example.studentmanagement.controller;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	@PostMapping
	public String addStudent(@RequestBody Student student)
	{
		return studentservice.addStudent(student);
	}
	
	@GetMapping
	public List<Student> getAllStudents()
	{
		return studentservice.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Object getStudentById(@PathVariable int id) {
	    Optional<Student> res = studentservice.getStudentById(id);
	    
	    if (res.isPresent()) {
	        return res.get();
	    } 
	    else {
	        return "Student with ID " + id + " does not exist.";
	    }
	} 

	

    // PUT /students/{id}
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentservice.updateStudent(id, student);
    }

    // DELETE /students/{id}
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentservice.deleteStudent(id);
    }
}
