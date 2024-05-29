package tierhandlung2307;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Programm {
    Scanner sc = new Scanner(System.in);
    private DBconnection db;

    public Programm() {
        this.db = new DBconnection();
    }
    //Kundenliste
    private String oeffnungszeiten = "8:49 - 16:30";



    public void menu() throws SQLException {

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
                    menuShowAnimals();
                    break;
                case "2":
                    System.out.println("Tier hinzufügen");
                    menuAddAnimal();
                    break;
                case "3":
                    System.out.println("Tier löschen");
                    menu3();
                    break;
                case "4":
                    System.out.println("Menü 4");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Bitte gültige Auswahl treffen");
                    System.out.println("-----------------------------");

            }
        }
    }
    public String menuShowAnimals() throws SQLException {

        int eingabe = 1;
        String eingabeTier = "";
        while ( eingabe != 0  ) {
            //Menüausgabe
            System.out.println("1. Hunde anzeigen");
            System.out.println("2. Katzen anzeigen");
            System.out.println("3. Fische anzeigen");
            System.out.println("4. Alle anzeigen");
            System.out.println("0. Hauptmenü");

            System.out.println("Bitte Auswahl treffen");
            eingabe = sc.nextInt();

            switch (eingabe) {
                case 1:
                    //Aufruf Menü 1
                    System.out.println("Beherbergte Hunde: ");
                    eingabeTier = "hund";
                    displayAnimals(eingabeTier);
                    break;
                case 2:
                    System.out.println("Beherbergte Katzen: ");
                    eingabeTier = "katze";
                    displayAnimals(eingabeTier);
                    break;
                case 3:
                    System.out.println("Beherbergte Fische: ");
                    eingabeTier = "fisch";
                    displayAnimals(eingabeTier);
                    break;
                case 4:
                    System.out.println("Alle beherbergten Tiere: ");
                    break;
                case 0:

                default:
                    System.out.println("Bitte gültige Auswahl treffen");
                    System.out.println("-----------------------------");
            }
        }
        return eingabeTier;
    }

    public void menu2() throws SQLException {

    }

    public void menu3() throws SQLException {

    }



    public void displayAnimals(String eingabeTier) throws SQLException {
        String selectQuery = "SELECT * FROM " + eingabeTier;
        db.rs = db.stmt.executeQuery(selectQuery);


        // extract data from result set
        while (db.rs.next()) {
            String name = db.rs.getString("name");
            int tid = db.rs.getInt("tid");
            String alter = db.rs.getString("alter");
            int satt = db.rs.getInt("satt");

            //Display results

            System.out.print("_______________________________\n");
            System.out.print("ID: " + tid + "\n");
            System.out.print("Name: " + name + "\n");
            System.out.print("Alter: " + alter + "\n");
            System.out.print("Satt: " + satt + "\n");
        }
    }

    public void menuAddAnimal() throws SQLException{
        int eingabe = 1;
        String eingabeTier = "";
        while ( eingabe != 0  ) {
            //Menüausgabe
            System.out.println("1. Hund hinzufügen");
            System.out.println("2. Katze hinzufügen");
            System.out.println("3. Fisch hinzufügen");
            System.out.println("0. Hauptmenü");
            System.out.println("Bitte Auswahl treffen");
            eingabe = sc.nextInt();

            switch (eingabe) {
                case 1:
                    //Aufruf Menü 1
                    System.out.println("Hund hinzufügen: ");
                    eingabeTier = "hund";
                    addAnimal(eingabeTier);
                    break;
                case 2:
                    //Aufruf Menü 2
                    System.out.println("Katze hinzufügen: ");
                    eingabeTier = "katze";
                    addAnimal(eingabeTier);
                    break;
                case 3:
                    //Aufruf Menü 3
                    System.out.println("Fisch hinzufügen: ");
                    eingabeTier = "fisch";
                    addAnimal(eingabeTier);
                    break;
                case 0:
                    //Aufruf Menü 4
                    menu();
                    break;
                default:
                    System.out.println("Bitte gültige Auswahl treffen");
                    System.out.println("-----------------------------");
            }
        }
//        return eingabeTier;
    }

    public void addAnimal(String eingabeTier) throws SQLException {
        System.out.println(eingabeTier);
        System.out.println("Name: ");
        String animalName = sc.next();
        System.out.println("Alter: ");
        int animalAge = sc.nextInt();
        System.out.println("Satt: ");
        int animalFed = sc.nextInt();

        String sql = "INSERT INTO " + eingabeTier + "(name, `alter`, satt) VALUES (?, ?, ?)";
        PreparedStatement ps = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, animalName);
        ps.setInt(2, animalAge);
        ps.setInt(3, animalFed);

        ps.executeUpdate();
        int autoKey = -1;
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            autoKey = rs.getInt(1);
        }
        ps = db.conn.prepareStatement("SELECT * FROM " + eingabeTier + " WHERE tid = ?");
        ps.setInt(1, autoKey);
        db.rs = ps.executeQuery();
        System.out.println("");

//         extract data from result set
        while (db.rs.next()) {
            int tid = db.rs.getInt("tid");
            String name = db.rs.getString("name");
            int alter = db.rs.getInt("alter");
            int satt = db.rs.getInt("satt");

            //Display results

            System.out.print("_______________________________\n");
            System.out.print(name + " wurde erfolgreich erstellt\n");
            System.out.print("ID: " + tid + "\n");
            System.out.print("Alter: " + alter + "\n");
            System.out.print("Satt: " + satt + "\n");
            System.out.print("_______________________________\n");
        }
    }





}
