package Model;

public class Studente {
	private static int count=0;

	private int id;
	private String nome;
	private String cognome;
	private String codFiscale;
	private String corsoIscritto;
	
	public Studente() {}
	
	public Studente(String nome, String cognome, String codFiscale, String corsoIscritto) {
		this.id = ++count;
		this.nome = nome;
		this.cognome = cognome;
		this.codFiscale = codFiscale;
		this.corsoIscritto = corsoIscritto;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public String getCorsoIscritto() {
		return corsoIscritto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public void setCorsoIscritto(String corsoIscritto) {
		this.corsoIscritto = corsoIscritto;
	}

	@Override
	public String toString() {
		String desc= String.format("Studente: %s %s è iscritto al corso %s",nome, cognome,corsoIscritto);
		return desc;
	}
	
	
	
	
}
