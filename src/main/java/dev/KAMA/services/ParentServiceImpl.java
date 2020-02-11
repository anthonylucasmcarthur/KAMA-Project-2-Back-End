package dev.KAMA.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.KAMA.entities.Parent;
import dev.KAMA.entities.Report;
import dev.KAMA.entities.Showcase;
import dev.KAMA.repositories.ChildRepo;
import dev.KAMA.repositories.ParentRepo;
import dev.KAMA.repositories.ReportRepo;
import dev.KAMA.repositories.ShowcaseRepo;
import dev.KAMA.repositories.TeacherRepo;

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
	
	@Autowired
	ChildRepo cr;
	
	public Parent loginParent(String username, String password) {
		Parent p = pr.getParentByUsername(username);
		if (p.getPassword().equals(password)) {
			p.setChildren(p.getChildren());
			return p;
		}
		return null;
	}

	public Set<Report> viewReports(Parent parent) {
		Set<Report> reports = rr.fin
		
		return null;
	}

	public Set<Showcase> viewShowcase(Parent parent) {
		Set<Showcase> showcases = sr.findAllById(parent.getpId());
		return showcases;
	}

}
