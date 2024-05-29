package tierhandlung2307;

public class Tier {
	private String name;
	private int alter;
	private int satt;
	private int index;
	
	public Tier(String name, int alter, int satt) {
		this.name = name;
		this.alter = -1;
		this.satt = satt;

	}

	public void fuettern() {
		System.out.println(name + " muss gefüttert werden");
	}

	public int getIndex() { return this.index;}

	public void setName(String name){
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setAlter(int alter){
		this.alter = alter;
	}
	public int getAlter() {
		return this.alter;
	}

	public void setSatt(int satt){
		this.satt = satt;
	}
	public int getSatt() {
		return this.satt;
	}

//	public String deleteAusgabe(int index) {
//		return "ID: " + (index + 1) + ", Name: " + this.name;
//	}
}

