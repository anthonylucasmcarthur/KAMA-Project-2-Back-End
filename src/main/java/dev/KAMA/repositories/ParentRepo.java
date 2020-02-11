package dev.KAMA.repositories;

import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Parent;

@Repository
public interface ParentRepo {
	
	Parent getParentByUsername(String username);

}
