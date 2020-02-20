package dev.KAMA.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Report;
import dev.KAMA.entities.Teacher;
import dev.KAMA.repositories.ChildRepo;
import dev.KAMA.repositories.ParentRepo;
import dev.KAMA.repositories.ReportRepo;
import dev.KAMA.repositories.TeacherRepo;

@Component
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	ParentRepo pr;
	
	@Autowired
	ReportRepo rr;
	
	@Autowired
	TeacherRepo tr;
	
	@Autowired
	ChildRepo cr;
	
	public boolean loginTeacher(String username, String password) {
		Teacher t = tr.findByUsername(username);
		if (t.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public Teacher getTeacherById(int id) {
		return this.tr.findById(id).get();
	}

	public Report submitReport(Report report) {
		report = rr.save(report);
		return report;
	}

	public Set<Report> viewAllReports() {
		return new HashSet<Report>((Collection<? extends Report>) this.rr.findAll());
	}
	
	@Override
	public Set<Report> viewAllReports(Teacher teacher) {
		return rr.findByTeacher(teacher);
	}

	public Set<Child> findAllChildren() {
		Set<Child> children = cr.findAll();
		return children;
	}

	@Override
	public Set<Report> findReportsForChild(Child child) {
		return rr.findByChild(child);
	}

	@Override
	public Child getChildByReport(Report report) {
		return cr.findByReports(report);
	}

	@Override
	public Report getReportById(int id) {
		return rr.findByrId(id);
	}
	
	public Teacher getTeacherByUsername(String username) {
		Teacher teacher = tr.findByUsername(username);
		return teacher;
	}

}
