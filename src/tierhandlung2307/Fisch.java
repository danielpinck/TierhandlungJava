package tierhandlung2307;

public class Fisch extends Tier{
    double salzgehalt;

    public Fisch(String name, int alter, int satt, String id, double salzgehalt) {
        super(name, alter, satt, id);
        this.salzgehalt = salzgehalt;
    }

    public void setSalzgehalt(double salzgehalt) {
        this.salzgehalt = salzgehalt;
    }

    public double getSalzgehalt() {
        return salzgehalt;
    }
}
