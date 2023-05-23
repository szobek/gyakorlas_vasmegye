package gyakorlas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

public class FileHandling {

	public static void readFile(String file, List<Szuletes> szuletesiLista) {
		System.out.println("Feladat 2: adatok beolvasása, tárolás");
		try (BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"))){
			while (br.ready()) {
				
				szuletesiLista.add(new Szuletes(br.readLine())); 
			}
		} catch (Exception e) {
			System.out.println("Hiba van!");
		}
		
	}
}
