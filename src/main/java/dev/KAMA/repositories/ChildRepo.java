package dev.KAMA.repositories;

import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Report;

@Repository
public interface ChildRepo {
	
	

	Child findByReports(Report report);
	Child findByUsername(String username);
}
