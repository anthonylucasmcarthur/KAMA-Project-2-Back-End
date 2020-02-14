package dev.KAMA.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Report;
//import dev.KAMA.entities.Showcase;

@Repository
public interface ChildRepo extends CrudRepository<Child,Integer> {
	
	List<Child> findByReports(Report report);

}
