package davidemancini.exceptions;

public class NumGiocaotoreMin2Magg10 extends RuntimeException{
    public NumGiocaotoreMin2Magg10(int num){
        super(num+" non è valido, non possono esserci meno di 2 o piu di 10 giocatori ");
    }
}
