package dev.KAMA.services;


import java.util.Set;

import dev.KAMA.entities.Report;
import dev.KAMA.entities.Showcase;
import dev.KAMA.entities.Teacher;

public interface TeacherService {

	public Teacher loginTeacher(String username, String password);
	
	public Teacher submitReport(Teacher teacher, Report report);
	
	public Set<Report> viewAllReports();
	
	public Teacher submitShowcase(Teacher teacher, Showcase showcase);
	
	public Set<Showcase> viewAllShowcases();
}
