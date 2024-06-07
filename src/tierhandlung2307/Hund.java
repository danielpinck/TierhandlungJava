package tierhandlung2307;

import java.util.Arrays;

public class Hund extends Tier {
	boolean entwurmt;
	String kommandos;
	
	public Hund (String name, int alter, int satt, int id, boolean entwurmt, String kommandos) {
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
	public String getKommandos() {
		return kommandos;
	}
	public void setKommandos(String kommandos) {
		this.kommandos = kommandos;
	}

	public void entwurmen() {
		System.out.println("Entwurmt Angabe hier" + this.getName());
	}

	public void gassiGehen() {
		System.out.println("Gassi gehen mit: " + this.getName());
	}
	@Override
	public String ausgabe() {
	return super.ausgabe() + "\n" + "Entwurmt: " + getEntwurmt() + "\n" + "Kommandos:" + getKommandos();

	}
}
