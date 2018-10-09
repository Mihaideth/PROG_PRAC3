package fase2;
import java.util.Arrays;

public abstract class Beca {
	protected int codi;
	protected String programa;
	protected String universitat;
	protected String pais;
	protected int durada;
	protected int places;
	protected String[]ensenyament;
	protected int dotacioMensual;
	protected int dotacioViatge;
	protected int nEnsenyaments;
	protected LlistaSolicitud acceptats;
	/**
	 * Constructor base de beca
	 * @param codi codi de la beca
	 * @param programa programa de la beca
	 * @param universitat universitat que ofereix la beca
	 * @param pais pais on esta situada la universitat
	 * @param durada durada de la beca 
	 * @param places places que admet la beca
	 * @param ensenyament ensenyaments que poden demanar la beca
	 * @param dotacioMensual ajuda mensual que ofereix la beca
	 * @param dotacioViatge ajuda unica que ofereix la beca
	 * @param nEnsenyaments nombre d'ensenyaments que poden demanar la beca
	 */
	public Beca(int codi, String programa, String universitat, String pais, int durada, int places, String[]ensenyament, int dotacioMensual,int dotacioViatge,int nEnsenyaments){
		this.codi = codi;
		this.programa=programa;
		this.universitat=universitat;
		this.pais=pais;
		this.durada=durada;
		this.places=places;
		this.ensenyament=ensenyament;
		this.dotacioMensual=dotacioMensual;
		this.dotacioViatge=dotacioViatge;
		this.nEnsenyaments=nEnsenyaments;
	}

	public int getNEnsenyaments(){
		return nEnsenyaments;
	}
	public int getCodi() {
		return codi;
	}

	public void setCodi(int codi) {
		this.codi = codi;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getUniversitat() {
		return universitat;
	}

	public void setUniversitat(String universitat) {
		this.universitat = universitat;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getDurada() {
		return durada;
	}

	public void setDurada(int durada) {
		this.durada = durada;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

	public String[] getEnsenyament() {
		return ensenyament;
	}

	public void setEnsenyament(String[] ensenyament) {
		this.ensenyament = ensenyament;
	}

	public int getDotacioMensual() {
		return dotacioMensual;
	}

	public void setDotacioMensual(int dotacioMensual) {
		this.dotacioMensual = dotacioMensual;
	}

	public int getDotacioViatge() {
		return dotacioViatge;
	}

	public void setDotacioViatge(int dotacioViatge) {
		this.dotacioViatge = dotacioViatge;
	}

/**
 * 
 * @return retorna una copia de la beca
 */
	public abstract Beca copia();

	@Override
	public String toString() {
		return "Beca [codi=" + codi + ", programa=" + programa
				+ ", universitat=" + universitat + ", pais=" + pais
				+ ", durada=" + durada + ", places=" + places
				+ ", ensenyament=" + Arrays.toString(ensenyament)
				+ ", dotacioMensual=" + dotacioMensual + ", dotacioViatge="
				+ dotacioViatge + "]";
	}
	/**
	 * 
	 * @return string que es guarda al fitxer
	 */
	public abstract String toStringFitxer();
	/**
	 * 
	 * @return ensenyaments separats per ","
	 */
	public String toStringEnsenyament(){
		String string= new String();
		for(int i=0;i<ensenyament.length;i++){
			string=string+","+ensenyament[i];
		}
		return(string);
	}
		
}



