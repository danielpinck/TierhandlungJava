package tierhandlung2307;

public class Fisch extends Tier{
    double salzgehalt;

    public Fisch(String name, int alter, int satt, double salzgehalt) {
        super(name, alter, satt);
        this.salzgehalt = salzgehalt;
    }

    public void setSalzgehalt(double salzgehalt) {
        this.salzgehalt = salzgehalt;
    }

    public double getSalzgehalt() {
        return salzgehalt;
    }
}
