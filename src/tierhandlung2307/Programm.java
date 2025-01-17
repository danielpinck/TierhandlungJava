package tierhandlung2307;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.lang.reflect.Parameter;

public class Programm {
    private final static int ALTER = 1;
    private final static int NAME = 2;
    private final static int ID = 3;
    Scanner sc = new Scanner(System.in);
    private DBconnection db;

    public Programm() {
        this.db = new DBconnection();
    }
    //Kundenliste
    private String oeffnungszeiten = "8:49 - 16:30";

    //Tierliste
    private ArrayList<Tier> tierliste = new ArrayList<>();



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
            System.out.println("4. Testing");
            System.out.println("0. Hauptmenü");

            System.out.println("Bitte Auswahl treffen");
            eingabe = sc.nextInt();

            switch (eingabe) {
                case 1:
                    //Aufruf Menü 1
                    System.out.println("Beherbergte Hunde: ");
                    eingabeTier = "hund";
                    sortedMenu(eingabeTier);

                    break;
                case 2:
                    System.out.println("Beherbergte Katzen: ");
                    eingabeTier = "katze";
                    sortedMenu(eingabeTier);
                    break;
                case 3:
                    System.out.println("Beherbergte Fische: ");
                    eingabeTier = "fisch";
//                    displayAnimals(eingabeTier);
                    break;
                case 4:
                    System.out.println("Testing hund: ");
                    eingabeTier = "hund";
                    testing(eingabeTier);
                    break;
                case 0:
                    tierliste.clear();

                default:
                    System.out.println("Bitte gültige Auswahl treffen");
                    System.out.println("-----------------------------");
            }
        }
        return eingabeTier;
    }

    public void sortedMenu(String eingabeTier) throws SQLException {
        int eingabe = 5;
        while ( eingabe != 0  ) {
            //Menüausgabe
            System.out.println("1. Nach Alter sortiert");
            System.out.println("2. Nach name sortiert");
            System.out.println("3. Nach ID sortiert");
            System.out.println("0. Hauptmenü");

            System.out.println("Bitte Auswahl treffen");
            eingabe = sc.nextInt();

            switch (eingabe) {
                case 1:
                    //Aufruf Menü 1
                    System.out.println("Nach Alter sortiert: ");
//                    eingabeTier = "hund";
                    displayAnimals(eingabeTier, eingabe);
                    break;
                case 2:
                    System.out.println("Nach Name sortiert: ");
//                    eingabeTier = "katze";
                    displayAnimals(eingabeTier, eingabe);
                    break;
                case 3:
                    System.out.println("Nach ID sortiert: ");
//                    eingabeTier = "fisch";
                    displayAnimals(eingabeTier, eingabe);
                    break;
                case 0:
                    tierliste.clear();

                default:
                    System.out.println("Bitte gültige Auswahl treffen");
                    System.out.println("-----------------------------");
            }
        }
//        return eingabeTier;

    }

    public void menu3() throws SQLException {

    }

    public void testing(String eingabeTier) throws SQLException {
        String selectQuery = "SELECT * FROM " + eingabeTier;

        db.rs = db.stmt.executeQuery(selectQuery);
        int i = 0;

        // extract data from result set
        while (db.rs.next()) {


            String name = db.rs.getString("name");
            int tid = db.rs.getInt("tid");
            int alter = db.rs.getInt("alter");
            int satt = db.rs.getInt("satt");
            switch (eingabeTier) {
                case "hund":
                    boolean entwurmtHund = db.rs.getBoolean("entwurmt");
                    String kommandos = db.rs.getString("kommandos");
                    Hund hund = new Hund(name, alter, satt, tid, entwurmtHund, kommandos);
                    tierliste.add(hund);
                    for (Tier j : tierliste) {
                        System.out.println(j.getName());
//                        System.out.println(j.getEntwurmt());

                    }


                    break;
                case "katze":
//                    boolean entwurmtKatze = db.rs.getBoolean("entwurmt");
//                    boolean hauskatze = db.rs.getBoolean("hauskatze");
//                    Katze katze = new Katze(name, alter, satt, tid, entwurmtKatze, hauskatze);
//                    tierliste.add(katze);
//                    System.out.println(tierliste.get(i).ausgabe());
                    break;
                case "fisch":
//                    double salzgehalt = db.rs.getDouble("salzgehalt");
//                    Fisch fisch = new Fisch(name, alter, satt, tid, salzgehalt);
//                    tierliste.add(fisch);
//                    System.out.println(tierliste.get(i).ausgabe());
                    break;
            }


            //Display results

//            ResultSetMetaData resultSetMetaData = db.rs.getMetaData();
//            int count = resultSetMetaData.getColumnCount();
//            for (int j = 1; j <=count; j++) {
//                System.out.println(resultSetMetaData.getColumnName(j));
//            }

//            System.out.print("_______________________________\n");
//            System.out.print("ID: " + tier.getId() + "\n");
//            System.out.print("Name: " + tier.getName() + "\n");
//            System.out.print("Alter: " + tier.getAlter() + "\n");
//            System.out.print("Satt: " + tier.getSatt() + "\n");
        }


    }


    private boolean vergleicheTier(Tier tier1, Tier tier2, int kriterium) {
        boolean erg = false;
        switch (kriterium) {
            case ALTER:
                if (tier1.getAlter() > tier2.getAlter()) {
                    erg = true;

                }
                break;
            case NAME:
                if (tier1.getName().compareToIgnoreCase(tier2.getName()) > 0 ){
                    erg = true;
                }
                break;
            case ID:
                if (tier1.getId() > (tier2.getId())){
                    erg = true;
                }
                break;
        }
        return erg;
    }

    private void sortTiere(int kriterium) {
//        Tier k;
        for (int i = 0; i<tierliste.size(); i++) {
            for (int j = tierliste.size()-1; j > 0; j--) {
                if (vergleicheTier(tierliste.get(j-1), tierliste.get(j),kriterium)) {
//                    k = tierliste.get(j);

                    Collections.swap(tierliste, j-1, j);
//                    tierliste.set(j, k);
//                    k = tierliste.get(j);
//                    tierliste.set(j-1, k);
                }

            }

        }
    }

    public void displayAnimals(String eingabeTier, int sortedBy) throws SQLException {

        String selectQuery = "SELECT * FROM " + eingabeTier;
        db.rs = db.stmt.executeQuery(selectQuery);

        // extract data from result set
        while (db.rs.next()) {


            String name = db.rs.getString("name");
            int tid = db.rs.getInt("tid");
            int alter = db.rs.getInt("alter");
            int satt = db.rs.getInt("satt");

            Tier tier;
            switch (eingabeTier.toLowerCase()) {
                case "hund":
                    boolean entwurmt = db.rs.getBoolean("entwurmt");
                    String kommandos = db.rs.getString("kommandos");
                    tier = new Hund(name, alter, satt, tid, entwurmt, kommandos);
                    break;
                case "katze":
                    entwurmt = db.rs.getBoolean("entwurmt");
                    boolean hauskatze = db.rs.getBoolean("hauskatze");
                    tier = new Katze(name, alter, satt, tid, entwurmt, hauskatze);
                    break;
                case "fisch":
                    double salzgehalt = db.rs.getDouble("salzgehalt");
                    tier = new Fisch(name, alter, satt, tid, salzgehalt);
                    break;

                default:
                    throw new IllegalArgumentException("Unbekanntes Tier: " + eingabeTier);
            }
            tierliste.add(tier);

            //Display results
//            System.out.println(tierliste.get(i).ausgabe());
//            ResultSetMetaData resultSetMetaData = db.rs.getMetaData();
//            int count = resultSetMetaData.getColumnCount();
//            for (int j = 1; j <=count; j++) {
//                System.out.println(resultSetMetaData.getColumnName(j));
//                System.out.println(resultSetMetaData.getColumnTypeName(j));
//            }

//            System.out.print("_______________________________\n");
//            System.out.print("ID: " + tier.getId() + "\n");
//            System.out.print("Name: " + tier.getName() + "\n");
//            System.out.print("Alter: " + tier.getAlter() + "\n");
//            System.out.print("Satt: " + tier.getSatt() + "\n");
        }
        sortTiere(sortedBy);
        for (int l = 0; l < tierliste.size(); l++) {
            System.out.println(tierliste.get(l).ausgabe());
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
        ArrayList<Tier> addAnimalList = new ArrayList<>();
        System.out.println(eingabeTier);
        System.out.println("Name: ");
        String animalName = sc.next();
        System.out.println("Alter: ");
        int animalAge = sc.nextInt();
        System.out.println("Satt: ");
        int animalFed = sc.nextInt();
//        Tier tier = new Tier(animalName, animalAge, animalFed, 0);


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
