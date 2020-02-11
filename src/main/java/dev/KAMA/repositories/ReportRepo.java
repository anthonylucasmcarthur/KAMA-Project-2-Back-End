package dev.KAMA.repositories;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepo extends CrudRepository<Record,Integer> {

	Record getRecordByDate(Date date);
	
}
