package fase2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import exception.NoTrobat;

public class LlistaBeca {

	private int numBeques = 0;
	private Beca[] llista;

	public LlistaBeca(int numBeques) {
		llista = new Beca[numBeques];
		numBeques = 0;
	}

	/**
	 * Metode per afegir beca
	 * 
	 * @param p
	 *            beca copiada
	 */
	public void afegirBeca(Beca p) {
		if (numBeques < llista.length) {
			llista[numBeques] = p.copia();
			numBeques++;
		}
	}

	public int getNumBeques() {
		return (numBeques);
	}

	public Beca[] getLlista() {
		return llista;
	}

	/**
	 * Metode per editar la durada de la beca
	 * 
	 * @param codi
	 *            de la beca a editar
	 * @param durada
	 *            duracio de la beca
	 * @throws NoTrobat
	 *             quan la beca no existeix o no es troba
	 */
	public void editarDuradaBeca(int codi, int durada) throws NoTrobat {
		int pos;

		pos = getBeca(codi);
		if (pos == -1)
			throw new NoTrobat();
		llista[pos].setDurada(durada);
	}

	/**
	 * Metode per editar les places de la beca
	 * 
	 * @param codi
	 *            de la beca
	 * @param places
	 *            numero de places disponibles
	 * @throws NoTrobat
	 *             quan la beca no existeix o no es troba
	 */
	public void editarPlacesBeca(int codi, int places) throws NoTrobat {
		int pos;

		pos = getBeca(codi);
		if (pos == -1)
			throw new NoTrobat();
		llista[pos].setPlaces(places);
	}

	/**
	 * Metode per decrementar el nombre de places d'una beca pendent, i si nomes
	 * quedava una plaça s'elimina la beca, significa que s'ha assignat la beca
	 * 
	 * @param codi
	 *            de la beca que se li decrementen les places
	 * @throws NoTrobat
	 *             quan la beca no existeix o no es troba
	 */
	public void decrementarPlaces(int codi) throws NoTrobat {
		int pos, places;

		pos = getBeca(codi);
		if (pos == -1)
			throw new NoTrobat();
		places = llista[pos].getPlaces();
		if (places > 1)
			llista[pos].setPlaces(places - 1);
		else
			eliminarBeca(codi);
	}

	/**
	 * Metode per eliminar una beca a partir del seu codi
	 * 
	 * @param codi
	 *            id de la beca
	 * @throws NoTrobat
	 *             quan la beca no existeix o no es troba
	 */
	public void eliminarBeca(int codi) throws NoTrobat {
		int pos;
		pos = getBeca(codi);
		if (pos == -1)
			throw new NoTrobat();
		for (int i = pos; i < numBeques - 1; i++)
			llista[i] = llista[i + 1];

		numBeques--;
		llista[numBeques] = null;
	}

	/**
	 * Metode per consultar beca
	 * 
	 * @param codi
	 *            ID de la beca
	 * @throws NoTrobat
	 *             quan la beca no existeix o no es troba
	 * @return la beca demanada
	 */
	public Beca consultarBeca(int codi) throws NoTrobat {
		int pos;

		pos = getBeca(codi);
		if (pos == -1)
			throw new NoTrobat();
		else
			return (llista[pos]);
	}

	/**
	 * Metode per trobar beca
	 * 
	 * @param codi
	 *            ID de la beca
	 * @return trobada o no trobada
	 */
	public int getBeca(int codi) {
		int i, pos;
		pos = 0;
		i = 0;
		boolean trobat;
		trobat = false;
		while ((i < numBeques) && (!trobat)) {
			if (codi == (llista[i].getCodi())) {
				trobat = true;
				pos = i;
			}
			i++;
		}

		if (trobat) {
			return pos;
		} else {
			return -1;
		}

	}

	/**
	 * Metode per buscar una beca segons el pais destí
	 * 
	 * @param pais
	 *            pais de desti
	 * @throws NoTrobat
	 *             quan la beca no existeix o no es troba
	 * @return beques amb el mateix destí
	 */

	public Beca[] llistaBequesPais(String pais) throws NoTrobat {
		int i = 0;
		int j = 0;
		Beca[] beques = new Beca[numBeques];

		while (i < numBeques) {
			if (llista[i].getPais().equalsIgnoreCase(pais)) {
				beques[j] = llista[i].copia();
				j++;
			}
			i++;
		}
		if (j != 0) {
			Beca[] retornar = new Beca[j];
			for (i = 0; i < j; i++) {
				retornar[i] = beques[i];
			}
			return retornar;
		} else
			throw new NoTrobat();
	}

