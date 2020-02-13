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
 // testing services
 // teacher
 @Test
 void findAllChild() {     
  System.out.println(pr.findByUsername("ablack"));
  System.out.println(ts.findAllChildren());
 }
 // not working ... need help
 @Test
 void viewAllReports(){
 
  
  System.out.println(ts.viewAllReports());
 }
 // this works
 @Test
 void viewAllShowcases(){
  System.out.println(ts.viewAllShowcases());
 }
 
 
 // works
 @Test
 void submitReport() {
  Report r = new Report();
  Teacher t = tr.findByUsername("cgreen");
  
  r.setStatus("Bad");
  r.setComment("pushed kid off swing");
 
 
  ts.submitReport(t, r);
 }
 @Test
 void submitShowcase() {
  Showcase sc = new Showcase();
  Teacher t = tr.findByUsername("cgreen");
  Child c = new Child();
  c.setcId(1);
  sc.setLink("https://www.google.com/");
  sc.setComment("he did good");
  sc.setChild(c);
  ts.submitShowcase(t, sc);
 }
 
 // test for the parent
 
 @Test
 void loginParent() {
  System.out.println(pr.findByUsername("wwest"));
 }
 
 
 
}
