package gyakorlas;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Szuletes> szuletesiLista = new ArrayList<Szuletes>();
	public static void main(String[] args) {
		

		
		new Main().run();
	}

	private void run() {
		Feladatok f = new Feladatok(szuletesiLista);
		FileHandling.readFile("vas.txt", szuletesiLista);
		f.a4esFeladatByAdrian();
		f.sumAllBabiesBetweenDates("7110101", "991231");
		f.getBoysFromList();
		f.a7esFeladatByAdian();
		//f.adrianCucca();
		f.babyInLeapDay();
		f.statisticByYear();
	}

	

	

	

}
