package fase2;

	public class ErasmusMundus extends Beca {
		private String[] paisos;
        
		public ErasmusMundus(int codi, String programa, String universitat,
				String pais, int durada, int places, String[] ensenyament,
				int dotacioMensual, int dotacioViatge,int nEnsenyaments) {
			super(codi, programa, universitat, pais, durada, places, ensenyament,
					dotacioMensual, dotacioViatge,nEnsenyaments);
		}

		public String[] getPaisos() {
			return paisos;
		}

		public void setPaisos(String[] paisos) {
			this.paisos = paisos;
		}

		/**
		 * Copia de la beca, per poder ficarla a la llista
		 */
		public ErasmusMundus copia() {
			ErasmusMundus novaErasmusMundus = new ErasmusMundus(codi, programa,
					universitat, pais, durada, places, ensenyament, dotacioMensual,
					dotacioViatge,nEnsenyaments);
			return (novaErasmusMundus);
		}

		public String toStringFitxer() {
			return (codi + "," + programa + "," + universitat + "," + pais + ","
					+ dotacioMensual + "," + dotacioViatge + "," + durada + ","
					+ places +nEnsenyaments+ toStringEnsenyament()+",");
		}
	}