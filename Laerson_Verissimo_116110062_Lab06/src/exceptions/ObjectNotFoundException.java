package exceptions;

public class ObjectNotFoundException extends Exception {
	ObjectNotFoundException() {
		super("Objeto não encontrado");
	}
	
	public ObjectNotFoundException(String message) {
		super(message);
	}
	
	public ObjectNotFoundException(String message, Throwable t) {
		super(message, t);
	}
	
	public ObjectNotFoundException(Throwable t) {
		super(t);
	}

}
