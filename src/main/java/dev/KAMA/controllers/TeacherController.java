package dev.KAMA.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.KAMA.entities.Child;
import dev.KAMA.entities.Teacher;
import dev.KAMA.services.ParentService;
import dev.KAMA.services.TeacherService;

@Component
@Controller
public class TeacherController {

	@Autowired
	TeacherService ts;
	
	@Autowired
	ParentService ps;
	
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	@ResponseBody
	public Teacher getTeacher(HttpServletRequest request) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("User");
		return teacher;
	}
	
	@RequestMapping(value = "/children", method = RequestMethod.GET)
	@ResponseBody
	public Set<Child> getChildren(){
		return ts.findAllChildren();
	}
	
}
