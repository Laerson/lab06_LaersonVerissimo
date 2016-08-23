package exceptions;

public class StringInvalidaException extends Exception {
	public StringInvalidaException() {
		super("String Invalida");
	}
	
	public StringInvalidaException(String message) {
		super(message);
	}
	
	public StringInvalidaException(String message, Throwable t) {
		super(message, t);
	}
	
	public StringInvalidaException(Throwable t) {
		super(t);
	}

}