package dev.KAMA.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
public class ParentController {

	@Autowired
	TeacherService ts;

	@Autowired
	ParentService ps;
	
	@RequestMapping(value = "/parent", method = RequestMethod.POST)
	@CrossOrigin(origins = { "http://localhost:4200" })
	@ResponseBody
	public Parent loginParent(@RequestBody Parent parent) {
		if(ps.getParentByUsername(parent.getUsername()) != null) {
			if(ps.loginParent(parent.getUsername(), parent.getPassword())) {
				parent = ps.getParentByUsername(parent.getUsername());
				parent.setChildren(null);
				parent.setPassword(null);
				parent.setUsername(null);
				return parent;
			}
		}
		return new Parent();
	}

	@RequestMapping(value = "/child/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = { "http://localhost:4200" })
	@ResponseBody
	public Child getChild(@PathVariable int id) {
		Child child = ps.getChildById(id);
		child.setReports(fixReport(child.getReports()));
		child.setParent(null);
		return child;

	}

	public Set<Report> fixReport(Set<Report> reports) {
		System.out.println(reports);
		for (Report i : reports) {
			Teacher teacher = new Teacher();
			Teacher newteach = ps.getTeacherByReport(i);
			teacher.setFname(newteach.getFname());
			teacher.setLname(newteach.getLname());
			i.setChild(null);
			i.setTeacher(teacher);
		}
		return reports;
	}

	public Set<Child> fixChildren(Set<Child> children) {
		for (Child i : children) {
			i.setParent(null);
			i.setReports(null);
		}
		return children;
	}
}
