package dev.KAMA.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Report;


@Repository
public interface ChildRepo extends CrudRepository<Child,Integer> {
	
	Child findByReports(Report reports);
	
	Set<Child> findAll();

}
