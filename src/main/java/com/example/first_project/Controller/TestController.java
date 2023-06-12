package com.example.first_project.Controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.first_project.Model.StudentDto;
import com.example.first_project.Service.StudentServiceImpl;

@RestController
//@RequestMapping("/admin")
public class TestController {
	@Autowired
	StudentServiceImpl ss;

	@GetMapping(value = "/list")
	public ModelAndView getAll() {
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("listStudent", ss.GetListStudent());
		return mv;
	}

	@RequestMapping(value = "admin/add", method = RequestMethod.GET)
	public ModelAndView AddStudentView(ModelAndView mv) {
		StudentDto obj = new StudentDto();
		mv.addObject("obj", obj);
		mv.addObject("title", "Add New Student");
		mv.setViewName("add");
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView insertStudent(@ModelAttribute StudentDto obj) throws ParseException {
		StudentDto sv = ss.findById(obj.getID());
		ModelAndView mav = new ModelAndView();
		try {
			if (sv == null) {
				mav.setViewName("redirect:list");
				ss.insert(obj);
			} else {
				mav.setViewName("redirect:list");
				ss.update(obj);
			}
		} catch (Exception e) {
//			mav.addObject("title", "Add New Teacher");
//			mav.addObject("obj", obj);
//			mav.addObject("msg", "ID exited");
//			mav.setViewName("add");
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "admin/updateStudent/{id}", method = RequestMethod.GET)
	public ModelAndView updateStudent(@PathVariable("id") String id) {
		StudentDto obj = ss.findById(id);
		ModelAndView mv = new ModelAndView("add");
		mv.addObject("obj", obj);
		mv.addObject("title", "Update Student");
		return mv;
	}

	@RequestMapping(value = "/searchClassRoom", method = RequestMethod.GET)
	public ModelAndView searchByName(@RequestParam("fullname") String name) {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("listStudent", ss.findByName(name));
		return mav;
	}
}
