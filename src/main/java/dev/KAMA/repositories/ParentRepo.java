package dev.KAMA.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Parent;


@Repository
public interface ParentRepo extends CrudRepository<Parent,Integer>  {
	
	Parent getParentByUsername(String username);
	Parent findByChildren(Child child);

}
