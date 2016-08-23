/* 116110062 - Laerson Saraiva Verissimo: LAB 6 - Turma 2 */
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
