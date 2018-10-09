package fase2;

public class MOU extends Beca {

	private String[] paisos;

	public MOU(int codi, String programa, String universitat, String pais,
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

	public MOU copia() {
		MOU novaMou = new MOU(codi, programa, universitat, pais, durada,
				places, ensenyament, dotacioMensual, dotacioViatge,nEnsenyaments);
		return (novaMou);
	}

	public String toStringFitxer() {
		return (codi + "," + programa + "," + universitat + "," + pais + ","
				+ dotacioMensual + "," + dotacioViatge + "," + durada + ","
				+ places +nEnsenyaments+ toStringEnsenyament()+",");
	}
}
