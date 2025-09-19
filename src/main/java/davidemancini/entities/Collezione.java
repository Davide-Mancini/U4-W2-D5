package davidemancini.entities;

import java.security.PublicKey;
import java.util.*;
import java.util.stream.Collectors;

public class Collezione {
    List<GiocoGenerale> collezioneGiochi ;

    public Collezione(){
        this.collezioneGiochi= new ArrayList<>();
    }

    //METODI
//METODO PER AGGIUNGERE UN GIOCO ALLA COLLEZIONE
    public void aggiungiGiocoACollezione (GiocoGenerale giocoGenerale){
        collezioneGiochi.add(giocoGenerale);
    }

    //METODO PER CERCRE L'ID
    public List<GiocoGenerale> cercaPerId (String id){
       return collezioneGiochi.stream().filter(gioco->gioco.getId().equals(id)).toList();
    }
    public void stampaCercaId (String id){
        System.out.println("Questo è il gioco che stai cercando "+ cercaPerId(id));
    }
//METODO PER RICERCA TRAMITE PREZZO
    public List<GiocoGenerale> cercaPerPrezzo(double prezzo){
        return collezioneGiochi.stream().filter(gioco->gioco.getPrezzo()<prezzo).toList();
    }
    public void stampaRicercaPrezzo(double prezzo){
        System.out.println("Ecco una lista di giochi che costano meno di " + prezzo +" €"+cercaPerPrezzo(prezzo));
    }
    //METODO PER RICERCA TRAMITE NUMERO GIOCATORI
    public List<GiocoGenerale> cercaPerNumGiocatori(int giocatori){
        return collezioneGiochi.stream().filter(gioco->gioco instanceof GiocoDaTavolo).map(giocotavola-> giocotavola).filter(giocodatavola->((GiocoDaTavolo) giocodatavola).getNumeroGiocatori()==giocatori).toList();
    }
    public void stampaCercaPerGIocatori (int giocatori){
        System.out.println("Ecco tutti i giochi perfetti per giocare in "+ giocatori + cercaPerNumGiocatori(giocatori));
    }
    //METODO PER RIMOZIONE TRAMITE ID
    public void rimuoviTramiteId (String id){
// System.out.println(collezioneGiochi.stream().filter(gioco->!gioco.getId().equals(id)).toList()); AVEVO FATTO COSI MA IN REALTA NON RIMUOVEVA UN EFFETTIVAMENTE DA COLLEZIONE GIOCHI MA CREAVA UN ALTRA LISTA SENZA IL GIOCO CON ID
        collezioneGiochi.removeIf(gioco->gioco.getId().equals(id));// HO USATO IL REMOVE IF, QUINDI SE RITORNA VERO IL GIOCO VINE ELIMINATO
    }
    //NUMERO TOTALI
    public void numeroGiochi(){
        System.out.println("momentaneamente ci sono "+collezioneGiochi.size() + " giochi");
    }

    public Map<Integer, DoubleSummaryStatistics>statistiche(){
       return collezioneGiochi.stream().collect(Collectors.groupingBy(gioco-> gioco.getAnnoPubblicazione(),Collectors.summarizingDouble(gioco->gioco.getPrezzo())));

    }
    public void stampaStats (){
        statistiche().forEach((anno,stats)-> System.out.println("anno pubblicazione "+ anno+" ,"+stats));
    }
    //METODO MEDIA PREZZI
    public void mediaPrezzi (){
        System.out.println("La media dei prezzi di tutti i giochi della collezione è: "+collezioneGiochi.stream().collect(Collectors.averagingDouble(gioco->gioco.getPrezzo())));
    }
    //METODO PER GIOCO PIU COSTOSO
    public List<GiocoGenerale> giochiOrdinatiPerPrezzo (){
        return collezioneGiochi.stream().sorted(Comparator.comparing(gioco->gioco.getPrezzo())).toList();
    }
    public List<GiocoGenerale> giocoPiuCostoso(){
        System.out.println("il gioco piu costoso è :");
        return giochiOrdinatiPerPrezzo().stream().sorted(Comparator.comparing(GiocoGenerale::getPrezzo).reversed()).limit(1).toList();
    }
    @Override
    public String toString() {
        return "Collezione{" +
                "collezioneGiochi=" + collezioneGiochi +
                '}';
    }
}
