package fase2;
import java.util.Arrays;


public class Solicitud {
	private String nom;
	private String dni;
	private String ensenyament;
	private float notaMitja;
	private String idioma;
	private int[] opcionsBeca;
	private boolean estat;
	
	/**
	 * constructor de la solicitud de l'alumne
	 * @param nom és el nom de l'alumne
	 * @param dni és el dni de l'alumne
	 * @param ensenyament és l'ensenyament que cursa l'alumne 
	 * @param notaMitja és la nota mitja de l'alumme
	 * @param idioma és l'idioma que parla l'alumne
	 * @param opcionsBeca és un vector amb les beques que vol solicitar l'alumne
	 */
	public Solicitud(String nom, String dni, String ensenyament,
			float notaMitja, String idioma, int[] opcionsBeca) {
		this.nom = nom;
		this.dni = dni;
		this.ensenyament = ensenyament;
		this.notaMitja = notaMitja;
		this.idioma = idioma;
		this.opcionsBeca = opcionsBeca;
		estat=false;
	}
	/**
	 * 
	 * @return retorna un copia de la solicitud
	 */
    public Solicitud copia(){
    	Solicitud novaSolicitud=new Solicitud(nom,dni,ensenyament,notaMitja,idioma,opcionsBeca);
    	return(novaSolicitud);
    }

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getEnsenyament() {
		return ensenyament;
	}


	public void setEnsenyament(String ensenyament) {
		this.ensenyament = ensenyament;
	}


	public float getNotaMitja() {
		return notaMitja;
	}


	public void setNotaMitja(float notaMitja) {
		this.notaMitja = notaMitja;
	}


	public String getIdioma() {
		return idioma;
	}


	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}


	public int[] getOpcionsBeca() {
		return opcionsBeca;
	}


	public void setOpcionsBeca(int[] opcionsBeca) {
		this.opcionsBeca = opcionsBeca;
	}
	
	public boolean getEstat() {
		return estat;
	}


	public void setEstat() {
		estat=true;
	}
	private String toStringOpcions(){
		String s="";
		for(int i=0; i<opcionsBeca.length;i++) s+=opcionsBeca[i]+",";
		return (s.substring(0,s.length()-1));
	}
	public String toStringFitxer(){
		return(nom+","+dni+","+ensenyament+","+notaMitja+","+idioma+","+toStringOpcions()+",");
	}
	@Override
	public String toString() {
		return "Solicitud [nom=" + nom + ", dni=" + dni + ", ensenyament="
				+ ensenyament + ", notaMitja=" + notaMitja + ", idioma="
				+ idioma + ", opcionsBeca=" + Arrays.toString(opcionsBeca)
				+ ", estat=" + estat + "]";
	}

	
}
