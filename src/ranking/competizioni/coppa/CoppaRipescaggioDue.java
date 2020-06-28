package ranking.competizioni.coppa;

import ranking.competizioni.*;

public class CoppaRipescaggioDue extends ScontriDirettiDiRipescaggio
{
	public CoppaRipescaggioDue()
	{
		this.nome = "CoppaRipescaggioDue";
		this.partitePerTurno = 1;
		this.puntiVittoria = 0.075f;
		this.puntiPareggio = 0.025f; 
		this.puntiNonDisputato = 0.075f;
	}; 
}