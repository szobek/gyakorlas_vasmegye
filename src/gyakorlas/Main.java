package gyakorlas;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Szuletes> szuletesiLista = new ArrayList<Szuletes>();
	static String sor = null;
	static int nemAzonosito = 0;
	static int[] evSzamHatarertekek = new int[2];

	public static void main(String[] args) {
		FileHandling.readFile("vas.txt", szuletesiLista);
		System.out.println("4. FELADAT:");
		nemMegfeleloAzonositokTorlese();
		
		System.out.println("7. FELADAT:");
		evSzamHatarertekek= evszamHatarertek();
		System.out.println(evSzamHatarertekek[0]+"-"+evSzamHatarertekek[1]);
	}

	public static void nemMegfeleloAzonositokTorlese() {
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

	public static int[] evszamHatarertek() {
		int[] minMax = new int[2];
		int evMeghataroz=0;
		
		for (int i = 0; i < szuletesiLista.size(); i++) {
			String szuletesiIdõ = szuletesiLista.get(i).getSzuletesiIdo();
			
			
			if (szuletesiIdõ.charAt(0) == '9') { //eleg ennyit vizsgalni, mivel 1997 utáni értékek lehetnek az evszamok
				evMeghataroz = 1900 + Integer.parseInt(szuletesiIdõ.substring(0,2));
				System.out.println(evMeghataroz+"::"+ Integer.parseInt(szuletesiIdõ.substring(0,2)));
				}
			if (szuletesiIdõ.charAt(0) != '9') {
				evMeghataroz = 2000 + Integer.parseInt(szuletesiIdõ.substring(0,2));		
				System.out.println(evMeghataroz+"::"+ Integer.parseInt(szuletesiIdõ.substring(0,2)));

				}
			if (i==0) { //tomb kezdoertekeinek megadasa
				minMax[0]=evMeghataroz;
				minMax[1]=evMeghataroz;
				
			}
			if (evMeghataroz>minMax[1]) {
				minMax[1]=evMeghataroz;
				}
			if (evMeghataroz<minMax[0]) {
				minMax[0]=evMeghataroz;
				}

		}
		return minMax;
	}

}
