package ranking.competizioni.riserve;

import ranking.Squadra;
import ranking.competizioni.*;

import java.util.List;
import java.util.Map;

public class CampionatoRiserve extends Competizione
{
	private static final String RIPOSO = "RIP";
	protected static final String SEPARATORE_PUNTEGGIO = "-";
	private float puntiVittoria;
	private float puntiPareggio;
	private float puntiPerFantapunto;
	
	public CampionatoRiserve()
	{
		this.nome = "CampionatoRiserve";
		this.puntiVittoria = 0.030f;
		this.puntiPareggio = 0.015f;
		this.puntiPerFantapunto = 0.0005f;
	}; 
	
	@Override
	public void carica(Map<String, Squadra> squadre, List<String> l)
	{
		for(String s: l)
		{
			if(((s.split(REGEX))[0]).equals(RIPOSO))
				squadre.get((s.split(REGEX))[1]).aggiungiPunti(this.puntiPerFantapunto * Float.parseFloat(((s.split(REGEX))[2])));
			else
			{
				if(Integer.parseInt((((s.split(REGEX))[4].split(SEPARATORE_PUNTEGGIO))[0]))>Integer.parseInt((((s.split(REGEX))[4].split(SEPARATORE_PUNTEGGIO))[1])))
					squadre.get((s.split(REGEX))[0]).aggiungiPunti(this.puntiVittoria);
				if(Integer.parseInt((((s.split(REGEX))[4].split(SEPARATORE_PUNTEGGIO))[0]))<Integer.parseInt((((s.split(REGEX))[4].split(SEPARATORE_PUNTEGGIO))[1])))
					squadre.get((s.split(REGEX))[3]).aggiungiPunti(this.puntiVittoria);
				if(Integer.parseInt((((s.split(REGEX))[4].split(SEPARATORE_PUNTEGGIO))[0]))==Integer.parseInt((((s.split(REGEX))[4].split(SEPARATORE_PUNTEGGIO))[1])))
				{
					squadre.get((s.split(REGEX))[0]).aggiungiPunti(this.puntiPareggio);
					squadre.get((s.split(REGEX))[3]).aggiungiPunti(this.puntiPareggio);	
				}
				squadre.get((s.split(REGEX))[0]).aggiungiPunti(this.puntiPerFantapunto * Float.parseFloat(((s.split(REGEX))[1])));
				squadre.get((s.split(REGEX))[3]).aggiungiPunti(this.puntiPerFantapunto * Float.parseFloat(((s.split(REGEX))[2])));
			}
		}
	}
}
