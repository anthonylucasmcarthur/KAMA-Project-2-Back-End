package dev.KAMA.repositories;

import java.sql.Date;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Showcase;

@Repository
public interface ShowcaseRepo extends CrudRepository<Showcase,Integer>{
	
	Showcase getShowcaseByDate(Date date);
	Set<Showcase> findAllById(int id);
	Set<Showcase> findAll();
}
