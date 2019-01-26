package com.techtalentsouth.Week3Assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/")
	public String home(Model model) {
		getAllStudents(model);
		return "assessment/index.html";
	}
	
	@GetMapping("/Information")
	public String create_student(Student student) {
		return "assessment/info.html";
	}
	@PostMapping(value = "/Information")
	public String addNewStudent(Student student,Model model) {
		studentRepository.save(student);
		model.addAttribute("firstName",student.getFirstName());
		model.addAttribute("lastName",student.getLastName());
		model.addAttribute("address",student.getAddress());
		model.addAttribute("email",student.getEmail());
		model.addAttribute("phone",student.getPhone());
		model.addAttribute("dateOfBirth",student.getDateOfBirth());
		getAllStudents(model);
				
		return "assessment/result.html";
	}
	
	private void getAllStudents(Model model) {
		model.addAttribute("students", studentRepository.findAll());
	}

}
