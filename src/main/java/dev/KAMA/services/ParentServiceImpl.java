package dev.KAMA.services;

import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.kama.entities.Parent;
import dev.kama.entities.Report;
import dev.kama.entities.Showcase;

@Component
@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	ParentRepo pr;
	
	@Autowired
	ReportRepo rr;
	
	@Autowired
	ShowcaseRepo sr;
	
	@Autowired
	TeacherRepo tr;
	
	public Parent loginParent(String username, String password) {
		Parent p = pr.getParentByUsername(username);
		if (p.getPassword().equals(password)) {
			return p;
		}
		return null;
	}

	public Set<Report> viewReports(Parent parent) {
		Set<Report> reports = rr.findAllById(parent.getpId());
		return reports;
	}

	public Set<Showcase> viewShowcase(Parent parent) {
		Set<Showcase> showcases = sr.findAllById(parent.getpId());
		return showcases;
	}

}
