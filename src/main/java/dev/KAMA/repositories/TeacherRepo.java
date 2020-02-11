package dev.KAMA.repositories;

<<<<<<< HEAD
import dev.KAMA.entities.Teacher;

public interface TeacherRepo {

	Teacher getTeacherByUsername(String username);
	
=======
import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Teacher;

@Repository
public interface TeacherRepo {

	Teacher getTeacherByUsername(String username);
>>>>>>> Anthony
}
