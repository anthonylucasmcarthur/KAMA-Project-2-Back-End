package dev.KAMA.repositories;

import java.sql.Date;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Report;

@Repository
public interface ReportRepo extends CrudRepository<Report,Integer> {

	Report getRecordByDate(Date date);

	Set<Report> findAllByrId(int rId);
	Set<Report> findAll();

	
}
