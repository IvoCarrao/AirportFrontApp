package org.AirportFrontApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping("home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	List<Airplane> listDB = new ArrayList<>();
	
	//The method is named addAlien like the name of the form on home.jsp
	@RequestMapping("/addAirplane")
	public ModelAndView addAlien(Airplane airplane){
		
		listDB.add(airplane);
		ModelAndView mv = new ModelAndView();
		mv.addObject("airplane", airplane);
		mv.setViewName("addAirplane");
		return mv;
	}
	
	@RequestMapping("/getAirplane")
	public ModelAndView getAlien(String id){
		
		Airplane airplane = listDB.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
		ModelAndView mv = new ModelAndView();
		mv.addObject("airplane", airplane);
		mv.setViewName("getAirplane");
		return mv;
	}
	
}
