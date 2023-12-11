package com.example.demo.ser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;



@Service
public class StudentServiceImpl{
	
	@Autowired
	private StudentRepository studentRepository;


	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}


	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}


	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}

}