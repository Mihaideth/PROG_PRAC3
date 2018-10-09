package fase2;


public class ErasmusPlus extends Beca {

	private String[] paisos;
	private String idiomaClasses;

	public ErasmusPlus(String idiomaClasses, int codi, String programa,
			String universitat, String pais, int durada, int places,
			String[] ensenyament, int dotacioMensual, int dotacioViatge,int nEnsenyaments) {
		super(codi, programa, universitat, pais, durada, places, ensenyament,
				dotacioMensual, dotacioViatge,nEnsenyaments);
		this.idiomaClasses = idiomaClasses;
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

	public void setIdiomaClasses(String idiomaClasses) {
		this.idiomaClasses = idiomaClasses;
	}

	/**
	 * Copia de la beca, per poder ficarla a la llista
	 */
	public ErasmusPlus copia() {
		ErasmusPlus novaErasmusPlus = new ErasmusPlus(idiomaClasses, codi,
				programa, universitat, pais, durada, places, ensenyament,
				dotacioMensual, dotacioViatge,nEnsenyaments);
		return (novaErasmusPlus);
	}

	public String toStringFitxer() {
		return (codi + "," + programa + "," + universitat + "," + pais + ","
				+ idiomaClasses + "," + dotacioMensual + "," + dotacioViatge
				+ "," + durada + "," + places +nEnsenyaments+ toStringEnsenyament()+",");
	}

}
