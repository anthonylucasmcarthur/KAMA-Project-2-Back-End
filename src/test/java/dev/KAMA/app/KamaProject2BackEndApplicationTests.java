package dev.KAMA.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.KAMA.entities.Report;
import dev.KAMA.repositories.ChildRepo;
import dev.KAMA.repositories.ParentRepo;
import dev.KAMA.repositories.ReportRepo;
import dev.KAMA.repositories.ShowcaseRepo;
import dev.KAMA.repositories.TeacherRepo;
import dev.KAMA.services.TeacherService;

@SpringBootTest
class KamaProject2BackEndApplicationTests {

	@Autowired
	ParentRepo pr;
	
	@Autowired
	ReportRepo rr;
	
	@Autowired
	TeacherRepo tr;
	
	@Autowired
	ShowcaseRepo sr;
	
	@Autowired
	ChildRepo cr;
	
	@Autowired
	TeacherService ts;
	
	@Test
	void contextLoads() {
		System.out.println("Hello");
	}
	
	@Test
	void findAllChild() {     
		System.out.println(pr.findByUsername("ablack"));
		System.out.println(ts.findAllChildren());
	}

}
