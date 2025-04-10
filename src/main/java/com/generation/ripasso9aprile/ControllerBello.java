package com.generation.ripasso9aprile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class ControllerBello
{

	@GetMapping("/prova")
	public String prova(Model m)
	{
		String[] classiCss = {"a","b","c"};

		String[] testi = {"ciao","bye","hello"};


		Random rand = new Random();

		//invio nel model una classeCss e un testoACaso
		m.addAttribute("classeCss", classiCss[rand.nextInt(classiCss.length)]);
		m.addAttribute("testo", testi[rand.nextInt(classiCss.length)]);


		return "prova";
	}

	@GetMapping("/prova2")
	public String prova2(Model m)
	{
		List<FintoTicket> tutti = new ArrayList<>();
		tutti.add( FintoTicket.builder().contenuto("Ticket 1: è risolto URGENTE").risolto(true).urgente(true).build());
		tutti.add(  FintoTicket.builder().contenuto("Ticket 2: è IRRISOLTO URGENTE").risolto(false).urgente(true).build());
		tutti.add(  FintoTicket.builder().contenuto("Ticket 3: è risolto NON_URGENTE").risolto(true).urgente(false).build());
		tutti.add(  FintoTicket.builder().contenuto("Ticket 4: è IRRISOLTO NON_URGENTE").risolto(false).urgente(false).build());
		//questo serve per il primo esempio
		m.addAttribute("tickets", tutti);

		//creo una mappa che ha come chiavi gli oggetti FintoTicket e come valori le String che saranno nella view le classi Css
		//											LinkedHashMap mi permette di mantere l'ordine di inserimento durante lo scorrimento
		Map<FintoTicket,String> ticketToClass = new LinkedHashMap<>();
		//scorro tutti i ticket
		for(FintoTicket t : tutti)
		{
			//Riempio la stringa con il valore corretto in base allo stato del ticket
			String classeCss;
			if(t.isRisolto())
			{
				classeCss = t.isUrgente() ? "ticketRisoltoUrgente"  : "ticketRisoltoNonUrgente";
			}
			else
			{
				classeCss = t.isUrgente() ? "ticketIrrisoltoUrgente"  : "ticketIrrisoltoNonUrgente";
			}
			//aggiungo come coppia chiave valore alla mappa il ticket che sto scorrendo e la stringa calcolata
			ticketToClass.put(t,classeCss);
		}


		//passo la mappa alla view con il nome di ticketsMap
		m.addAttribute("ticketsMap", ticketToClass);

		return "prova2";
	}
}
