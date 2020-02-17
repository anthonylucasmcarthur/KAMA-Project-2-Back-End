package dev.KAMA.services;

import java.util.Set;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Report;
import dev.KAMA.entities.Teacher;

public interface TeacherService {

	public Teacher loginTeacher(String username, String password);
	
	public Report submitReport(Report report);
	
	public Teacher getTeacherById(int id);
	
	public Set<Report> viewAllReports();
	
	public Set<Report> viewAllReports(Teacher teacher);
		
	public Set<Child> findAllChildren();
	
	public Set<Report> findReportsForChild(Child child);
	
	public Child getChildByReport(Report report);
	
	public Report getReportById(int id);
}

