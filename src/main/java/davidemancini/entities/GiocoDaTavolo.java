package davidemancini.entities;

public class GiocoDaTavolo extends GiocoGenerale{
    //ATTRIBUTI
    private int numeroGiocatori;
    private int durataMedia;

    //COSTRUTTORI
    public GiocoDaTavolo(String id, String titolo, int annoPubblicazione, double prezzo,int numeroGiocatori, int durataMedia) {
        super(id, titolo, annoPubblicazione, prezzo);
        this.numeroGiocatori=numeroGiocatori;
        this.durataMedia=durataMedia;
    }
    //METODI

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }



    public int getDurataMedia() {
        return durataMedia;
    }

    public void setDurataMedia(int durataMedia) {
        this.durataMedia = durataMedia;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "id='" + id + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo  +
                "numeroGiocatori=" + numeroGiocatori +
                ", durataMedia=" + durataMedia +
                '}';
    }
}
