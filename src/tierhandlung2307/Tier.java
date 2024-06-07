package tierhandlung2307;

public class Tier {
	private String name;
	private int alter;
	private int satt;
	private int id;
	
	public Tier(String name, int alter, int satt, int id) {
		this.name = name;
		this.alter = alter;
		this.satt = satt;
		this.id = id;
	}

	public void fuettern() {
		System.out.println(name + " muss gefüttert werden");
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() { return this.id;}

	public void setName(String name){
		this.name = name;
	}
	public String getName() {
		return "Name: " + this.name;
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

	public String ausgabe() {
		System.out.print("_______________________________\n");
        return "Name: " + getName() + "\n" +
				"Alter: " + getAlter() + "\n" +
				"Satt: " + getSatt() + "\n" +
				"ID: " + getId();
	}

//	public String deleteAusgabe(int index) {
//		return "ID: " + (index + 1) + ", Name: " + this.name;
//	}
}

