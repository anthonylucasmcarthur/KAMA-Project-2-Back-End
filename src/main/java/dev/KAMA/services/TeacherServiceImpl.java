package dev.KAMA.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Report;
import dev.KAMA.entities.Showcase;
import dev.KAMA.entities.Teacher;
import dev.KAMA.repositories.ChildRepo;
import dev.KAMA.repositories.ParentRepo;
import dev.KAMA.repositories.ReportRepo;
import dev.KAMA.repositories.ShowcaseRepo;
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
	ShowcaseRepo sr;
	
	@Autowired
	ChildRepo cr;
	
	
	public Teacher loginTeacher(String username, String password) {
		Teacher t = tr.findByUsername(username);
		if (t.getPassword().equals(password)) {
			t.setReports(t.getReports());
			return t;
		}
		return null;
	}

	public Teacher submitReport(Teacher teacher, Report report) {
		report.setTeacher(teacher);
		rr.save(report);
		return teacher;
	}

	public Set<Report> viewAllReports() {
		return new HashSet<Report>((Collection<? extends Report>) this.rr.findAll());
	}
	
	@Override
	public Set<Report> viewAllReports(Teacher teacher) {
		return teacher.getReports();
	}

	public Teacher submitShowcase(Teacher teacher, Showcase showcase) {
		showcase.setTeacher(teacher);
		sr.save(showcase);
		return teacher;
	}

	public Set<Showcase> viewAllShowcases() {
		return new HashSet<Showcase>((Collection<? extends Showcase>) this.sr.findAll());
	}
	
	@Override
	public Set<Showcase> viewAllShowcases(Teacher teacher) {
		return teacher.getShowcases();
	}

	public Set<Child> findAllChildren() {
		Set<Child> children = new HashSet<Child>((Collection<? extends Child>) this.cr.findAll());
		return children;
	}

	@Override
	public Set<Report> findReportsForChild(Child child) {
		return child.getReports();
	}

	@Override
	public Set<Showcase> findShowcasesForChild(Child child) {
		return child.getShowcases();
	}

}
