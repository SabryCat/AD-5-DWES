package com.ite.zapateria.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {
	
	@GetMapping("/menu")
	public String mostrarMenu() {
		return "menu";
	}
}