	/**
	 * Consultar dotacio de la beca erasmus plus
	 * 
	 * @param codi
	 *            ID de la beca
	 * @throws NoTrobat
	 *             quan la beca no existeix o no es troba
	 * @return dotacio de la beca
	 */
	public int consultarDotacioErasmusPlus(int codi) throws NoTrobat {
		int pos;

		pos = getBeca(codi);
		if (pos == -1)
			throw new NoTrobat();
		if (llista[pos] instanceof ErasmusPlus)
			return llista[pos].getDotacioMensual();
		else
			return 0;
	}

	/**
	 * 
	 * @param idioma de les beques(erasmusplus o isep)
	 * @return codis de les beques amb l'idioma introduït
	 * @throws NoTrobat
	 *             quan la beca no existeix o no es troba
	 */
	public int[] consultarBequesAmbIdioma(String idioma) throws NoTrobat {
		int llistaIdiomes[] = new int[numBeques];
		int numTrobats = 0;

		for (int i = 0; i < numBeques; i++) {
			if (llista[i] instanceof ErasmusPlus) {
				if (((ErasmusPlus) llista[i]).getIdiomaClasses()
						.equalsIgnoreCase(idioma))
					llistaIdiomes[numTrobats++] = llista[i].getCodi();
			} else if (llista[i] instanceof Isep) {
				if (((Isep) llista[i]).getIdiomaClasses().equalsIgnoreCase(
						idioma))
					llistaIdiomes[numTrobats++] = llista[i].getCodi();
			}
		}
		if (numTrobats == 0)
			throw new NoTrobat();
		int[] retornar = new int[numTrobats];
		for (int i = 0; i < numTrobats; i++)
			retornar[i] = llistaIdiomes[i];
		return retornar;
	}

	/**
	 * Mètode per carregar les beques des d'un fitxer
	 */
	public void carregarBeques() {
		try {
			Scanner lectura = new Scanner(new File("BequesCarregar.txt"));
			String idiomaClasses = null;
			int dotacioMensual = 0;
			int dotacioViatge = 0;
			lectura.useDelimiter(",");
			int nEnsenyaments = 0;
			while (lectura.hasNext()) {
				int codi = Integer.parseInt(lectura.next());
				String programa = lectura.next();
				String universitat = lectura.next();
				String pais = lectura.next();
				if (programa.equalsIgnoreCase("ErasmusPlus")) {
					idiomaClasses = lectura.next();
				}
				dotacioMensual = Integer.parseInt(lectura.next());
				dotacioViatge = Integer.parseInt(lectura.next());
				int durada = Integer.parseInt(lectura.next());
				int places = Integer.parseInt(lectura.next());
				nEnsenyaments = Integer.parseInt(lectura.next());
				String[] ensenyament = new String[nEnsenyaments];
				for (int i = 0; i < nEnsenyaments; i++) {
					ensenyament[i] = lectura.next();
				}
				if (programa.equalsIgnoreCase("ErasmusPlus")) {
					ErasmusPlus beca = new ErasmusPlus(idiomaClasses, codi,
							programa, universitat, pais, durada, places,
							ensenyament, dotacioMensual, dotacioViatge,
							nEnsenyaments);
					afegirBeca(beca);
				}
				if (programa.equalsIgnoreCase("MOU")) {
					MOU beca = new MOU(codi, programa, universitat, pais,
							durada, places, ensenyament, dotacioMensual,
							dotacioViatge, nEnsenyaments);
					afegirBeca(beca);
				}
				if (programa.equalsIgnoreCase("Isep")) {
					Isep beca = new Isep(codi, programa, universitat, pais,
							durada, places, ensenyament, dotacioMensual,
							dotacioViatge, nEnsenyaments);
					afegirBeca(beca);
				}
				if (programa.equalsIgnoreCase("ErasmusMundus")) {
					ErasmusMundus beca = new ErasmusMundus(codi, programa,
							universitat, pais, durada, places, ensenyament,
							dotacioMensual, dotacioViatge, nEnsenyaments);
					afegirBeca(beca);
				}
				lectura.nextLine();
			}
			lectura.close();
		} catch (FileNotFoundException e) {

			System.out.println("El fitxer no existeix");
		}
	}

	/**
	 * Mètode per guardar les beques en un fitxer
	 */
	public void exportarBeques() {
		try {
			BufferedWriter escriptura = new BufferedWriter(new FileWriter(
					"BequesGuardar.txt"));
			for (int i = 0; i < numBeques; i++) {
				Beca b = llista[i];
				escriptura.write(b.toStringFitxer());
				escriptura.newLine();
			}
			escriptura.close();
		} catch (IOException e) {
			System.out.println("No es pot escriure");
		}

	}
}
