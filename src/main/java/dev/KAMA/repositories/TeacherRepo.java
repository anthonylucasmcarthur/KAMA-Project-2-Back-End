package dev.KAMA.repositories;

import dev.KAMA.entities.Teacher;

public interface TeacherRepo {

	Teacher getTeacherByUsername(String username);
	

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Teacher;



@Repository
public interface TeacherRepo extends CrudRepository<Teacher,Integer> {

	Teacher getTeacherByUsername(String username);

}
