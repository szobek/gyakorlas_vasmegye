package gyakorlas;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Szuletes> szuletesiLista = new ArrayList<Szuletes>();
	public static void main(String[] args) {
FileHandling.readFile("vas.txt",szuletesiLista);

	int nemAzonosito=0;

	for (Szuletes szuletes : szuletesiLista) {
		String nem = szuletes.getNeme();
		String szuletesiIdõ = szuletes.getSzuletesiIdo();
		
		if ((nem.equals("férfi")) && (szuletesiIdõ.charAt(0)=='9')) {
			nemAzonosito=1;	
		}
		if ((nem.equals("férfi")) && (szuletesiIdõ.charAt(0)=='2')) {
			nemAzonosito=3;	
		}
		if ((nem.equals("nõ")) && (szuletesiIdõ.charAt(0)=='9')) {
			nemAzonosito=2;	
		}
		if ((nem.equals("nõ")) && (szuletesiIdõ.charAt(0)=='2')) {
			nemAzonosito=4;	
		}
		
		String sor = nemAzonosito+"-"+szuletes.getSzuletesiIdo()+"-"+szuletes.getAzonosNapiKod()+szuletes.getEllenorzoKarakter();
		System.out.println(sor+" "+Szuletes.CdvE11(sor));
	}

	}
}
