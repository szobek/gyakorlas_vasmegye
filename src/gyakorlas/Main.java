package gyakorlas;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Szuletes> szuletesiLista = new ArrayList<Szuletes>();
	public static void main(String[] args) {
FileHandling.readFile("vas.txt",szuletesiLista);
	}
}
