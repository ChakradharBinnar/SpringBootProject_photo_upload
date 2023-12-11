package com.demo.ser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.StudentEntity;
import com.demo.repo.StudentRepo;

@Service
public class StudentSer {
	
	@Autowired
	private StudentRepo repo;
	
	public void saveStu(StudentEntity stu) {
		repo.save(stu);
	}
	
	public List<StudentEntity> getAllStu(){
		return repo.findAll();
	}
	
	public void dltStudentById(int id) {
		repo.deleteById(id);
	}

}
