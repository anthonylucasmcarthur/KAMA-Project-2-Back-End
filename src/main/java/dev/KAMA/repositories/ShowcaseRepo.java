package dev.KAMA.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Report;
import dev.KAMA.entities.Showcase;
import dev.KAMA.entities.Teacher;

@Repository
public interface ShowcaseRepo extends CrudRepository<Showcase,Integer>{
	
	List<Showcase> findByDate(Date date);
	Set<Showcase> findAllBycwId(int cwId);
	Set<Showcase> findAll();
	
	Set<Showcase> findByChild(Child child);
	Set<Showcase> findByTeacher(Teacher teacher);
}
