package exceptions;

public class NullReferenceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NullReferenceException() {
		super("Objeto tem referência null");
	}
	
	public NullReferenceException(String message) {
		super(message);
	}
	
	public NullReferenceException(String message, Throwable t) {
		super(message, t);
	}
	
	public NullReferenceException(Throwable t) {
		super(t);
	}

}
