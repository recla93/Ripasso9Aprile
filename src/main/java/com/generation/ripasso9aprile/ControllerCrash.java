package com.generation.ripasso9aprile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerCrash
{



	@GetMapping("/crasha")
	public String metodoBurbero()
	{

		Integer.parseInt("ciao");

		return "pagina";
	}
}
