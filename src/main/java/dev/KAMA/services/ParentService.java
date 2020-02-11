package dev.KAMA.services;

import java.util.Set;

import dev.kama.entities.Parent;
import dev.kama.entities.Report;
import dev.kama.entities.Showcase;

public interface ParentService {

	Parent loginParent(String username, String password);
	Set<Report> viewReports(Parent parent);
	Set<Showcase> viewShowcase(Parent parent);
	
}
