package gyakorlas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
	static List<Szuletes> szuletesiLista = new ArrayList<Szuletes>();

	public static void main(String[] args) {
		FileHandling.readFile("vas.txt", szuletesiLista);

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
			// System.out.println(sor + " " + Szuletes.CdvE11(sor));
		}
		// new Main().sumAllBabiesBetweenDates("900101", "990101");
		// new Main().writeYearsFromStartToEnd("1999-12-10", "2020-11-01" );
		new Main().statisticByYear();
	}

	private void sumAllBabiesBetweenDates(String startDate, String endDate) {
		int szuletett = 0;
		try {
			Date from = new SimpleDateFormat("yyMMdd").parse(startDate);
			Date to = new SimpleDateFormat("yyMMdd").parse(endDate);
			for (Szuletes szuletes : szuletesiLista) {
				// System.out.println(szuletes.getSzuletesiIdo());
				Date szuletettACsecsemo = new SimpleDateFormat("yyMMdd").parse(szuletes.getSzuletesiIdo());
				if (szuletettACsecsemo.after(from) && szuletettACsecsemo.before(to)) {
					szuletett++;
				}

			}
			System.out.println("Vas megyében a vizsgált dátumok alatt " + szuletett + " csecsemõ született");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void writeYearsFromStartToEnd(String startDate, String endDate) {
		try {
			LocalDate fromDate = LocalDate.parse(startDate);
			LocalDate toDate = LocalDate.parse(endDate);
			System.out.println(fromDate.getYear() + " - " + toDate.getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void statisticByYear() {

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
			System.out.println(mapItem.getKey() +" - "+mapItem.getValue()+" fõ" );
		}
	}

}
