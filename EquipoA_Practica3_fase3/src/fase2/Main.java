package fase2;
import java.util.*;

import exception.NoTrobat;
import gui.Finestra;

public class Main {

	static Scanner teclat = new Scanner(System.in);

	/**
	 * Menu que es mostrara per pantalla referent a les Beques
	 */

	public static void Menu1() {
		System.out.println("\n\nMENU BECA:");
		System.out.println("\n\t1. Afegir Beca");
		System.out.println("\t2. Eliminar Beca");
		System.out
				.println("\t3. Editar dades beca(durada i nombre de places) ");
		System.out.println("\t4. Consultar informacio beca a partir del codi");
		System.out
				.println("\t5. Consultar les beques disponibles a un cert pais");
		System.out
				.println("\t6. Consultar la quantitat total de diners de la beca ERASMUSPlus");
		System.out
				.println("\t7. Consultar beques segons idiomes pel cas de ERASMUPlus i ISEP");
		System.out
				.println("\t8. Carregar la informacio de les noves beques des d'un fixer de text");
		System.out.println("\t9. Guardar la llista de beques en un fixer");
		System.out.println("\t10. Assignar beques");
		System.out.println("\t11. Sortir");
		System.out.print("\n\t\t\tQuina opcio vols escollir?:\n");
	}

	/**
	 * Menu que es mostrara per pantalla referent a les4 Solicituds
	 */

	public static void Menu2() {
		System.out.println("\n\nMENU SOLICITUD:");
		System.out.println("\n\t1. Afegir Solicitut");
		System.out
				.println("\t2. Consultar una solicitud a partir del codi de beca");
		System.out
				.println("\t3. Consultar quantes solicituds hi ha d'alumnes d'un cert ensenyament");
		System.out
				.println("\t4. Consultar quines beques no tenen cap solicitud");
		System.out.println("\t5. Carregar des d'un fixer les solicituds");
		System.out.println("\t6. Guardar solicituds en un fixer de text");
		System.out.println("\t7. Sortir");
		System.out.print("\n\t\t\tQuina opcio vols escollir?:\n");
	}

	// *Metodes Beca
	public static int llegirEnter() {
		boolean comprobat = false;
		int valor = 0;
		while (!comprobat) {
			try {
				String s = teclat.next();
				valor = Integer.parseInt(s);
				comprobat = true;
			} catch (NumberFormatException e) {
				System.out.print("Error en el format del codi\n");
			}
		}
		return valor;
	}

