package com.generation.ripasso9aprile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FintoTicket
{
	private String contenuto;
	private boolean risolto,urgente;

}
