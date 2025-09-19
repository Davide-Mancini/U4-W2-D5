package davidemancini.entities;

import davidemancini.enums.Generi;
import davidemancini.enums.Piattaforma;

public class Videogioco extends GiocoGenerale{
    //ATTRIBUTI
    private Piattaforma piattaforma;
    private int durataGioco;
    private Generi genere;

    //COSTRUTTORI
    public Videogioco(String id, String titolo, int annoPubblicazione, double prezzo,Piattaforma piattaforma, int durataGioco, Generi genere) {
        super(id, titolo, annoPubblicazione, prezzo);
        this.piattaforma=piattaforma;
        this.durataGioco=durataGioco;
        this.genere=genere;
    }
    //METODI


    public Piattaforma getPiattaforma() {
        return piattaforma;
    }

    public Generi getGenere() {
        return genere;
    }

    public int getDurataGioco() {
        return durataGioco;
    }

    public void setDurataGioco(int durataGioco) {
        this.durataGioco = durataGioco;
    }

    @Override
    public String toString() {
        return "Videogioco{" +
                "id='" + id + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                "piattaforma=" + piattaforma +
                ", durataGioco=" + durataGioco +
                ", genere=" + genere +
                '}';
    }
}
