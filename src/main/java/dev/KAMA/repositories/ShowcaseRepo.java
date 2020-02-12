package dev.KAMA.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Showcase;

@Repository
public interface ShowcaseRepo extends CrudRepository<Showcase,Integer>{
	
	List<Showcase> findByDate(Date date);
	Set<Showcase> findAllBycwId(int cwId);
	Set<Showcase> findAll();
}
