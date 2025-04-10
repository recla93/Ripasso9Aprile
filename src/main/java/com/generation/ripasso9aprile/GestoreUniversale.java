package com.generation.ripasso9aprile;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GestoreUniversale
{

	@ExceptionHandler(NoResourceFoundException.class)
	public String paginaNonTrovata(NoResourceFoundException e)
	{

		return "buffone";
	}

	//catch(NumberFormatException e)
	@ExceptionHandler(NumberFormatException.class)
	public String catturoEccezioniNumberFormat(NumberFormatException e)
	{

		return "paginaEccezioneNumerica";
	}
}
