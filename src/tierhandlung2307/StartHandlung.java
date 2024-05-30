package tierhandlung2307;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StartHandlung {

	Scanner sc = new Scanner(System.in);

	private DBconnection db;
    public StartHandlung() {
        this.db = new DBconnection();
	}

	
	//Tierliste
	private ArrayList<Tier> tierListe = new ArrayList<>();

	//Kundenliste
	private String oeffnungszeiten = "8:49 - 16:30";

	public static void main(String[] args) throws SQLException {


        System.out.println("Willkommen zur Tierhandlung Bieler!");
		StartHandlung start = new StartHandlung();
		System.out.println("Geöffnet: " + start.oeffnungszeiten);
		
//		start.tierListe = start.ladeDaten();
		
		Scanner sc = new Scanner(System.in);
		
		String eingabe = "1";
		while ( !eingabe.equals("0")  ) {
			//Menüausgabe
			System.out.println("1. Tiere anzeigen");
			System.out.println("2. Tiere hinzufügen");
			System.out.println("3. Tiere löschen");
			
			System.out.println("0. Programm beenden");
			
			System.out.println("Bitte Auswahl treffen");
			eingabe = sc.next();
			switch (eingabe) {
				case "1":
					//Aufruf Menü 1
					System.out.println("Beherbergte Tiere: ");
					start.menu1();
					break;
				case "2":
					System.out.println("Tier hinzufügen");
					start.menu2();
					break;
				case "3":
					System.out.println("Tier löschen");
					start.menu3();
					break;
				case "4":
					System.out.println("Menü 4");
					break;
				default:
					System.out.println("Bitte gültige Auswahl treffen");
					System.out.println("-----------------------------");				
					
			}
		}	
	}


	private void menu1() throws SQLException {
//		for (int i = 0; i < this.tierListe.size(); i++) {
//			if (this.tierListe.get(i) != null) {
//				System.out.println(tierListe.get(i).ausgabe() );
//				System.out.println("-----------------------------");
//			}
//		}
		displayAnimals();

	}

	private void menu2() throws SQLException {
		addAnimal();
		System.out.println("Tier erfolgreich angelegt");

	}

	private void menu3() {
//		deleteAnimal();

	}

//	private ArrayList<Tier> ladeDaten() {
//		Tier[] liste = new Tier[100];
//		liste[0] = new Tier("Brutus", 11, 1);
//		liste[1] = new Tier("Chucky", 5, 0);
//		tierListe.add(0, liste[0]);
//		tierListe.add(0, liste[1]);
//		return tierListe;
//	}

	public void displayAnimals() throws SQLException {
		String selectQuery = "SELECT id, name, type, fed FROM animals";
		db.rs = db.stmt.executeQuery(selectQuery);

		// extract data from result set
		while (db.rs.next()) {
			int id = db.rs.getInt("id");
			String name = db.rs.getString("name");
			String type = db.rs.getString("type");
			String fed = db.rs.getString("fed");

			//Display results
			//System.out.print("ID: " + id + " Name: " + name + " Type: " + type + " Fed: " + fed);
			System.out.print("ID: " + id + "\n");
			System.out.print("Name: " + name + "\n");
			System.out.print("Type: " + type + "\n");
			System.out.print("Fed: " + fed + "\n");
		}
	}

	public void addAnimal() throws SQLException{

		System.out.println("Name: ");
		String animalName = sc.nextLine();
		System.out.println("Type: ");
		String animalType = sc.nextLine();
		System.out.println("Age: ");
		String animalAge = sc.nextLine();
		System.out.println("Fed: ");
		String animalFed = sc.nextLine();

		PreparedStatement ps = db.conn.prepareStatement("INSERT INTO animals(name, type, age, fed) VALUES (?, ?, ?, ?)");
		ps.setString(1, animalName);
		ps.setString(2, animalType);
		ps.setString(3, animalAge);
		ps.setString(4, animalFed);
		int row = ps.executeUpdate();
		System.out.println(row);
//		while (rs.next())
//		System.out.println("Tier erfolgreich angelegt");
//		System.out.println(rs.getString("Datensatz für " + rs.getString(1) + " " + rs.getString(2) + "wurde angelegt"));

	}


//	private Tier[] addAnimal() {
//		Scanner sc = new Scanner(System.in);
////		stmt = conn.createStatement();
//		String sql = "SELECT id, name, type, fed FROM animals";
////		ResultSet rs = stmt.executeQuery(sql);
////		INSERT INTO `animals`(`name`, `type`, `fed`) VALUES ('floppi', 'cat', 'true')
//		Tier[] newAnimal = new Tier[1];
//		System.out.println("Name");
//		String animalName = sc.nextLine();
//		System.out.println("Type");
//		int animalAge = Integer.parseInt(sc.nextLine());
//		System.out.println("Fed");
//		int animalFed = Integer.parseInt(sc.nextLine());
//		newAnimal[0] = new Tier(animalName,animalAge, animalFed);
//
//		tierListe.add(newAnimal[0]);
//		return newAnimal;
//	}

//	private void deleteAnimal() {
//
//		System.out.println("Welches Tier soll gelöscht werden? \nGeben Sie die Nummer ein: ");
//		for (int i = 0; i < this.tierListe.size(); i++) {
//			if (this.tierListe.get(i) != null) {
//				System.out.println(tierListe.get(i).deleteAusgabe(i) );
//				System.out.println("-----------------------------");
//			}
//
//		}
//
//		Scanner sc = new Scanner(System.in);
//		int deleteNum = Integer.parseInt(sc.nextLine())-1;
//		if (deleteNum >= 0 && deleteNum < tierListe.size()) {
//			String deletedAnimal = tierListe.get(deleteNum).deleteAusgabe(deleteNum);
//			tierListe.remove(deleteNum);
//			System.out.println(deletedAnimal + " wurde erfolgreich gelöscht.");
//		} else {
//			System.out.println("Ungültige Eingabe");
//		}
//	}

}
