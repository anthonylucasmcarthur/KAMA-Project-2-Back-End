package dev.KAMA.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Report;
import dev.KAMA.entities.Teacher;
import dev.KAMA.services.ParentService;
import dev.KAMA.services.TeacherService;

@Component
@Controller
public class TeacherController {

	@Autowired
	TeacherService ts;
	
	@Autowired
	ParentService ps;
		
	@RequestMapping(value = "/teacher", method = RequestMethod.POST)
	@CrossOrigin(origins = {"http://localhost:4200"})
	@ResponseBody
	public Teacher loginTeacher(@RequestBody Teacher teacher) {
		Teacher t = ts.loginTeacher(teacher.getUsername(), teacher.getPassword());
		return t;
	}
	
	@RequestMapping(value = "/children", method = RequestMethod.GET)
	@CrossOrigin(origins = {"http://localhost:4200"})
	@ResponseBody
	public Set<Child> getChildren(){
		return ts.findAllChildren();
	}
	
	@RequestMapping(value = "/reports", method = RequestMethod.POST)
	@CrossOrigin(origins = {"http://localhost:4200"})
	@ResponseBody
	public Set<Report> createReport(Report report){
		ts.submitReport(report.getTeacher(), report);
		return ts.viewAllReports();
	}
}
