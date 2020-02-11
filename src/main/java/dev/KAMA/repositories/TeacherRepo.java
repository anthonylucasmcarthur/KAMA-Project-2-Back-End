package dev.KAMA.repositories;

import dev.KAMA.entities.Teacher;

public interface TeacherRepo {

	Teacher getTeacherByUsername(String username);
	
}
