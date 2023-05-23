package gyakorlas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Feladatok {
	
	static List<Szuletes> szuletesiLista;
	static int[] evSzamHatarertekek = new int[2];
	static String sor = null;
	static int nemAzonosito = 0;
	
	public Feladatok(List<Szuletes> szuletesiLista) {
		Feladatok.szuletesiLista=szuletesiLista;
	}
	/**
	 * Chech the year is leao
	 * 
	 * @param datum
	 * @param kod
	 * @return
	 */
	private boolean isLeapYear(String datum, char kod) {
		String szuletesiDatum = "";
		switch (kod) {
		case '1', '2' -> szuletesiDatum = "19" + datum.substring(0, 2);
		case '3', '4' -> szuletesiDatum = "20" + datum.substring(0, 2);
		}
		return (Integer.parseInt(szuletesiDatum) % 4) == 0;
	}

	public void babyInLeapDay() {
		System.out.print("Feladat 8: ");
		int i = 0;

		boolean leap = isLeapYear(szuletesiLista.get(i).getSzuletesiIdo(), szuletesiLista.get(i).getSzemelyKod());
		boolean dateEnd = szuletesiLista.get(i).getSzuletesiIdo().substring(2, 6).equals("0224");
		while (leap && !dateEnd && i < szuletesiLista.size() - 1) {
			i++;
		}
		if (i < szuletesiLista.size()) {
			System.out.println("Szökõnapon született baba");
		} else {
			System.out.println("nem találtam");

		}


	}
	
	public void writeYearsFromStartToEnd(String startDate, String endDate) {
		try {
			LocalDate fromDate = LocalDate.parse(startDate);
			LocalDate toDate = LocalDate.parse(endDate);
			System.out.println(fromDate.getYear() + " - " + toDate.getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void statisticByYear() {
		System.out.print("Feladat 9: ");
		Map<String, Integer> map = new TreeMap<String, Integer>();
		System.out.println(" Statistika");
		for (Szuletes szuletesItem : szuletesiLista) {
			String szuetesiDatum = "";

			switch (szuletesItem.getSzemelyKod()) {
			case '1', '2' -> szuetesiDatum = "19" + szuletesItem.getSzuletesiIdo().substring(0, 2);
			case '3', '4' -> szuetesiDatum = "20" + szuletesItem.getSzuletesiIdo().substring(0, 2);
			}

			if (!map.containsKey(szuetesiDatum)) {
				map.put(szuetesiDatum, 1);
			} else {
				map.replace(szuetesiDatum, map.get(szuetesiDatum), map.get(szuetesiDatum) + 1);
			}
		}

		for (Entry<String, Integer> mapItem : map.entrySet()) {
			System.out.println(mapItem.getKey() + " - " + mapItem.getValue() + " fõ");
		}
	}
	
	public void sumAllBabiesBetweenDates(String startDate, String endDate) {
		System.out.print("Feladat 5: ");
		int szuletett = 0;
		try {
			Date from = new SimpleDateFormat("yyMMdd").parse(startDate);
			Date to = new SimpleDateFormat("yyMMdd").parse(endDate);
			for (Szuletes szuletes : szuletesiLista) {
				Date szuletettACsecsemo = new SimpleDateFormat("yyMMdd").parse(szuletes.getSzuletesiIdo());
				if (szuletettACsecsemo.after(from) && szuletettACsecsemo.before(to)) {
					szuletett++;
				}

			}
			System.out.println("Vas megyében a vizsgált dátumok alatt " + szuletett + " csecsemõ született");
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	public void getBoysFromList() {
		System.out.print("Feladat 6: ");
		int boys=0;
		for(Szuletes szuletes:szuletesiLista) {
			if(szuletes.getSzemelyKod()=='1' ||szuletes.getSzemelyKod()=='3') {
				boys++;
			}
		}
		
		System.out.println("Fiúk száma: "+boys);
	}
	
	
	
	
	public void adrianCucca() {
		int nemAzonosito = 0;

		for (Szuletes szuletes : szuletesiLista) {
			String nem = szuletes.getNeme();
			String szuletesiIdõ = szuletes.getSzuletesiIdo();

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

			String sor = nemAzonosito + "-" + szuletes.getSzuletesiIdo() + "-" + szuletes.getAzonosNapiKod()
					+ szuletes.getEllenorzoKarakter();
			 System.out.println(sor + " " + Szuletes.CdvE11(sor));
		}
		
	}
	
	
	public static int[] evszamHatarertek() {
		int[] minMax = new int[2];
		int evMeghataroz=0;
		
		try {
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return minMax;
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
	
	public void a4esFeladatByAdrian() {
		System.out.println("4. FELADAT:");
		nemMegfeleloAzonositokTorlese();
		
		
	}
	
	public void a7esFeladatByAdian() {
		System.out.print("7. FELADAT: ");
		evSzamHatarertekek= evszamHatarertek();
		System.out.println("Vizsgált idõszak: "+evSzamHatarertekek[0]+"-"+evSzamHatarertekek[1]);
	}
	
	
	
	
	
}

