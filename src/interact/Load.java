package interact;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ranking.*;
import ranking.competizioni.*;
import ranking.competizioni.campionato.*;
import ranking.competizioni.champions.*;
import ranking.competizioni.coppa.*;
import ranking.competizioni.coppaDiLega.CoppaDiLega;
import ranking.competizioni.europaL.*;
import ranking.competizioni.riserve.CampionatoRiserve;
import ranking.competizioni.serie.*;

public class Load 
{
	private static final String IN = "In/Input "; 
	private static final String SQUADRE = "In/Squadre";

	public static List<String> readData(String file)
	{
		List<String> lines = null;
		try(BufferedReader in = new BufferedReader(new FileReader(file)))
		{
			lines = in.lines().collect(Collectors.toList());
			return lines;
		}
		catch(IOException e) 
		{ 
			System.err.println(e.getMessage()); 
			return null; 
		}
	}
	
	public static void main(String[] args)
	{
		Map<String, Squadra> m = new HashMap<>(); 
		for(String s: readData(SQUADRE))
		{
			Squadra sq = new Squadra(s);
			m.put(s, sq); 
		}
		
		List<Competizione> competizioni = new LinkedList<>();
		Competizione c;
		c = new Campionato(); 
		competizioni.add(c); 
		c = new CoppaDiLega(); 
		competizioni.add(c);
		c = new CoppaSedicesimi(); 
		competizioni.add(c);
		c = new CoppaRipescaggioUnoUno(); 
		competizioni.add(c);
		c = new CoppaRipescaggioUnoDue(); 
		competizioni.add(c);
		c = new CoppaOttavi();
		competizioni.add(c);
		c = new CoppaRipescaggioDue(); 
		competizioni.add(c);
		c = new CoppaQuarti();
		competizioni.add(c);
		c = new SerieA(); 
		competizioni.add(c); 
		c = new SerieB(); 
		competizioni.add(c);
		c = new SerieC(); 
		competizioni.add(c);
		c = new ChampionsGironi(); 
		competizioni.add(c);
		c = new ChampionsSemifinali();
		competizioni.add(c);
		c = new ChampionsFinale();
		competizioni.add(c);
		c = new EuropaLGironi(); 
		competizioni.add(c);
		c = new EuropaLSemifinali();
		competizioni.add(c);
		c = new CampionatoRiserve(); 
		competizioni.add(c);
		
		for(Competizione comp: competizioni)
			comp.carica(m, readData(IN + comp.getNome()));
		
		List<Squadra> l = new LinkedList<>(m.values()); 
		Collections.sort(l); 
		
		Date d = new Date();
		System.out.println("RANKING LEGA aggiornato al " + d); 
		System.out.println("Posizione Squadra Punti");
		int pos = 1;
		for(Squadra sq: l)
		{
			System.out.println(pos + ". " + sq);
			pos++;
		}		 
	}
}
