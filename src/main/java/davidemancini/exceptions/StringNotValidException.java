package davidemancini.exceptions;

public class StringNotValidException extends RuntimeException {
    public StringNotValidException(String scelta) {
        super(scelta+ "non è una scelta valida, scegli si o no");
    }
}
