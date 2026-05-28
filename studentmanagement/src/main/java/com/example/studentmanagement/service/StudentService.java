package com.example.studentmanagement.service;
import com.example.studentmanagement.entity.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
      private final List<Student> students= new ArrayList<>();
      
      //create
      
      public String addStudent(Student student)
      {
    	  students.add(student);
    	  return "Success: Student '" + student.getName() + "' has been added with ID: " + student.getId();
      }
      
      //read all
     public List<Student> getAllStudents()
      {
    	  return students;
      }
      
      //get by id
      public Optional<Student> getStudentById(int id)
      {
    	  return students.stream().filter(s -> s.getId()==id).findFirst();
      }
      
      //update by id
      
      public String updateStudent(int id, Student updated)
      {
    	  for(Student s: students)
    	  {
    		  if(s.getId()==id)
    		  {
    			  s.setName(updated.getName());
    			  s.setMarks(updated.getMarks());
    			  s.setCourse(updated.getCourse());
    			  return "Success: Student ID " + id + " has been updated.";
    		  }
    	  }
    	  return "Error: Student with ID " + id + " was not found.";
      }
      //delete student by id
      
      public String deleteStudent(int id)
      {
    	  boolean removed = students.removeIf(s -> s.getId() == id);
          if (removed) {
              return "Success: Student ID " + id + " has been deleted.";
          }
          return "Error: Student with ID " + id + " was not found.";
      }
}
