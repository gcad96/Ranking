package ranking;

public class Squadra implements Comparable<Squadra>
{
	private String nome;
	private float punti;
	
	public Squadra(String nome)
	{
		this.nome = nome;
		this.punti = 0;
	}
	
	public String toString()
	{
		long arr = Math.round(this.punti * 10000); 
		float puntiArr = (float) arr/10000; 
		return this.nome + " " + puntiArr; 
	}
	
	public void aggiungiPunti(float punti)
	{
		this.punti+=punti; 
	}

	@Override
	public int compareTo(Squadra o) 
	{
		float diff = this.punti - o.punti;
		if(diff>=0)
			return -1;
		else
			return 1;
	}

}
