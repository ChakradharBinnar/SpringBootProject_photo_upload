package com.demo.ser;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.StudentModel;
import com.demo.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	public void saveData(StudentModel stu) {
		repo.save(stu);
	}
	
	public List<StudentModel> getAll(){
		return repo.findAll();
	}
	
	public void dltById(int id) {
		repo.deleteById(id);
	}
	
	public StudentModel getById(int id) {
		 return repo.findById(id).get();
	}

}
