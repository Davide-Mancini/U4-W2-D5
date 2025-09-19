package davidemancini;

import com.github.javafaker.Faker;
import davidemancini.entities.Collezione;
import davidemancini.entities.GiocoDaTavolo;
import davidemancini.entities.Videogioco;
import davidemancini.enums.Generi;
import davidemancini.enums.Piattaforma;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Faker faker = new Faker();
        Collezione collezione = new Collezione(); //ISTANZA DI COLLEZIONE

        //CREAZIONE LISTA CON VIDEOGIOCHI E GIOCHI DA TAVOLO
        for (int i = 0; i < 20; i++) {
            String idVideogiochi =(10000+i)+""; //ASSEGNO UN ID PROGRESSIVO A VIDEOGIOCHI COSI AD OGNI ITERAZIONE AUMENTA DI UNO (AVEVO FATTO CON RANDOM MA ERA DIFFICLE PROVARE IL CODICE)
            String idGiochiTavola =(20000+i)+"";//ASSEGNO UN ID PROGRESSIVO CHE INIZIA CON 2 A GIOCHI DA TAVOLO COSI AD OGNI ITERAZIONE AUMENTA DI UNO (AVEVO FATTO CON RANDOM MA ERA DIFFICLE PROVARE IL CODICE)
            int numeroCasualeAnnoPubbl = random.nextInt(1990,2025);
            double prezzoCasuale = random.nextDouble(0.99,150.99);
            int durataGiocoCasuale = random.nextInt(2,150);
            int durataMedia = random.nextInt(15,150);
            int numeroGiocatoriCausuale = random.nextInt(2,10);
            collezione.aggiungiGiocoACollezione(new Videogioco(idVideogiochi,faker.esports().game(),numeroCasualeAnnoPubbl,prezzoCasuale, Piattaforma.PS5,durataGiocoCasuale, Generi.SOUL));
            collezione.aggiungiGiocoACollezione(new GiocoDaTavolo(idGiochiTavola,faker.book().title(),numeroCasualeAnnoPubbl,prezzoCasuale,numeroGiocatoriCausuale,durataMedia));
        }
        while (true){
        System.out.println("cosa vuoi vedere?" );
        System.out.println("premi 1 per visualizzare la collezione di giochi");
        System.out.println( "premi 2 per cercare un gioco specifico tramite id");
        System.out.println("premi 3 per avere la lista dei giochi con prezzo inferiore a quello che vuoi tu" );
        System.out.println( "premi 4 per trovare tutti i giochi con un determinato numero di giocatori");
        System.out.println(  "premi 5 per rimuovere un gioco dalla collezione");
        System.out.println( "premi 6 per aggiornare un attributo di un gioco");
        System.out.println(  "premi 7 per avere statistiche genrali su tutta la collezione");
        System.out.println(  "premi 8 per trovare il gioco piu costoso");
        System.out.println( "premi 9 per la media di tutti i prezzi");
            System.out.println("premi 10 per sapere qunati giochi sono presenti nella collezione");
        System.out.println("premi 0 per uscire");
       int scelta= scanner.nextInt();
       switch (scelta){
           case(1):
               System.out.println(collezione);
               break;
           case (2):
               System.out.println("inserisci id");
               String id = String.valueOf(scanner.nextInt());
               collezione.stampaCercaId(id);
               break;
           case (3):
               System.out.println("prezzo per ricerca");
               int prezzo = scanner.nextInt();
               collezione.stampaRicercaPrezzo(prezzo);
               break;
           case (4):
               System.out.println("quanti giocatori?");
               int giocatori = scanner.nextInt();
               collezione.stampaCercaPerGIocatori(giocatori);
               break;
           case (5):
               collezione.numeroGiochi();
               System.out.println("quale gioco vuoi rimuovere? (inserisci id)");
               String id2 = String.valueOf(scanner.nextInt());
               collezione.rimuoviTramiteId(id2);
               collezione.numeroGiochi();
               break;
           case (6):
               //da finire
               break;
           case(7):
               collezione.stampaStats();
               break;
           case (8):
               collezione.giocoPiuCostoso();
               break;
           case(9):
               collezione.mediaPrezzi();
               break;
           case(10):
               collezione.numeroGiochi();


       } if(scelta==0){
       break;}
        }
//        collezione.stampaCercaId("10008");
//        collezione.stampaRicercaPrezzo(24);
//        collezione.stampaCercaPerGIocatori(4);
//        collezione.rimuoviTramiteId("10000"); //RITORNA UNA LISTA DI COLLEZIONE GIOCHI MA SENZA IL GIOCO CON ID INSERITO
//        collezione.stampaStats(); //STAMPA LE STATISTICHE DEI GIOCHI SUDDIVISI PER ANNO DI PUBBLICAZIONE
//        collezione.numeroGiochi();//NUMERO GIOCHI TOTALI ALL'INTERNO DELLA LISTA
//        collezione.aggiungiGiocoACollezione(new Videogioco("10045","call of duty 4", 2004,15.99,Piattaforma.XBOX,21,Generi.SPARATUTTO));
//        collezione.numeroGiochi();//AGGIUNGENDO UN GIOCO ALLA COLLEZIONE SI AGGIORNA IL NUMERO DI GIOCHI PRESENTI
//        collezione.mediaPrezzi();//CALCOLO LA MEDIA DI TUTTI I PREZZI
//        System.out.println(collezione.giocoPiuCostoso());



//                  System.out.println(collezione.cercaPerId("415455"));
//                  System.out.println(collezione.cercaPerPrezzo(15.20));
//                  System.out.println(collezione.cercaPerNumGiocatori(4));

    }
}
