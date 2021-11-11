package com.todo1.kardexSpring.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.todo1.kardexSpring.model.Kardex;
import com.todo1.kardexSpring.model.embeddedId.KardexID;
import com.todo1.kardexSpring.service.IKardexService;

@Controller
public class HomeController {

	@Autowired
	private IKardexService kardexService;

	@GetMapping("/")
	public String home(Model model, HttpSession session, HttpServletRequest request) {

		Map<KardexID, Kardex> kardexList = kardexService.findAllStockProducts();		
	    Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
	    
	    if (inputFlashMap != null) {
	        System.out.println("map : "+ inputFlashMap.get("RegistroExitoso"));
			model.addAttribute("RegistroExitoso", inputFlashMap.get("RegistroExitoso"));
	    } 
	    
		model.addAttribute("kardexList", kardexList);
		session.setAttribute("kardexList", kardexList);
		return "home";
	}
}
