package com.demo.contro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.StudentModel;
import com.demo.ser.StudentService;

@Controller
public class StudentContro {
	
	@Autowired
	private StudentService ser;
	
	
	@GetMapping("/")
	public String getForm() {
		return"form";
	}
	@PostMapping("/save")
	public String saveData(StudentModel stu) {
		 ser.saveData(stu);
		 return "form";
	}
	@GetMapping("/getAll")
	public String getAllStudent(Model m) {
		List<StudentModel> list=ser.getAll();
		m.addAttribute("list", list);
		return "table";
	}
	
	@RequestMapping("/dlt/{id}")
	public String dltById(@PathVariable int id) {
		ser.dltById(id);
		return "redirect:/getAll";
	}
	
	@PostMapping("/update/{id}")
	public String updateStu(@PathVariable int id, @ModelAttribute("student") StudentModel stu) {
		
		StudentModel existingStu = ser.getById(id);
		
		existingStu.setId(id);
		existingStu.setFname(stu.getFname());
		existingStu.setMname(stu.getMname());
		existingStu.setLname(stu.getLname());
		existingStu.setEmail(stu.getEmail());
		existingStu.setAddress(stu.getAddress());
		
		ser.saveData(existingStu);
		
		return "redirect:/getAll";	
	}
	@GetMapping("/byId/{id}")
	public String getById(@PathVariable int id, Model m) {
		StudentModel student = ser.getById(id);
		m.addAttribute("student", student);
		return "update";
		
	}
	
}
