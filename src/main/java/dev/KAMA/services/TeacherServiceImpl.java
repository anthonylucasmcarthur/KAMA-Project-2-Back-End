package dev.KAMA.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import dev.kama.entities.Parent;
import dev.kama.entities.Report;
import dev.kama.entities.Showcase;
import dev.kama.entities.Teacher;

@Component
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	ParentRepo pr;
	
	@Autowired
	ReportRepo rr;
	
	@Autowired
	ShowcaseRepo sr;
	
	@Autowired
	TeacherRepo tr;
	
	
	public Teacher loginTeacher(String username, String password) {
		Teacher t = tr.getTeacherByUsername(username);
		if (t.getPassword().equals(password)) {
			return t;
		}
		return null;
	}

	public Teacher submitReport(Teacher teacher, Report report) {
		report.setTeacher(teacher.gettId());
		report.setrId(rr.save(report));
		return teacher;
	}

	public Set<Report> viewAllReports() {
		return new HashSet<Report>((Collection<? extends Report>) this.rr.findAll());
	}

	public Teacher submitShowcase(Teacher teacher, Showcase showcase) {
		showcase.setTeacher(teacher.gettId());
		showcase.setsId(sr.save(showcase));
		return teacher;
	}

	public Set<Showcase> viewAllShowcases() {
		return new HashSet<Showcase>((Collection<? extends Showcase>) this.sr.findAll());
	}

}
