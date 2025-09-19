package davidemancini.entities;

public abstract class GiocoGenerale {
    //ATTRIBUTI
    protected String id;
    protected String titolo;
    protected int annoPubblicazione;
    protected double prezzo;
    //COSTRUTTORI
    public GiocoGenerale(String id, String titolo, int annoPubblicazione, double prezzo){
        this.id=id;
        this.titolo=titolo;
        this.annoPubblicazione=annoPubblicazione;
        this.prezzo=prezzo;
    }
    //METODI

    public String getId() {
        return id;
    }


    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }


    public String getTitolo() {
        return titolo;
    }

    @Override
    public String toString() {
        return "GiocoGenerale{" +
                "id='" + id + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                '}';
    }
}
