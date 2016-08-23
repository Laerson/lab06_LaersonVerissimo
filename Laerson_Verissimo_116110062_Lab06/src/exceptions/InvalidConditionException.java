package exceptions;

public class InvalidConditionException extends Exception {
	
	public InvalidConditionException() {
		super("Condição invalida");
	}
	
	public InvalidConditionException(String message) {
		super(message);
	}
	
	public InvalidConditionException(String message, Throwable t) {
		super(message, t);
	}
	
	public InvalidConditionException(Throwable t) {
		super(t);
	}

}
