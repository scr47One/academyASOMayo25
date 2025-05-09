package com.academy.aso.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {
	
	@GetMapping("/saludo")
	String saludar() {
		return "Bienvenido Academy ASO 2025";
	}

}
