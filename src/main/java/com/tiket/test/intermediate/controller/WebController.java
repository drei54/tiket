package com.tiket.test.intermediate.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	private Logger logger = Logger.getLogger(WebController.class.getName());

	@GetMapping("/")
	public String index(Model model,
			@RequestParam(value = "page", defaultValue="0",required = false) final Integer page,
			HttpSession session,
			HttpServletRequest request
		){
	
		model.addAttribute("page", page);
		return "order";
	}
}
