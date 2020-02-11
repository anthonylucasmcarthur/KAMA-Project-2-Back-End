package dev.KAMA.services;

import java.util.Set;

import dev.kama.entities.Report;
import dev.kama.entities.Showcase;
import dev.kama.entities.Teacher;

public interface TeacherService {

	Teacher loginTeacher(String username, String password);
	Teacher submitReport(Teacher teacher, Report report);
	Set<Report> viewAllReports();
	Teacher submitShowcase(Teacher teacher, Showcase showcase);
	Set<Showcase> viewAllShowcases();
	
}
