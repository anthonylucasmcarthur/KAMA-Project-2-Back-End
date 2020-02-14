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

import com.google.gson.Gson;

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
		teacher.setReports(null);
//		teacher.setReports(reportSimplify(teacher.getReports()));
		teacher.setShowcases(null);
		return teacher;
	}

	@RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = { "http://localhost:4200" })
	@ResponseBody
	public Set<Report> getTeacherReports(@PathVariable int id) {
		Teacher teacher = ts.getTeacherById(id);
		Set<Report> reports = ts.viewAllReports(teacher);
		if (reports.isEmpty()) {
			System.out.println(teacher.getReports());
			System.out.println(reports);
			reports = reportSimplify(reports);
			System.out.println(reports);
			return reports;
		}else {
			System.out.println("Null");
			return null;
		}
	}

	@RequestMapping(value = "/children", method = RequestMethod.GET)
	@CrossOrigin(origins = { "http://localhost:4200" })
	@ResponseBody
	public Set<Child> getChildren() {
		return ts.findAllChildren();
	}

	@RequestMapping(value = "/reports", method = RequestMethod.POST)
	@CrossOrigin(origins = { "http://localhost:4200" })
	@ResponseBody
	public Report createReport(@RequestBody Report report) {
		ts.submitReport(report);
		report.getChild().setParent(null);
		report.getChild().setReports(null);
		report.getChild().setShowcases(null);
		report.getTeacher().setReports(null);
		report.getTeacher().setShowcases(null);
		return report;
	}

	@RequestMapping(value = "/parent", method = RequestMethod.POST)
	@CrossOrigin(origins = { "http://localhost:4200" })
	@ResponseBody
	public Parent loginParent(@RequestBody Parent parent) {
		Parent p = ps.loginParent(parent.getUsername(), parent.getPassword());
		return p;
	}

	public static Set<Report> reportSimplify(Set<Report> reports) {
		for (Report i : reports) {
			System.out.println(i);
			i.getChild().setParent(null);
			i.getChild().setReports(null);
			i.getChild().setShowcases(null);
			i.setTeacher(null);
			System.out.println(i);
		}
		return reports;
	}
}
