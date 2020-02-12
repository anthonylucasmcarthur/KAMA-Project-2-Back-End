package dev.KAMA.repositories;

import dev.KAMA.entities.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TeacherRepo extends CrudRepository<Teacher,Integer>{

	Teacher findByUsername(String username);

}
