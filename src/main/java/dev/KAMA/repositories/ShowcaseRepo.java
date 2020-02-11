package dev.KAMA.repositories;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowcaseRepo extends CrudRepository<Showcase,Integer>{
	
	Showcase getShowcaseByDate(Date date);

}
