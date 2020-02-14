package dev.KAMA.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Report;
import dev.KAMA.entities.Teacher;

@Repository
public interface ReportRepo extends CrudRepository<Report, Long> {

	Report getRecordByDate(Date date);

	Report findByrId(int rId);

	Set<Report> findAll();

	Set<Report> findByChild(Child child);
	
	//@Query("FROM Report WHERE t_id = teacher.tId") 
	Set<Report> findByTeacher(Teacher teacher);

	
}
