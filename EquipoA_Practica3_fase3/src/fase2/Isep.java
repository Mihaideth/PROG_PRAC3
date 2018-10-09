package fase2;


public class Isep extends Beca {

	private String[] paisos;
	private static String idiomaClasses="angles";

	public Isep(int codi, String programa, String universitat, String pais,
			int durada, int places, String[] ensenyament, int dotacioMensual,
			int dotacioViatge,int nEnsenyaments) {
		super(codi, programa, universitat, pais, durada, places, ensenyament,
				dotacioMensual, dotacioViatge,nEnsenyaments);
	}

	public String[] getPaisos() {
		return paisos;
	}

	public void setPaisos(String[] paisos) {
		this.paisos = paisos;
	}

	public String getIdiomaClasses() {
		return idiomaClasses;
	}

	/**
	 * Copia de la beca, per poder ficarla a la llista
	 */
	public Isep copia() {
		Isep novaIsep = new Isep(codi, programa, universitat, pais, durada,
				places, ensenyament, dotacioMensual, dotacioViatge,nEnsenyaments);
		return (novaIsep);
	}

	public String toStringFitxer() {
		return (codi + "," + programa + "," + universitat + "," + pais + ","
				+ dotacioMensual + "," + dotacioViatge + "," + durada + ","
				+ places +nEnsenyaments + toStringEnsenyament()+",");
	}
}