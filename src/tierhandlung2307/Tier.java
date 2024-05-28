package tierhandlung2307;

public class Tier {
	private String name;
	private int alter;
	private int satt;
	private int index;
	
	public Tier(String name, int alter, int satt) {
		this.name = name;
		this.alter = alter;
		this.satt = satt;

	}
	
	public Tier(String name) {
		this.name = name;
		this.alter = -1;
	}

	public String getName() {
		return this.name;
	}
	public int getAlter() {
		return this.alter;
	}
	public int getSatt() { return this.satt; }
	public int getIndex() { return this.index;}
	
	public String ausgabe() {
		String ausgabe = "Name: ";
		ausgabe = ausgabe + this.name;
		ausgabe = ausgabe + "\n";
		ausgabe = ausgabe + "Alter: " + this.alter;
		ausgabe = ausgabe + "\n";
		ausgabe = ausgabe + "Gefüttert " + this.satt;
		return ausgabe;
	}

	public String deleteAusgabe(int index) {
		return "ID: " + (index + 1) + ", Name: " + this.name;
	}
	
	
}
