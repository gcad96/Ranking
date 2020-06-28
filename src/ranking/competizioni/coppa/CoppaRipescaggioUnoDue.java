package ranking.competizioni.coppa;

import ranking.competizioni.*;

public class CoppaRipescaggioUnoDue extends ScontriDirettiDiRipescaggio
{
	public CoppaRipescaggioUnoDue()
	{
		this.nome = "CoppaRipescaggioUnoDue";
		this.partitePerTurno = 1;
		this.puntiVittoria = 0.025f;
		this.puntiPareggio = 0.010f; 
		this.puntiNonDisputato = 0.075f;
	}; 
}
