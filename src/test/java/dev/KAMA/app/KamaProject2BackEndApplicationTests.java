package dev.KAMA.app;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Report;
import dev.KAMA.entities.Teacher;
import dev.KAMA.repositories.ChildRepo;
import dev.KAMA.repositories.ParentRepo;
import dev.KAMA.repositories.ReportRepo;
import dev.KAMA.repositories.TeacherRepo;
import dev.KAMA.services.ParentService;
import dev.KAMA.services.TeacherService;

@SpringBootTest
@Transactional
class KamaProject2BackEndApplicationTests {

	@Autowired
	ParentRepo pr;

	@Autowired
	ReportRepo rr;

	@Autowired
	TeacherRepo tr;
	
	@Autowired
	ChildRepo cr;

	@Autowired
	TeacherService ts;
	
	@Autowired
	ParentService ps;
	
	 @Test
 void contextLoads() {
  //System.out.println("Hello");
  int id = 2;
  Child c = ps.getChildById(id);
  System.out.println(c);
 }
 // testing services
 // teacher
 @Test
 void findAllChild() {
	 Set<Child> children = cr.findAll();
	 System.out.println(children);
 }
 // not working ... need help
 @Test
 void viewAllReports(){
	 Teacher teacher = ts.getTeacherById(2);
	 System.out.println(teacher);
	 System.out.println(teacher.getReports());
	 Set<Report> reports = ts.viewAllReports(teacher);
	 System.out.println(reports);
//	 if(reports.isEmpty()) {
//	 System.out.println(reports);
//	 }else {
//		 System.out.println("Bum");
//	 }
 }
 // this works
// @Test
// void viewAllShowcases(){
//  System.out.println(ts.viewAllShowcases());
// }
// 
 
 // works
 @Test
 void submitReport() {
  Report r = new Report();
  Teacher t = tr.findByUsername("cgreen");
  Child c = cr.findById(1).get();
  
  r.setChild(c);
  r.setStatus("Bad");
  r.setComment("pushed kid off swing");
  r.setTeacher(t);
  System.out.println(r.getTeacher());
  System.out.println(r.getChild());
  ts.submitReport(r);
  System.out.println(r);
  System.out.println(r.getrId());
 }
 @Test
 void submitShowcase() {
//  //Showcase sc = new Showcase();
//  Teacher t = tr.findByUsername("cgreen");
//  Child c = new Child();
//  c.setcId(1);
//  sc.setLink("https://www.google.com/");
//  sc.setComment("he did good");
//  sc.setChild(c);
//  ts.submitShowcase(t, sc);
	}

	// test for the parent

	@Test
	void loginParent() {
		System.out.println(pr.findByUsername("wwest"));
	}
	
}
