package ranking.competizioni;

import ranking.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ScontriDirettiDiRipescaggio extends Competizione
{
	protected static final String SEPARATORE_PUNTEGGIO = "-";
	protected static final String DELIMITATORE = ": ";
	protected static final String SEPARATORE_SQUADRE = " ,";
	protected int partitePerTurno;
	protected float puntiVittoria;
	protected float puntiPareggio;
	protected float puntiNonDisputato;
	
	public ScontriDirettiDiRipescaggio()
	{
	}; 
	
	@Override
	public void carica(Map<String, Squadra> squadre, List<String> l)
	{
		List<Squadra> elim = new LinkedList<>();
		for(String s: (l.remove(0).split(DELIMITATORE))[1].split(SEPARATORE_SQUADRE))
		{
			
			Squadra sq = squadre.get(s);
			if(sq!=null)
				elim.add(sq);
		}
		List<Squadra> pres = new LinkedList<>(); 
		int partite = 0;
		for(String s: l)
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
			pres.add(squadre.get((s.split(REGEX))[0])); pres.add(squadre.get((s.split(REGEX))[3]));
			partite++;
		}
		for(Squadra sq: squadre.values())
		{
			if(!pres.contains(sq) && !elim.contains(sq))
				sq.aggiungiPunti((partite/this.partitePerTurno)*this.puntiNonDisputato);
		}
	}
}
