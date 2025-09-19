package davidemancini.exceptions;

public class SceltaNonValida extends RuntimeException {
    public SceltaNonValida(int scelta) {

        super(scelta +" non è valido, devi scegliere tra 0 e 10");
    }
}
