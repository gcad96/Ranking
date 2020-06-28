package ranking.competizioni;

import java.util.List;
import java.util.Map;

import ranking.Squadra;

public class Competizione 
{
	protected static final String REGEX = " *\t *";
	protected String nome;
	
	public Competizione() 
	{
		;
	}

	public String getNome() 
	{
		return nome;
	}
	
	public void carica(Map<String, Squadra> squadre, List<String> l)
	{
		;
	}
}