	public static void afegirBeca(LlistaBeca llistaBeca) {
		int codi, durada, places, nEnsenyaments, dotacioMensual;
		System.out.println("Introdueix el codi de la beca");
		codi = llegirEnter();
		System.out
				.println("Introdueix el programa per al qual vols solicitar la beca");
		String programa = teclat.next();
		teclat.nextLine();
		System.out.println("Introdueix el nom de la universitat desti");
		String universitat = teclat.nextLine();
		System.out.println("Introdueix el nom del pais \n  Països permesos: \n *ISEP: EUA i Puerto Rico \n *ERASMUS MUNDUS: Geòrgia, Azerbaitjan, Armènia, Ucraïna, Moldàvia, Bielorússia");
		String pais = teclat.nextLine();

		if (programa.equalsIgnoreCase("ERASMUSPlus")) {

			System.out.println("Introdueix la durada");
			durada = llegirEnter();
			System.out.println("Introdueix el numero de places");
			places = llegirEnter();
			System.out
					.println("A quants ensenyaments s'ofereix la beca en questio");
			nEnsenyaments = llegirEnter();
			String[] llistaensenyaments = new String[nEnsenyaments];
			for (int i = 0; i < nEnsenyaments; i++) {
				System.out
						.println("Introdueix l'ensenyament on s'ofereix un per un");
				String ensenyament = teclat.next();
				llistaensenyaments[i] = ensenyament;
			}
			System.out.println("Introdueix una dotacio mensual");
			dotacioMensual = llegirEnter();

			while ((dotacioMensual < 200) && (dotacioMensual > 500)) {
				System.out.println("Valor fora de l'interval ");
				System.out.println("Introdueix una dotacio mensual");
				dotacioMensual = llegirEnter();

			}
			System.out.println("Valor dintre de l'interval");
			System.out.println("Introdueix l'idioma");
			String idioma = teclat.next();
			ErasmusPlus beca = new ErasmusPlus(idioma, codi, programa,
					universitat, pais, durada, places, llistaensenyaments,
					dotacioMensual, 0, nEnsenyaments);
			llistaBeca.afegirBeca(beca);
		}
		if (programa.equalsIgnoreCase("MOU")) {
			System.out.println("Introdueix la durada");
			durada = llegirEnter();
			System.out.println("Introdueix el numero de places");
			places = llegirEnter();
			System.out
					.println("A quants ensenyaments s'ofereix la beca en questio");
			nEnsenyaments = llegirEnter();
			String[] llistaensenyaments = new String[nEnsenyaments];
			for (int i = 0; i < nEnsenyaments; i++) {
				System.out
						.println("Introdueix l'ensenyament on s'ofereix un per un");
				String ensenyament = teclat.next();
				llistaensenyaments[i] = ensenyament;
			}
			int dotacioViatge = 600;

			MOU beca = new MOU(codi, programa, universitat, pais, durada,
					places, llistaensenyaments, 0, dotacioViatge, nEnsenyaments);
			llistaBeca.afegirBeca(beca);

		}

		if (programa.equalsIgnoreCase("ISEP")) {
			System.out.println("Introdueix la durada");
			durada = llegirEnter();
			System.out.println("Introdueix el numero de places");
			places = llegirEnter();
			System.out
					.println("A quants ensenyaments s'ofereix la beca en questio");
			nEnsenyaments = llegirEnter();
			String[] llistaensenyaments = new String[nEnsenyaments];
			for (int i = 0; i < nEnsenyaments; i++) {
				System.out
						.println("Introdueix l'ensenyament on s'ofereix un per un");
				String ensenyament = teclat.next();
				llistaensenyaments[i] = ensenyament;
			}
			int dotacioViatge = 600;
			dotacioMensual = 500;
			if ((pais.equalsIgnoreCase("EUA"))
					|| (pais.equalsIgnoreCase("PuertoRico"))) {
				System.out.println("S'ha afegit correctament");
				Isep beca = new Isep(codi, programa, universitat, pais, durada,
						places, llistaensenyaments, dotacioMensual,
						dotacioViatge, nEnsenyaments);
				llistaBeca.afegirBeca(beca);

			}

			else
				System.out.println("No s'ha afegit correctament");
		}

		if (programa.equalsIgnoreCase("ERASMUSMundus")) {
			System.out.println("Introdueix la durada");
			durada = llegirEnter();
			System.out.println("Introdueix el numero de places");
			places = llegirEnter();
			System.out
					.println("A quants ensenyaments s'ofereix la beca en questio");
			nEnsenyaments = llegirEnter();
			String[] llistaensenyaments = new String[nEnsenyaments];
			for (int i = 0; i < nEnsenyaments; i++) {
				System.out
						.println("Introdueix l'ensenyament on s'ofereix un per un");
				String ensenyament = teclat.next();
				llistaensenyaments[i] = ensenyament;
			}
			dotacioMensual = 500;
			if ((pais.equalsIgnoreCase("Georgia"))
					|| (pais.equalsIgnoreCase("Azerbaitzan"))
					|| (pais.equalsIgnoreCase("Armenia"))
					|| (pais.equalsIgnoreCase("Ucrania"))
					|| (pais.equalsIgnoreCase("Moldavia"))
					|| (pais.equalsIgnoreCase("Bielorusia"))) {
				System.out.println("S'ha pogut introduir");
				ErasmusMundus beca = new ErasmusMundus(codi, programa,
						universitat, pais, durada, places, llistaensenyaments,
						dotacioMensual, 0, nEnsenyaments);
				llistaBeca.afegirBeca(beca);

			} else
				System.out.println("No s'ha pogut introduir");

		}

	}

	public static void eliminarBeca(LlistaBeca llistaBeca) {
		int codi;
		System.out
				.println("Introdueix el identificador de la beca que vols consultar");
		codi = llegirEnter();
		try {
			llistaBeca.eliminarBeca(codi);
			System.out.println("Beca borrada correctamente");
		} catch (NoTrobat e) {
			System.out.println("Beca no trobada");
		}
	}

	public static void modificarDadesBeca(LlistaBeca llistaBeca) {
		int codi, durada, places;
		System.out
				.println("Introdueix el identificador de la beca que vols consultar");
		codi = llegirEnter();

		int retorna = llistaBeca.getBeca(codi);

		if (retorna != -1) {
			System.out.println("Introdueix la nova durada de la beca");
			durada = llegirEnter();
			System.out.println("Introdueix el nou nombre de places");
			places = llegirEnter();
			try {
				llistaBeca.editarDuradaBeca(codi, durada);
				llistaBeca.editarPlacesBeca(codi, places);
				System.out.println("S'ha modificat la beca");
			} catch (NoTrobat e) {
				System.out.println("Beca no trobada");
			}
		}

		else

			System.out
					.println("La beca amb aquest codi identificador no existeix");

	}

