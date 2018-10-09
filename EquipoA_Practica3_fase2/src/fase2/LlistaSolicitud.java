package fase2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import exception.NoTrobat;

public class LlistaSolicitud {
	private int nSolicituds = 0;
	private Solicitud[] llista;

	public LlistaSolicitud(int capacitat) {
		llista = new Solicitud[capacitat];
		nSolicituds = 0;
	}

	/**
	 * Metode per afegir una nova solicitut
	 * 
	 * @param s
	 *            nom de la beca a copiar
	 */
	public void novaSolicitud(Solicitud s) {
		if (nSolicituds < llista.length) {
			llista[nSolicituds] = s.copia();
			nSolicituds++;
		}
	}

	public int getNSolicituds() {
		return (nSolicituds);
	}

	/**
	 * Metode per consultar les solicituts de beca a una certa destinació donant
	 * el codi de la beca
	 * 
	 * @param codi
	 *            ID de la beca
	 * @return Solicituds
	 */
	public Solicitud[] consultarSolicitudsBeca(int codi) {
		int i = 0;
		int j = 0;
		Solicitud[] solicituds = new Solicitud[nSolicituds];

		while (i < nSolicituds) {
			int[] opcions = llista[i].getOpcionsBeca();
			if ((opcions[0] == codi) || (opcions[1] == codi)
					|| (opcions[2] == codi)) {
				solicituds[j] = llista[i];
				j++;
			}
			i++;
		}
		Solicitud[] retorna = new Solicitud[j];
		retorna = solicituds;
		return (retorna);
	}

	/**
	 * Metode per consultar el numero de solicituds a un cert ensenyament
	 * 
	 * @param ensenyament
	 *            tipus de ensenyament
	 * @return num de solicituds
	 */
	public int getNumBequesEnsenyament(String ensenyament) {
		int i = 0, res = 0;

		while (i < nSolicituds) {
			if (llista[i].getEnsenyament().equalsIgnoreCase(ensenyament))
				res++;
			i++;
		}
		return res;
	}

	/**
	 * Metode per a consultar els codis de les beques que no tenen cap solicitud
	 * 
	 * @param llista2
	 *            és la llista de beques
	 * @return els codis de les beques sense solicitud
	 */
	public int[] bequesSenseSolicitud(LlistaBeca llista2) {
		int i = 0, j = 0, z = 0;
		boolean trobat = false;
		int[] codis = new int[llista2.getNumBeques()];
		Beca[] beques = llista2.getLlista();

		while (i < llista2.getNumBeques()) {
			while ((j < nSolicituds) && (!trobat)) {
				if ((llista[i].getOpcionsBeca()[0] == beques[j].getCodi())
						|| (llista[i].getOpcionsBeca()[1] == beques[j]
								.getCodi())
						|| (llista[i].getOpcionsBeca()[2] == beques[j]
								.getCodi()))
					trobat = true;
				j++;
			}
			if (!trobat) {
				codis[z] = beques[j - 1].getCodi();
				z++;
			} else
				trobat = false;
			i++;
		}
		int[] retorna = new int[z];
		retorna = codis;
		return (retorna);

	}

	/**
	 * Metode per a ordenar la llista de solicituds de major nota mitja a menor
	 */
	public void ordenarSolicitudsNota() {
		int j = 0;
		int posNota = 0;
		float notaMax;
		Solicitud aux;
		for (int i = 0; i < nSolicituds; i++) {
			j = i;
			notaMax = 0;
			while (j < nSolicituds) {
				if (llista[j].getNotaMitja() > notaMax) {
					notaMax = llista[j].getNotaMitja();
					posNota = j;
				}
				j++;
			}
			aux = llista[posNota];
			llista[posNota] = llista[i];
			llista[i] = aux;
		}
	}

	/**
	 * metode per assignar totes les beques possibles a les solicituds segons la
	 * seva nota mitja i les seves prioritats
	 * 
	 * @param bAcceptades
	 *            es la llista de beques que ja estan assignades a una solicitud
	 * @param bPendents
	 *            es la llista de beques que estem mirant d'assignar
	 */
	public void assignarBeques(LlistaBeca bAcceptades, LlistaBeca bPendents) {
		int i = 0, j = 0, pos, pos2, codi = 0;
		Beca beca;
		int[] codis;

		ordenarSolicitudsNota();
		while (i < nSolicituds) {
			while (j < 3 && !llista[i].getEstat()) {
				codis = llista[i].getOpcionsBeca();
				codi = codis[j];
				pos = bPendents.getBeca(codi);
				if (pos != -1) {
					int[] opcions = new int[3];
					opcions[0] = llista[i].getOpcionsBeca()[j];
					opcions[1] = opcions[0];
					opcions[2] = opcions[0];
					llista[i].setOpcionsBeca(opcions);
					try {
						beca = bPendents.consultarBeca(opcions[0]);
						pos2 = bAcceptades.getBeca(opcions[0]);
						if (pos2 == -1) {
							beca.setPlaces(1);
							bAcceptades.afegirBeca(beca);
						} else
							bAcceptades.consultarBeca(opcions[0]).setPlaces(
									beca.getPlaces() + 1);
						bPendents.decrementarPlaces(opcions[0]);
						System.out
								.println("S'ha acceptat la solicitud a nom de: "
										+ llista[i].getNom()
										+ " amb nota mitja: "
										+ llista[i].getNotaMitja()
										+ "\nSe li ha assignat la beca: "
										+ bAcceptades.consultarBeca(opcions[0])
												.toString());
						llista[i].setEstat();
					} catch (NoTrobat e) {
					}
				}
				j++;
			}
			j = 0;
			i++;
		}

	}

	/**
	 * Mètode per carregar les solicituds des d'un fitxer
	 */
	public void carregarSolicitud() {
		try {
			Scanner lectura = new Scanner(new File("SolicitudsCarregar.txt"));
			lectura.useDelimiter(",");
			while (lectura.hasNext()) {
				String nom = lectura.next();
				String dni = lectura.next();
				String ensenyament = lectura.next();
				float notaMitja = Float.parseFloat(lectura.next());
				String idioma = lectura.next();
				int[] opcionsBeca = new int[3];
				opcionsBeca[0] = Integer.parseInt(lectura.next());
				opcionsBeca[1] = Integer.parseInt(lectura.next());
				opcionsBeca[2] = Integer.parseInt(lectura.next());

				Solicitud solicitud = new Solicitud(nom, dni, ensenyament,
						notaMitja, idioma, opcionsBeca);
				novaSolicitud(solicitud);
			}
			lectura.close();
		} catch (FileNotFoundException e) {

			System.out.println("El fitxer no existeix");
		}
	}

	/**
	 * Mètode per guardar les solicituds en un fitxer
	 */
	public void guardarSolicitud() {
		try {
			BufferedWriter escriptura = new BufferedWriter(new FileWriter(
					"SolicitudsGuardar.txt"));

			for (int i = 0; i < nSolicituds; i++) {
				Solicitud s = llista[i];
				escriptura.write(s.toStringFitxer());
			}
			escriptura.close();
		} catch (IOException e) {
			System.out.println("No es pot escriure");
		}
	}

}
