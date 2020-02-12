package dev.KAMA.repositories;

import dev.KAMA.entities.Showcase;
import dev.KAMA.entities.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TeacherRepo extends CrudRepository<Showcase,Integer>{

	Teacher findByUsername(String username);

}