	public static void consultarInfoBeca(LlistaBeca llistaBeca) {
		int codi;
		System.out.println("Diguem el codi de la teva beca");
		codi = llegirEnter();
		try {
			Beca beca2 = llistaBeca.consultarBeca(codi);
			System.out.println(beca2);
		} catch (NoTrobat e) {
			System.out.println("No s'ha trobat una beca");
		}
	}

	public static void consultarBecaPais(LlistaBeca llistaBeca) {
		System.out.println("Introdueix el pais que vols consultar");
		String pais = teclat.nextLine();
		try {
			Beca[] beques = llistaBeca.llistaBequesPais(pais);
			for (int i = 0; i < beques.length; i++) {
				System.out.println(beques[i].toString());
			}

		} catch (NoTrobat e) {
			System.out.println("No s'ha trobat una beca");
		}

	}

	public static void consultarDinersErasmusPlus(LlistaBeca llistaBeca) {
		int codi;
		System.out
				.println("Consultar la quantitat total de diners d’una beca ERASMUS+, introdueix el codi de la beca");
		codi = llegirEnter();
		try {
			System.out.println(llistaBeca.consultarDotacioErasmusPlus(codi));
		} catch (NoTrobat e) {
			System.out.println("Beca no trobada");
		}

	}

	public static void getNumBequesAmbIdioma(LlistaBeca llistabeca) {

		System.out.println("Introdueix l'idioma que vols consultar:");
		String idioma = teclat.nextLine();
		idioma = teclat.nextLine();
		try {
			int[] beques = llistabeca.consultarBequesAmbIdioma(idioma);
			System.out
					.println("Els codis de les beques amb aquest idioma són: ");
			for (int i = 0; i < beques.length; i++)
				System.out.println(beques[i]);
		} catch (NoTrobat e) {
			System.out.println("Beca no trobada");
		}

	}

	public static void carregarBeques(LlistaBeca llistaBeca) {
		llistaBeca.carregarBeques();
	}

	public static void exportarBeques(LlistaBeca llistaBeca) {
		llistaBeca.exportarBeques();
	}

	public static void assignarBeques(LlistaBeca bAcceptades,
			LlistaBeca llistaBeca, LlistaSolicitud llistaSolicitud) {
		llistaSolicitud.assignarBeques(bAcceptades, llistaBeca);
	}

	// *Metodes Solicitud

	public static void novaSolicitud(LlistaSolicitud llistaSolicitud) {
		String nom, dni, ensenyament, idioma;
		int opcions;
		float notaMitja;
		int[] opcionsBeca = new int[3];

		System.out.println("Introdueix el nom:");
		nom = teclat.nextLine();
		teclat.nextLine();
		System.out.println("Introdueix el dni:");
		dni = teclat.nextLine();
		System.out.println("Introduix l'ensenyament:");
		ensenyament = teclat.nextLine();
		System.out.println("Introduix la nota mitja:");
		notaMitja = teclat.nextFloat();
		System.out.println("Introduix l'idioma:");
		idioma = teclat.nextLine();
		teclat.nextLine();
		System.out.println("Introdueix el nivell del idioma");
		String nivell = teclat.nextLine();
		if ((nivell.equalsIgnoreCase("B2")) || (nivell.equalsIgnoreCase("C1"))
				|| (nivell.equalsIgnoreCase("C2"))) {
			System.out.println("El teu nivell d'angles compleix els requisits");

			System.out
					.println("Introdueix el numero de opcions de beca que vols introduir");
			opcions = llegirEnter();
			int i = 0;
			while ((i < opcions) && (opcions <= 3)) {
				System.out.println("Introdueix opció de beca:");
				opcionsBeca[i] = teclat.nextInt();
				i++;

			}

			Solicitud solicitud = new Solicitud(nom, dni, ensenyament,
					notaMitja, idioma, opcionsBeca);
			llistaSolicitud.novaSolicitud(solicitud);
		} else
			System.out
					.println("El teu nivell d'angles no compleix els requisits");

	}

	public static void consultarSolicitudsBeca(LlistaSolicitud llistaSolicitud) {
		int codi;
		System.out.println("Introdueix el codi de la beca que vols consultar:");
		codi = llegirEnter();
		Solicitud[] retorna = llistaSolicitud.consultarSolicitudsBeca(codi);
		for (int i = 0; i < retorna.length; i++) {
			System.out.println(retorna[i].toString());
		}
	}

