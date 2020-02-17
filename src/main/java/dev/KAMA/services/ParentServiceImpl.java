package dev.KAMA.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Parent;
import dev.KAMA.entities.Report;
import dev.KAMA.entities.Teacher;
//import dev.KAMA.entities.Showcase;
import dev.KAMA.repositories.ChildRepo;
import dev.KAMA.repositories.ParentRepo;
import dev.KAMA.repositories.ReportRepo;
//import dev.KAMA.repositories.ShowcaseRepo;
import dev.KAMA.repositories.TeacherRepo;

@Component
@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	ParentRepo pr;

	@Autowired
	ReportRepo rr;

//	@Autowired
//	ShowcaseRepo sr;

	@Autowired
	TeacherRepo tr;

	@Autowired
	ChildRepo cr;

	public Parent loginParent(String username, String password) {
		Parent p = pr.findByUsername(username);
		if (p.getPassword().equals(password)) {
			return p;
		}
		return null;
	}

	public Set<Child> viewChildren(Parent parent) {
		return parent.getChildren();
	}

	public Set<Report> viewReports(Parent parent) {
		Set<Child> children = parent.getChildren();
		Set<Report> reports = new HashSet<Report>();
		for (Child child : children) {
			reports.addAll(child.getReports());
		}
		return reports;
	}

	@Override
	public Child getChildById(int id) {
		return cr.findById(id).get();
	}

	@Override
	public Teacher getTeacherByReport(Report report) {
		return report.getTeacher();
	}

//	public Set<Showcase> viewShowcase(Parent parent) {
//		Set<Child> children = parent.getChildren();
//		Set<Showcase> showcases = new HashSet<Showcase>();
//		for (Child child : children) {
//			showcases.addAll(child.getShowcases());
//		}
//		return showcases;
//	}

}
