package gyakorlas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
	static List<Szuletes> szuletesiLista = new ArrayList<Szuletes>();

	public static void main(String[] args) {
		FileHandling.readFile("vas.txt", szuletesiLista);
		new Main().sumAllBabiesBetweenDates("900101", "990101");
	}

	private void sumAllBabiesBetweenDates(String startDate, String endDate) {
		int szuletett = 0;
		try {
			Date from = new SimpleDateFormat("yyMMdd").parse(startDate);
			Date to = new SimpleDateFormat("yyMMdd").parse(endDate);
			for(Szuletes szuletes:szuletesiLista) {
				//System.out.println(szuletes.getSzuletesiIdo());
				Date szuletettACsecsemo = new SimpleDateFormat("yyMMdd").parse(szuletes.getSzuletesiIdo());
				if(szuletettACsecsemo.after(from) && szuletettACsecsemo.before(to)) {
					szuletett++;
				}
				
			}
			System.out.println("Vas megyében a vizsgált dátumok alatt "+szuletett+" csecsemõ született");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