	public static void bequesSenseSolicitud(LlistaSolicitud llistaSolicitud,
			LlistaBeca llistaBeca) {

		int[] codis = llistaSolicitud.bequesSenseSolicitud(llistaBeca);
		int i = 0;
		if (codis[i] != 0) {
			System.out
					.println("Els codis de les beques sense cap solicitud són:\n");
			while (i < codis.length) {
				System.out.println(codis[i]);
				i++;
			}
		} else
			System.out.println("No hi ha cap beca sense solicitud");
	}

	public static void getNumBequesEnsenyament(LlistaSolicitud llistaSolicitud) {

		System.out
				.println("Introdueix les sigles de l'ensenyament de la beca que vols consultar:");
		String ensenyament = teclat.next();
		int resultat = llistaSolicitud.getNumBequesEnsenyament(ensenyament);
		System.out.println("El número de beques a aquest ensenyament és: "
				+ resultat);
	}

	public static void carregarSolicitud(LlistaSolicitud llistaSolicitud) {
		llistaSolicitud.carregarSolicitud();
	}

	// 6.Guardar solicituds en fitxer
	public static void guardarSolicitud(LlistaSolicitud llistaSolicitud) {
		llistaSolicitud.guardarSolicitud();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcio;
		int opcio2;
		int numBeques = 100;
		int capacitat = 100;
		LlistaBeca llistaBeca = new LlistaBeca(numBeques);
		LlistaSolicitud llistaSolicitud = new LlistaSolicitud(capacitat);
		LlistaBeca bAcceptades = new LlistaBeca(numBeques);

		System.out.println("\n A quin menu vols tenir acces?:");
		System.out.println("\n\t1. Menu Beca");
		System.out.println("\n\t2. Menu Solicituds");
		System.out.println("\n\t3. GUI beca");
		System.out.println("\n\t4. Sortir");
		int n = teclat.nextInt();

		while (n != 4) {
			while ((n < 0) || (n > 4)) {
				System.out.println("\n Opcio incorrecta");
				System.out.println("\n A quin menu vols tenir acces?:");
				System.out.println("\n\t1. Menu Beca");
				System.out.println("\n\t2. Menu Solicituds");
				System.out.println("\n\t3. GUI beca");
				System.out.println("\n\t4. Sortir");
				n = teclat.nextInt();

			}

			if (n == 1) {
				Menu1();
				opcio = teclat.nextInt();

				while (opcio != 11) {
					switch (opcio) {
					case 1:
						afegirBeca(llistaBeca);
						break;
					case 2:
						eliminarBeca(llistaBeca);
						break;
					case 3:
						modificarDadesBeca(llistaBeca);
						break;
					case 4:
						consultarInfoBeca(llistaBeca);
						break;
					case 5:
						consultarBecaPais(llistaBeca);
						break;
					case 6:
						consultarDinersErasmusPlus(llistaBeca);
						break;
					case 7:
						getNumBequesAmbIdioma(llistaBeca);
						break;
					case 8:
						carregarBeques(llistaBeca);
						break;
					case 9:
						exportarBeques(llistaBeca);
						break;
					case 10:
						assignarBeques(bAcceptades, llistaBeca, llistaSolicitud);

					}

					Menu1();
					opcio = teclat.nextInt();
				}
			}

			if (n == 2) {
				Menu2();
				opcio2 = teclat.nextInt();

				while (opcio2 != 7) {
					switch (opcio2) {
					case 1:
						novaSolicitud(llistaSolicitud);
						break;
					case 2:
						consultarSolicitudsBeca(llistaSolicitud);
						break;
					case 3:
						getNumBequesEnsenyament(llistaSolicitud);
						break;
					case 4:
						bequesSenseSolicitud(llistaSolicitud, llistaBeca);
						break;
					case 5:
						carregarSolicitud(llistaSolicitud);
						break;
					case 6:
						guardarSolicitud(llistaSolicitud);
						break;

					}

					Menu2();
					opcio2 = teclat.nextInt();
				}

			}
			if (n == 3) {
				new Finestra(llistaBeca);
			}
			if (n != 4) {
				System.out.println("\n A quin menu vols tenir acces?:");
				System.out.println("\n\t1. Menu Beca");
				System.out.println("\n\t2. Menu Solicituds");
				System.out.println("\n\t3. GUI beca");
				System.out.println("\n\t4. Sortir");
				n = teclat.nextInt();
			}
		}
	}
}
