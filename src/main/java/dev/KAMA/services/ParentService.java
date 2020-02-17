package dev.KAMA.services;

import java.util.Set;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Parent;
import dev.KAMA.entities.Report;
//import dev.KAMA.entities.Showcase;
import dev.KAMA.entities.Teacher;

public interface ParentService {

	Parent loginParent(String username, String password);
	Set<Report> viewReports(Parent parent);
//	Set<Showcase> viewShowcase(Parent parent);
	Child getChildById(int id);
	Teacher getTeacherByReport(Report report);
	
	
}
