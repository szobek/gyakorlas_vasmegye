package gyakorlas;

public class Szuletes {
	private String neme;
	private String szuletesiIdo;
	private String azonosNapiKod;
	private char ellenorzoKarakter;

	public Szuletes(String neme, String szuletesiIdo, String azonosNapiKod, char ellenorzoKarakter) {
		this.neme = neme;
		this.szuletesiIdo = szuletesiIdo;
		this.azonosNapiKod = azonosNapiKod;
		this.ellenorzoKarakter = ellenorzoKarakter;
	}

	public Szuletes(String csvSor) {
		this.neme = setSex(csvSor.charAt(0));
		this.szuletesiIdo = csvSor.substring(2,7);
		this.azonosNapiKod = csvSor.substring(9,11);
		this.ellenorzoKarakter = csvSor.charAt(12);
	}

	private String setSex(char nem) {
		String sex = "";
		switch (nem) {
			case '1', '3' -> sex = "férfi";
			case '2', '4' -> sex = "nõ";
		}
		return sex;

	}
}
