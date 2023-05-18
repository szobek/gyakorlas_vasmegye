package gyakorlas;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Szuletes> szuletesiLista = new ArrayList<Szuletes>();
	static String sor = null;
	static int nemAzonosito = 0;
	
	public static void main(String[] args) {
		FileHandling.readFile("vas.txt", szuletesiLista);
		nemMegfeleloAzonositokTorlese();
		}

	public static void nemMegfeleloAzonositokTorlese() {
		System.out.println("4. FELADAT:");
		for (int i = 0; i < szuletesiLista.size(); i++) {
			String nem = szuletesiLista.get(i).getNeme();
			String szuletesiIdõ = szuletesiLista.get(i).getSzuletesiIdo();

			if ((nem.equals("férfi")) && (szuletesiIdõ.charAt(0) == '9')) {
				nemAzonosito = 1;
				}
			if ((nem.equals("férfi")) && (szuletesiIdõ.charAt(0) == '2')) {
				nemAzonosito = 3;
				}
			if ((nem.equals("nõ")) && (szuletesiIdõ.charAt(0) == '9')) {
				nemAzonosito = 2;
				}
			if ((nem.equals("nõ")) && (szuletesiIdõ.charAt(0) == '2')) {
				nemAzonosito = 4;
				}

			sor = nemAzonosito + "-" + szuletesiLista.get(i).getSzuletesiIdo() + "-"
					+ szuletesiLista.get(i).getAzonosNapiKod() + szuletesiLista.get(i).getEllenorzoKarakter();

			if (!(Szuletes.CdvE11(sor))) {
				szuletesiLista.remove(i);
				}	
		}

		System.out.println("Rossz adatok törölve.");
	
	}

}

