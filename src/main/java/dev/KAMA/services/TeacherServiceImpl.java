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
			return t;
		}
		return null;
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

	public Showcase submitShowcase(Showcase showcase) {
		sr.save(showcase);
		return showcase;
	}

	public Set<Showcase> viewAllShowcases() {
		return new HashSet<Showcase>((Collection<? extends Showcase>) this.sr.findAll());
	}
	
	@Override
	public Set<Showcase> viewAllShowcases(Teacher teacher) {
		return sr.findByTeacher(teacher);
	}

	public Set<Child> findAllChildren() {
		Set<Child> children = new HashSet<Child>((Collection<? extends Child>) this.cr.findAll());
		return children;
	}

	@Override
	public Set<Report> findReportsForChild(Child child) {
		return rr.findByChild(child);
	}

	@Override
	public Set<Showcase> findShowcasesForChild(Child child) {
		return sr.findByChild(child);
	}

}
