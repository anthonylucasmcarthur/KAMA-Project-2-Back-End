package dev.KAMA.repositories;

import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Teacher;

@Repository
public interface TeacherRepo {

	Teacher getTeacherByUsername(String username);
}
