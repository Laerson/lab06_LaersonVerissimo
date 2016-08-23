package exceptions;

public class NumeroInvalidoException extends Exception {
	public NumeroInvalidoException() {
		super("Numero Invalido");
	}
	
	public NumeroInvalidoException(String message) {
		super(message);
	}
	
	public NumeroInvalidoException(String message, Throwable t) {
		super(message, t);
	}
	
	public NumeroInvalidoException(Throwable t) {
		super(t);
	}

}
