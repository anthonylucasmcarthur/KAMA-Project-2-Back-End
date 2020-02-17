package dev.KAMA.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Parent;
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
	@CrossOrigin(origins = { "http://localhost:4200" })
	@ResponseBody
	public Teacher loginTeacher(@RequestBody Teacher teacher) {
		teacher = ts.loginTeacher(teacher.getUsername(), teacher.getPassword());
		System.out.println(teacher);
		teacher.setReports(null);
//		teacher.setReports(reportSimplify(teacher.getReports()));
		return teacher;
	}

	@RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = { "http://localhost:4200" })
	@ResponseBody
 	public Set<Report> getTeacherReports(@PathVariable int id) {
		Teacher teacher = ts.getTeacherById(id);
		Set<Report> reports = ts.viewAllReports(teacher);
		System.out.println("HELLO" + reports);
		reports = fixReport(reports);
		return reports;
	}

	@RequestMapping(value = "/children", method = RequestMethod.GET)
	@CrossOrigin(origins = { "http://localhost:4200" })
	@ResponseBody
	public Set<Child> getChildren() {
		Set<Child> children = ts.findAllChildren();
		for(Child child: children) {
			child.setParent(null);
			child.setReports(null);
		}
		return children;
	}

	@RequestMapping(value = "/reports", method = RequestMethod.POST)
	@CrossOrigin(origins = { "http://localhost:4200" })
	@ResponseBody
	public Report createReport(@RequestBody Report report) {
		ts.submitReport(report);
		report.getChild().setParent(null);
		report.getChild().setReports(null);
		report.getTeacher().setReports(null);
		return report;
	}

	public Set<Report> fixReport(Set<Report> reports){
		Child c = new Child();
		Child newc = new Child();
		for (Report i : reports) {
			System.out.println(i);
			c = ts.getChildByReport(i);
			newc.setFname(c.getFname());
			newc.setLname(c.getLname());
			i.setChild(newc);
			i.setTeacher(null);
		}
		return reports;
	}
	
}
