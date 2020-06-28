package ranking.competizioni.coppa;

import ranking.competizioni.*;

public class CoppaRipescaggioUnoUno extends ScontriDirettiDiRipescaggio
{
	public CoppaRipescaggioUnoUno()
	{
		this.nome = "CoppaRipescaggioUnoUno";
		this.partitePerTurno = 3;
		this.puntiVittoria = 0.050f;
		this.puntiPareggio = 0.020f; 
		this.puntiNonDisputato = 0.075f;
	}; 
}
