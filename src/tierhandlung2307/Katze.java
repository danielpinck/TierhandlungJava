package tierhandlung2307;

public class Katze extends Tier {
    boolean entwurmt;
    boolean hauskatze;

    public Katze (String name, int alter, int satt, String id, boolean entwurmt, boolean hauskatze) {
        super(name, alter, satt, id);
        this.entwurmt = entwurmt;
        this.hauskatze = hauskatze;
    }

    public void setHauskatze(boolean hauskatze) {
        this.hauskatze = hauskatze;
    }

    public boolean geHauskatze() {
        return hauskatze;
    }

    public boolean getEntwurmt() {
        return entwurmt;
    }

    public void setEntwurmt(boolean entwurmt) {
        this.entwurmt = entwurmt;
    }

    public void entwurmen() {
        System.out.println("Entwurmt Angabe hier" + this.getName());
    }


}
