package dev.KAMA.repositories;

import java.sql.Date;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Report;
import dev.KAMA.entities.Teacher;

@Repository
public interface ReportRepo extends CrudRepository<Report,Long> {

	Report getRecordByDate(Date date);

	Set<Report> findAllByrId(int rId);
	Set<Report> findAll();
	Set<Report> findByChild(Child child);
	Set<Report> findByTeacher(Teacher teacher);

	
}
