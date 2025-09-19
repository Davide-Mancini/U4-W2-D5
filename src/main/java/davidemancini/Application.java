package davidemancini;

import com.github.javafaker.Faker;
import davidemancini.entities.Collezione;
import davidemancini.entities.GiocoDaTavolo;
import davidemancini.entities.Videogioco;
import davidemancini.enums.Generi;
import davidemancini.enums.Piattaforma;
import davidemancini.exceptions.NumGiocaotoreMin2Magg10;
import davidemancini.exceptions.StringNotValidException;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Faker faker = new Faker();
        Collezione collezione = new Collezione(); //ISTANZA DI COLLEZIONE
        Piattaforma[]piattaforma = Piattaforma.values(); //CREO ARRAY DI TIPO PIATTAFORMA CON AL SUO INTERNO I VALORI
        Generi[]generi = Generi.values();



        //CREAZIONE LISTA CON VIDEOGIOCHI E GIOCHI DA TAVOLO
        for (int i = 0; i < 20; i++) {
            String idVideogiochi =(10000+i)+"";     //ASSEGNO UN ID PROGRESSIVO A VIDEOGIOCHI COSI AD OGNI ITERAZIONE AUMENTA DI UNO (AVEVO FATTO CON RANDOM MA ERA DIFFICLE PROVARE IL CODICE)
            String idGiochiTavola =(20000+i)+"";  //ASSEGNO UN ID PROGRESSIVO CHE INIZIA CON 2 A GIOCHI DA TAVOLO COSI AD OGNI ITERAZIONE AUMENTA DI UNO (AVEVO FATTO CON RANDOM MA ERA DIFFICLE PROVARE IL CODICE)
            int numeroCasualeAnnoPubbl = random.nextInt(1990,2025);
            double prezzoCasuale = Math.round(random.nextDouble(0.99,150.99)*100.0)/100.0;   //MI PERMETTE DI LASCIARE SOLO DUE DECIMALI
            int durataGiocoCasuale = random.nextInt(2,150);
            int durataMedia = random.nextInt(15,150);
            int numeroGiocatoriCausuale = random.nextInt(2,10);
            Generi generiCasuali = generi[random.nextInt(0, generi.length-1)] ; // RANDOMIZZO SCELTA DELL'ENUM GRAZIE AI VALORI RECUPERATI, DA 0 ALLA LUNGHEZZA DI GENERI CHE è UN ARRAY
            Piattaforma piattaformaCasuale = piattaforma[random.nextInt(0, piattaforma.length-1)]; // RANDOMIZZO SCELTA DELL'ENUM GRAZIE AI VALORI RECUPERATI, DA 0 ALLA LUNGHEZZA DI PIATTAFORME CHE è UN ARRAY
            collezione.aggiungiGiocoACollezione(new Videogioco(idVideogiochi,faker.esports().game(),numeroCasualeAnnoPubbl,prezzoCasuale, piattaformaCasuale,durataGiocoCasuale, generiCasuali));
            collezione.aggiungiGiocoACollezione(new GiocoDaTavolo(idGiochiTavola,faker.book().title(),numeroCasualeAnnoPubbl,prezzoCasuale,numeroGiocatoriCausuale,durataMedia));
        }
        //MENU CHE VIENE STAMPATO FINCHE NON SI PREME 0
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
            System.out.println("premi 11 per inserire un nuovo gioco alla collezione");
        System.out.println("premi 0 per uscire");
       int scelta= scanner.nextInt();
       // IN BASE ALLA SCELTA SI ACCEDE A UN METODO
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
               collezione.stampaGiocoPiuCostoso();
               break;
           case(9):
               collezione.mediaPrezzi();
               break;
           case(10):
               collezione.numeroGiochi();
                break;
           case(11):
               try {
               System.out.println("vuoi aggiungere un videogioco?(si o no)");
              String siNo= scanner.next();
              if(!siNo.equals("si") && !siNo.equals("no") ){
                  throw new StringNotValidException(siNo);
              }


                   if (siNo.equals("si")){
                  System.out.println("come si chiama il videogioco?");
                  scanner.nextLine(); //HO TROVATO QUESTA SOLUZIONE PER POTER RISOLVERE IL NEXT LINE CHE SALTA LA RIGA
                  String titolo= scanner.nextLine();
                  System.out.println("quando è stato pubblciato?");
                  int dataPubbl = scanner.nextInt();
                  scanner.nextLine();
                  System.out.println("quanto costa? SEPARA I DICIMALI CON IL PUNTO");
                  double prezzo2= Double.parseDouble(scanner.nextLine());
                  System.out.println("quanto dura il gioc?");
                  int durata = scanner.nextInt();
                  scanner.nextLine();
                 collezione.aggiungiGiocoACollezione(new Videogioco(random.nextInt(30000,39999)+"",titolo,dataPubbl,prezzo2,Piattaforma.PS5,durata,Generi.SPARATUTTO));
                  System.out.println("gioco aggiunto alla collezione");
                    break;
              }else if(siNo.equals("no")){
                  System.out.println("aggiungi gioco da tavola");
                  System.out.println("come si chiama il gioco da tavola?");
                  scanner.nextLine();
                  String titolo2= scanner.nextLine();
                  System.out.println("quando è stato pubblciato?");
                  int dataPubbl2 = scanner.nextInt();
                  scanner.nextLine();
                  System.out.println("quanto costa? SEPARA I DICIMALI CON IL PUNTO");
                  double prezzo3= Double.parseDouble(scanner.nextLine());
                  System.out.println("per quanti giocatori è?");
                  int numGiocatori= scanner.nextInt();
                  scanner.nextLine();
                  try {
                      if(numGiocatori<2 || numGiocatori>10){
                          throw new NumGiocaotoreMin2Magg10(numGiocatori);
                      }
                  }catch (NumGiocaotoreMin2Magg10 ex){
                      System.out.println("errore " + ex.getMessage());
                      System.out.println("imposto il numero minimo");
                      numGiocatori=2;
                  }

                  System.out.println("quanti minuti dura mediamente una partita?");
                  int durataPartita= scanner.nextInt();
                  scanner.nextLine();

                  collezione.aggiungiGiocoACollezione(new GiocoDaTavolo(random.nextInt(30000,39999)+"",titolo2,dataPubbl2,prezzo3,numGiocatori,durataPartita));
                  System.out.println("gioco da tavola aggiunto alla collezione");
                  break;
              }

               }catch (StringNotValidException ex){
                   System.out.println(ex.getMessage());
               }



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
