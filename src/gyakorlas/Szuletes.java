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
		this.szuletesiIdo = csvSor.substring(2,8);
		this.azonosNapiKod = csvSor.substring(9,12);
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
	
	public String getNeme() {
		return neme;
	}

	public String getSzuletesiIdo() {
		return szuletesiIdo;
	}

	public String getAzonosNapiKod() {
		return azonosNapiKod;
	}

	public char getEllenorzoKarakter() {
		return ellenorzoKarakter;
	}

	public static boolean CdvE11(String csvSor) {
		int[] k = new int[11];
		k[1]=10*Integer.parseInt(csvSor.substring(0,1));
		k[2]=9*Integer.parseInt(csvSor.substring(2,3));
		k[3]=8*Integer.parseInt(csvSor.substring(3,4));
		k[4]=7*Integer.parseInt(csvSor.substring(4,5));
		k[5]=6*Integer.parseInt(csvSor.substring(5,6));
		k[6]=5*Integer.parseInt(csvSor.substring(6,7));
		k[7]=4*Integer.parseInt(csvSor.substring(7,8));
		k[8]=3*Integer.parseInt(csvSor.substring(9,10));
		k[9]=2*Integer.parseInt(csvSor.substring(10,11));
		k[10]=1*Integer.parseInt(csvSor.substring(11,12));
		k[0]=Integer.parseInt(csvSor.substring(12));
		return ((k[1]+k[2]+k[3]+k[4]+k[5]+k[6]+k[7]+k[8]+k[9]+k[10])%11==k[0]);
	}

	
}
