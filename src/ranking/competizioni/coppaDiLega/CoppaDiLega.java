package ranking.competizioni.coppaDiLega;

import ranking.Squadra;
import ranking.competizioni.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CoppaDiLega extends Competizione
{
	private Map<Integer, Float> premi;
	private float puntiPerFantapunto;
	public CoppaDiLega()
	{
		this.nome = "CoppaDiLega";
		this.premi = new HashMap<>(); 
		this.premi.put(1, 0.100f);
		this.premi.put(2, 0.075f);
		this.premi.put(3, 0.050f);
		this.premi.put(4, 0.040f);
		this.premi.put(5, 0.035f);
		this.premi.put(6, 0.030f);
		this.premi.put(7, 0.020f);
		this.premi.put(8, 0.015f);
		this.premi.put(9, 0.010f);
		this.premi.put(10, 0.005f);
		this.premi.put(11, 0.002f);
		this.premi.put(12, 0.001f);
		this.puntiPerFantapunto = 0.001f; 
	}; 
	
	@Override
	public void carica(Map<String, Squadra> squadre, List<String> l)
	{
		float prec = -1;
		int pos = 1;
		int posPrec = pos;
		for(String s: l)
		{
			if(pos<=squadre.size())
			{
				if(Float.parseFloat(((s.split(REGEX))[3]))!=prec)
				{
					squadre.get((s.split(REGEX))[2]).aggiungiPunti(this.premi.get(pos));
					posPrec = pos;
				}
				else
					squadre.get((s.split(REGEX))[2]).aggiungiPunti(this.premi.get(posPrec));
					
				squadre.get((s.split(REGEX))[2]).aggiungiPunti(this.puntiPerFantapunto * Float.parseFloat(((s.split(REGEX))[3])));
				pos++;
				prec = Float.parseFloat(((s.split(REGEX))[3]));
			}
			else
			{
				pos = 1;
			}
		}
	}
}

