package gyakorlas;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Szuletes> szuletesiLista = new ArrayList<Szuletes>();

	public static void main(String[] args) {
		FileHandling.readFile("vas.txt", szuletesiLista);

		
		new Main().run();
	}

	private void run() {
		Feladatok f = new Feladatok(szuletesiLista);

		f.adrianCucca();
		f.babyInLeapDay();
	}

	

	

	

}
