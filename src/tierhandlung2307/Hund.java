package tierhandlung2307;

import java.util.Arrays;

public class Hund extends Tier {
	boolean entwurmt;
	String[] kommandos;
	
	public Hund (String name, int alter, int satt, int id, boolean entwurmt, String[] kommandos) {
		super(name, alter, satt, id);
		this.entwurmt = entwurmt;
		this.kommandos = kommandos;
	}

	public boolean getEntwurmt() {
		return entwurmt;
	}

	public void setEntwurmt(boolean entwurmt) {
		this.entwurmt = entwurmt;
	}
	public String[] getKommandos() {
		return kommandos;
	}
	public void setKommandos(String[] kommandos) {
		this.kommandos = kommandos;
	}

	public void entwurmen() {
		System.out.println("Entwurmt Angabe hier" + this.getName());
	}

	public void gassiGehen() {
		System.out.println("Gassi gehen mit: " + this.getName());
	}
	public String ausgabeHund() {
		System.out.print("_______________________________\n");
		String ausgabe = "Entwurmt: ";
		ausgabe = ausgabe + getEntwurmt();
		ausgabe = ausgabe + "\n";
		ausgabe = ausgabe + "Kommandos: " + Arrays.toString(getKommandos());
		ausgabe = ausgabe + "\n";
		ausgabe = ausgabe + "Satt: " + getSatt();
		ausgabe = ausgabe + "\n";
		ausgabe = ausgabe + "ID: " + getId();


		return ausgabe;
	}
}
