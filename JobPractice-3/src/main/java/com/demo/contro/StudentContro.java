package com.demo.contro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.StudentEntity;
import com.demo.ser.StudentSer;

@Controller
public class StudentContro {
	
	@Autowired
	private StudentSer ser;
	
	@GetMapping("/")
	public String getForm() {
		return "form";
	}
	
	@PostMapping("/save")
	public String saveStud(StudentEntity stu) {
		ser.saveStu(stu);
		return "form";
	}
	
	@GetMapping("/getAll")
	public String getAllStudent(Model m) {
		List<StudentEntity> stu=ser.getAllStu();
		m.addAttribute("stu", stu);
		return "table";
	}
	@RequestMapping("/dlt/{id}")
	public String deleteStudentById(@PathVariable int id) {
		ser.dltStudentById(id);
		return "redirect:/getAll";
	}

}
