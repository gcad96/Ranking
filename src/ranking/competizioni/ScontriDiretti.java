package ranking.competizioni;

import ranking.*;
import java.util.List;
import java.util.Map;

public class ScontriDiretti extends Competizione
{
	protected static final String SEPARATORE_PUNTEGGIO = "-";
	protected static final String NON_DISPUTATA = "N.D.";
	protected float puntiVittoria;
	protected float puntiPareggio;
	
	public ScontriDiretti()
	{
	}; 
	
	@Override
	public void carica(Map<String, Squadra> squadre, List<String> l)
	{
		for(String s: l)
		{
			if(s.startsWith(NON_DISPUTATA))
			{
				squadre.get((s.split(REGEX))[1]).aggiungiPunti(this.puntiVittoria);
				continue;
			}
			if(Integer.parseInt((((s.split(REGEX))[4].split(SEPARATORE_PUNTEGGIO))[0]))>Integer.parseInt((((s.split(REGEX))[4].split(SEPARATORE_PUNTEGGIO))[1])))
				squadre.get((s.split(REGEX))[0]).aggiungiPunti(this.puntiVittoria);
			if(Integer.parseInt((((s.split(REGEX))[4].split(SEPARATORE_PUNTEGGIO))[0]))<Integer.parseInt((((s.split(REGEX))[4].split(SEPARATORE_PUNTEGGIO))[1])))
				squadre.get((s.split(REGEX))[3]).aggiungiPunti(this.puntiVittoria);
			if(Integer.parseInt((((s.split(REGEX))[4].split(SEPARATORE_PUNTEGGIO))[0]))==Integer.parseInt((((s.split(REGEX))[4].split(SEPARATORE_PUNTEGGIO))[1])))
			{
				squadre.get((s.split(REGEX))[0]).aggiungiPunti(this.puntiPareggio);
				squadre.get((s.split(REGEX))[3]).aggiungiPunti(this.puntiPareggio);	
			}
		}
	}
}
