package dev.KAMA.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Report;
import dev.KAMA.entities.Teacher;
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
		Child c = new Child();
		Teacher t = new Teacher();
		t = tr.findById(2).get();
		c = cr.findById(8).get();
		//System.out.println(c.getReports());
		//System.out.println(rr.findByChild(c));
		System.out.println(rr.findByTeacher(t));
		//System.out.println(sr.findAll());
	}

}
